package react.bootstrap.site.components.docs

import kotlin.reflect.KClass
import kotlin.reflect.KFunction

/**
 * This class is used to print a function reference, until Kotlin JS supports a better way to do this.
 */
internal data class FunReference(
    val kFunction: KFunction<*>,
    val receiver: Set<String>? = null,
    val args: Set<Argument> = emptySet(),
    val returnType: String? = null
) {
    constructor(
        kFunction: KFunction<*>,
        receiver: Set<String>? = null,
        args: Set<Argument> = emptySet(),
        returnType: KClass<*>
    ) : this(kFunction, receiver, args, returnType.simpleName!!)

    internal data class Argument constructor(
        val name: String,
        val type: String,
        val nullable: Boolean = false,
        val default: String? = null
    ) {
        constructor(
            name: String,
            type: String
        ) : this(name, type, false, null)

        constructor(
            name: String,
            type: KClass<*>
        ) : this(name, type.simpleName!!, false, null)

        constructor(
            name: String,
            type: KClass<*>,
            default: String
        ) : this(name, type.simpleName!!, false, default)

        constructor(
            name: String,
            type: KClass<*>,
            nullable: Boolean
        ) : this(name, type.simpleName!!, nullable, null)

        constructor(
            name: String,
            type: KClass<*>,
            nullable: Boolean,
            default: String
        ) : this(name, type.simpleName!!, nullable, default)
    }

    fun print(oneLine: Boolean): String {
        val receiverString = receiver?.joinToString(".")?.plus(".")

        val argsStrings = args.map { arg ->
            val argStringBuilder = StringBuilder("${arg.name}: ${arg.type}")

            if (arg.nullable) {
                argStringBuilder.append("?")
            }

            if (arg.default !== null) {
                argStringBuilder.append(" = ${arg.default}")
            }

            argStringBuilder.toString()
        }

        val returnTypeString = returnType?.let { ": $it" }

        if (oneLine) {
            return "fun $receiverString${kFunction.name}(${argsStrings.joinToString()})$returnTypeString"
        } else {
            return """
fun $receiverString${kFunction.name}(
    ${argsStrings.joinToString(",\n    ")}
)$returnTypeString
            """
        }
    }
}
