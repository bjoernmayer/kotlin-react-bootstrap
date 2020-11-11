package react.bootstrap.layout.grid.container

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

fun RBuilder.container(
    viscosity: Container.Viscosities? = null,
    classes: String? = null,
    block: RDOMHandler<DIV>
): ReactElement = abstractDomComponent<DIV, Container.Props<DIV>>(Container::class)
    .classes(classes)
    .handler {
        attrs {
            this.viscosity = viscosity
        }
    }
    .domHandler(block)
    .build()

inline fun <reified T : HtmlBlockTag> RBuilder.container(
    viscosity: Container.Viscosities? = null,
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Container.Props<T>>(Container::class)
    .classes(classes)
    .handler {
        attrs {
            this.viscosity = viscosity
        }
    }
    .domHandler(block)
    .build()

class ContainerBuilder(override val builder: RBuilder) : Builder {
    fun fluid(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
        builder.container(viscosity = Container.Viscosities.FLUID, classes = classes, block = block)

    fun sm(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
        builder.container(viscosity = Container.Viscosities.SM, classes = classes, block = block)

    fun md(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
        builder.container(viscosity = Container.Viscosities.MD, classes = classes, block = block)

    fun lg(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
        builder.container(viscosity = Container.Viscosities.LG, classes = classes, block = block)

    fun xl(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
        builder.container(viscosity = Container.Viscosities.XL, classes = classes, block = block)
}

val RBuilder.Containers: ContainerBuilder
    get() = ContainerBuilder(this)
