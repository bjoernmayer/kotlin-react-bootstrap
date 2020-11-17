package react.bootstrap.components.nav

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
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.DomComponent
import react.bootstrap.lib.react.onEachComponent
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * This is designed as a sealed class in order to differentiate between different Props in the builder extension
 * functions
 *
 * @param P RProps Type
 */
sealed class NavComponent<T : HtmlBlockTag, P : NavComponent.Props<T>>(
    props: P,
    tag: KClass<T>
) : DomComponent<NavComponent.DomBuilder<T>, T, P, RState>(props, tag) {
    class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): DomBuilder<T> = DomBuilder(builderFactory)

    class Ul(props: Props) : NavComponent<UL, Ul.Props>(props, UL::class) {
        override fun DomBuilder<UL>.build() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                addChildren()
            } else {
                childList.addAll(childrenArray.setActiveLinkPredicate(NavItems.Li::class))
            }
        }

        interface Props : NavComponent.Props<UL>
    }

    class Ol(props: Props) : NavComponent<OL, Ol.Props>(props, OL::class) {
        override fun DomBuilder<OL>.build() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                addChildren()
            } else {
                childList.addAll(childrenArray.setActiveLinkPredicate(NavItems.Li::class))
            }
        }

        interface Props : NavComponent.Props<OL>
    }

    class Nav(props: Props) : NavComponent<NAV, Nav.Props>(props, NAV::class) {
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

        interface Props : NavComponent.Props<NAV>
    }

    class Div(props: Props) : NavComponent<DIV, Div.Props>(props, DIV::class) {
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

        interface Props : NavComponent.Props<DIV>
    }

    override fun buildClasses(): Set<ClassNames> {
        val navClasses = mutableSetOf(
            ClassNames.NAV
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

    protected inline fun <
        reified C : Component<P, *>,
        P : NavItems.Props<*>
        > Array<out Child>.setActiveLinkPredicate(
        @Suppress("UNUSED_PARAMETER") component: KClass<C> = C::class,
    ): Array<out Child> =
        onEachComponent(component) { _, _ ->
            attrs {
                activeLinkPredicate = this@NavComponent.props.activeLinkPredicate
            }
        }

    interface Props<T : HtmlBlockTag> : DomComponent.Props<DomBuilder<T>, T> {
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
