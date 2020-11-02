package react.bootstrap.components.nav

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.UL
import kotlinx.html.classes
import react.Child
import react.Component
import react.RState
import react.bootstrap.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractComponent
import react.bootstrap.lib.react.identifiable.mapComponents
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.childrenArray
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * This is designed as a sealed class in order to differentiate between different Props in the builder extension
 * functions
 *
 * @param PT RProps Type
 */
sealed class Navs<PT : Navs.Props> : AbstractComponent<HtmlBlockTag, PT, RState>() {
    class Ul : Navs<Ul.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = UL::class

        override fun RDOMBuilder<HtmlBlockTag>.transferChildren() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                children()
            } else {
                childList.addAll(props.childrenArray.mapActiveLinkPredicate<NavItems.Li.Props, NavItems.Li>())
            }
        }

        interface Props : Navs.Props
    }

    class Ol : Navs<Ol.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = OL::class

        override fun RDOMBuilder<HtmlBlockTag>.transferChildren() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                children()
            } else {
                childList.addAll(props.childrenArray.mapActiveLinkPredicate<NavItems.Li.Props, NavItems.Li>())
            }
        }

        interface Props : Navs.Props
    }

    class Nav : Navs<Nav.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = NAV::class

        override fun RDOMBuilder<HtmlBlockTag>.transferChildren() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                children()
            } else {
                // For nav based navs we also need to check for direct children of type navLink, since such navs do not
                // need navItems
                val items = props.childrenArray.mapActiveLinkPredicate<NavItems.NavItem.Props, NavItems.NavItem>()

                childList.addAll(
                    items.mapComponents<NavLink.Props, NavLink> { _, _ ->
                        attrs {
                            activeLinkPredicate = this@Nav.props.activeLinkPredicate
                        }
                    }
                )
            }
        }

        interface Props : Navs.Props
    }

    class Div : Navs<Div.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = DIV::class

        override fun RDOMBuilder<HtmlBlockTag>.transferChildren() {
            // We don't need to do special child handling, if no activeLinkPredicate is there
            // This is because, the children can stay as they are
            if (props.activeLinkPredicate == null) {
                children()
            } else {
                // For div based navs we also need to check for direct children of type navLink, since such navs do not
                // need navItems
                val items = props.childrenArray.mapActiveLinkPredicate<NavItems.DivItem.Props, NavItems.DivItem>()

                childList.addAll(
                    items.mapComponents<NavLink.Props, NavLink> { _, _ ->
                        attrs {
                            activeLinkPredicate = this@Div.props.activeLinkPredicate
                        }
                    }
                )
            }
        }

        interface Props : Navs.Props
    }

    override fun RDOMBuilder<HtmlBlockTag>.build() {
        attrs {
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

            classes = props.classes.addOrInit(navClasses)
        }
    }

    protected inline fun <
        PT : NavItems.Props,
        reified CT : Component<PT, *>
        > Array<out Child>.mapActiveLinkPredicate(): Array<out Child> =
        mapComponents<PT, CT> { _, _ ->
            attrs {
                activeLinkPredicate = this@Navs.props.activeLinkPredicate
            }
        }

    interface Props : WithGlobalAttributes {
        var appearance: Appearance?
        var widthHandling: WidthHandling?
        var activeLinkPredicate: (NavLink.Props.() -> Boolean)?
    }

    enum class Appearance {
        DEFAULT,
        TABS,
        PILLS;
    }

    enum class WidthHandling {
        DEFAULT,
        FILL,
        JUSTIFY;
    }
}
