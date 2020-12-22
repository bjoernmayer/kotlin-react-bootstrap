package react.bootstrap.content.tables

import kotlinx.html.TD
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.component.RDOMHandler
import react.dom.td as reactTd

/**
 * Creates a [TD] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 * @param contextualStyle Set [ContextualStyle] to colour-in the [TD]s.
 */
public fun RBuilder.td(
    classes: String? = null,
    contextualStyle: ContextualStyle? = null,
    block: RDOMHandler<TD>
): ReactElement =
    reactTd(classes = contextualStyle?.let { classes.appendClass(it.className) } ?: classes) {
        val builder = this
        with(block) {
            builder.handle()
        }
    }
