package react.bootstrap.site

import react.bootstrap.site.components.app
import react.dom.render
import kotlin.browser.document

fun main() {
    style()

    val rootDiv = document.getElementById("root")
    render(rootDiv) {
        app()
    }
}
