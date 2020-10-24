package react.bootstrap.components.nav

import kotlinx.html.classes
import kotlinx.html.tabIndex
import react.RBuilder
import react.RComponent
import react.RState
import react.bootstrap.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.rprops.WithActive
import react.bootstrap.lib.rprops.tags.WithAttributesA
import react.bootstrap.lib.rprops.WithDisabled
import react.bootstrap.lib.rprops.WithDomEvents
import react.bootstrap.lib.rprops.WithTypeFlag
import react.bootstrap.lib.kotlinxhtml.ariaDisabled
import react.bootstrap.lib.kotlinxhtml.loadDomEvents
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.dom.a

// Todo: on active handling
class NavLink : RComponent<NavLink.Props, RState>() {
    override fun RBuilder.render() {
        val navLinkClasses = mutableSetOf(
            ClassNames.NAV_LINK
        )

        if (props.active == true) {
            navLinkClasses.add(ClassNames.ACTIVE)
        }

        if (props.disabled == true) {
            navLinkClasses.add(ClassNames.DISABLED)
        }

        val classes = props.classes.addOrInit(navLinkClasses)

        a {
            attrs {
                loadGlobalAttributes(props)
                loadDomEvents(props)
                // Set classes again, since we added a few
                this.classes = classes
                // load A attributes


                if (props.disabled == true) {
                    tabIndex = "-1"
                    ariaDisabled = true
                }
            }
            children()
        }
    }

    interface Props : WithAttributesA, WithActive, WithDisabled, WithDomEvents, WithTypeFlag<NavLink>
}
