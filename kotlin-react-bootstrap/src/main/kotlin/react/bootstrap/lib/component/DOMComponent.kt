package react.bootstrap.lib.component

import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import kotlinx.html.attributesMapOf
import kotlinx.html.classes
import react.Child
import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.react.rprops.WithClasses
import react.bootstrap.lib.react.rprops.childrenArray
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * A [DOMComponent] is a react component, which passes through its [DOMComponent.Props.handler] to the underlying
 * HTML element.
 *
 * Keep ind mind: The children of the DomComponent are emptied on purpose.
 * You can access them with [DOMComponent.childrenArray] and readd them using [DOMComponent.addChildren]
 *
 * @param T type of the tag which is used to render this component
 * @param H type of [DOMHandler], used for [DOMComponent.Props.handler]
 * @param B RDOMBuilder type. Use [SimpleDOMComponent] or [AbstractDOMComponent] if you want to go for [RDOMBuilder]
 * @param P property type
 * @param S State type
 */
abstract class DOMComponent
<T : DOMTag, H : DOMHandler<out T, B>, B : RDOMBuilder<T>, P : DOMComponent.Props<H>, S : RState>(
    props: P,
    tag: KClass<out T>
) : BootstrapComponent<P, S>(props) {
    init {
        props.requireProperties(props::handler)

        @Suppress("SENSELESS_COMPARISON")
        require(tag !== null) {
            "tag must not be null!"
        }
    }

    private val builderFactory: (TagConsumer<Unit>) -> T = getBuilderFactory(tag)

    protected val childrenArray: Array<out Child>
        get() = buildBuilder(builderFactory).apply {
            with(props.handler) {
                this@apply.handle()
            }
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

                    with(props.handler) {
                        this@apply.handle()
                    }

                    // We clear the childList of the Builder B temporarily. This gives extending components the chance
                    // to customise them
                    childList.clear()

                    build()
                }
                .create()
        )
    }

    interface Props<H : DOMHandler<out Tag, *>> : WithClasses {
        var handler: H
    }

    open class ComponentBuilder<T : DOMTag, H : DOMHandler<out T, B>, B : RDOMBuilder<T>, P : Props<H>> constructor(
        protected val builder: RBuilder,
        protected val component: KClass<out DOMComponent<T, H, *, P, *>>
    ) {
        protected var classes: String? = null
        var propHandler: PropHandler<P> = PropHandler { }

        lateinit var domHandler: H

        fun classes(classes: String?): ComponentBuilder<T, H, B, P> {
            this.classes = classes

            return this
        }

        fun propHandler(propHandler: PropHandler<P>): ComponentBuilder<T, H, B, P> {
            this.propHandler = propHandler

            return this
        }

        // fun domHandler(domHandler: H): ComponentBuilder<T, H, B, P> {
        //     @Suppress("USELESS_IS_CHECK")
        //     require(domHandler is H) {
        //         // I don't know why, but this setter sometimes accepts normal Functions.
        //         // It looks like they are sometimes not properly converted into the Fun Interface.
        //         "Wrong ${DOMHandler::class.simpleName} type given. Given type: ${domHandler::class.simpleName}"
        //     }
        //
        //     this.domHandler = domHandler
        //
        //     return this
        // }

        fun domHandler(domHandler: DOMHandler<T, B>): ComponentBuilder<T, H, B, P> {
            // This is a neccessary Hack. If type of domHandler would be just H, some lambdas might not be converted
            // into the typed DOMHandler. Resulting in weird errors.
            // Without this hack, the failing FunInterfaces need to be created using FUNINTERFACE { ... }
            this.domHandler = domHandler.unsafeCast<H>()

            return this
        }

        open fun build(): ReactElement =
            builder.child(component) {
                attrs {
                    classes = this@ComponentBuilder.classes.splitClassesToSet()
                    handler = this@ComponentBuilder.domHandler

                    with(propHandler) {
                        this@attrs.handle()
                    }
                }
            }

        protected fun String?.splitClassesToSet(): Set<String> = this?.split(" ")?.toSet() ?: emptySet()
    }

    companion object {
        @Suppress("UNUSED_VARIABLE", "UNUSED_ANONYMOUS_PARAMETER")
        internal fun <T : Any> getBuilderFactory(tag: KClass<T>): (TagConsumer<Unit>) -> T = { tagConsumer ->
            // This intantiates the tag by using some reflection js magic.
            // ::class.js points to the javascript constructor
            val constructor = tag.js
            val attributes = attributesMapOf("class", null)

            js("new constructor(attributes, tagConsumer)") as T
        }

        fun <T : DOMTag, H : DOMHandler<T, B>, B : RDOMBuilder<T>, P : Props<H>> RBuilder.domComponent(
            componentKlazz: KClass<out DOMComponent<T, H, B, P, *>>
        ) = ComponentBuilder(this, componentKlazz)
    }
}
