package react.bootstrap.content.typography.muted

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.DOMWrapComponent.Companion.domWrapComponent

/**
 * Creates a generic [Muted] element.
 *
 * @param TT Tag Type to be used to render this [Muted].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.muted(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = domWrapComponent<TT, Muted.Props<TT>>(classes, Muted::class, domHandler = block)
