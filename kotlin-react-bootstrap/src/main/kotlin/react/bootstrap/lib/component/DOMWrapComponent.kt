package react.bootstrap.lib.component

import kotlinx.html.Tag
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * A DOMWrapComponent is a pass-through component.
 * It can be rendered with any HTML Tag and gives the user full controll of the tag attributes
 *
 * @param TT Tag type
 * @param PT Prop Type
 */
abstract class DOMWrapComponent<TT : Tag, PT : DOMWrapComponent.Props<TT>>(props: PT) : RComponent<PT, RState>(props) {
    init {
        // These comparison are not senseless. The props are built using kotlin's `dynamic` keyword. Null is a possible
        // value.

        @Suppress("SENSELESS_COMPARISON")
        require(props.domClass != null) {
            "Missing property: domClass must not be null!"
        }

        @Suppress("SENSELESS_COMPARISON")
        require(props.domHandler != null) {
            "Missing property: domHandler must not be null!"
        }
    }

    protected abstract fun RDOMBuilder<TT>.build()

    final override fun RBuilder.render() {
        @Suppress("UNUSED_VARIABLE", "UNUSED_ANONYMOUS_PARAMETER")
        val rROMBuilder = RDOMBuilder { tagConsumer ->
            // This intantiates the tag by using some reflection js magic.
            // ::class.js points to the javascript constructor
            val constructor = props.domClass.js
            val attributes = attributesMapOf("class", null)

            js("new constructor(attributes, tagConsumer)") as TT
        }

        child(
            rROMBuilder
                .apply {
                    build()
                    props.domHandler.invoke(this)
                }
                .create()
        )
    }

    interface Props<TT : Tag> : RProps {
        var domClass: KClass<TT>
        var domHandler: RDOMHandler<TT>
    }

    companion object {
        inline fun <reified TT : Tag, reified PT : Props<TT>> RBuilder.domWrapComponent(
            klazz: KClass<out DOMWrapComponent<*, *>>,
            noinline block: RDOMHandler<TT>,
        ): ReactElement {

            @Suppress("UNCHECKED_CAST")
            val componentKlazz: KClass<out DOMWrapComponent<TT, PT>> = klazz as KClass<out DOMWrapComponent<TT, PT>>

            return child(componentKlazz) {
                attrs {
                    domHandler = block
                    domClass = TT::class
                }
            }
        }
    }
}
