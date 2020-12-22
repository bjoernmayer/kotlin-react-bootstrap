package react.bootstrap.lib.react

import kotlinext.js.asJsObject
import kotlinext.js.clone
import react.Child
import react.Component
import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.ReactElement
import react.rClass
import kotlin.reflect.KClass

/**
 * This identifies a child as a component of the specified type
 *
 * @param C Component Type
 * @return True if the child is of type [C]
 */
public inline fun <reified C : Component<*, *>> Child.isComponent(): Boolean {
    val reactElement = asJsObject().asReactElementOrNull() ?: return false

    return reactElement.componentJsClass == C::class.js
}

/**
 * This identifies a child as a component of the specified type
 *
 * @param C Component Type
 * @return True if the child is of type [C]
 */
public fun <C : Component<*, *>> Child.isComponent(componentKlazz: KClass<out C>): Boolean {
    val reactElement = asJsObject().asReactElementOrNull() ?: return false

    return reactElement.componentJsClass == componentKlazz.js
}

/**
 * Returns a list containing the results of applying the given [transform] function to each [ReactElement] of type [C],
 * its props of type [P] and its index in the original array.
 *
 * @param C React Component
 * @param P Props of the same Component
 * @param R value type of the result [List]
 */
public inline fun <reified C : Component<P, *>, P : RProps, R : Any> Array<out Child>.mapReactElementsIndexed(
    @Suppress("UNUSED_PARAMETER") component: KClass<C> = C::class,
    transform: (index: Int, pairedElement: Pair<ReactElement, P>) -> R
): List<R> = mapIndexedNotNull { index, child ->
    if (child.isComponent<C>().not()) {
        return@mapIndexedNotNull null
    }

    val reactElement = child.asJsObject().asReactElementOrNull() ?: return@mapIndexedNotNull null

    transform(index, reactElement to reactElement.props.unsafeCast<P>())
}

/**
 * Executes the given action on each [RElementBuilder] of type [P]
 *
 * @param C Component type Component
 * @param P Props type Component
 * @param action Basically a [RElementBuilder] which receives the index and the old props of the child
 */
public fun <P : RProps> Array<out Child>.onEachComponent(
    component: KClass<out Component<P, *>>,
    action: RElementBuilder<P>.(index: Int, originalProps: P) -> Unit
): Array<out Child> {
    val rBuilder = RBuilder()

    return mapIndexed { index, child ->
        if (child.isComponent(component).not()) {
            return@mapIndexed child
        }

        val props: P = child.unsafeCast<ReactElement>().props.unsafeCast<P>()

        rBuilder.child(component.rClass, clone(props)) {
            action(index, props)
        }
    }.toTypedArray()
}
