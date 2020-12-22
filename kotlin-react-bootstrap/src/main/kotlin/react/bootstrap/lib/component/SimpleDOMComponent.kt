package react.bootstrap.lib.component

import kotlinx.html.TagConsumer
import react.RBuilder
import react.RState
import react.bootstrap.lib.DOMTag
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * A [SimpleDOMComponent] is a react component, which passes through its [SimpleDOMComponent.Props.handler] to the underlying
 * HTML element.
 *
 * @param T type of the tag which is used to render this component
 * @param P property type
 * @param S State type
 */
public abstract class SimpleDOMComponent<T : DOMTag, P : SimpleDOMComponent.Props<T>, S : RState>(
    props: P,
    tag: KClass<T>
) : DOMComponent<T, RDOMHandler<T>, RDOMBuilder<T>, P, S>(props, tag) {

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): RDOMBuilder<T> = RDOMBuilder(builderFactory)

    public interface Props<T : DOMTag> : DOMComponent.Props<RDOMHandler<T>> {
        override var handler: RDOMHandler<T>
    }

    public companion object {
        @Suppress("UNCHECKED_CAST")
        public fun <T : DOMTag, P : Props<T>> RBuilder.simpleDomComponent(
            componentKlazz: KClass<out SimpleDOMComponent<T, P, *>>
        ): ComponentBuilder<T, RDOMHandler<T>, RDOMBuilder<T>, P> = domComponent(componentKlazz)
    }
}
