package react.bootstrap.lib.component

import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.react.rprops.requireProperties
import kotlin.reflect.KClass
import kotlinx.html.CommonAttributeGroupFacade as CommonAttributes

/**
 * An [AbstractDomComponent] is a react component, which passes through its [AbstractDomComponent.Props.handler] to the
 * underlying HTML element, whose type is set via [AbstractDomComponent.Props.tag].
 *
 * @param T type of the tag which is used to render this component
 * @param P property type
 * @param S State type
 */
abstract class AbstractDomComponent<T : CommonAttributes, P : AbstractDomComponent.Props<T>, S : RState>(
    props: P
) : DomComponent<T, P, S>(props, props.tag) {
    init {
        props.requireProperties(props::tag)
    }

    interface Props<T : CommonAttributes> : DomComponent.Props<T> {
        var tag: KClass<T>
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        inline fun <reified T : CommonAttributes, reified P : Props<T>> RBuilder.abstractDomComponent(
            classes: String? = null,
            klazz: KClass<out AbstractDomComponent<*, *, *>>,
            crossinline handler: RHandler<P> = { },
            noinline domHandler: RDOMHandler<T>,
        ): ReactElement = domComponent(classes, klazz as KClass<out DomComponent<*, P, *>>, domHandler) {
            attrs {
                tag = T::class
            }

            handler()
        }
    }
}
