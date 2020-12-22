package react.bootstrap.site

import kotlinext.js.require
import kotlinx.browser.document
import react.bootstrap.site.components.app
import react.dom.render

@JsModule("favicon.ico")
external val favicon: dynamic

fun main() {
    require("style.css")

    val rootDiv = document.getElementById("root")
    render(rootDiv) {
        app()
    }

    document.querySelector("link[rel=\"shortcut icon\"]")?.apply {
        setAttribute("href", favicon.default as String)
    }
}
