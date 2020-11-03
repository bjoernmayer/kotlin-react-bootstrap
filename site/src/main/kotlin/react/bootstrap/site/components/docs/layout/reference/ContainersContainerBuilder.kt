package react.bootstrap.site.components.docs.layout.reference

import react.RBuilder
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.ContainerBuilder
import react.bootstrap.layout.grid.container.container
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic

internal class ContainersContainerBuilder : SectionComponent() {
    override val title: String = "Containers & ContainerBuilder"

    override fun RBuilder.render() {
        sectionTitle(section)
        subSectionTitle(RBuilder::container.name, section)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Container::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::container)
                .nestedBy(RBuilder::class)
                .addParameter("viscosity", Container.Viscosities::class, true, FunSpec.Parameter.NULL)
                .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("block", Generic("RHandler", Container.Props::class))
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
            subSectionTitle(function.name, section)
            val viscosity = Container.Viscosities.valueOf(function.name.toUpperCase())
            Markdown {
                //language=Markdown
                +"""
Creates a `${Container::class.nestedName}` element with `viscosity` set to `${viscosity.nestedName}`.
            """
            }
            codeExample {
                +FunSpec.builder(function, false)
                    .nestedBy(ContainerBuilder::class)
                    .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                    .addParameter("block", Generic("RHandler", Container.Props::class))
                    .returns("ReactElement")
                    .build()
            }
        }
    }
}
