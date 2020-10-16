package react.bootstrap.site.lib.codepoet

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

internal class FunSpec private constructor(
    private val function: KFunction<*>,
    private val putParametersOnSeparateLines: Boolean
) {
    private val parents = mutableSetOf<String>()
    private val parameters = mutableSetOf<Parameter>()
    private var returns: String? = null

    fun nestedBy(klazz: KClass<*>): FunSpec {
        parents.add(klazz.simpleName!!)
        return this
    }

    fun nestedBy(property: KProperty<*>): FunSpec {
        parents.add(property.name)
        return this
    }

    fun nestedBy(generic: Generic): FunSpec {
        parents.add(generic.simpleName)
        return this
    }

    fun nestedBy(name: String): FunSpec {
        parents.add(name)
        return this
    }

    fun addParameter(
        parameterName: String,
        type: KClass<*>,
        nullable: Boolean = false,
        default: String? = null
    ): FunSpec {
        parameters.add(
            Parameter(
                parameterName,
                type.simpleName!!,
                nullable,
                default
            )
        )

        return this
    }

    fun addParameter(
        parameterName: String,
        type: String,
        nullable: Boolean = false,
        default: String? = null
    ): FunSpec {
        parameters.add(
            Parameter(
                parameterName,
                type,
                nullable,
                default
            )
        )

        return this
    }


    fun addParameter(
        parameterName: String,
        type: Generic,
        nullable: Boolean = false,
        default: String? = null
    ): FunSpec {
        parameters.add(
            Parameter(
                parameterName,
                type.simpleName,
                nullable,
                default
            )
        )

        return this
    }

    fun returns(type: KClass<*>): FunSpec {
        returns = type.simpleName!!
        return this
    }

    fun returns(type: String): FunSpec {
        returns = type
        return this
    }

    fun build(): String = buildString {
        append("fun ")
        if (parents.isEmpty()) {
            append(function.name)
        } else {
            append(parents.joinToString("."))
            append(".${function.name}")
        }

        if (putParametersOnSeparateLines) {
            appendLine("(")
        } else {
            append("(")
        }
        append(
            parameters.map {
                buildString {
                    append("${it.name}: ${it.type}")

                    if (it.nullable) {
                        append("?")
                    }

                    if (it.default !== null) {
                        append(" = ${it.default}")
                    }
                }
            }.run {
                if (putParametersOnSeparateLines) {
                    joinToString(",\n", postfix = "\n") {
                        "    $it"
                    }
                } else {
                    joinToString(", ")
                }
            }
        )
        appendLine(
            buildString {
                append(")")

                returns?.also {
                    append(": $it")
                }
            }
        )
    }

    internal data class Parameter constructor(
        val name: String,
        val type: String,
        val nullable: Boolean = false,
        val default: String? = null
    ) {
        companion object {
            const val NULL = "null"
        }
    }

    companion object {
        fun builder(
            function: KFunction<*>,
            putParametersOnSeparateLines: Boolean = true
        ) = FunSpec(function, putParametersOnSeparateLines)
    }
}
