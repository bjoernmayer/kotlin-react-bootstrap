package react.bootstrap.layout

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.div

enum class ContainerVariants(private val classNames: ClassNames) {
    CONTAINER(ClassNames.CONTAINER),
    SM(ClassNames.CONTAINER_SM),
    MD(ClassNames.CONTAINER_MD),
    LG(ClassNames.CONTAINER_LG),
    XL(ClassNames.CONTAINER_XL),
    FLUID(ClassNames.CONTAINER_FLUID);

    override fun toString(): String {
        return "$classNames"
    }
}

fun RBuilder.container(variants: ContainerVariants, classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit) =
    div(classes.appendClass("$variants"), block)

fun RBuilder.container(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    container(ContainerVariants.CONTAINER, classes, block)

fun RBuilder.containerSm(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    container(ContainerVariants.SM, classes, block)

fun RBuilder.containerMd(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    container(ContainerVariants.MD, classes, block)

fun RBuilder.containerLG(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    container(ContainerVariants.LG, classes, block)

fun RBuilder.containerXL(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    container(ContainerVariants.XL, classes, block)

fun RBuilder.containerFluid(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    container(ContainerVariants.FLUID, classes, block)
