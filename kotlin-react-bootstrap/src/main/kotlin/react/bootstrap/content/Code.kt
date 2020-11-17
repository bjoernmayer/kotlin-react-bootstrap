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
 * @param scrollable Set this to *true* to make preformatted contents scrollable.
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.pre(scrollable: Boolean, classes: String? = null, block: RDOMHandler<PRE>): ReactElement =
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
