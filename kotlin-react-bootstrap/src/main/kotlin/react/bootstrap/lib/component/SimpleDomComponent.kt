package react.bootstrap.lib.component

import kotlinx.html.TagConsumer
import react.RBuilder
import react.RState
import react.bootstrap.lib.DomTag
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * A [SimpleDomComponent] is a react component, which passes through its [SimpleDomComponent.Props.handler] to the underlying
 * HTML element.
 *
 * @param T type of the tag which is used to render this component
 * @param P property type
 * @param S State type
 */
abstract class SimpleDomComponent<T : DomTag, P : SimpleDomComponent.Props<T>, S : RState>(
    props: P,
    tag: KClass<T>
) : DomComponent<RDOMBuilder<T>, T, P, S>(props, tag) {

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): RDOMBuilder<T> = RDOMBuilder(builderFactory)

    interface Props<T : DomTag> : DomComponent.Props<RDOMBuilder<T>, T>

    companion object {
        @Suppress("UNCHECKED_CAST")
        inline fun <reified T : DomTag, P : Props<T>> RBuilder.simpleDomComponent(
            componentKlazzSimple: KClass<out SimpleDomComponent<T, P, *>>
        ) = domComponent<RDOMBuilder<T>, T, P>(componentKlazzSimple)
    }
}
