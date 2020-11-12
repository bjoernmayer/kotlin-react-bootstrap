package react.bootstrap.lib.react

import kotlinext.js.asJsObject
import react.Child
import react.Component

/**
 * This identifies a child as a component of the specified type
 *
 * @param CT Component Type
 * @return True if the child is of type [CT]
 */
inline fun <reified CT : Component<*, *>> Child.isComponent(): Boolean {
    val reactElement = asJsObject().asReactElementOrNull() ?: return false

    return reactElement.componentJsClass == CT::class.js
}
