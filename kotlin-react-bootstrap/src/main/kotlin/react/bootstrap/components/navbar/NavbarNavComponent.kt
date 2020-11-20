package react.bootstrap.components.navbar

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import kotlinx.html.UL
import react.Child
import react.Component
import react.RState
import react.bootstrap.components.nav.ActiveLinkPredicate
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.NavLink
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.DOMComponent
import react.bootstrap.lib.react.onEachComponent
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * Todo: Add a new "AbstractNavComponent" to share at least the navbar code.
 * In the same step: Try to move the build logic also into this abstract class
 *
 * This is a SubComponent. So consider to move it into Navbar
 *
 * @param T Tag to render
 * @param P RProps Type
 */
sealed class NavbarNavComponent<T : HtmlBlockTag, P : NavbarNavComponent.Props<T>>(
    props: P,
    tag: KClass<out T>
) : DOMComponent<T, NavbarNavDOMHandler<T>, NavbarNavComponent.DomBuilder<T>, P, RState>(props, tag) {
    class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): DomBuilder<T> = DomBuilder(builderFactory)

    class Ul(props: Props) : NavbarNavComponent<UL, Ul.Props>(props, UL::class) {
        override fun DomBuilder<UL>.build() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                addChildren()
            } else {
                childList.addAll(childrenArray.setActiveLinkPredicate(NavItems.Li::class))
            }
        }

        interface Props : NavbarNavComponent.Props<UL>
    }

    class Ol(props: Props) : NavbarNavComponent<OL, Ol.Props>(props, OL::class) {
        override fun DomBuilder<OL>.build() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                addChildren()
            } else {
                childList.addAll(childrenArray.setActiveLinkPredicate(NavItems.Li::class))
            }
        }

        interface Props : NavbarNavComponent.Props<OL>
    }

    class Nav(props: Props) : NavbarNavComponent<NAV, Nav.Props>(props, NAV::class) {
        override fun DomBuilder<NAV>.build() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                addChildren()
            } else {
                // For nav based navs we also need to check for direct children of type navLink, since such navs do not
                // need navItems
                val items = childrenArray.setActiveLinkPredicate(NavItems.DivItem::class)

                childList.addAll(
                    items.onEachComponent(NavLink::class) { _, _ ->
                        attrs {
                            activeLinkPredicate = this@Nav.props.activeLinkPredicate
                        }
                    }
                )
            }
        }

        interface Props : NavbarNavComponent.Props<NAV>
    }

    class Div(props: Props) : NavbarNavComponent<DIV, Div.Props>(props, DIV::class) {
        override fun DomBuilder<DIV>.build() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                addChildren()
            } else {
                // For nav based navs we also need to check for direct children of type navLink, since such navs do not
                // need navItems
                val items = childrenArray.setActiveLinkPredicate(NavItems.DivItem::class)

                childList.addAll(
                    items.onEachComponent(NavLink::class) { _, _ ->
                        attrs {
                            activeLinkPredicate = this@Div.props.activeLinkPredicate
                        }
                    }
                )
            }
        }

        interface Props : NavbarNavComponent.Props<DIV>
    }

    override fun buildClasses(): Set<ClassNames> {
        val navClasses = mutableSetOf(
            ClassNames.NAVBAR_NAV
        )

        if (props.appearance == Appearance.TABS) {
            navClasses.add(ClassNames.NAV_TABS)
        }

        if (props.appearance == Appearance.PILLS) {
            navClasses.add(ClassNames.NAV_PILLS)
        }

        if (props.widthHandling == WidthHandling.FILL) {
            navClasses.add(ClassNames.NAV_FILL)
        }

        if (props.widthHandling == WidthHandling.JUSTIFY) {
            navClasses.add(ClassNames.NAV_JUSTIFIED)
        }

        return navClasses
    }

    protected fun <P : NavItems.Props<*>> Array<out Child>.setActiveLinkPredicate(
        component: KClass<out Component<P, *>>,
    ): Array<out Child> = onEachComponent(component) { _, _ ->
        attrs {
            activeLinkPredicate = this@NavbarNavComponent.props.activeLinkPredicate
        }
    }

    interface Props<T : HtmlBlockTag> : DOMComponent.Props<NavbarNavDOMHandler<T>> {
        var appearance: Appearance?
        var widthHandling: WidthHandling?
        var activeLinkPredicate: ActiveLinkPredicate?
    }

    enum class Appearance {
        TABS,
        PILLS;
    }

    enum class WidthHandling {
        FILL,
        JUSTIFY;
    }
}
