package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.components.buttons.solidSecondaryFun
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importButtonGroupBuilder
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

internal class BasicExample : SectionComponent() {
    override val title: String = "Basic example"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Wrap a series of buttons in `${RBuilder::buttonGroup.name}`.
            """
        }
        val leftMiddleRight = listOf("Left", "Middle", "Right")
        liveExample {
            buttonGroup {
                leftMiddleRight.forEach {
                    Buttons.solid.secondary { +it }
                }
            }
        }
        codeExample {
            +Imports.builder()
                .importButtonsBuilder()
                .importButtonGroupBuilder()
                .build()

            +FunCall.builder(RBuilder::buttonGroup)
                .setLambdaArgument(
                    buildString {
                        leftMiddleRight.forEach {
                            appendLine(
                                FunCall.builder(solidSecondaryFun, FunCall.Style.INLINE)
                                    .nestedBy(RBuilder::Buttons)
                                    .nestedBy(ButtonBuilder::solid)
                                    .setLambdaArgument(plusString(it))
                                    .build()
                            )
                        }
                    }
                )
                .build()
        }
    }
}
