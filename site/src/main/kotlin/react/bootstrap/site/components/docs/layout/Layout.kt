package react.bootstrap.site.components.docs.layout

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.site.components.docs.layout.grid.grid
import react.bootstrap.site.components.docs.layout.overview.Overview
import react.child
import react.router.dom.RouteResultProps
import react.router.dom.route
import react.router.dom.switch

class Layout : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        switch {
            route("${props.match.path}overview/") { child(Overview) }
            route("${props.match.path}grid/") { grid() }
        }
    }
}
