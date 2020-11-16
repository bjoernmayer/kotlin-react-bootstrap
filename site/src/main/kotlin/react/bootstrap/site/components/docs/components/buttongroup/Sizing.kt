package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importButtonGroup
import react.bootstrap.site.components.docs.importButtonGroupBuilder
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.br

internal class Sizing : SectionComponent() {
    override val title: String = "Sizing"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Instead of applying button sizing classes to every button in a group, just set `sizes` to each
`${RBuilder::buttonGroup.name}`, including each one when nesting multiple groups.
            """
        }
        val leftMiddleRight = listOf("Left", "Middle", "Right")
        liveExample {
            buttonGroup(sizes = ButtonGroup.Sizes.LG) {
                leftMiddleRight.forEach {
                    Buttons.solid.secondary { +it }
                }
            }
            br { }
            buttonGroup {
                leftMiddleRight.forEach {
                    Buttons.solid.secondary { +it }
                }
            }
            br { }
            buttonGroup(sizes = ButtonGroup.Sizes.SM) {
                leftMiddleRight.forEach {
                    Buttons.solid.secondary { +it }
                }
            }
            br { }
        }
        codeExample {
            +Imports.builder()
                .importButtonGroup()
                .importButtonsBuilder()
                .importButtonGroupBuilder()
                .build()

            +FunCall.builder(RBuilder::buttonGroup)
                .setLambdaArgument("...")
                .build()
            +FunCall.builder(RBuilder::br, FunCall.Style.NEW_INLINE)
                .setEmptyLambdaArgument()
                .build()
            +FunCall.builder(RBuilder::buttonGroup)
                .addArgument("sizes", ButtonGroup.Sizes.SM)
                .setLambdaArgument("...")
                .build()
        }
    }
}
