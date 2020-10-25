package react.bootstrap.components.nav

import kotlinext.js.jsObject
import kotlinx.html.classes
import kotlinx.html.tabIndex
import react.RBuilder
import react.RComponent
import react.RState
import react.RStatics
import react.bootstrap.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.react.rprops.WithActive
import react.bootstrap.lib.react.rprops.tags.WithAttributesA
import react.bootstrap.lib.react.rprops.WithDisabled
import react.bootstrap.lib.react.rprops.WithDomEvents
import react.bootstrap.lib.react.identifiable.IdentifiableProps
import react.bootstrap.lib.kotlinxhtml.ariaDisabled
import react.bootstrap.lib.kotlinxhtml.loadAttributes
import react.bootstrap.lib.kotlinxhtml.loadDomEvents
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.dom.a

// Todo: on active handling
class NavLink : BootstrapComponent<NavLink.Props, RState>() {
    override fun buildClasses(): Set<ClassNames> {
        val navLinkClasses = mutableSetOf(
            ClassNames.NAV_LINK
        )

        if (props.active == true) {
            navLinkClasses.add(ClassNames.ACTIVE)
        }

        if (props.disabled == true) {
            navLinkClasses.add(ClassNames.DISABLED)
        }

        return navLinkClasses
    }

    override fun RBuilder.render() {
        a {
            attrs {
                loadGlobalAttributes(props)
                loadDomEvents(props)
                loadAttributes(props)

                classes = getComponentClasses()

                if (props.disabled == true) {
                    tabIndex = "-1"
                    ariaDisabled = true
                }
            }
            children()
        }
    }

    interface Props : WithAttributesA, WithActive, WithDisabled, WithDomEvents, IdentifiableProps<NavLink>

    companion object : RStatics<Props, RState, NavLink, Nothing>(NavLink::class) {
        init {
            defaultProps = jsObject {
                componentType = NavLink::class
            }
        }
    }
}
