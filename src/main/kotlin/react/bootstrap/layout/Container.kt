package react.bootstrap.layout

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.div

enum class Viscosities(val className: ClassNames) {
    FLUID(ClassNames.CONTAINER_FLUID),
    SM(ClassNames.CONTAINER_SM),
    MD(ClassNames.CONTAINER_MD),
    LG(ClassNames.CONTAINER_LG),
    XL(ClassNames.CONTAINER_XL);
}

fun RBuilder.container(
    viscosity: Viscosities? = null,
    classes: String? = null,
    block: RDOMBuilder<DIV>.() -> Unit
): ReactElement {
    val className: ClassNames = viscosity?.className ?: ClassNames.CONTAINER

    return div(classes.appendClass("$className"), block)
}
