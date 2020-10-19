package react.bootstrap.site.lib.codepoet

import kotlin.reflect.KProperty

internal class Assignment private constructor(private val assignedName: String) {
    private val modifiers: MutableSet<String> = mutableSetOf()

    private var type: Type = Type.NEITHER
    private lateinit var value: Any

    fun addModifier(modifier: String): Assignment {
        modifiers.add(modifier)
        return this
    }

    fun valType(): Assignment {
        this.type = Type.VAL
        return this
    }

    fun varType(): Assignment {
        this.type = Type.VAR
        return this
    }

    fun value(value: CharSequence): Assignment {
        this.value = value
        return this
    }

    fun value(value: Number): Assignment {
        this.value = value
        return this
    }

    fun value(value: Boolean): Assignment {
        this.value = value
        return this
    }

    fun value(value: LambdaValue): Assignment {
        this.value = value
        return this
    }

    fun value(value: FunCall): Assignment {
        this.value = value
        return this
    }

    fun value(value: FunCallDelegate): Assignment {
        this.value = value
        return this
    }

    fun build() = buildString {
        if (modifiers.isNotEmpty()) {
            append(modifiers.joinToString(" "))
            append(" ")
        }

        if (type != Type.NEITHER) {
            append(type.name.toLowerCase())
            append(" ")
        }

        append(assignedName)
        append(" ")

        append(
            when (value) {
                is LambdaValue -> "= ${(value as LambdaValue).build()}"
                is String -> "= \"$value\""
                is FunCall -> "= ${(value as FunCall).build()}"
                is FunCallDelegate -> "by ${(value as FunCallDelegate).funCall.build()}"
                else -> "= $value"
            }
        )
    }

    data class FunCallDelegate(val funCall: FunCall)

    enum class Type {
        VAL,
        VAR,
        NEITHER;
    }

    companion object {
        fun builder(property: KProperty<*>) = Assignment(property.name)
        fun builder(assignedName: String) = Assignment(assignedName)
    }
}
