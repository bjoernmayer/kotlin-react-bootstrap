package react.bootstrap.components.nav

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.UL
import kotlinx.html.classes
import react.RState
import react.bootstrap.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * This is designed as a sealed class in order to differentiate between different Props in the builder extension
 * functions
 */
sealed class Navs<P : Navs.Props> : AbstractComponent<HtmlBlockTag, P, RState>() {
    class Ul : Navs<Ul.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = UL::class

        interface Props : Navs.Props
    }

    class Ol : Navs<Ol.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = OL::class

        interface Props : Navs.Props
    }

    class Nav : Navs<Nav.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = NAV::class

        interface Props : Navs.Props
    }

    class Div : Navs<Div.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = DIV::class

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

    interface Props : WithGlobalAttributes {
        var appearance: Appearance?
        var widthHandling: WidthHandling?
        var activeLinkPredicate: ((NavLink) -> Boolean)?
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
