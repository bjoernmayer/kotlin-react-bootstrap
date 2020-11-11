package react.bootstrap.site.components.docs.layout.reference

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.ContainerBuilder
import react.bootstrap.layout.grid.container.container
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.FunSpec.Parameter.Modifier.CROSSINLINE
import react.bootstrap.site.lib.codepoet.FunSpec.Parameter.Modifier.NOINLINE
import react.bootstrap.site.lib.codepoet.Generic
import react.bootstrap.site.lib.codepoet.LambdaValue
import react.bootstrap.site.lib.codepoet.LambdaValue.Style.INLINE

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
                .addParameter<Container.Viscosities>("viscosity", null)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "handler",
                    Generic("RHandler", Generic(Container.Props::class, DIV::class).build()),
                    default = LambdaValue("", INLINE).build()
                )
                .addParameter("block", Generic("RDOMHandler", DIV::class))
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
                .addParameter<Container.Viscosities>("viscosity", null)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "handler",
                    Generic("RHandler", Generic(Container.Props::class, "T").build()),
                    default = LambdaValue("", INLINE).build(),
                    modifier = CROSSINLINE
                )
                .addParameter("block", Generic("RDOMHandler", "T"), modifier = NOINLINE)
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
                        "handler",
                        Generic("RHandler", Generic(Container.Props::class, DIV::class).build()),
                        default = LambdaValue("", INLINE).build()
                    )
                    .addParameter("block", Generic("RDOMHandler", DIV::class))
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
                        "handler",
                        Generic("RHandler", Generic(Container.Props::class, "T").build()),
                        default = LambdaValue("", INLINE).build(),
                        modifier = CROSSINLINE
                    )
                    .addParameter("block", Generic("RDOMHandler", "T"), modifier = NOINLINE)
                    .returns("ReactElement")
                    .build()
            }
        }
    }
}
