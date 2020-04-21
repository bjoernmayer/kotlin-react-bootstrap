package react.bootstrap.site.components

import react.RBuilder
import react.bootstrap.ariaLabel
import react.dom.a
import react.dom.div
import react.dom.header
import react.dom.li
import react.dom.ul
import react.router.dom.navLink

fun RBuilder.header() {
    header("navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar") {
        a(href = "/", classes = "navbar-brand mr-0 mr-md-2") {
            attrs {
                ariaLabel = "Kotlin React Bootstrap"
            }
            +"Kotlin React Bootstrap"
        }
        div("navbar-nav-scroll") {
            ul("navbar-nav bd-navbar-nav flex-row") {
                li("nav-item") {
                    navLink(to = "/", className = "nav-link", exact = true) { +"Home" }
                }
                li("nav-item") {
                    navLink(to = PATH_DOCS, className = "nav-link") { +"Documentation" }
                }
            }
        }
        ul("navbar-nav ml-md-auto") {
            li("nav-item") {
                a(
                    href = "https://github.com/bjoernmayer/kotlin-react-bootstrap",
                    target = "_blank",
                    classes = "nav-link p2"
                ) {
                    +"GitHub"
                    attrs {
                        ariaLabel = "GitHub"
                        rel = "noopener"
                    }
                }
            }
        }
    }
}
