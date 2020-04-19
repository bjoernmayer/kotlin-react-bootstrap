package react.bootstrap.site.components.docs

import kotlinx.html.*
import react.RBuilder
import react.RProps
import react.bootstrap.data
import react.bootstrap.site.external.MatchProps
import react.bootstrap.site.external.matchPath
import react.dom.*
import react.router.dom.RouteResultProps

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
