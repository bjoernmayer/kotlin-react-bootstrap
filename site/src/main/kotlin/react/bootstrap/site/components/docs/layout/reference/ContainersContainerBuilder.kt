package react.bootstrap.site.components.docs.layout.reference

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.ContainerBuilder
import react.bootstrap.layout.grid.container.container
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic

internal class ContainersContainerBuilder : SectionComponent() {
    override val title: String = "Containers & ContainerBuilder"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle(RBuilder::container.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Container::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::container)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter<Container.Viscosities>("viscosity", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic.builder<Container.Props<*>, DIV>().build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic.builder<RDOMHandler<*>, DIV>())
                .returns("ReactElement")
                .build()
        }

        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Container::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::container, inline = true)
                .nestedBy<RBuilder>()
                .addTypeParameter("T", HtmlBlockTag::class, true)
                .addParameter<String?>("classes", null)
                .addParameter<Container.Viscosities>("viscosity", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(Container.Props::class, "T").build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic(RDOMHandler::class, "T"))
                .returns("ReactElement")
                .build()
        }

        listOf(
            ContainerBuilder::fluid,
            ContainerBuilder::sm,
            ContainerBuilder::md,
            ContainerBuilder::lg,
            ContainerBuilder::xl
        ).forEach { function ->
            subSectionTitle(function.name)
            val viscosity = Container.Viscosities.valueOf(function.name.toUpperCase())
            Markdown {
                //language=Markdown
                +"""
Creates a `${Container::class.nestedName}` element with `viscosity` set to `${viscosity.nestedName}`.
            """
            }
            codeExample {
                +FunSpec.builder(function)
                    .nestedBy<ContainerBuilder>()
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic(PropHandler::class, Generic.builder<Container.Props<*>, DIV>().build()),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic.builder<RDOMHandler<*>, DIV>())
                    .returns("ReactElement")
                    .build()
            }

            Markdown {
                //language=Markdown
                +"""
Creates a generic `${Container::class.nestedName}` element with `viscosity` set to `${viscosity.nestedName}`.
            """
            }
            codeExample {
                +FunSpec.builder(function, inline = true)
                    .nestedBy<ContainerBuilder>()
                    .addTypeParameter("T", HtmlBlockTag::class, true)
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic(PropHandler::class, Generic(Container.Props::class, "T").build()),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic(RDOMHandler::class, "T"))
                    .returns("ReactElement")
                    .build()
            }
        }
    }
}
