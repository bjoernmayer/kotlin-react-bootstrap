package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.importButtonGroup
import react.bootstrap.site.components.docs.importButtonGroupBuilder
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

internal class VerticalVariation : SectionComponent() {
    override val title: String = "Vertical variation"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Make a set of buttons appear vertically stacked rather than horizontally. __Split button dropdowns are not supported
here.__
            """
        }
        liveExample {
            buttonGroup(ButtonGroup.Appearance.VERTICAL) {
                for (x in 1..6) {
                    Buttons.solid.secondary { +"Button" }
                }
            }
        }
        // Todo add second liveExample featuring Dropdowns
        codeExample {
            +Imports.builder()
                .importButtonGroup()
                .importButtonsBuilder()
                .importButtonGroupBuilder()
                .build()

            +FunCall.builder(RBuilder::buttonGroup)
                .addArgument(ButtonGroup.Appearance.VERTICAL)
                .setLambdaArgument("...")
                .build()
        }
    }
}
