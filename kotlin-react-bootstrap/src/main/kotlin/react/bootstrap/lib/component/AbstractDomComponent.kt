package react.bootstrap.lib.component

import kotlinx.html.attributesMapOf
import kotlinx.html.classes
import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.helpers.addOrInit
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
import kotlin.reflect.KClass
import kotlinx.html.CommonAttributeGroupFacade as CommonAttributes

/**
 * A [AbstractDomComponent] is a react component, which passes through its [AbstractDomComponent.Props.handler] to the
 * underlying HTML element, whose type is set via [AbstractDomComponent.Props.klazz].
 *
 * @param T type of the tag which is used to render this component
 * @param P property type
 * @param S State type
 */
abstract class AbstractDomComponent<T : CommonAttributes, P : AbstractDomComponent.Props<T>, S : RState>(props: P) :
    DomComponent<T, P, S>(props) {
    init {
        props.requireProperties(props::klazz)
    }

    protected open fun RDOMBuilder<T>.build() {}

    final override fun RBuilder.render(componentClasses: Set<ClassNames>, handler: RDOMHandler<T>) {
        @Suppress("UNUSED_VARIABLE", "UNUSED_ANONYMOUS_PARAMETER")
        val rROMBuilder = RDOMBuilder { tagConsumer ->
            // This intantiates the tag by using some reflection js magic.
            // ::class.js points to the javascript constructor
            val constructor = props.klazz.js
            val attributes = attributesMapOf("class", null)

            js("new constructor(attributes, tagConsumer)") as T
        }

        child(
            rROMBuilder
                .apply {
                    attrs {
                        classes = props.classes.addOrInit(componentClasses)
                    }

                    build()

                    handler()
                }
                .create()
        )
    }

    interface Props<T : CommonAttributes> : DomComponent.Props<T> {
        var klazz: KClass<T>
    }

    companion object {
        inline fun <reified T : CommonAttributes, reified P : Props<T>> RBuilder.domComponent(
            classes: String? = null,
            klazz: KClass<out AbstractDomComponent<*, *, *>>,
            crossinline handler: RHandler<P> = { },
            noinline domHandler: RDOMHandler<T>,
        ): ReactElement {

            @Suppress("UNCHECKED_CAST")
            val componentKlazz: KClass<out AbstractDomComponent<*, P, *>> =
                klazz as KClass<out AbstractDomComponent<*, P, *>>

            return child(componentKlazz) {
                attrs {
                    this.classes = classes.splitClassesToSet()
                    this.handler = domHandler
                    this.klazz = T::class
                }

                handler()
            }
        }
    }
}
