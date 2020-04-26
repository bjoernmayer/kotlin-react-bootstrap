package react.bootstrap.site.components.docs.fixings

import kotlinx.html.P
import react.RBuilder
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.p

fun RBuilder.contentPageLead(block: RDOMBuilder<P>.() -> Unit): ReactElement =
    p("bd-lead", block)
