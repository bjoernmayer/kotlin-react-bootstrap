@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.layout.overview

import react.RBuilder
import react.bootstrap.layout.grid.container.Containers
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.layout.grid.importFromGrid
import react.bootstrap.site.external.Markdown

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
            ln { }
            ktFun(Containers::fluid, parents = listOf(RBuilder::Containers.name)) {
                ln { +"// Content here" }
            }
            ktFun(Containers::sm, parents = listOf(RBuilder::Containers.name)) {
                ln { +"// Content here" }
            }
            ktFun(Containers::md, parents = listOf(RBuilder::Containers.name)) {
                ln { +"// Content here" }
            }
            ktFun(Containers::lg, parents = listOf(RBuilder::Containers.name)) {
                ln { +"// Content here" }
            }
            ktFun(Containers::xl, parents = listOf(RBuilder::Containers.name)) {
                ln { +"// Content here" }
            }
        }
    }
}
