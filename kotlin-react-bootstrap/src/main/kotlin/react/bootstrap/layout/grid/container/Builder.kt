package react.bootstrap.layout.grid.container

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

fun RBuilder.container(
    viscosity: Container.Viscosities? = null,
    classes: String? = null,
    handler: RHandler<Container.Props<DIV>> = { },
    block: RDOMHandler<DIV>
): ReactElement = abstractDomComponent<DIV, Container.Props<DIV>>(Container::class)
    .classes(classes)
    .handler {
        attrs {
            this.viscosity = viscosity
        }

        handler()
    }
    .domHandler(block)
    .build()

inline fun <reified T : HtmlBlockTag> RBuilder.container(
    viscosity: Container.Viscosities? = null,
    classes: String? = null,
    crossinline handler: RHandler<Container.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Container.Props<T>>(Container::class)
    .classes(classes)
    .handler {
        attrs {
            this.viscosity = viscosity
        }

        handler()
    }
    .domHandler(block)
    .build()

class ContainerBuilder(override val builder: RBuilder) : Builder {
    fun fluid(
        classes: String? = null,
        handler: RHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.FLUID, classes = classes, handler = handler, block = block)

    inline fun <reified T : HtmlBlockTag> fluid(
        classes: String? = null,
        crossinline handler: RHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.FLUID, classes = classes, handler = handler, block = block)

    fun sm(
        classes: String? = null,
        handler: RHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.SM, classes = classes, handler = handler, block = block)

    inline fun <reified T : HtmlBlockTag> sm(
        classes: String? = null,
        crossinline handler: RHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.SM, classes = classes, handler = handler, block = block)

    fun md(
        classes: String? = null,
        handler: RHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.MD, classes = classes, handler = handler, block = block)

    inline fun <reified T : HtmlBlockTag> md(
        classes: String? = null,
        crossinline handler: RHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.MD, classes = classes, handler = handler, block = block)

    fun lg(
        classes: String? = null,
        handler: RHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.LG, classes = classes, handler = handler, block = block)

    inline fun <reified T : HtmlBlockTag> lg(
        classes: String? = null,
        crossinline handler: RHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.LG, classes = classes, handler = handler, block = block)

    fun xl(
        classes: String? = null,
        handler: RHandler<Container.Props<DIV>> = { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.XL, classes = classes, handler = handler, block = block)

    inline fun <reified T : HtmlBlockTag> xl(
        classes: String? = null,
        crossinline handler: RHandler<Container.Props<T>> = { },
        noinline block: RDOMHandler<T>
    ): ReactElement =
        builder.container(viscosity = Container.Viscosities.XL, classes = classes, handler = handler, block = block)
}

val RBuilder.Containers: ContainerBuilder
    get() = ContainerBuilder(this)
