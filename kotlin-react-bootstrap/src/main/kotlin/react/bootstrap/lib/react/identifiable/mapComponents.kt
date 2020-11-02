package react.bootstrap.lib.react.identifiable

import kotlinext.js.clone
import react.Child
import react.Component
import react.RBuilder
import react.RElementBuilder
import react.RHandler
import react.RProps
import react.ReactElement
import react.rClass

/**
 * This mapping function allows you to modify Kotlin React Bootstrap Components.
 *
 * @param PT Props type of the child component
 * @param CT Component type of the child component
 * @param transform Basically a [RHandler] which receives the index and the old props of the child
 */
inline fun <PT : RProps, reified CT : Component<PT, *>> Array<out Child>.mapComponents(
    noinline transform: RElementBuilder<PT>.(index: Int, oldProps: PT) -> Unit
): Array<out Child> {
    val rBuilder = RBuilder()

    return mapIndexed { index, child ->
        if (child.isComponent<CT>().not()) {
            return@mapIndexed child
        }

        val props: PT = child.unsafeCast<ReactElement>().props.unsafeCast<PT>()

        rBuilder.child(CT::class.rClass, clone(props)) {
            transform(index, props)
        }
    }.toTypedArray()
}
