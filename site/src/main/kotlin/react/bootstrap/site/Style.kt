package react.bootstrap.site

import kotlinx.css.*
import kotlinx.css.properties.border
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
    }
    StyledComponents.injectGlobal(styles.toString())
}
