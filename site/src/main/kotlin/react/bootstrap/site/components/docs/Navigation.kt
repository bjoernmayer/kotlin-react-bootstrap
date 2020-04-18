package react.bootstrap.site.components.docs

import react.RProps
import react.bootstrap.ariaLabel
import react.dom.div
import react.dom.nav
import react.functionalComponent
import react.router.dom.routeLink
import react.router.dom.useRouteMatch

val Navigation = functionalComponent<RProps> {
    val match = useRouteMatch<RProps>() ?: return@functionalComponent

    nav("collapse bd-links") {
        attrs { ariaLabel = "Main navigation" }
        div("bd-toc-item") {
            routeLink("${match.url}/getting-started/introduction", className = "bd-toc-link") {
                +"Getting started"
            }
        }
        div("bd-toc-item") {
            routeLink("${match.url}/content/reboot", className = "bd-toc-link") {
                +"Content"
            }
        }
    }
}
