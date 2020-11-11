package react.bootstrap.content.typography.small

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

/**
 * Creates a generic [Small] element.
 *
 * @param T Tag Type to be used to render this [Small].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.small(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Small.Props<T>>(Small::class)
    .classes(classes)
    .domHandler(block)
    .build()
