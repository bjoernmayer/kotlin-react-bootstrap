package react.bootstrap.components.nav

import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.AbstractComponent
import react.bootstrap.lib.ClassNames
import react.dom.WithClassName
import react.dom.div
import react.dom.nav
import react.dom.ol
import react.dom.ul

sealed class Navs<P : Navs.Props> : AbstractComponent<P, P, RState>() {
    class Ul : Navs<Ul.Props>() {
        override fun RBuilder.getRenderer(): ReactElement = ul { }

        interface Props : Navs.Props
    }

    class Ol : Navs<Ol.Props>() {
        override fun RBuilder.getRenderer(): ReactElement = ol { }

        interface Props : Navs.Props
    }

    class Nav : Navs<Nav.Props>() {
        override fun RBuilder.getRenderer(): ReactElement = nav { }

        interface Props : Navs.Props
    }

    class Div : Navs<Div.Props>() {
        override fun RBuilder.getRenderer(): ReactElement = div { }

        interface Props : Navs.Props
    }

    final override fun P.handleProps() {
        val classes = mutableSetOf(
            ClassNames.NAV
        )

        if (props.appearance == Appearance.TABS) {
            classes.add(ClassNames.NAV_TABS)
        }

        if (props.appearance == Appearance.PILLS) {
            classes.add(ClassNames.NAV_PILLS)
        }

        if (props.widthHandling == WidthHandling.FILL) {
            classes.add(ClassNames.NAV_FILL)
        }

        if (props.widthHandling == WidthHandling.JUSTIFY) {
            classes.add(ClassNames.NAV_JUSTIFIED)
        }

        className = props.className.appendClass(classes)
    }

    interface Props : WithClassName {
        var appearance: Appearance?
        var widthHandling: WidthHandling?
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
