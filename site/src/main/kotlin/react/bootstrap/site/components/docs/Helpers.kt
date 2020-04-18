package react.bootstrap.site.components.docs

import kotlinx.html.*
import react.RBuilder
import react.bootstrap.data
import react.dom.*

fun RBuilder.kotlinExample(block: RDOMBuilder<CODE>.() -> Unit) =
    figure("highlight") {
        pre {
            code("language-kotlin") {
                attrs {
                    data("lang", "kotlin")
                }
                block()
            }
        }
    }

fun RBuilder.example(block: RDOMBuilder<DIV>.() -> Unit) =
    div("bd-example") {
        block()
    }

fun RBuilder.contentTitle(block: RDOMBuilder<H2>.() -> Unit) =
    h2("bd-content-title", block)

fun RBuilder.contentPageTitle(block: RDOMBuilder<H1>.() -> Unit) =
    h1("bd-title", block)

fun RBuilder.contentPageLead(block: RDOMBuilder<P>.() -> Unit) =
    p("bd-lead", block)
