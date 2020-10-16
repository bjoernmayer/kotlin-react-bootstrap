package react.bootstrap.site.lib.codepoet

import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.kt
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

internal class FunCall private constructor(
    private val function: KFunction<*>,
    private val style: Style,
    private val putArgumentsOnSeparateLine: Boolean,
    private val appendSemicolon: Boolean
) {
    private val parents = mutableSetOf<String>()

    private val arguments = mutableListOf<Pair<String?, Any>>()

    private var lambdaArgumentContent: String? = null

    private var lambda: String? = null

    fun nestedBy(klazz: KClass<*>): FunCall {
        parents.add(klazz.simpleName!!)
        return this
    }

    fun nestedBy(property: KProperty<*>): FunCall {
        parents.add(property.name)
        return this
    }

    fun addArgument(argumentName: String, value: Any): FunCall {
        arguments.add(argumentName to value)
        return this
    }

    fun addArgument(value: Any): FunCall {
        arguments.add(null to value)
        return this
    }

    fun addArgument(parameterName: String, value: ClassNames): FunCall {
        arguments.add(parameterName to "\${${value.kt}}")
        return this
    }

    fun setLambdaArgument(vararg contents: String): FunCall {
        lambdaArgumentContent = contents
            .joinToString("")
            .run {
                // Cut last newline
                if (style == Style.BLOCK) {
                    if (endsWith("\n")) {
                        substringBeforeLast("\n")
                    } else {
                        this
                    }.addIndentForEachLine()
                } else {
                    this
                }
            }

        return this
    }

    fun setEmptyLambdaArgument() = setLambdaArgument("")

    fun build(): String =
        buildString {
            if (parents.isEmpty()) {
                append(function.name)
            } else {
                append(parents.joinToString("."))
                append(".${function.name}")
            }

            if (arguments.isNotEmpty() || lambdaArgumentContent == null) {
                append("(")

                if (arguments.isNotEmpty()) {
                    if (putArgumentsOnSeparateLine) {
                        append(
                            arguments.toArgString(
                                ",\n",
                                "\n",
                                "\n${getIndent(0)}",
                                getIndent(1)
                            )
                        )
                    } else {
                        append(arguments.toArgString())
                    }
                }

                append(")")
            }

            if (lambdaArgumentContent == null) {
                return@buildString
            }

            val content = lambdaArgumentContent!!

            //  || style == Style.INLINE_BLOCK
            if (style == Style.INLINE) {
                if (content.isEmpty()) {
                    append(" { }")
                } else {
                    append(" { $content }")
                }

                if (appendSemicolon) {
                    append(";")
                }
            }

            if (style == Style.BLOCK) {
                appendLine(" {")
                appendLine(content)

                if (appendSemicolon) {
                    appendLine("};")
                } else {
                    appendLine("}")
                }
            }
        }

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

    internal enum class Style {
        INLINE,
        //        INLINE_BLOCK,
        BLOCK
    }

    companion object {
        fun builder(
            function: KFunction<*>,
            style: Style = Style.BLOCK,
            putArgumentsOnSeparateLine: Boolean = false,
            appendSemicolon: Boolean = false,
        ) = FunCall(function, style, putArgumentsOnSeparateLine, appendSemicolon)
    }
}
