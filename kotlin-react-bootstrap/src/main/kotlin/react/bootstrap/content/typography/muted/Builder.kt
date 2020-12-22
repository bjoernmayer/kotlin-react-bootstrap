package react.bootstrap.content.typography.muted

import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

/**
 * Creates a generic [Muted] element.
 *
 * @param T Tag Type to be used to render this [Muted].
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
public inline fun <reified T : DOMTag> RBuilder.muted(
    classes: String? = null,
    props: PropHandler<Muted.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Muted::class as KClass<Muted<T>>)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()
