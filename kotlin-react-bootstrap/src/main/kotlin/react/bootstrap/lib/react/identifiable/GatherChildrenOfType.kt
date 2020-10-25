package react.bootstrap.lib.react.identifiable

import kotlinext.js.asJsObject
import react.Child
import react.Component
import react.RProps
import react.bootstrap.lib.react.asReactElementOrNull
import react.bootstrap.lib.react.rprops.toMutable

/**
 * This makes use of the [IdentifiableProps] to identify and gather children of a specific type
 *
 * @param CT Some Kotlin React Bootstrap Component
 * @param PT RProps of the same Kotlin React Bootstrap Component
 * @return A map with found children with the child index as key
 */
inline fun <reified CT : Component<*, *>, reified PT : RProps> Array<out Child>.gatherChildrenPropsOfType(): Map<Int, PT> =
    mapIndexedNotNull { index, child ->
        if (child.isComponent<CT>()) {
            val reactElement = child.asJsObject().asReactElementOrNull() ?: return@mapIndexedNotNull null
            val elProps = reactElement.props.asJsObject()

            if (elProps.unsafeCast<IdentifiableProps<*>>().componentType == CT::class) {
                index to elProps.unsafeCast<PT>().toMutable()
            } else {
                null
            }
        } else {
            null
        }
    }.toMap()
