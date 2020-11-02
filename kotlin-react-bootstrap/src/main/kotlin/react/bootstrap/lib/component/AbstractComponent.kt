package react.bootstrap.lib.component

import kotlinx.html.Tag
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * @param TT Tag Type: The HTML tag type used to render this component
 * @param ACP Abstract Component Props: The [RProps] of the [AbstractComponent] implementation
 * @param ACS Abstract Componnt State: The [RState] of  the [AbstractComponent] implementation
 */
abstract class AbstractComponent<TT : Tag, ACP : WithGlobalAttributes, ACS : RState> : RComponent<ACP, ACS> {
    constructor() : super()
    constructor(props: ACP) : super(props)

    abstract val rendererTag: KClass<out TT>

    protected abstract fun RDOMBuilder<TT>.build()

    /**
     * This transfers the children of the [AbstractComponent] into the actual ReactElement
     */
    protected open fun RDOMBuilder<TT>.transferChildren() {
        children()
    }

    final override fun RBuilder.render() {
        @Suppress("UNUSED_VARIABLE", "UNUSED_ANONYMOUS_PARAMETER")
        val rROMBuilder = RDOMBuilder { tagConsumer ->
            // This intantiates the tag by using some reflection js magic.
            // ::class.js points to the javascript constructor
            val constructor = rendererTag.js
            val attributes = attributesMapOf("class", null)

            js("new constructor(attributes, tagConsumer)") as TT
        }

        child(
            rROMBuilder
                .apply {
                    build()
                    transferChildren()
                }
                .create()
        )
    }
}
