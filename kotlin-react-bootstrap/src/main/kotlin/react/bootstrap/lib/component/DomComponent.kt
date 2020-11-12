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

    override fun RBuilder.render(rendererClasses: Set<String>) {
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

    open class Builder<T : CommonAttributes, P : Props<T>> constructor(
        protected val builder: RBuilder,
        protected val tag: KClass<T>,
        protected val component: KClass<out DomComponent<T, P, *>>
    ) {
        protected var classes: String? = null
        protected var handler: RHandler<P> = { }
        protected var domHandler: RDOMHandler<T> = { }

        fun classes(classes: String?): Builder<T, P> {
            this.classes = classes

            return this
        }

        fun handler(handler: RHandler<P>): Builder<T, P> {
            this.handler = handler

            return this
        }

        fun domHandler(domHandler: RDOMHandler<T>): Builder<T, P> {
            this.domHandler = domHandler

            return this
        }

        open fun build(): ReactElement =
            builder.child(component) {
                attrs {
                    classes = this@Builder.classes.splitClassesToSet()
                    handler = this@Builder.domHandler
                }

                this@Builder.handler.invoke(this)
            }
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        inline fun <reified T : CommonAttributes, P : Props<T>> RBuilder.domComponent(
            componentKlazz: KClass<out DomComponent<*, *, *>>
        ) = Builder(this, T::class, componentKlazz as KClass<DomComponent<T, P, *>>)
    }
}
