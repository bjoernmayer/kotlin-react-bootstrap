package react.bootstrap.content

import kotlinx.html.PRE
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.RDOMHandler
import react.dom.pre

/**
 * Creates a [PRE] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 * @param scrollable Set this to *true* to make preformatted contents scrollable.
 */
public fun RBuilder.pre(classes: String? = null, scrollable: Boolean, block: RDOMHandler<PRE>): ReactElement =
    pre(
        classes = if (scrollable) {
            classes.appendClass(ClassNames.PRE_SCROLLABLE)
        } else {
            classes
        },
    ) {
        val builder = this
        with(block) {
            builder.handle()
        }
    }
