package react.bootstrap.site.components.docs.fixings

import kotlinx.html.DIV
import react.RBuilder
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.site.external.PrismCode
import react.bootstrap.site.external.PrismCodeProps
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.figure

fun RBuilder.codeBox(block: RElementBuilder<PrismCodeProps>.() -> Unit): ReactElement =
    figure("highlight") {
        PrismCode {
            attrs {
                className = "language-kotlin"
                component = "pre"
            }
            block()
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
