package react.bootstrap.lib.react.identifiable

import react.Component
import react.RProps
import kotlin.reflect.KClass

/**
 * This is used to identify children as Kotlin React Bootstrap components
 *
 * Use defaultProps to set this field!
 */
interface IdentifiableProps<T : Component<*, *>> : RProps {
    var componentType: KClass<T>
}
