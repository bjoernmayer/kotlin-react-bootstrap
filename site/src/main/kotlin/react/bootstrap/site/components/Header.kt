package react.bootstrap.site.components

import kotlinx.html.A
import kotlinx.html.HEADER
import kotlinx.html.SPAN
import kotlinx.html.role
import kotlinx.html.style
import kotlinx.html.unsafe
import react.RBuilder
import react.RProps
import react.bootstrap.components.nav.navLink
import react.bootstrap.components.navbar.Navbar
import react.bootstrap.components.navbar.NavbarNavs
import react.bootstrap.components.navbar.brand
import react.bootstrap.components.navbar.navItem
import react.bootstrap.components.navbar.navbar
import react.bootstrap.content.typography.small.small
import react.bootstrap.helpers.classes
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.dom.img
import react.dom.svg
import react.router.dom.navLink

@JsModule("logo.png")
external val logo: dynamic

fun RBuilder.header() {
    navbar<HEADER>(
        expand = Breakpoints.ALL,
        theme = Navbar.Theme.DARK,
        classes = classes(ClassNames.STICKY_TOP, "krbd")
    ) {
        brand<A> {
            attrs {
                href = "#"
                ariaLabel = "Kotlin React Bootstrap"
            }
            img(src = logo.default as? String, classes = classes(ClassNames.MR_2, ClassNames.MB_1)) { }
            +"Kotlin React Bootstrap"
            small<SPAN>(classes(ClassNames.ML_1)) {
                +"0.0.0"
            }
        }
        NavbarNavs.nav {
            navItem {
                navLink<RProps>(to = "/", className = "nav-link", exact = true) { +"Home" }
            }
            navItem {
                navLink<RProps>(to = PATH_DOCS, className = "nav-link") { +"Documentation" }
            }
        }
        NavbarNavs.nav(classes(ClassNames.ML_MD_AUTO)) {
            navItem {
                navLink(href = "https://github.com/bjoernmayer/kotlin-react-bootstrap", target = "_blank") {
                    attrs {
                        ariaLabel = "GitHub"
                        rel = "noopener"
                    }
                    svg("navbar-nav-svg") {
                        attrs {
                            role = "img"
                            @Suppress("UnsafeCastFromDynamic")
                            style = kotlinext.js.js {
                                width = "1.rem"
                                height = "1rem"
                            }

                            set("viewBox", "0 0 512 499.36")
                            set("focusable", false)
                            unsafe {
                                raw(
                                    """
<title>Github</title><path fill="currentColor" fill-rule="evenodd" d="M256 0C114.64 0 0 114.61 0 256c0 113.09 73.34 209
 175.08 242.9 12.8 2.35 17.47-5.56 17.47-12.34 0-6.08-.22-22.18-.35-43.54-71.2
15.49-86.2-34.34-86.2-34.34-11.64-29.57-28.42-37.45-28.42-37.45-23.27-15.84 1.73-15.55
1.73-15.55 25.69 1.81 39.21 26.38 39.21 26.38 22.84 39.12 59.92 27.82 74.5 21.27 2.33-16.54
8.94-27.82 16.25-34.22-56.84-6.43-116.6-28.43-116.6-126.49 0-27.95 10-50.8 26.35-68.69-2.63-6.48-11.42-32.5 2.51-67.75
0 0 21.49-6.88 70.4 26.24a242.65 242.65 0 0 1 128.18 0c48.87-33.13 70.33-26.24 70.33-26.24 14 35.25 5.18 61.27 2.55
67.75 16.41 17.9 26.31 40.75 26.31 68.69 0 98.35-59.85 120-116.88 126.32 9.19 7.9 17.38 23.53 17.38 47.41 0 34.22-.31
61.83-.31 70.23 0 6.85 4.61 14.81 17.6 12.31C438.72 464.97 512 369.08 512 256.02 512 114.62 397.37 0 256 0z"></path>
"""
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
