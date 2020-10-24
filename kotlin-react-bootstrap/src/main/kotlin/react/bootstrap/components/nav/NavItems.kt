package react.bootstrap.components.nav

import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.component.AbstractComponent
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.WithClassName
import react.dom.div
import react.dom.li

/*
Notizen:
Ich brauche eine Property (oder zwei), welche der Nav mitteilt, welches item das aktive ist.
Die Property ist optional, das active prop kann weiterhin auf links gesetzt werden.

Anhand des href oder anhand eines keys (nicht unique, mehrere können aktiiv sein. vllt sogar ne liste erlauben?

onActive predicate?
eine closure welche ein item bekommt, und dann je nachdem ob true zurück kommt oder nicht, wird die dann auf active
gestzt
 */
sealed class NavItems<P : NavItems.Props> : AbstractComponent<P, P, RState>() {
    class Li : NavItems<Li.Props>() {
        override fun RBuilder.getRenderer(): ReactElement = li { }

        interface Props : NavItems.Props
    }

    class NavItem : NavItems<NavItem.Props>() {
        override fun RBuilder.getRenderer(): ReactElement = div { }

        interface Props : NavItems.Props
    }

    class DivItem : NavItems<DivItem.Props>() {
        override fun RBuilder.getRenderer(): ReactElement = div { }

        interface Props : NavItems.Props
    }

    override fun P.handleProps() {
        className = props.className.appendClass(ClassNames.NAV_ITEM)
    }

    interface Props : WithClassName
}
