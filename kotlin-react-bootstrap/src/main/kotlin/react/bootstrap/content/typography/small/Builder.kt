package react.bootstrap.content.typography.small

import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

/**
 * Creates a generic [Small] element.
 *
 * @param T Tag Type to be used to render this [Small].
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : DOMTag> RBuilder.small(
    classes: String? = null,
    props: PropHandler<Small.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Small::class as KClass<Small<T>>)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()
