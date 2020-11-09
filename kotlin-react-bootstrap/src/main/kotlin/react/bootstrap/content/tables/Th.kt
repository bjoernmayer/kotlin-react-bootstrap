package react.bootstrap.content.tables

import kotlinx.html.TH
import kotlinx.html.ThScope
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.RDOMHandler
import react.dom.th

/**
 * Creates a [TH] element.
 *
 * @param contextualStyle Set a [ContextualStyle] to colour-in the [TH]s.
 * @param scope
 * @param classes Space separated list of CSS classes for this element.
 */
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
