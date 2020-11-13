package react.bootstrap.lib.component

import kotlinx.html.TagConsumer
import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.DomTag
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * An [AbstractDomComponent] is a react component, which passes through its [AbstractDomComponent.Props.handler] to the
 * underlying HTML element, whose type is set via [AbstractDomComponent.Props.tag].
 *
 * @param T type of the tag which is used to render this component
 * @param P property type
 * @param S State type
 */
abstract class AbstractDomComponent<T : DomTag, P : AbstractDomComponent.Props<T>, S : RState>(
    props: P
) : DomComponent<RDOMBuilder<T>, T, P, S>(props, props.tag) {
    init {
        props.requireProperties(props::tag)
    }

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): RDOMBuilder<T> = RDOMBuilder(builderFactory)

    interface Props<T : DomTag> : DomComponent.Props<RDOMBuilder<T>, T> {
        var tag: KClass<T>
    }

    class ComponentBuilder<T : DomTag, P : Props<T>> constructor(
        builder: RBuilder,
        tag: KClass<T>,
        component: KClass<out AbstractDomComponent<T, P, *>>
    ) : DomComponent.ComponentBuilder<RDOMBuilder<T>, T, P>(builder, tag, component) {
        override fun build(): ReactElement =
            builder.child(component) {
                attrs {
                    classes = this@ComponentBuilder.classes.splitClassesToSet()
                    handler = this@ComponentBuilder.domHandler
                    tag = this@ComponentBuilder.tag
                    this@ComponentBuilder.propHandler.invoke(this)
                }
            }
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        inline fun <reified T : DomTag, P : Props<T>> RBuilder.abstractDomComponent(
            componentKlazz: KClass<out AbstractDomComponent<*, *, *>>
        ) = ComponentBuilder(this, T::class, componentKlazz as KClass<AbstractDomComponent<T, P, *>>)
    }
}
