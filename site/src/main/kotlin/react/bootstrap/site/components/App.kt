package react.bootstrap.site.components

import react.RBuilder
import react.bootstrap.layout.containerFluid
import react.bootstrap.site.components.docs.Docs
import react.child
import react.dom.div
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

internal const val PATH_DOCS = "/docs/"

fun RBuilder.app() =
    browserRouter {
        div {
            header()
            containerFluid {
                switch {
                    route(PATH_DOCS) { child(Docs) }
                    route("/") { child(Home) }
                }
            }
        }
    }

