package react.bootstrap.site.components.docs.fixings

import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RElementBuilder
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.FunctionCallCodeBuilder
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.external.PrismLight
import react.dom.figure
import kotlin.reflect.KFunction

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

internal data class Quoted(
    val value: String
)

internal class CodeExampleBuilder(private val indent: Int) : RElementBuilder<CodeExample.Props>(jsObject()) {
    internal fun joinToString(): String = childList.joinToString("")

    internal fun string(content: String) {
        +"+\"$content\""
    }
    internal fun plusString(content: String): String = "+\"$content\""

    operator fun FunctionCallCodeBuilder.unaryPlus() {
        +this.build()
    }

    internal fun multiline(vararg contents: String) {
        ln { +"+\"\"\"" }
        // no ln to not have indent
        +contents.joinToString("\n", postfix = "\n")
        ln { +"\"\"\"" }
    }

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

    internal fun functionCall(function: KFunction<*>): FunctionCallCodeBuilder =
        FunctionCallCodeBuilder()
            .function(function)

    internal fun ktFun(
        function: KFunction<*>,
        parents: List<String> = emptyList(),
        breakDownArgs: Boolean = false,
        style: FunStyle = FunStyle.BLOCK,
        args: Map<out String?, Any> = emptyMap(),
        block: (CodeExampleBuilder.() -> Unit)? = null
    ) {
        +buildString {
            append(getIndent(indent))

            if (parents.isEmpty()) {
                append(function.name)
            } else {
                append(buildNestedName(function.name, *parents.toTypedArray()))
            }

            // print args or () if there is no block
            if (args.isNotEmpty() || block == null) {
                append("(")

                if (args.isNotEmpty()) {
                    if (breakDownArgs) {
                        append(
                            args.toArgString(
                                ",\n",
                                "\n",
                                "\n${getIndent(indent)}",
                                getIndent(indent + 1)
                            )
                        )
                    } else {
                        append(args.toArgString())
                    }
                }

                append(")")
            }

            if (block != null) {
                // apply new level of indent only for block style
                val newIndent = if (style == FunStyle.INLINE || style == FunStyle.INLINE_BLOCK) {
                    indent - 2
                } else {
                    indent + 1
                }

                val content = CodeExampleBuilder(newIndent).apply {
                    block()
                }.joinToString()

                if (style == FunStyle.INLINE || style == FunStyle.INLINE_BLOCK) {
                    if (content.isEmpty()) {
                        append(" { }")
                    } else {
                        append(" { $content }")
                    }
                }

                if (style == FunStyle.BLOCK) {
                    val strippedContent =
                        if (content.endsWith("\n")) {
                            content.substringBeforeLast("\n")
                        } else {
                            content
                        }

                    append(" {\n$strippedContent\n${getIndent(indent)}}")
                }
            }

            if (style == FunStyle.BLOCK || style == FunStyle.INLINE_BLOCK) {
                append("\n")
            }
        }
    }

    internal fun ktBlock(opener: String, block: (CodeExampleBuilder.() -> Unit)) {
        val content = CodeExampleBuilder(indent + 1).apply {
            block()
        }.joinToString()

        val strippedContent =
            if (content.endsWith("\n")) {
                content.substringBeforeLast("\n")
            } else {
                content
            }

        ln {
            +"$opener {\n$strippedContent\n${getIndent(indent)}}"
        }
    }

    private fun getIndent(level: Int): String =
        buildString {
            for (x in 1..level) {
                append("    ")
            }
        }

    private fun Map<out String?, Any>.toArgString(
        separator: CharSequence = ", ",
        prefix: CharSequence = "",
        postfix: CharSequence = "",
        linePrefix: CharSequence = ""
    ): String = entries.joinToString(separator, prefix, postfix) {
        buildString {
            append(linePrefix)

            it.key?.apply {
                append("$this = ")
            }

            if (it.value is Quoted) {
                append("\"${(it.value as Quoted).value}\"")
            } else {
                append(it.value)
            }
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

internal enum class FunStyle {
    INLINE,
    INLINE_BLOCK,
    BLOCK
}
