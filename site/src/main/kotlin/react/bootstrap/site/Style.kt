package react.bootstrap.site

import kotlinx.css.BorderStyle
import kotlinx.css.CSSBuilder
import kotlinx.css.Color
import kotlinx.css.background
import kotlinx.css.color
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.properties.border
import kotlinx.css.rem
import kotlinx.css.rgba
import styled.StyledComponents
import styled.injectGlobal

const val BD_EXAMPLE = "bd-example"

fun style() {
    kotlinext.js.require("docs.min.css")

    val styles = CSSBuilder().apply {
        ".bd-navbar" {
            background = "linear-gradient(45deg, #4193d3 0%,#7f6de3 25%,#c857bc 50%,#c857bc 50%,#f88909 98%);"
        }
        ".$BD_EXAMPLE" {
            padding(1.5.rem)
            margin(top = 1.rem)
            border(width = 0.2.rem, style = BorderStyle.solid, color = Color("#f8f9fa"))
        }

        ".bd-navbar .navbar-nav .nav-link" {
            color = rgba(255,255,255,.5);
        }
    }
    StyledComponents.injectGlobal(styles.toString())
}
