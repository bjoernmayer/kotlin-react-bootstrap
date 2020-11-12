package react.bootstrap.lib.react

import kotlinext.js.asJsObject
import kotlinext.js.clone
import react.Child
import react.Component
import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.ReactElement
import react.bootstrap.lib.react.rprops.toMutable
import react.rClass

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

/**
 * Gathers Properties P of children of type C
 *
 * @param C Some Kotlin React Bootstrap Component
 * @param P RProps of the same Kotlin React Bootstrap Component
 * @return A map with found children with the child index as key
 */
inline fun <reified P : RProps, reified C : Component<P, *>> Array<out Child>.gatherChildrenProps(): Map<Int, P> =
    mapIndexedNotNull { index, child ->
        if (child.isComponent<C>().not()) {
            return@mapIndexedNotNull null
        }
        val reactElement = child.asJsObject().asReactElementOrNull() ?: return@mapIndexedNotNull null
        val elProps = reactElement.props.asJsObject()

        index to elProps.unsafeCast<P>().toMutable()
    }.toMap()

/**
 * This mapping function allows you to modify [Component]s.
 *
 * @param P Props type of the child component
 * @param C Component type of the child component
 * @param transform Basically a [RElementBuilder] which receives the index and the old props of the child
 */
inline fun <P : RProps, reified C : Component<P, *>> Array<out Child>.mapComponents(
    noinline transform: RElementBuilder<P>.(index: Int, oldProps: P) -> Unit
): Array<out Child> {
    val rBuilder = RBuilder()

    return mapIndexed { index, child ->
        if (child.isComponent<C>().not()) {
            return@mapIndexed child
        }

        val props: P = child.unsafeCast<ReactElement>().props.unsafeCast<P>()

        rBuilder.child(C::class.rClass, clone(props)) {
            transform(index, props)
        }
    }.toTypedArray()
}
