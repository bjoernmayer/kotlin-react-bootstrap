package react.bootstrap.site.components.docs.fixings

import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.dom.RDOMBuilder

fun <T : HTMLTag> RBuilder.contentTitle(
    tagFun: RBuilder.(classes: String?, block: RDOMBuilder<T>.() -> Unit) -> ReactElement,
    contentTitle: String,
    block: RDOMBuilder<T>.() -> Unit = { }
): ReactElement =
    tagFun("bd-content-title") {
        +contentTitle
        block()
    }
