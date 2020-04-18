package react.bootstrap.layout.grid

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.div

fun RBuilder.row(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    div(classes.appendClass("${ClassNames.ROW}"), block)
