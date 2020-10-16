package react.bootstrap.site.lib.codepoet

import react.bootstrap.site.components.docs.nestedName
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

    fun addParameter(parameter: Parameter): FunSpec {
        parameters.add(parameter)
        return this
    }

//    fun addParameter(
//        parameterName: String,
//        type: KClass<*>,
//        nullable: Boolean = false,
//        default: String? = null
//    ): FunSpec {
//        parameters.add(
//            Parameter(
//                parameterName,
//                type,
//                nullable,
//                default
//            )
//        )
//
//        return this
//    }

    fun addParameter(
        parameterName: String,
        type: String,
        nullable: Boolean = false,
        default: String? = null
    ): FunSpec = addParameter(Parameter(parameterName, type, nullable, default))

    fun <T : Enum<*>> addParameter(
        parameterName: String,
        type: KClass<T>,
        nullable: Boolean = false,
        default: T? = null
    ): FunSpec = addParameter(parameterName, type.nestedName, nullable, default?.nestedName)

    fun addParameter(
        parameterName: String,
        type: KClass<*>,
        nullable: Boolean = false,
        default: String? = null
    ): FunSpec = addParameter(parameterName, type.nestedName, nullable, default)

    fun addParameter(
        parameterName: String,
        type: Generic,
        nullable: Boolean = false,
        default: String? = null
    ): FunSpec = addParameter(Parameter(parameterName, type.simpleName, nullable, default))

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
            parameters
                .map(Parameter::build)
                .run {
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
        constructor(
            name: String,
            type: KClass<*>,
            nullable: Boolean = false,
            default: String? = null
        ) : this(name, type.nestedName, nullable, default)

        constructor(
            name: String,
            type: KClass<out Enum<*>>,
            nullable: Boolean = false,
            default: Enum<*>? = null
        ) : this(name, type.nestedName, nullable, default?.nestedName)

        constructor(
            name: String,
            type: Generic,
            nullable: Boolean = false,
            default: String? = null
        ) : this(name, type.simpleName, nullable, default)

        fun build() = buildString {
            append("${name}: ${type}")

            if (nullable) {
                append("?")
            }

            if (default !== null) {
                append(" = ${default}")
            }
        }

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
