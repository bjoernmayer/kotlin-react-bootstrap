package react.bootstrap.components.nav

import kotlinx.html.tabIndex
import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.CustomisableComponent
import react.bootstrap.lib.WithActive
import react.bootstrap.lib.WithDisabled
import react.bootstrap.lib.WithDomEvents
import react.bootstrap.lib.WithRenderAs
import react.bootstrap.lib.ariaDisabled
import react.bootstrap.lib.transferDomEvents
import react.dom.WithClassName
import react.dom.a

class NavLink : CustomisableComponent<NavLink.RendererProps, NavLink.Props, RState>() {
    override fun RendererProps.handleProps() {
        val navLinkClasses = mutableSetOf(
            ClassNames.NAV_LINK
        )

        if (props.active == true) {
            navLinkClasses.add(ClassNames.ACTIVE)
        }

        if (props.disabled == true) {
            navLinkClasses.add(ClassNames.DISABLED)

            tabIndex = -1
            // Aria Disabled would need be set here, too. This is currently not possible, because [fixAttributeName] in
            // ReactDOMAttributes.kt does not fix the html property name correctly
        }

        className = props.className.appendClass(navLinkClasses)

        transferDomEvents(props)
    }

    override fun RBuilder.getDefaultRenderer(): ReactElement = a(href = props.href, target = props.target) {
        if (props.disabled == true) {
            attrs {
                tabIndex = "-1"
                ariaDisabled = true
            }
        }
    }

    interface Props : WithClassName, WithRenderAs, WithActive, WithDisabled, WithDomEvents {
        var href: String?
        var target: String?
    }

    interface RendererProps : WithClassName, WithDomEvents {
        var tabIndex: Int?
    }
}
