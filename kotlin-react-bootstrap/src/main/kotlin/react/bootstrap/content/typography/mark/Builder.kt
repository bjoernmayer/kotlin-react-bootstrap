package react.bootstrap.content.typography.mark

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

/**
 * Creates a generic [Mark] element.
 *
 * @param T Tag Type to be used to render this [Mark].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.mark(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Mark.Props<T>>(Mark::class)
    .classes(classes)
    .domHandler(block)
    .build()
