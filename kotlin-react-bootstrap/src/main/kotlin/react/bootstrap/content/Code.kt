package react.bootstrap.content

import kotlinx.html.PRE
import react.RBuilder
import react.bootstrap.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.RDOMHandler
import react.dom.pre

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
