package react.bootstrap.components.nav

import kotlinext.js.jsObject
import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.LI
import kotlinx.html.classes
import react.RState
import react.RStatics
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractComponent
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.identifiable.IdentifiableProps
import react.bootstrap.lib.react.identifiable.mapComponents
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.childrenArray
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

sealed class NavItems<P : NavItems.Props> : AbstractComponent<HtmlBlockTag, P, RState>() {
    class Li : NavItems<Li.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = LI::class

        interface Props : NavItems.Props, IdentifiableProps<Li>

        companion object : RStatics<Props, RState, Li, Nothing>(Li::class) {
            init {
                Li.defaultProps = jsObject {
                    componentType = Li::class
                }
            }
        }
    }

    class NavItem : NavItems<NavItem.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = DIV::class

        interface Props : NavItems.Props, IdentifiableProps<NavItem>

        companion object : RStatics<Props, RState, NavItem, Nothing>(NavItem::class) {
            init {
                NavItem.defaultProps = jsObject {
                    componentType = NavItem::class
                }
            }
        }
    }

    class DivItem : NavItems<DivItem.Props>() {
        override val rendererTag: KClass<out HtmlBlockTag> = DIV::class

        interface Props : NavItems.Props, IdentifiableProps<DivItem>

        companion object : RStatics<Props, RState, DivItem, Nothing>(DivItem::class) {
            init {
                DivItem.defaultProps = jsObject {
                    componentType = DivItem::class
                }
            }
        }
    }

    override fun RDOMBuilder<HtmlBlockTag>.transferChildren() {
        if (props.activeLinkPredicate == null) {
            children()
        } else {
            childList.addAll(
                props.childrenArray.mapComponents<NavLink.Props, NavLink> { _, _ ->
                    attrs {
                        activeLinkPredicate = this@NavItems.props.activeLinkPredicate
                    }
                }
            )
        }
    }

    override fun RDOMBuilder<HtmlBlockTag>.build() {
        attrs {
            loadGlobalAttributes(props)
            classes = props.classes.addOrInit(setOf(ClassNames.NAV_ITEM))
        }
    }

    interface Props : WithGlobalAttributes {
        var activeLinkPredicate: (A.() -> Boolean)?
    }
}
