package react.bootstrap.site.components

import react.Fragment
import react.RBuilder
import react.RProps
import react.bootstrap.site.components.docs.Docs
import react.bootstrap.site.external.BrowserRouterProps
import react.bootstrap.site.from
import react.bootstrap.site.scrollToTop
import react.child
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

internal const val PATH_DOCS = "/docs/"

fun RBuilder.app() =
    browserRouter {
        attrs {
            @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
            (this as BrowserRouterProps).basename = "/kotlin-react-bootstrap"
        }
        child(scrollToTop)
        Fragment {
            header()
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
