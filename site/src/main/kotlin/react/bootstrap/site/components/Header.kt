package react.bootstrap.site.components

import react.RBuilder
import react.bootstrap.ariaLabel
import react.dom.a
import react.dom.div
import react.dom.header
import react.dom.img
import react.dom.li
import react.dom.ul
import react.router.dom.navLink

@JsNonModule
@JsModule("kotlin.png")
external val kotlinLogo: dynamic

@JsNonModule
@JsModule("react.png")
external val reactLogo: dynamic

@JsNonModule
@JsModule("bootstrap.png")
external val bootstrapLogo: dynamic

@JsNonModule
@JsModule("github.png")
external val githubLogo: dynamic

fun RBuilder.header() {
    header("navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar") {
        a(href = "/", classes = "navbar-brand mr-0 mr-md-2") {
            attrs {
                ariaLabel = "Kotlin React Bootstrap"
            }
            img(src = kotlinLogo.default as? String) { attrs { height = "30" } }
            img(src = reactLogo.default as? String) { attrs { height = "30" } }
            img(src = bootstrapLogo.default as? String) { attrs { height = "30" } }
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
                    img(src = githubLogo.default as? String) { attrs { height = "30" } }
                    attrs {
                        ariaLabel = "GitHub"
                        rel = "noopener"
                    }
                }
            }
        }
    }
}
