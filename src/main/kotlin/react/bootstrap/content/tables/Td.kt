package react.bootstrap.content.tables

import kotlinx.html.TD
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.dom.RDOMBuilder
import react.dom.td

fun RBuilder.td(
    contextualStyle: ContextualStyle? = null,
    classes: String? = null,
    block: RDOMBuilder<TD>.() -> Unit
): ReactElement =
    td(
        classes = contextualStyle?.let { classes.appendClass(it.className) } ?: classes,
        block = block
    )
