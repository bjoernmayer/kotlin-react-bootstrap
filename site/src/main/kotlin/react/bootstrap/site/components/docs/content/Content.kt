package react.bootstrap.site.components.docs.content

import react.RProps
import react.bootstrap.site.components.docs.content.typography.Typography
import react.child
import react.functionalComponent
import react.router.dom.route
import react.router.dom.switch
import react.router.dom.useRouteMatch

val Content = functionalComponent<RProps> {
    val match = useRouteMatch<RProps>() ?: return@functionalComponent

    switch {
        route("${match.path}/typography/") { child(Typography) }
    }
}
