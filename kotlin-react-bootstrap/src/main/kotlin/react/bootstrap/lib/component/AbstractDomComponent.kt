package react.bootstrap.lib.component

import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.DomTag
import react.bootstrap.lib.react.rprops.requireProperties
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
) : DomComponent<T, P, S>(props, props.tag) {
    init {
        props.requireProperties(props::tag)
    }

    interface Props<T : DomTag> : DomComponent.Props<T> {
        var tag: KClass<T>
    }

    class Builder<T : DomTag, P : Props<T>> constructor(
        builder: RBuilder,
        tag: KClass<T>,
        component: KClass<out AbstractDomComponent<T, P, *>>
    ) : DomComponent.Builder<T, P>(builder, tag, component) {
        override fun build(): ReactElement =
            builder.child(component) {
                attrs {
                    classes = this@Builder.classes.splitClassesToSet()
                    handler = this@Builder.domHandler
                    tag = this@Builder.tag
                    this@Builder.propHandler.invoke(this)
                }
            }
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        inline fun <reified T : DomTag, P : Props<T>> RBuilder.abstractDomComponent(
            componentKlazz: KClass<out AbstractDomComponent<*, *, *>>
        ) = Builder(this, T::class, componentKlazz as KClass<AbstractDomComponent<T, P, *>>)
    }
}
