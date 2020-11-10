package react.bootstrap.components.navbar

import kotlinx.html.HtmlInlineTag
import kotlinx.html.classes
import react.RBuilder
import react.RState
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.component.DOMWrapComponent
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.RDOMBuilder
import react.dom.div

class Navbar : BootstrapComponent<Navbar.Props, RState>() {
    override fun buildClasses(): Set<ClassNames> {
        val navbarClasses = mutableSetOf(ClassNames.NAVBAR)

        when (props.expand) {
            Breakpoints.ALL -> navbarClasses.add(ClassNames.NAVBAR_EXPAND)
            Breakpoints.SM -> navbarClasses.add(ClassNames.NAVBAR_EXPAND_SM)
            Breakpoints.MD -> navbarClasses.add(ClassNames.NAVBAR_EXPAND_MD)
            Breakpoints.LG -> navbarClasses.add(ClassNames.NAVBAR_EXPAND_LG)
            Breakpoints.XL -> navbarClasses.add(ClassNames.NAVBAR_EXPAND_XL)
            else -> {
                // nothing
            }
        }

        props.theme?.let {
            navbarClasses.add(it.classNames)
        }

        return navbarClasses
    }

    override fun RBuilder.render() {
        div {
            attrs {
                loadGlobalAttributes(props)
                classes = getComponentClasses()
            }
            children()
        }
    }

    interface Props : WithGlobalAttributes {
        var expand: Breakpoints?
        var theme: Theme?
    }

    enum class Theme(internal val classNames: ClassNames) {
        LIGHT(ClassNames.NAVBAR_LIGHT),
        DARK(ClassNames.NAVBAR_DARK)
    }

    open class Brand<TT : HtmlInlineTag>(props: Props<TT>) : DOMWrapComponent<TT, Brand.Props<TT>, RState>(props) {
        override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.NAVBAR_BRAND)

        interface Props<TT : HtmlInlineTag> : WithGlobalAttributes, DOMWrapComponent.Props<TT>
    }
}
