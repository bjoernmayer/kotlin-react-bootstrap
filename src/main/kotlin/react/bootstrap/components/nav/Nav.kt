package react.bootstrap.components.nav

import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.RenderAsComponent
import react.bootstrap.lib.WithRenderAs
import react.dom.WithClassName
import react.dom.ul

class Nav : RenderAsComponent<Nav.Props, WithClassName, RState>() {
    override fun WithClassName.handleProps() {
        val classes = mutableSetOf<ClassNames>()

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

        className = props.className.appendClass(ClassNames.NAV)
    }

    override fun RBuilder.getDefaultRenderer(): ReactElement = ul { }

    interface Props : WithRenderAs, WithClassName {
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
