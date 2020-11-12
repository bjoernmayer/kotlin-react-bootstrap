package react.bootstrap.layout.grid.container

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.lib.PropHandler
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

fun RBuilder.container(
    viscosity: Container.Viscosities? = null,
    classes: String? = null,
    propHandler: PropHandler<Container.Props<DIV>> = { },
    block: RDOMHandler<DIV>
): ReactElement = abstractDomComponent<DIV, Container.Props<DIV>>(Container::class)
    .classes(classes)
    .propHandler {
        this.viscosity = viscosity

        propHandler()
    }
    .domHandler(block)
    .build()

inline fun <reified T : HtmlBlockTag> RBuilder.container(
    viscosity: Container.Viscosities? = null,
    classes: String? = null,
    crossinline propHandler: PropHandler<Container.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Container.Props<T>>(Container::class)
    .classes(classes)
    .propHandler {
        this.viscosity = viscosity

        propHandler()
    }
    .domHandler(block)
    .build()

class ContainerBuilder(override val builder: RBuilder) : Builder {
    fun fluid(
        classes: String? = null,
        propHandler: PropHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.FLUID, classes = classes, propHandler = propHandler, block = block)

    inline fun <reified T : HtmlBlockTag> fluid(
        classes: String? = null,
        crossinline propHandler: PropHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.FLUID, classes = classes, propHandler = propHandler, block = block)

    fun sm(
        classes: String? = null,
        propHandler: PropHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.SM, classes = classes, propHandler = propHandler, block = block)

    inline fun <reified T : HtmlBlockTag> sm(
        classes: String? = null,
        crossinline propHandler: PropHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.SM, classes = classes, propHandler = propHandler, block = block)

    fun md(
        classes: String? = null,
        propHandler: PropHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.MD, classes = classes, propHandler = propHandler, block = block)

    inline fun <reified T : HtmlBlockTag> md(
        classes: String? = null,
        crossinline propHandler: PropHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.MD, classes = classes, propHandler = propHandler, block = block)

    fun lg(
        classes: String? = null,
        propHandler: PropHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.LG, classes = classes, propHandler = propHandler, block = block)

    inline fun <reified T : HtmlBlockTag> lg(
        classes: String? = null,
        crossinline propHandler: PropHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.LG, classes = classes, propHandler = propHandler, block = block)

    fun xl(
        classes: String? = null,
        propHandler: PropHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.XL, classes = classes, propHandler = propHandler, block = block)

    inline fun <reified T : HtmlBlockTag> xl(
        classes: String? = null,
        crossinline propHandler: PropHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.XL, classes = classes, propHandler = propHandler, block = block)
}

val RBuilder.Containers: ContainerBuilder
    get() = ContainerBuilder(this)
