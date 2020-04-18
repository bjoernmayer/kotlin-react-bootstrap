package react.bootstrap.site.components.docs.content

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.site.components.docs.content.typography.Typography
import react.router.dom.RouteResultProps
import react.router.dom.route
import react.router.dom.switch

class Content : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        switch {
            route<RProps>("${props.match.path}/typography/") {
                child(Typography::class) {
                    attrs {
                        match = it.match
                    }
                }
            }
        }
    }
}
