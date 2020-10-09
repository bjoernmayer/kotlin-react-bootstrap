package react.bootstrap.content.tables

import kotlinx.html.TH
import kotlinx.html.ThScope
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.RDOMHandler
import react.dom.th

fun RBuilder.th(
    contextualStyle: ContextualStyle? = null,
    scope: ThScope? = null,
    classes: String? = null,
    block: RDOMHandler<TH>
): ReactElement =
    th(
        classes = contextualStyle?.let { classes.appendClass(it.className) } ?: classes,
        scope = scope,
        block = block
    )
