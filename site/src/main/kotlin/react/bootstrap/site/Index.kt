package react.bootstrap.site

import kotlinx.html.MAIN
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.ReactElement
import react.bootstrap.site.components.app
import react.dom.RDOMBuilder
import react.dom.render
import react.dom.tag
import kotlin.browser.document

// Todo: remove as soon as it is available in kotlin-react ...
inline fun RBuilder.main(classes: String? = null, block: RDOMBuilder<MAIN>.() -> Unit): ReactElement =
    tag(block) { MAIN(attributesMapOf("class", classes), it) }

@JsModule("favicon.ico")
external val favicon: dynamic

fun main() {
    kotlinext.js.require("docs.min.css")
    kotlinext.js.require("style.css")

    val rootDiv = document.getElementById("root")
    render(rootDiv) {
        app()
    }

    document.querySelector("link[rel=\"shortcut icon\"]")?.apply {
        setAttribute("href", favicon.default as String)
    }
}
