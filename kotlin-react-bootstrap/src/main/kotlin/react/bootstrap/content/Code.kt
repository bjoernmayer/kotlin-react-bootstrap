package react.bootstrap.content

import kotlinx.html.PRE
import react.RBuilder
import react.bootstrap.appendClass
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.pre

/**
 * Creates a [PRE] element.
 *
 * @param scrollable Set this to *true* to make preformatted contents scrollable.
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("unused")
fun RBuilder.pre(scrollable: Boolean, classes: String? = null, block: RDOMHandler<PRE>) =
    pre(
        classes = if (scrollable) {
            classes.appendClass(ClassNames.PRE_SCROLLABLE)
        } else {
            classes
        },
        block = block
    )
