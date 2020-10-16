package react.bootstrap.site.components.docs

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

internal class FunctionCallCodeBuilder {
    internal enum class Style {
        INLINE,
        INLINE_BLOCK,
        BLOCK
    }

    private lateinit var function: KFunction<*>
    private val parents = mutableSetOf<String>()
    private val args = mutableListOf<Pair<String?, Any>>()
    private var lambda: String? = null
    private var putArgumentsOnSeparteLine: Boolean = false
    private var style: Style = Style.BLOCK
    private var indent: Int = 0

    fun function(function: KFunction<*>): FunctionCallCodeBuilder {
        this.function = function
        return this
    }

    fun nestedBy(klazz: KClass<*>): FunctionCallCodeBuilder {
        parents.add(klazz.simpleName!!)
        return this
    }

    fun nestedBy(property: KProperty<*>): FunctionCallCodeBuilder {
        parents.add(property.name)
        return this
    }

    fun arg(parameterName: String, value: Any): FunctionCallCodeBuilder {
        args.add(parameterName to value)
        return this
    }

    fun arg(value: Any): FunctionCallCodeBuilder {
        args.add(null to value)
        return this
    }

    fun putArgumentsOnSeparteLine(): FunctionCallCodeBuilder {
        putArgumentsOnSeparteLine = true
        return this
    }

    fun putArgumentsOnSeparteLine(value: Boolean): FunctionCallCodeBuilder {
        putArgumentsOnSeparteLine = value
        return this
    }

    fun lambdaContent(content: String): FunctionCallCodeBuilder {
        lambda = content
        return this
    }

    fun lambdaCalls(innerCalls: Collection<FunctionCallCodeBuilder>): FunctionCallCodeBuilder {
        lambda = innerCalls.joinToString("\n") {
            it.build()
        }
        return this
    }

    fun lambdaCalls(vararg innerCalls: FunctionCallCodeBuilder): FunctionCallCodeBuilder =
        lambdaCalls(innerCalls.toList())

    fun lambdaCalls(innerCallsListBuilder: MutableList<FunctionCallCodeBuilder>.() -> Unit): FunctionCallCodeBuilder =
        lambdaCalls(
            mutableListOf<FunctionCallCodeBuilder>().apply {
                innerCallsListBuilder()
            }
        )

    fun emptyLambda(): FunctionCallCodeBuilder {
        lambda = ""
        return this
    }

    fun style(style: Style): FunctionCallCodeBuilder {
        this.style = style
        return this
    }

    fun inline(): FunctionCallCodeBuilder {
        this.style = Style.INLINE
        return this
    }

    fun block(): FunctionCallCodeBuilder {
        this.style = Style.BLOCK
        return this
    }

    fun build(): String =
        buildString {
            if (parents.isEmpty()) {
                append(function.name)
            } else {
                append(parents.joinToString("."))
                append(".${function.name}")
            }

            if (args.isNotEmpty() || lambda == null) {
                append("(")

                if (args.isNotEmpty()) {
                    if (putArgumentsOnSeparteLine) {
                        append(
                            args.toArgString(
                                ",\n",
                                "\n",
                                "\n${getIndent(0)}",
                                getIndent(1)
                            )
                        )
                    } else {
                        append(args.toArgString())
                    }
                }

                append(")")
            }

            if (lambda == null) {
                return@buildString
            }

            val content = lambda!!

            //  || style == Style.INLINE_BLOCK
            if (style == Style.INLINE) {
                if (content.isEmpty()) {
                    append(" { }")
                } else {
                    append(" { $content }")
                }
            }

            if (style == Style.BLOCK) {
//                val strippedContent =
//                    if (content.endsWith("\n")) {
//                        content.substringBeforeLast("\n")
//                    } else {
//                        content
//                    }

                appendLine(" {")
                appendLine(content.addIndentForEachLine())
                append("}")
            }
        }

    private fun increaseIndent() = indent++

    private fun List<Pair<String?, Any>>.toArgString(
        separator: CharSequence = ", ",
        prefix: CharSequence = "",
        postfix: CharSequence = "",
        linePrefix: CharSequence = ""
    ): String = joinToString(separator, prefix, postfix) { (key, value) ->
        buildString {
            append(linePrefix)

            key?.apply {
                append("$this = ")
            }

            if (value is String) {
                append("\"$value\"")
            } else {
                append(value)
            }
//            if (value is Quoted) {
//                append("\"${(value).value}\"")
//            } else {
//                append(value)
//            }
        }
    }

    private fun String.addIndentForEachLine() =
        split("\n").joinToString("\n") {
            "${getIndent(1)}$it"
        }

    private fun getIndent(level: Int): String =
        buildString {
            for (x in 1..level) {
                append("    ")
            }
        }
}
