package react.bootstrap.site.components.docs.layout

import react.*
import react.bootstrap.site.components.docs.layout.overview.Overview
import react.router.dom.RouteResultProps
import react.router.dom.route
import react.router.dom.switch

class Layout : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        switch {
            route("${props.match.path}overview/") { child(Overview) }
        }
    }
}
