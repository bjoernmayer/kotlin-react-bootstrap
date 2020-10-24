package react.bootstrap.lib.rprops

import react.RProps
import kotlin.reflect.KClass

/**
 * This is used to identify children as Kotlin React Bootstrap components
 */
interface WithTypeFlag<T : Any> : RProps {
    var krbType: KClass<T>
}
