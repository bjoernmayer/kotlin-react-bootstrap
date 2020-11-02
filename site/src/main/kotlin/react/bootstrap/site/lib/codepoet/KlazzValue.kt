package react.bootstrap.site.lib.codepoet

import kotlin.reflect.KClass

internal data class KlazzValue(val klazz: KClass<*>) : CodePoet {
    override fun build(): String = "${klazz.simpleName!!}::class"
}
