package react.bootstrap.layout.grid.container

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
public fun RBuilder.container(
    viscosity: Container.Viscosities? = null,
    classes: String? = null,
    props: PropHandler<Container.Props<DIV>> = PropHandler { },
    block: RDOMHandler<DIV>
): ReactElement = container<DIV>(viscosity, classes, props, block)

@Suppress("UNCHECKED_CAST")
public inline fun <reified T : HtmlBlockTag> RBuilder.container(
    viscosity: Container.Viscosities? = null,
    classes: String? = null,
    props: PropHandler<Container.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Container::class as KClass<Container<T>>)
    .classes(classes)
    .propHandler {
        this.viscosity = viscosity

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()

public class ContainerBuilder(override val builder: RBuilder) : Builder {
    public fun fluid(
        classes: String? = null,
        props: PropHandler<Container.Props<DIV>> = PropHandler { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.FLUID,
            classes = classes,
            props = props,
            block = block
        )

    public inline fun <reified T : HtmlBlockTag> fluid(
        classes: String? = null,
        props: PropHandler<Container.Props<T>> = PropHandler { },
        block: RDOMHandler<T>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.FLUID,
            classes = classes,
            props = props,
            block = block
        )

    public fun sm(
        classes: String? = null,
        props: PropHandler<Container.Props<DIV>> = PropHandler { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.SM,
            classes = classes,
            props = props,
            block = block
        )

    public inline fun <reified T : HtmlBlockTag> sm(
        classes: String? = null,
        props: PropHandler<Container.Props<T>> = PropHandler { },
        block: RDOMHandler<T>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.SM,
            classes = classes,
            props = props,
            block = block
        )

    public fun md(
        classes: String? = null,
        props: PropHandler<Container.Props<DIV>> = PropHandler { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.MD,
            classes = classes,
            props = props,
            block = block
        )

    public inline fun <reified T : HtmlBlockTag> md(
        classes: String? = null,
        props: PropHandler<Container.Props<T>> = PropHandler { },
        block: RDOMHandler<T>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.MD,
            classes = classes,
            props = props,
            block = block
        )

    public fun lg(
        classes: String? = null,
        props: PropHandler<Container.Props<DIV>> = PropHandler { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.LG,
            classes = classes,
            props = props,
            block = block
        )

    public inline fun <reified T : HtmlBlockTag> lg(
        classes: String? = null,
        props: PropHandler<Container.Props<T>> = PropHandler { },
        block: RDOMHandler<T>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.LG,
            classes = classes,
            props = props,
            block = block
        )

    public fun xl(
        classes: String? = null,
        props: PropHandler<Container.Props<DIV>> = PropHandler { },
        block: RDOMHandler<DIV>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.XL,
            classes = classes,
            props = props,
            block = block
        )

    public inline fun <reified T : HtmlBlockTag> xl(
        classes: String? = null,
        props: PropHandler<Container.Props<T>> = PropHandler { },
        block: RDOMHandler<T>
    ): ReactElement =
        builder.container(
            viscosity = Container.Viscosities.XL,
            classes = classes,
            props = props,
            block = block
        )
}

public val RBuilder.Containers: ContainerBuilder
    get() = ContainerBuilder(this)
