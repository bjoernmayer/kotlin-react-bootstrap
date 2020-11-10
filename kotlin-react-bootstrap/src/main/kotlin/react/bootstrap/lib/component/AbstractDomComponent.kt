package react.bootstrap.lib.component

import kotlinx.html.attributesMapOf
import kotlinx.html.classes
import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
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
abstract class AbstractDomComponent<T : CommonAttributes, P : AbstractDomComponent.Props<T>, S : RState>(props: P) :
    DomComponent<T, P, S>(props) {
    init {
        props.requireProperties(props::tag)
    }

    protected open fun RDOMBuilder<T>.build() {}

    final override fun RBuilder.render(rendererClasses: Set<String>, handler: RDOMHandler<T>) {
        @Suppress("UNUSED_VARIABLE", "UNUSED_ANONYMOUS_PARAMETER")
        val rROMBuilder = RDOMBuilder { tagConsumer ->
            // This intantiates the tag by using some reflection js magic.
            // ::class.js points to the javascript constructor
            val constructor = props.tag.js
            val attributes = attributesMapOf("class", null)

            js("new constructor(attributes, tagConsumer)") as T
        }

        child(
            rROMBuilder
                .apply {
                    attrs {
                        classes = rendererClasses
                    }

                    build()

                    handler()
                }
                .create()
        )
    }

    interface Props<T : CommonAttributes> : DomComponent.Props<T> {
        var tag: KClass<T>
    }

    companion object {
        inline fun <reified T : CommonAttributes, reified P : Props<T>> RBuilder.abstractDomComponent(
            classes: String? = null,
            klazz: KClass<out AbstractDomComponent<*, *, *>>,
            crossinline handler: RHandler<P> = { },
            noinline domHandler: RDOMHandler<T>,
        ): ReactElement = domComponent<T, P>(classes, klazz, domHandler) {
            attrs {
                tag = T::class
            }

            handler()
        }
    }
}
