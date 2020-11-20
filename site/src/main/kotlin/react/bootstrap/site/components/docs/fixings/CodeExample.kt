package react.bootstrap.site.components.docs.fixings

import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RElementBuilder
import react.RProps
import react.RState
import react.RStatics
import react.ReactElement
import react.bootstrap.helpers.classes
import react.bootstrap.lib.bootstrap.ClassNames
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

        figure(classes(ClassNames.BG_LIGHT, ClassNames.MB_5, ClassNames.PL_3, "krbd")) {
            PrismLight {
                attrs {
                    language = props.language
                    style = coy.default
                }
                +code
            }
        }
    }

    interface Props : RProps {
        var language: String
        var code: String?
    }

    companion object : RStatics<Props, RState, CodeExample, Nothing>(CodeExample::class) {
        init {
            defaultProps = jsObject {
                language = "kotlin"
            }
        }
    }
}

internal class CodeExampleBuilder : RElementBuilder<CodeExample.Props>(jsObject()) {
    internal fun joinToString(): String = childList.joinToString("")

    internal fun plusString(content: String): String = "+\"$content\""

    internal fun appendLine(content: String) = +"$content\n"
}

internal fun RBuilder.codeExample(block: CodeExampleBuilder.() -> Unit): ReactElement {
    val code = CodeExampleBuilder().apply {
        block()
    }

    return child(CodeExample::class) {
        attrs.code = code.joinToString()
    }
}
