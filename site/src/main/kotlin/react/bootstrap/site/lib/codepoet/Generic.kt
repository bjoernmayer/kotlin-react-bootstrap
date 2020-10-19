package react.bootstrap.site.lib.codepoet

import react.bootstrap.site.components.docs.nestedName
import kotlin.reflect.KClass

internal data class Generic(
    private val className: String,
    private val typeName: String
) {
    constructor(
        clazz: KClass<*>,
        type: KClass<*>
    ) : this(clazz.nestedName, type.nestedName)

    constructor(
        className: String,
        type: KClass<*>
    ) : this(className, type.nestedName)

    val simpleName = "$className<$typeName>"
}
