package react.bootstrap.content.typography

import kotlinx.html.P
import react.RBuilder
import react.ReactElement
import react.bootstrap.addClass
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.p

fun RDOMBuilder<P>.toLead() =
    addClass("${ClassNames.LEAD}")

fun RBuilder.lead(classes: String? = null, block: RDOMBuilder<P>.() -> Unit): ReactElement =
    p(classes.appendClass("${ClassNames.LEAD}"), block)
