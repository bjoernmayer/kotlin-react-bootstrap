package react.bootstrap.content.typography.mark

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.domComponent

/**
 * Creates a generic [Mark] element.
 *
 * @param TT Tag Type to be used to render this [Mark].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.mark(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = domComponent<TT, Mark.Props<TT>>(classes, Mark::class, domHandler = block)
