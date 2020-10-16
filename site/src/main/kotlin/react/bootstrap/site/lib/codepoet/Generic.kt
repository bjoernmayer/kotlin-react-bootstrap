package react.bootstrap.site.lib.codepoet

import react.bootstrap.site.components.docs.components.alerts.nestedName
import kotlin.reflect.KClass

data class Generic(
    private val clazz: KClass<*>,
    private val type: KClass<*>
) {
    val simpleName = "${clazz.nestedName}<${type.nestedName}>"
}
