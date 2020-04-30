package react.bootstrap.content

import kotlinx.html.PRE
import react.RBuilder
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.pre

@Suppress("unused")
fun RBuilder.pre(scrollable: Boolean, classes: String? = null, block: RDOMBuilder<PRE>.() -> Unit) =
    pre(
        classes = if (scrollable) {
            classes.appendClass(ClassNames.PRE_SCROLLABLE)
        } else {
            classes
        },
        block = block
    )
