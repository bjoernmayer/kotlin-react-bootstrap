package react.bootstrap.content.typography.small

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.DomComponent.Companion.domComponent

/**
 * Creates a generic [Small] element.
 *
 * @param TT Tag Type to be used to render this [Small].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.small(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = domComponent<TT, Small.Props<TT>>(classes, Small::class, domHandler = block)
