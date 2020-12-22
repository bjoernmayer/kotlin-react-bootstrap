package react.bootstrap.components.common.navs

import kotlinx.html.HtmlBlockTag
import react.Child
import react.Component
import react.RState
import react.bootstrap.components.nav.ActiveLinkPredicate
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.NavLink
import react.bootstrap.components.nav.Navigation
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.DOMComponent
import react.bootstrap.lib.component.DOMHandler
import react.bootstrap.lib.react.onEachComponent
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

public abstract class AbstractNavComponent
<T : HtmlBlockTag, H : DOMHandler<out T, B>, B : RDOMBuilder<T>, P : AbstractNavComponent.Props<T, H, B>>(
    props: P,
    tag: KClass<out T>
) : DOMComponent<T, H, B, P, RState>(props, tag) {

    override fun buildClasses(): Set<ClassNames> {
        val navClasses = mutableSetOf<ClassNames>()

        if (props.appearance == Navigation.Appearance.TABS) {
            navClasses.add(ClassNames.NAV_TABS)
        }

        if (props.appearance == Navigation.Appearance.PILLS) {
            navClasses.add(ClassNames.NAV_PILLS)
        }

        if (props.widthHandling == Navigation.WidthHandling.FILL) {
            navClasses.add(ClassNames.NAV_FILL)
        }

        if (props.widthHandling == Navigation.WidthHandling.JUSTIFY) {
            navClasses.add(ClassNames.NAV_JUSTIFIED)
        }

        return navClasses
    }

    protected fun RDOMBuilder<*>.buildUlOl() {
        // We don't need to do special child handling, if no activeLinkPredicate is there
        // This is because, the children can stay as they are
        if (props.activeLinkPredicate == null) {
            addChildren()
        } else {
            childList.addAll(childrenArray.setActiveLinkPredicate(NavItems.Li::class))
        }
    }

    protected fun RDOMBuilder<*>.buildDivItem() {
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
                        activeLinkPredicate = props.activeLinkPredicate
                    }
                }
            )
        }
    }

    private fun <P : NavItems.Props<*>> Array<out Child>.setActiveLinkPredicate(
        component: KClass<out Component<P, *>>,
    ): Array<out Child> = onEachComponent(component) { _, _ ->
        attrs {
            activeLinkPredicate = props.activeLinkPredicate
        }
    }

    public interface Props<T : HtmlBlockTag, H : DOMHandler<out T, B>, B : RDOMBuilder<T>> : DOMComponent.Props<H> {
        public var appearance: Navigation.Appearance?
        public var widthHandling: Navigation.WidthHandling?
        public var activeLinkPredicate: ActiveLinkPredicate?
    }
}
