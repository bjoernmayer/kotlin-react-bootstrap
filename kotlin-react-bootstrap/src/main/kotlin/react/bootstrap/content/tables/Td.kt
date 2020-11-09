package react.bootstrap.content.tables

import kotlinx.html.TD
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.RDOMHandler
import react.dom.td

/**
 * Creates a [TD] element.
 *
 * @param contextualStyle Set [ContextualStyle] to colour-in the [TD]s.
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.td(
    contextualStyle: ContextualStyle? = null,
    classes: String? = null,
    block: RDOMHandler<TD>
): ReactElement =
    td(
        classes = contextualStyle?.let { classes.appendClass(it.className) } ?: classes,
        block = block
    )
