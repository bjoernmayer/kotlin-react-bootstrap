package react.bootstrap.site.components.docs

import kotlinx.html.CODE
import kotlinx.html.DIV
import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.HTMLTag
import kotlinx.html.P
import react.RBuilder
import react.RProps
import react.ReactElement
import react.bootstrap.data
import react.bootstrap.layout.grid.ColAttribute
import react.bootstrap.layout.grid.ColumnCount
import react.bootstrap.site.external.MatchProps
import react.bootstrap.site.external.matchPath
import react.dom.RDOMBuilder
import react.dom.code
import react.dom.div
import react.dom.figure
import react.dom.h1
import react.dom.h2
import react.dom.p
import react.dom.pre
import react.router.dom.RouteResultProps
import kotlin.reflect.KFunction8
import kotlin.reflect.KFunction9

typealias ColFun = KFunction8<RBuilder, ColAttribute?, ColAttribute?, ColAttribute?, ColAttribute?, ColAttribute?,
    String?, (RDOMBuilder<DIV>.() -> Unit), ReactElement>

typealias RowFun = KFunction9<RBuilder, ColumnCount?, ColumnCount?, ColumnCount?, ColumnCount?, ColumnCount?, Boolean,
    String?, (RDOMBuilder<DIV>.() -> Unit), ReactElement>

fun RBuilder.kotlinExample(block: RDOMBuilder<CODE>.() -> Unit) =
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

fun RBuilder.example(block: RDOMBuilder<DIV>.() -> Unit) =
    div("bd-example") {
        block()
    }

fun RBuilder.exampleRow(block: RDOMBuilder<DIV>.() -> Unit) =
    div("bd-example-row") {
        block()
    }

fun RBuilder.contentTitle(block: RDOMBuilder<H2>.() -> Unit) =
    h2("bd-content-title", block)

fun <T : HTMLTag> RBuilder.contentTitle(
    tagFun: RBuilder.(String?, RDOMBuilder<T>.() -> Unit) -> ReactElement,
    block: RDOMBuilder<T>.() -> Unit
) =
    tagFun("bd-content-title", block)

fun RBuilder.contentPageTitle(block: RDOMBuilder<H1>.() -> Unit) =
    h1("bd-title", block)

fun RBuilder.contentPageLead(block: RDOMBuilder<P>.() -> Unit) =
    p("bd-lead", block)

fun RouteResultProps<RProps>.from(props: RouteResultProps<RProps>) {
    history = props.history
    location = props.location
    match = props.match
}

data class MatchProps(
    override var path: String,
    override var exact: Boolean = false,
    override var strict: Boolean = false
) : MatchProps

fun pathMatches(path: String, props: MatchProps): Boolean =
    matchPath(path, props) !== null
