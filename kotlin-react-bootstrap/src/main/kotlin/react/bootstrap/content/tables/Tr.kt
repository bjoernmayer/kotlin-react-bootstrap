package react.bootstrap.content.tables

import kotlinx.html.TR
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.RDOMHandler
import react.dom.tr

/**
 * Creates a [TR] element.
 *
 * @param contextualStyle Set [ContextualStyle] to colour-in the [TR]s.
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.tr(
    contextualStyle: ContextualStyle? = null,
    classes: String? = null,
    block: RDOMHandler<TR>
): ReactElement =
    tr(
        classes = contextualStyle?.let { classes.appendClass(it.className) } ?: classes,
        block = block
    )
