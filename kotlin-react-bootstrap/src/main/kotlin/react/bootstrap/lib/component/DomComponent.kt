package react.bootstrap.lib.component

import kotlinx.html.TagConsumer
import kotlinx.html.attributesMapOf
import kotlinx.html.classes
import react.Child
import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.DomTag
import react.bootstrap.lib.PropHandler
import react.bootstrap.lib.react.rprops.WithClasses
import react.bootstrap.lib.react.rprops.childrenArray
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * A [DomComponent] is a react component, which passes through its [DomComponent.Props.handler] to the underlying
 * HTML element.
 *
 * Keep ind mind: The children of the DomComponent are emptied on purpose.
 * You can access them with [DomComponent.childrenArray] and readd them using [DomComponent.addChildren]
 *
 * @param B RDOMBuilder type. Use [SimpleDomComponent] or [AbstractDomComponent] if you want to go for [RDOMBuilder]
 * @param T type of the tag which is used to render this component
 * @param P property type
 * @param S State type
 */
abstract class DomComponent<B : RDOMBuilder<T>, T : DomTag, P : DomComponent.Props<B, T>, S : RState>(
    props: P,
    private val tag: KClass<T>
) : BootstrapComponent<P, S>(props) {
    init {
        props.requireProperties(props::handler)

        @Suppress("SENSELESS_COMPARISON")
        require(tag !== null) {
            "tag must not be null!"
        }
    }

    @Suppress("UNUSED_VARIABLE", "UNUSED_ANONYMOUS_PARAMETER")
    private val builderFactory: (TagConsumer<Unit>) -> T = { tagConsumer ->
        // This intantiates the tag by using some reflection js magic.
        // ::class.js points to the javascript constructor
        val constructor = tag.js
        val attributes = attributesMapOf("class", null)

        js("new constructor(attributes, tagConsumer)") as T
    }

    protected val childrenArray: Array<out Child>
        get() = buildBuilder(builderFactory).apply {
            props.handler.invoke(this)
        }.create().props.childrenArray

    protected abstract fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): B

    /**
     * Do not forget to call [addChildren] to add back the children
     */
    protected open fun B.build() {
        addChildren()
    }

    protected fun RBuilder.addChildren() {
        childList.addAll(childrenArray)
    }

    final override fun RBuilder.render(rendererClasses: Set<String>) {
        child(
            buildBuilder(builderFactory)
                .apply {
                    attrs {
                        classes = rendererClasses
                    }

                    props.handler.invoke(this)

                    // We clear the childList of the Builder B temporarily. This gives extending components the chance
                    // to customise them
                    childList.clear()

                    build()
                }
                .create()
        )
    }

    interface Props<B : RDOMBuilder<T>, T : DomTag> : WithClasses {
        var handler: B.() -> Unit
    }

    open class ComponentBuilder<B : RDOMBuilder<T>, T : DomTag, P : Props<B, T>> constructor(
        protected val builder: RBuilder,
        protected val tag: KClass<T>,
        protected val component: KClass<out DomComponent<B, T, P, *>>
    ) {
        protected var classes: String? = null
        protected var propHandler: PropHandler<P> = { }
        protected var domHandler: B.() -> Unit = { }

        fun classes(classes: String?): ComponentBuilder<B, T, P> {
            this.classes = classes

            return this
        }

        fun propHandler(propHandler: PropHandler<P>): ComponentBuilder<B, T, P> {
            this.propHandler = propHandler

            return this
        }

        fun domHandler(domHandler: B.() -> Unit): ComponentBuilder<B, T, P> {
            this.domHandler = domHandler

            return this
        }

        open fun build(): ReactElement =
            builder.child(component) {
                attrs {
                    classes = this@ComponentBuilder.classes.splitClassesToSet()
                    handler = this@ComponentBuilder.domHandler
                    this@ComponentBuilder.propHandler.invoke(this)
                }
            }
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        inline fun <B : RDOMBuilder<T>, reified T : DomTag, P : Props<B, T>> RBuilder.domComponent(
            componentKlazz: KClass<out DomComponent<*, *, *, *>>
        ) = ComponentBuilder(this, T::class, componentKlazz as KClass<DomComponent<B, T, P, *>>)
    }
}
