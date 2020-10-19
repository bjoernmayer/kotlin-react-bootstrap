@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.layout.overview

import react.RBuilder
import react.bootstrap.layout.grid.container.Containers
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.importFromGrid
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

internal class ContainerBuilder : SectionComponent() {
    override val title: String = "Container builder"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
The `RBuilder` also offers a builder to make creating containers a bit simpler.
            """
        }
        codeExample {
            +Imports.builder()
                .importFromGrid("container", "Containers")
                .build()

            +listOf(Containers::fluid, Containers::sm, Containers::md, Containers::lg, Containers::xl)
                .joinToString("") { function ->
                    FunCall.builder(function)
                        .nestedBy(RBuilder::Containers)
                        .setLambdaArgument("// Content here")
                        .build()
                }
        }
    }
}
