package react.bootstrap.site.components.docs.fixings

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.site.external.Prism
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.figure

@JsNonModule
@JsModule("react-syntax-highlighter/dist/esm/styles/prism/coy")
external val coy: dynamic

fun RBuilder.codeBox(block: RBuilder.() -> Unit): ReactElement {
    val code = RBuilder().apply {
        block()
    }

    val codeString = code.childList.joinToString("")

    return figure("highlight") {
        Prism {
            attrs {
                language = "kotlin"
                style = coy.default
            }
            +codeString
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
