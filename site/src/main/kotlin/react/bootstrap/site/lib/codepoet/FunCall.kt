package react.bootstrap.site.lib.codepoet

import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.lib.codepoet.IndentTool.indentLines
import react.bootstrap.site.lib.codepoet.IndentTool.getIndent
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

internal class FunCall private constructor(
    private val functionName: String,
    private val style: Style,
    private val putArgumentsOnSeparateLine: Boolean,
    private val appendSemicolon: Boolean
) {
    private val parents = mutableSetOf<Parent>()

    private val arguments = mutableListOf<Pair<String?, Any>>()

    private var lambdaArgumentContent: String? = null

    fun nestedBy(klazz: KClass<*>, nullable: Boolean = false): FunCall {
        parents.add(Parent(klazz.simpleName!!, nullable))
        return this
    }

    fun nestedBy(property: KProperty<*>, nullable: Boolean = false): FunCall {
        parents.add(Parent(property.name, nullable))
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

    fun setLambdaArgument(content: String, vararg contents: String): FunCall {
        lambdaArgumentContent = listOf(content, *contents)
            .joinToString("")
            .run {
                if (style == Style.BLOCK) {
                    indentLines(this)
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
                append(functionName)
            } else {
                append(
                    parents.joinToString(".") {
                        it.build()
                    }
                )
                append(".$functionName")
            }

            if (arguments.isNotEmpty() || lambdaArgumentContent == null) {
                append("(")

                if (arguments.isNotEmpty()) {
                    if (putArgumentsOnSeparateLine) {
                        append(
                            arguments.toArgString(
                                ",\n",
                                "\n",
                                "\n",
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
                console.log(content)
                console.log(content.endsWith("\n    "))

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

    internal enum class Style {
        INLINE,
        BLOCK
    }

    internal data class Parent(
        private val name: String,
        private val nullable: Boolean = false
    ) {
        fun build() = buildString {
            append(name)

            if (nullable) {
                append("?")
            }
        }
    }

    companion object {
        fun builder(
            function: KFunction<*>,
            style: Style = Style.BLOCK,
            putArgumentsOnSeparateLine: Boolean = false,
            appendSemicolon: Boolean = false,
        ) = FunCall(function.name, style, putArgumentsOnSeparateLine, appendSemicolon)

        fun builder(
            function: Generic,
            style: Style = Style.BLOCK,
            putArgumentsOnSeparateLine: Boolean = false,
            appendSemicolon: Boolean = false,
        ) = FunCall(function.simpleName, style, putArgumentsOnSeparateLine, appendSemicolon)

        fun builder(
            function: String,
            style: Style = Style.BLOCK,
            putArgumentsOnSeparateLine: Boolean = false,
            appendSemicolon: Boolean = false,
        ) = FunCall(function, style, putArgumentsOnSeparateLine, appendSemicolon)
    }
}
