package react.bootstrap.lib.component

import kotlinext.js.clone
import kotlinext.js.getOwnPropertyNames
import kotlinext.js.jsObject
import kotlinx.html.HTMLTag
import kotlinx.html.Tag
import kotlinx.html.attributesMapOf
import react.Children
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.WithRendererTag
import react.bootstrap.makeInstance
import react.children
import react.dom.fixAttributeName
import kotlin.reflect.KClass

/**
 * @param ACP Abstract Component Props: The [RProps] of the [AbstractComponent] implementation
 * @param ACS Abstract Componnt State: The [RState] of  the [AbstractComponent] implementation
 */
abstract class AbstractComponent<ACP : WithGlobalAttributes, ACS : RState> : RComponent<ACP, ACS> {
    constructor() : super()
    constructor(props: ACP) : super(props)

    protected abstract fun WithGlobalAttributes.handleProps()

    /**
     * This is an [ElementProvider].
     *
     * This should return a [ReactElement] which is used as default renderer if no `renderAs` was set.
     */
    protected abstract fun getRenderer(): KClass<out Tag>

    final override fun RBuilder.render() {
        val renderer: KClass<out Tag> = getRenderer()

        val tagName = renderer.simpleName!!.toLowerCase()

        // val constructor = renderer.js
        // val attributes = attributesMapOf()
        // val lol =  js("new constructor(attributes)") as TT
        //
        // console.log(renderer.js)
        //
        // lol.handleProps()

        val actualProps: WithGlobalAttributes = jsObject()
        actualProps.handleProps()

        console.log(actualProps)

        val fixedProps: RProps = jsObject()
        actualProps.getOwnPropertyNames().forEach {
            val (key, value) = if (it == WithGlobalAttributes::classes.name) {
                "className" to ((actualProps.asDynamic()[it] as Set<String>?)?.joinToString(" ") ?: "")
            } else {
                fixAttributeName(it) to actualProps.asDynamic()[it]
            }
            fixedProps.asDynamic()[key] = value
        }

        console.log(fixedProps)

        // lol.attributesEntries.forEach { (attribute: String, value: Any?) ->
        //     val key = fixAttributeName(attribute)
        //     actualProps.asDynamic()[key] = value
        // }

        child(
            tagName,
            fixedProps,
            Children.toArray(props.children).toList()
        )
    }

    final override fun render(): dynamic = RBuilder().apply { render() }.childList.last()
}
