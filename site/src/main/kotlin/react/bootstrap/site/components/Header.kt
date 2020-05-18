package react.bootstrap.site.components

import kotlinx.html.role
import kotlinx.html.unsafe
import react.RBuilder
import react.RProps
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.ariaLabel
import react.dom.a
import react.dom.div
import react.dom.header
import react.dom.img
import react.dom.li
import react.dom.svg
import react.dom.ul
import react.router.dom.navLink

@JsModule("logo.png")
external val logo: dynamic

fun RBuilder.header() {
    header("navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar") {
        a(href = "/", classes = "navbar-brand ${ClassNames.MR_0} ${ClassNames.MR_MD_2}") {
            attrs {
                ariaLabel = "Kotlin React Bootstrap"
            }
            img(src = logo.default as? String, classes = "${ClassNames.MR_2}") { attrs { height = "30" } }
            +"Kotlin React Bootstrap"
        }
        div("navbar-nav-scroll") {
            ul("navbar-nav bd-navbar-nav flex-row") {
                li("nav-item") {
                    navLink<RProps>(to = "/", className = "nav-link", exact = true) { +"Home" }
                }
                li("nav-item") {
                    navLink<RProps>(to = PATH_DOCS, className = "nav-link") { +"Documentation" }
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
                    svg("navbar-nav-svg") {
                        attrs {
                            role = "img"

                            set("viewBox", "0 0 512 499.36")
                            set("focusable", false)
                            unsafe {
                                raw(
                                    "<title>Github</title><path fill=\"currentColor\" fill-rule=\"evenodd\" d=\"M256" +
                                        " 0C114.64 0 0 114.61 0 256c0 113.09 73.34 209 175.08 242.9 12.8 2.35 17.47-5" +
                                        ".56 17.47-12.34 0-6.08-.22-22.18-.35-43.54-71.2 15.49-86.2-34.34-86.2-34.34-" +
                                        "11.64-29.57-28.42-37.45-28.42-37.45-23.27-15.84 1.73-15.55 1.73-15.55 25.69 " +
                                        "1.81 39.21 26.38 39.21 26.38 22.84 39.12 59.92 27.82 74.5 21.27 2.33-16.54 8" +
                                        ".94-27.82 16.25-34.22-56.84-6.43-116.6-28.43-116.6-126.49 0-27.95 10-50.8 26" +
                                        ".35-68.69-2.63-6.48-11.42-32.5 2.51-67.75 0 0 21.49-6.88 70.4 26.24a242.65 2" +
                                        "42.65 0 0 1 128.18 0c48.87-33.13 70.33-26.24 70.33-26.24 14 35.25 5.18 61.27" +
                                        " 2.55 67.75 16.41 17.9 26.31 40.75 26.31 68.69 0 98.35-59.85 120-116.88 126." +
                                        "32 9.19 7.9 17.38 23.53 17.38 47.41 0 34.22-.31 61.83-.31 70.23 0 6.85 4.61 " +
                                        "14.81 17.6 12.31C438.72 464.97 512 369.08 512 256.02 512 114.62 397.37 0 256" +
                                        " 0z\"></path>"
                                )
                            }
                        }
                    }
                    attrs {
                        ariaLabel = "GitHub"
                        rel = "noopener"
                    }
                }
            }
        }
    }
}
