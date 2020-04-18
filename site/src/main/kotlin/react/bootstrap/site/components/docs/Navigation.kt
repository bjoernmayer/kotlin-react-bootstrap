package react.bootstrap.site.components.docs

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.ariaLabel
import react.dom.div
import react.dom.nav
import react.router.dom.RouteResultProps
import react.router.dom.routeLink

class Navigation : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        nav("collapse bd-links") {
            attrs { ariaLabel = "Main navigation" }
            div("bd-toc-item") {
                routeLink("${props.match.path}getting-started/introduction", className = "bd-toc-link") {
                    +"Getting started"
                }
            }
            div("bd-toc-item") {
                routeLink("${props.match.path}content/reboot", className = "bd-toc-link") {
                    +"Content"
                }
            }
        }
    }
}
