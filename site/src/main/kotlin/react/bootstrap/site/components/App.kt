package react.bootstrap.site.components

import react.RBuilder
import react.RProps
import react.bootstrap.layout.containerFluid
import react.bootstrap.site.components.docs.Docs
import react.bootstrap.site.components.docs.from
import react.bootstrap.site.external.BrowserRouterProps
import react.child
import react.dom.div
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

internal const val PATH_DOCS = "/docs/"

fun RBuilder.app() =
    browserRouter {
        attrs {
            @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
            (this as BrowserRouterProps).basename ="/kotlin-react-bootstrap"
        }
        div {
            header()
            containerFluid {
                switch {
                    route<RProps>(PATH_DOCS) {
                        child(Docs::class) {
                            attrs {
                                from(it)
                            }
                        }
                    }
                    route("/") { child(Home) }
                }
            }
        }
    }
