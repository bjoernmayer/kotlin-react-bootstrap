package react.bootstrap.lib.component

import kotlinx.html.TagConsumer
import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * An [AbstractDOMComponent] is a react component, which passes through its [AbstractDOMComponent.Props.handler] to the
 * underlying HTML element, whose type is set via [AbstractDOMComponent.Props.tag].
 *
 * @param T type of the tag which is used to render this component
 * @param P property type
 * @param S State type
 */
abstract class AbstractDOMComponent<T : DOMTag, P : AbstractDOMComponent.Props<T>, S : RState>(
    props: P
) : DOMComponent<T, RDOMHandler<T>, RDOMBuilder<T>, P, S>(props, props.tag) {
    init {
        props.requireProperties(props::tag)
    }

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): RDOMBuilder<T> = RDOMBuilder(builderFactory)

    interface Props<T : DOMTag> : DOMComponent.Props<RDOMHandler<T>> {
        var tag: KClass<out T>
    }

    class ComponentBuilder<T : DOMTag, P : Props<T>> constructor(
        builder: RBuilder,
        private val tag: KClass<out T>,
        component: KClass<out AbstractDOMComponent<T, P, *>>
    ) : DOMComponent.ComponentBuilder<T, RDOMHandler<T>, RDOMBuilder<T>, P>(builder, component) {
        override fun build(): ReactElement =
            builder.child(component) {
                attrs {
                    classes = this@ComponentBuilder.classes.splitClassesToSet()
                    handler = this@ComponentBuilder.domHandler
                    tag = this@ComponentBuilder.tag

                    with(propHandler) {
                        this@attrs.handle()
                    }
                }
            }
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        inline fun <reified T : DOMTag, P : Props<T>> RBuilder.abstractDomComponent(
            componentKlazz: KClass<out AbstractDOMComponent<T, P, *>>
        ) = ComponentBuilder(this, T::class, componentKlazz)
    }
}
