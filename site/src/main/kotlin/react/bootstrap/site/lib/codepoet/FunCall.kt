package react.bootstrap.site.lib.codepoet

import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.lib.codepoet.IndentTool.getIndent
import react.bootstrap.site.lib.codepoet.IndentTool.indentLines
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
    private val arguments = mutableSetOf<Argument>()
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
        arguments.add(Argument(argumentName, value))
        return this
    }

    fun addArgument(value: Any): FunCall {
        arguments.add(Argument(value = value))
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
                            arguments.buildArgString(
                                ",\n",
                                "\n",
                                "\n",
                                getIndent(1)
                            )
                        )
                    } else {
                        append(arguments.buildArgString())
                    }
                }

                append(")")
            }

            if (lambdaArgumentContent == null) {
                return@buildString
            }

            val content = lambdaArgumentContent!!

            if (style == Style.INLINE || style == Style.NEW_INLINE) {
                if (content.isEmpty()) {
                    append(" { }")
                } else {
                    append(" { $content }")
                }

                if (appendSemicolon) {
                    append(";")
                }

                if (style == Style.NEW_INLINE) {
                    append("\n")
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

    private fun Collection<Argument>.buildArgString(
        separator: CharSequence = ", ",
        prefix: CharSequence = "",
        postfix: CharSequence = "",
        linePrefix: CharSequence = ""
    ): String = joinToString(separator, prefix, postfix) { arg ->
        buildString {
            append(linePrefix)
            append(arg.build())
        }
    }

    internal enum class Style {
        INLINE,
        BLOCK,
        NEW_INLINE
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

    internal data class Argument constructor(
        val name: String? = null,
        val value: Any
    ) {
        internal data class PureValue(val value: String)

        fun build() = buildString {
            name?.apply {
                append("$this = ")
            }

            append(
                when (value) {
                    is ClassNames -> "\"\${${value.nestedName}}\""
                    is Enum<*> -> value.nestedName
                    is PureValue -> value.value
                    is LambdaValue -> value.build()
                    is String -> "\"$value\""
                    else -> value
                }
            )
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
