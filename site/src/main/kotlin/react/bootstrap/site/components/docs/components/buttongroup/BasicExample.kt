package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown

internal class BasicExample : SectionComponent() {
    override val title: String = "Basic example"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Wrap a series of buttons in `${RBuilder::buttonGroup.name}`.
            """
        }
        liveExample {
            buttonGroup {
                Buttons.solid.secondary { +"Left" }
                Buttons.solid.secondary { +"Middle" }
                Buttons.solid.secondary { +"Right" }
            }
        }
    }
}
