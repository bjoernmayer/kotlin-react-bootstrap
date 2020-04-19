package react.bootstrap.site.components.docs.about

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.router.dom.RouteResultProps

class About : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        h1 { +"About" }
    }
}
