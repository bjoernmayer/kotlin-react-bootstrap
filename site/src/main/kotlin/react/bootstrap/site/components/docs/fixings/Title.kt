package react.bootstrap.site.components.docs.fixings

import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.site.components.docs.pageTitle
import react.dom.RDOMBuilder
import react.dom.h1
import react.dom.h2

fun RBuilder.contentPageTitle(pagetitle: String, block: RDOMBuilder<H1>.() -> Unit = { }): ReactElement {
    pageTitle(pagetitle)
    return h1("bd-title") {
        +pagetitle
        block()
    }
}
fun RBuilder.contentTitle(contentTitle: String, block: RDOMBuilder<H2>.() -> Unit = { }): ReactElement =
    contentTitle(RBuilder::h2, contentTitle, block)

fun <T : HTMLTag> RBuilder.contentTitle(
    tagFun: RBuilder.(classes: String?, block: RDOMBuilder<T>.() -> Unit) -> ReactElement,
    contentTitle: String,
    block: RDOMBuilder<T>.() -> Unit
): ReactElement =
    tagFun("bd-content-title") {
        +contentTitle
        block()
    }
