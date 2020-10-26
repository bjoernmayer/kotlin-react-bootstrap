package react.bootstrap.components.nav

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.LI
import kotlinx.html.classes
import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.addOrInit
import react.bootstrap.lib.component.AbstractComponent
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.div
import react.dom.li
import kotlin.reflect.KClass

/*
Notizen:
Ich brauche eine Property (oder zwei), welche der Nav mitteilt, welches item das aktive ist.
Die Property ist optional, das active prop kann weiterhin auf links gesetzt werden.

Anhand des href oder anhand eines keys (nicht unique, mehrere können aktiiv sein. vllt sogar ne liste erlauben?

onActive predicate?
eine closure welche ein item bekommt, und dann je nachdem ob true zurück kommt oder nicht, wird die dann auf active
gestzt
 */
sealed class NavItems<P : NavItems.Props> : AbstractComponent<P, RState>() {
    class Li : NavItems<Li.Props>() {
        override fun getRenderer(): KClass<out HtmlBlockTag> = LI::class
        //     li {
        //     attrs {
        //         loadGlobalAttributes(props)
        //         classes = props.classes.addOrInit(setOf(ClassNames.NAV_ITEM))
        //     }
        // }

        interface Props : NavItems.Props
    }

    class NavItem : NavItems<NavItem.Props>() {
        override fun getRenderer(): KClass<out HtmlBlockTag> = DIV::class
        //     div {
        //     attrs {
        //         loadGlobalAttributes(props)
        //         classes = props.classes.addOrInit(setOf(ClassNames.NAV_ITEM))
        //     }
        // }

        interface Props : NavItems.Props
    }

    class DivItem : NavItems<DivItem.Props>() {
        override fun getRenderer(): KClass<out HtmlBlockTag> = DIV::class
        //     div {
        //     attrs {
        //         loadGlobalAttributes(props)
        //         classes = props.classes.addOrInit(setOf(ClassNames.NAV_ITEM))
        //     }
        // }

        interface Props : NavItems.Props
    }

    // Props are handled in sealed classes
    override fun WithGlobalAttributes.handleProps() { }

    interface Props : WithGlobalAttributes
}
