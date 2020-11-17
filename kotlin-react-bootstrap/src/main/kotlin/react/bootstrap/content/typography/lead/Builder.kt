package react.bootstrap.content.typography.lead

import kotlinx.html.P
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.lib.component.SimpleDOMComponent.Companion.simpleDomComponent

/**
 * Creates a [Lead] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.lead(
    classes: String? = null,
    props: PropHandler<Lead.Props> = PropHandler { },
    block: RDOMHandler<P>
): ReactElement = simpleDomComponent(Lead::class)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()
