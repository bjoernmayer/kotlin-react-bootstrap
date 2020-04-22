package react.bootstrap.content.typography

import kotlinx.html.UL
import react.RBuilder
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.ul

// Todo: Add enum for styles containing unstyled and inline

fun RBuilder.ul(
    styled: Boolean = true,
    classes: String?,
    block: RDOMBuilder<UL>.() -> Unit
) = ul(
    if (styled) {
        classes
    } else {
        classes.appendClass("${ClassNames.LIST_UNSTYLED}")
    },
    block
)
