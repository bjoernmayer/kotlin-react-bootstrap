package react.bootstrap.lib.react.identifiable

import kotlinext.js.asJsObject
import react.Child
import react.Component
import react.bootstrap.lib.react.asReactElementOrNull

/**
 * This makes use of the [IdentifiableProps] to identify a child as a component of the specified type
 *
 * @param CT Component Type
 * @return True if the child is of type [CT]
 */
inline fun <reified CT : Component<*, *>> Child.isComponent(): Boolean {
    val reactElement = asJsObject().asReactElementOrNull() ?: return false
    val elProps = reactElement.props.asJsObject()

    if (!elProps.hasOwnProperty(IdentifiableProps<*>::componentType.name)) {
        return false
    }

    return elProps.unsafeCast<IdentifiableProps<*>>().componentType == CT::class
}
