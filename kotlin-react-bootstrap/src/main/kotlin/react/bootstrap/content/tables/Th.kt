package react.bootstrap.content.tables

import kotlinx.html.TH
import kotlinx.html.ThScope
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.component.RDOMHandler
import react.dom.th as reactTh

/**
 * Creates a [TH] element.
 *
 * @param scope
 * @param classes Space separated list of CSS classes for this element.
 * @param contextualStyle Set a [ContextualStyle] to colour-in the [TH]s.
 */
public fun RBuilder.th(
    scope: ThScope? = null,
    classes: String? = null,
    contextualStyle: ContextualStyle? = null,
    block: RDOMHandler<TH>
): ReactElement =
    reactTh(classes = contextualStyle?.let { classes.appendClass(it.className) } ?: classes, scope = scope) {
        val builder = this
        with(block) {
            builder.handle()
        }
    }
