package react.bootstrap.lib.component

import kotlinx.html.attributesMapOf
import kotlinx.html.classes
import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.react.rprops.WithClasses
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
import kotlin.reflect.KClass
import kotlinx.html.CommonAttributeGroupFacade as CommonAttributes

/**
 * A [DomComponent] is a react component, which passes through its [DomComponent.Props.handler] to the underlying
 * HTML element.
 *
 * @param T type of the tag which is used to render this component
 * @param P property type
 * @param S State type
 */
abstract class DomComponent<T : CommonAttributes, P : DomComponent.Props<T>, S : RState>(
    props: P,
    private val tag: KClass<T>
) : BootstrapComponent<P, S>(props) {
    init {
        props.requireProperties(props::handler)
    }

    protected open fun RDOMBuilder<T>.build() {}

    final override fun RBuilder.render(rendererClasses: Set<String>) {
        @Suppress("UNUSED_VARIABLE", "UNUSED_ANONYMOUS_PARAMETER")
        val rROMBuilder = RDOMBuilder { tagConsumer ->
            // This intantiates the tag by using some reflection js magic.
            // ::class.js points to the javascript constructor
            val constructor = tag.js
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

                    props.handler.invoke(this)
                }
                .create()
        )
    }

    interface Props<T : CommonAttributes> : WithClasses {
        var handler: RDOMHandler<T>
    }

    companion object {
        inline fun <reified T : CommonAttributes, reified P : Props<T>> RBuilder.domComponent(
            classes: String? = null,
            klazz: KClass<out DomComponent<*, P, *>>,
            noinline domHandler: RDOMHandler<T>,
            crossinline handler: RHandler<P> = { }
        ): ReactElement {
            val componentKlazz: KClass<out DomComponent<*, P, *>> = klazz

            return child(componentKlazz) {
                attrs {
                    this.classes = classes.splitClassesToSet()
                    this.handler = domHandler
                }

                handler()
            }
        }
    }
}
