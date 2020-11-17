package react.bootstrap.content.typography.mark

import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

/**
 * Creates a generic [Mark] element.
 *
 * @param T Tag Type to be used to render this [Mark].
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : DOMTag> RBuilder.mark(
    classes: String? = null,
    props: PropHandler<Mark.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Mark::class as KClass<Mark<T>>)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()
