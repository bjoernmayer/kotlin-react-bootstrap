package react.bootstrap.site.components.docs.layout.overview

import react.RBuilder
import react.bootstrap.layout.grid.container.Containers
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ln
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
            ktB(0, "${RBuilder::Containers.name}.${Containers::fluid.name}") {
                ln(it) { +"// Content here" }
            }
            ktB(0, "${RBuilder::Containers.name}.${Containers::sm.name}") {
                ln(it) { +"// Content here" }
            }
            ktB(0, "${RBuilder::Containers.name}.${Containers::md.name}") {
                ln(it) { +"// Content here" }
            }
            ktB(0, "${RBuilder::Containers.name}.${Containers::lg.name}") {
                ln(it) { +"// Content here" }
            }
            ktB(0, "${RBuilder::Containers.name}.${Containers::xl.name}") {
                ln(it) { +"// Content here" }
            }
        }
    }
}
