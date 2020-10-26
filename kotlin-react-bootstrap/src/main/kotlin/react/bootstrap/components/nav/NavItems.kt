package react.bootstrap.components.nav

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.LI
import kotlinx.html.classes
import react.RState
import react.bootstrap.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractComponent
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

sealed class NavItems<P : NavItems.Props> : AbstractComponent<HtmlBlockTag, P, RState>() {
    class Li : NavItems<Li.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = LI::class

        interface Props : NavItems.Props
    }

    class NavItem : NavItems<NavItem.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = DIV::class

        interface Props : NavItems.Props
    }

    class DivItem : NavItems<DivItem.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = DIV::class

        interface Props : NavItems.Props
    }

    override fun RDOMBuilder<HtmlBlockTag>.build() {
        attrs {
            loadGlobalAttributes(props)
            classes = props.classes.addOrInit(setOf(ClassNames.NAV_ITEM))
        }
    }

    interface Props : WithGlobalAttributes
}
