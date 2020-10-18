@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.layout.overview

import react.RBuilder
import react.bootstrap.layout.grid.container.Containers
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.layout.grid.importFromGrid
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall

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
            importFromGrid("container", "Containers")
            appendLine { }
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
