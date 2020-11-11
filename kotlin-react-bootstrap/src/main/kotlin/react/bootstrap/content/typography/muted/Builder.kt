package react.bootstrap.content.typography.muted

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

/**
 * Creates a generic [Muted] element.
 *
 * @param T Tag Type to be used to render this [Muted].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.muted(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Muted.Props<T>>(Muted::class)
    .classes(classes)
    .domHandler(block)
    .build()
