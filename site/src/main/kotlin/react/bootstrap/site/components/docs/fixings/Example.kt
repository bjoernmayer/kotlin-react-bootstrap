package react.bootstrap.site.components.docs.fixings

import kotlinx.html.CODE
import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.data
import react.dom.RDOMBuilder
import react.dom.code
import react.dom.div
import react.dom.figure
import react.dom.pre

fun RBuilder.codeBox(block: RDOMBuilder<CODE>.() -> Unit): ReactElement =
    figure("highlight") {
        pre {
            code("kotlin") {
                attrs {
                    data("lang", "kotlin")
                }
                block()
            }
        }
    }

fun RBuilder.example(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    div(classes.appendClass("bd-example"), block)

fun RBuilder.exampleRow(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    div(classes.appendClass("bd-example-row")) {
        block()
    }

fun RBuilder.flexColsExampleRow(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    exampleRow(classes.appendClass("bd-example-row-flex-cols"), block)
