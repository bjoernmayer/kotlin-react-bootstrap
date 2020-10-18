package react.bootstrap.site.components.docs.fixings

import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RElementBuilder
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.external.PrismLight
import react.dom.figure

@JsNonModule
@JsModule("react-syntax-highlighter/dist/esm/styles/prism/coy")
external val coy: dynamic

@JsNonModule
@JsModule("react-syntax-highlighter/dist/esm/languages/prism/kotlin")
external val kotlin: dynamic

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

internal class CodeExampleBuilder(private val indent: Int) : RElementBuilder<CodeExample.Props>(jsObject()) {
    internal fun joinToString(): String = childList.joinToString("")

    internal fun string(content: String) {
        +"+\"$content\""
    }

    internal fun plusString(content: String): String = "+\"$content\""

    internal fun ln(block: CodeExampleBuilder.() -> Unit) {
        +getIndent(indent)
        block()
        +"\n"
    }

    internal fun ln(content: String) {
        ln {
            string(content)
        }
    }

    internal fun import(afterReactBootstrap: String) {
        ln { +"import react.bootstrap.$afterReactBootstrap" }
    }

    internal fun importClassNames() {
        import("lib.${ClassNames::class.simpleName}")
    }

    private fun getIndent(level: Int): String =
        buildString {
            for (x in 1..level) {
                append("    ")
            }
        }
}

internal fun RBuilder.codeExample(block: CodeExampleBuilder.() -> Unit): ReactElement {
    val code = CodeExampleBuilder(0).apply {
        block()
    }

    return child(CodeExample::class) {
        attrs.code = code.joinToString()
    }
}
