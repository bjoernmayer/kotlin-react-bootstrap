package react.bootstrap.lib.component

import kotlinx.html.Tag
import kotlinx.html.attributesMapOf
import react.Children
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.children
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * @param TT Tag Tyoe: The HTML tag type used to render this component
 * @param ACP Abstract Component Props: The [RProps] of the [AbstractComponent] implementation
 * @param ACS Abstract Componnt State: The [RState] of  the [AbstractComponent] implementation
 */
abstract class AbstractComponent<TT : Tag, ACP : WithGlobalAttributes, ACS : RState> : RComponent<ACP, ACS> {
    constructor() : super()
    constructor(props: ACP) : super(props)

    abstract val rendererTag: KClass<out TT>

    protected abstract fun RDOMBuilder<TT>.build()

    final override fun RBuilder.render() {
        @Suppress("UNUSED_VARIABLE")
        val rROMBuilder = RDOMBuilder {
            // This intantiates the tag by using some reflection js magic.
            val constructor = rendererTag.js
            val attributes = attributesMapOf("class", null)
            val meesaConsumer = it

            js("new constructor(attributes, meesaConsumer)") as TT
        }

        // Move children from the AbstractComponent into the newly created one
        Children.toArray(props.children).forEach {
            rROMBuilder.childList.add(it)
        }

        child(
            rROMBuilder.apply {
                build()
            }.create()
        )
    }
}
