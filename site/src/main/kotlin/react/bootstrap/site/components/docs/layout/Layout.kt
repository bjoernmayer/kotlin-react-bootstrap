package react.bootstrap.site.components.docs.layout

import react.RProps
import react.bootstrap.site.components.docs.layout.overview.Overview
import react.child
import react.functionalComponent
import react.router.dom.route
import react.router.dom.switch
import react.router.dom.useRouteMatch

val Layout = functionalComponent<RProps> {
    val match = useRouteMatch<RProps>() ?: return@functionalComponent

    switch {
        route("${match.url}/overview/") { child(Overview) }
    }
}
