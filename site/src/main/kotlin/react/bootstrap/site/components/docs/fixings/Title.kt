package react.bootstrap.site.components.docs.fixings

import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler

fun <T : HTMLTag> RBuilder.contentTitle(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    contentTitle: String,
    block: RDOMHandler<T> = { }
): ReactElement =
    tagFun("bd-content-title") {
        +contentTitle
        block()
    }
