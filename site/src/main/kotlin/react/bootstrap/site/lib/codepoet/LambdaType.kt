package react.bootstrap.site.lib.codepoet

import react.bootstrap.site.components.docs.nestedName
import kotlin.reflect.KClass

internal class LambdaType private constructor() : CodePoet {
    private var receiver: String? = null
    private var arguments = mutableSetOf<Argument>()
    private var returnType: String = Unit::class.simpleName!!

    fun receiver(receiver: KClass<*>): LambdaType {
        this.receiver = receiver.simpleName!!

        return this
    }

    fun addArgument(type: KClass<*>): LambdaType {
        arguments.add(
            Argument(type.nestedName)
        )

        return this
    }

    fun addArgument(name: String, type: KClass<*>): LambdaType {
        arguments.add(
            Argument(type.nestedName).apply {
                setName(name)
            }
        )

        return this
    }

    fun addArgument(name: String, type: KClass<*>, nullable: Boolean): LambdaType {
        arguments.add(
            Argument(type.nestedName).apply {
                setName(name)
                setNullable(nullable)
            }
        )

        return this
    }

    fun returns(type: KClass<*>): LambdaType {
        returnType = type.nestedName

        return this
    }

    override fun build(): String = buildString {
        receiver?.let {
            append("$receiver.")
        }
        append("(")
        append(arguments.joinToString(", ") {
            it.build()
        })
        append(") -> ")
        append(returnType)
    }

    internal class Argument(
        private val type: String
    ) : CodePoet {
        private var nullable: Boolean = false
        private var name: String? = null

        fun isNullable(): Argument {
            nullable = true

            return this
        }

        fun isNotNullable(): Argument {
            nullable = false

            return this
        }

        fun setNullable(value: Boolean): Argument {
            nullable = value

            return this
        }

        fun setName(name: String): Argument {
            this.name = name

            return this
        }

        override fun build(): String = buildString {
            name?.let {
                append("$it: ")
            }
            append(type)

            if (nullable) {
                append("?")
            }
        }
    }

    companion object {
        fun builder() = LambdaType()
    }
}
