package react.bootstrap.site.lib.codepoet

import react.bootstrap.site.components.docs.nestedName
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

internal class FunSpec private constructor(
    private val function: KFunction<*>,
    private val putParametersOnSeparateLines: Boolean,
    private val inline: Boolean
) {
    private val parents = mutableSetOf<String>()
    private val typeParameters = mutableSetOf<TypeParameter>()
    private val parameters = mutableSetOf<Parameter>()
    private var returns: String? = null

    fun addTypeParameter(
        parameterName: String,
        upperBound: KClass<*>? = null,
        reified: Boolean = false
    ): FunSpec {
        typeParameters.add(
            TypeParameter(parameterName, upperBound, reified)
        )

        return this
    }

    inline fun <reified T> nestedBy(): FunSpec {
        parents.add(T::class.simpleName!!)

        return this
    }

    fun nestedBy(property: KProperty<*>): FunSpec {
        parents.add(property.name)
        return this
    }

    /**
     * @param TP type parent
     * @param TC type child
     */
    inline fun <reified TP, reified TC> nestedByGeneric(): FunSpec {
        parents.add(Generic.builder<TP, TC>().build())

        return this
    }

    fun nestedBy(generic: Generic): FunSpec {
        parents.add(generic.build())

        return this
    }

    fun addParameter(parameter: Parameter): FunSpec {
        parameters.add(parameter)

        return this
    }

    fun addParameter(
        parameterName: String,
        type: String,
        nullable: Boolean = false,
        default: String? = null,
        modifier: Parameter.Modifier? = null
    ): FunSpec = addParameter(Parameter(parameterName, type, nullable, default, modifier))

    fun addParameter(
        parameterName: String,
        type: Generic,
        nullable: Boolean = false,
        default: String? = null,
        modifier: Parameter.Modifier? = null
    ): FunSpec = addParameter(Parameter(parameterName, type.build(), nullable, default, modifier))

    fun addParameter(
        parameterName: String,
        type: LambdaType,
        nullable: Boolean = false,
        default: String? = null
    ): FunSpec {
        val typeString = buildString {
            if (nullable) {
                append("(")
            }

            append(type.build())

            if (nullable) {
                append(")")
            }
        }

        return addParameter(Parameter(parameterName, typeString, nullable, default))
    }

    private fun addParameter(
        parameterName: String,
        type: KClass<*>,
        nullable: Boolean = false,
        default: String? = null,
        modifier: Parameter.Modifier? = null
    ): FunSpec = addParameter(parameterName, type.nestedName, nullable, default, modifier)

    inline fun <reified T> addParameter(parameterName: String): FunSpec {
        return addParameter(parameterName, T::class)
    }

    inline fun <reified T> addParameter(parameterName: String, default: T): FunSpec {
        val defaultString = default?.toString() ?: Parameter.NULL

        return addParameter(parameterName, T::class, default == null, defaultString)
    }

    inline fun <reified T : Enum<*>> addParameter(parameterName: String, default: T?): FunSpec {
        val defaultString = default?.nestedName ?: Parameter.NULL

        return addParameter(parameterName, T::class, default == null, defaultString)
    }

    inline fun <reified T> addParameter(parameterName: String, default: T, nullable: Boolean): FunSpec {
        val defaultString = default?.toString() ?: Parameter.NULL

        return addParameter(parameterName, T::class, nullable, defaultString)
    }

    inline fun <reified T> returns(): FunSpec {
        returns = T::class.simpleName!!
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
        if (inline) {
            append("inline ")
        }

        append("fun ")

        if (typeParameters.isNotEmpty()) {
            append("<")
            append(typeParameters.joinToString(", ") { it.build() })
            append("> ")
        }

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
        private val name: String,
        private val type: String,
        private val nullable: Boolean = false,
        private val default: String? = null,
        private val modifier: Modifier? = null
    ) : CodePoet {
        constructor(
            name: String,
            type: KClass<*>,
            nullable: Boolean = false,
            default: String? = null,
            modifier: Modifier? = null
        ) : this(name, type.nestedName, nullable, default, modifier)

        constructor(
            name: String,
            type: KClass<out Enum<*>>,
            nullable: Boolean = false,
            default: Enum<*>? = null,
            modifier: Modifier? = null
        ) : this(name, type.nestedName, nullable, default?.nestedName, modifier)

        constructor(
            name: String,
            type: Generic,
            nullable: Boolean = false,
            default: String? = null,
            modifier: Modifier? = null
        ) : this(name, type.build(), nullable, default, modifier)

        override fun build() = buildString {
            modifier?.let {
                append(it.name.toLowerCase())
                append(" ")
            }

            append("$name: $type")

            if (nullable) {
                append("?")
            }

            if (default !== null) {
                append(" = $default")
            }
        }

        enum class Modifier {
            NOINLINE,
            CROSSINLINE
        }

        companion object {
            const val NULL = "null"
        }
    }

    // Todo improve this poet. There is much more possible with type parameters than this CodePoet can render
    internal data class TypeParameter(
        private val name: String,
        private val upperBound: KClass<*>?,
        private val reified: Boolean
    ) : CodePoet {
        override fun build(): String = buildString {
            if (reified) {
                append("reified ")
            }

            append(name)

            upperBound?.let {
                append(" : ${it.nestedName}")
            }
        }
    }

    companion object {
        fun builder(
            function: KFunction<*>,
            putParametersOnSeparateLines: Boolean = true,
            inline: Boolean = false
        ) = FunSpec(function, putParametersOnSeparateLines, inline)
    }
}
