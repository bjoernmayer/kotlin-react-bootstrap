package react.bootstrap.site.components.docs.fixings

import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RElementBuilder
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.external.PrismLight
import react.dom.figure

internal typealias CodeExampleBuilder = RElementBuilder<CodeExample.Props>

@JsNonModule
@JsModule("react-syntax-highlighter/dist/esm/styles/prism/coy")
external val coy: dynamic

@JsNonModule
@JsModule("react-syntax-highlighter/dist/esm/languages/prism/kotlin")
external val kotlin: dynamic

internal fun CodeExampleBuilder.ln(indentationLevel: Int = 0, block: CodeExampleBuilder.() -> Unit) {
    for (x in 1..indentationLevel) {
        +"    "
    }
    block()
    +"\n"
}

internal fun CodeExampleBuilder.import(afterReactBootstrap: String) {
    ln { +"import react.bootstrap.$afterReactBootstrap" }
}

internal fun CodeExampleBuilder.importClassNames() {
    import("lib.${ClassNames::class.simpleName}")
}

internal fun CodeExampleBuilder.ktB(
    indentationLevel: Int = 0,
    opener: String,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) {
    ln(indentationLevel) { +"$opener {" }
    block(indentationLevel + 1)
    ln(indentationLevel) { +"}" }
}

internal fun CodeExampleBuilder.ktB(
    indentationLevel: Int = 0,
    opener: String,
    args: String,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) = ktB(indentationLevel, "$opener($args)", block)

internal fun CodeExampleBuilder.ktB(
    indentationLevel: Int = 0,
    opener: String,
    vararg args: Pair<String, String>,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) = ktB(indentationLevel, opener, args.joinToString { "${it.first} = ${it.second}" }, block)

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    content: String
) {
    if (content.isEmpty()) {
        ln(indentationLevel) { +"$opener { }" }
    } else {
        ln(indentationLevel) { +"$opener { $content }" }
    }
}

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    args: String,
    content: String
) {
    ktIB(indentationLevel, "$opener($args)", content)
}

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    vararg args: Pair<String, String>,
    content: () -> String
) = ktIB(indentationLevel, opener, args.joinToString { "${it.first} = ${it.second}" }, content())

internal fun CodeExampleBuilder.ktIB(
    indentationLevel: Int = 0,
    opener: String,
    vararg args: Pair<String, String>
) = ktIB(indentationLevel, opener, *args) { "+\"${args.joinToString { "${it.first} = ${it.second}" }}\"" }

internal class CodeExample : RComponent<CodeExample.Props, RState>() {
    override fun RBuilder.render() {
        val code = props.code ?: ""

        PrismLight.registerLanguage("kotlin", kotlin.default)

        figure("highlight") {
            PrismLight {
                attrs {
                    language = "kotlin"
                    style = coy.default
                }
                +code
            }
        }
    }

    interface Props : RProps {
        var code: String?
    }
}

internal fun RBuilder.codeExample(block: RHandler<CodeExample.Props>): ReactElement {
    val code = CodeExampleBuilder(jsObject()).apply {
        block()
    }

    return child(CodeExample::class) {
        attrs.code = code.childList.joinToString("")
    }
}
