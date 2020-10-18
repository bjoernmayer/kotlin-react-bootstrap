package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.components.button.buttonToolbar
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.components.docs.components.buttons.solidSecondaryFun
import react.bootstrap.site.components.docs.components.importButtonGroupBuilder
import react.bootstrap.site.components.docs.components.importButtonsBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.dom.p

internal class ButtonToolbar : SectionComponent() {
    override val title: String = "Button toolbar"

    override fun RBuilder.render() {
        sectionTitle(section)
        p {
            +"""
Combine sets of button groups into button toolbars for more complex components. Use utility classes as needed to space
out groups, buttons, and more.
            """
        }
        liveExample {
            buttonToolbar(label = "Toolbar with button groups") {
                buttonGroup(classes = "${ClassNames.MR_2}", label = "First group") {
                    for (x in 1..4) {
                        Buttons.solid.secondary { +x.toString() }
                    }
                }
                buttonGroup(classes = "${ClassNames.MR_2}", label = "Second group") {
                    for (x in 5..7) {
                        Buttons.solid.secondary { +x.toString() }
                    }
                }
                buttonGroup(label = "Third group") {
                    Buttons.solid.secondary { +"8" }
                }
            }
        }
        codeExample {
            importButtonsBuilder()
            importButtonGroupBuilder()
            import("components.button.${RBuilder::buttonToolbar.name}")
            ln { }
            +FunCall.builder(RBuilder::buttonToolbar)
                .addArgument("label", "Toolbar with button groups")
                .setLambdaArgument(
                    FunCall.builder(RBuilder::buttonGroup)
                        .addArgument("classes", ClassNames.MR_2)
                        .addArgument("label", "First group")
                        .setLambdaArgument(
                            buildString {
                                for (x in 1..4) {
                                    append(
                                        FunCall.builder(solidSecondaryFun, FunCall.Style.NEW_INLINE)
                                            .nestedBy(RBuilder::Buttons)
                                            .nestedBy(ButtonBuilder::solid)
                                            .setLambdaArgument(plusString(x.toString()))
                                            .build()
                                    )
                                }
                            }
                        ).build(),
                    FunCall.builder(RBuilder::buttonGroup)
                        .addArgument("classes", ClassNames.MR_2)
                        .addArgument("label", "Second group")
                        .setLambdaArgument(
                            buildString {
                                for (x in 5..7) {
                                    append(
                                        FunCall.builder(solidSecondaryFun, FunCall.Style.NEW_INLINE)
                                            .nestedBy(RBuilder::Buttons)
                                            .nestedBy(ButtonBuilder::solid)
                                            .setLambdaArgument(plusString(x.toString()))
                                            .build()
                                    )
                                }
                            }
                        ).build(),
                    FunCall.builder(RBuilder::buttonGroup)
                        .addArgument("classes", ClassNames.MR_2)
                        .addArgument("label", "Third group")
                        .setLambdaArgument(
                            FunCall.builder(solidSecondaryFun, FunCall.Style.INLINE)
                                .nestedBy(RBuilder::Buttons)
                                .nestedBy(ButtonBuilder::solid)
                                .setLambdaArgument(plusString("8"))
                                .build()
                        ).build()
                ).build()
        }
        // Todo Add Mixing with Input Groups
    }
}
