package react.bootstrap.site

import react.bootstrap.site.components.app
import react.dom.render
import kotlin.browser.document

fun main() {
    kotlinext.js.require("docs.min.css")
    kotlinext.js.require("style.css")

    val rootDiv = document.getElementById("root")
    render(rootDiv) {
        app()
    }
}
