package react.bootstrap.components.nav

import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.AbstractComponent
import react.bootstrap.lib.ClassNames
import react.dom.WithClassName
import react.dom.li

sealed class NavItems<P : NavItems.Props> : AbstractComponent<P, P, RState>() {
    class Li : NavItems<Li.Props>() {
        override fun RBuilder.getRenderer(): ReactElement = li { }

        interface Props : NavItems.Props
    }

    override fun P.handleProps() {
        className = props.className.appendClass(ClassNames.NAV_ITEM)
    }

    interface Props : WithClassName
}
