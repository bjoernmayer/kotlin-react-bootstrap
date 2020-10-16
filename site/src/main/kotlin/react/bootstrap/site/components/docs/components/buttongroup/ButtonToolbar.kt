package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.components.button.buttonToolbar
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.components.buttons.solidSecondaryFun
import react.bootstrap.site.components.docs.components.importButtonGroupBuilder
import react.bootstrap.site.components.docs.components.importButtonsBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.kt
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
            +functionCall(RBuilder::buttonToolbar)
                .arg("label", "Toolbar with button groups")
                .block()
                .lambdaCalls(
                    functionCall(RBuilder::buttonGroup)
                        .arg("classes", "\${${ClassNames.MR_2.kt}}")
                        .arg("label", "First group")
                        .block()
                        .lambdaCalls {
                            for (x in 1..4) {
                                add(
                                    functionCall(solidSecondaryFun)
                                        .nestedBy(RBuilder::Buttons)
                                        .nestedBy(ButtonBuilder::solid)
                                        .inline()
                                        .lambdaContent(plusString(x.toString()))
                                )
                            }
                        },
                    functionCall(RBuilder::buttonGroup)
                        .arg("classes", "\${${ClassNames.MR_2.kt}}")
                        .arg("label", "Second group")
                        .block()
                        .lambdaCalls {
                            for (x in 5..7) {
                                add(
                                    functionCall(solidSecondaryFun)
                                        .nestedBy(RBuilder::Buttons)
                                        .nestedBy(ButtonBuilder::solid)
                                        .inline()
                                        .lambdaContent(plusString(x.toString()))
                                )
                            }
                        },
                    functionCall(RBuilder::buttonGroup)
                        .arg("classes", "\${${ClassNames.MR_2.kt}}")
                        .arg("label", "Third group")
                        .block()
                        .lambdaCalls(
                            functionCall(solidSecondaryFun)
                                .nestedBy(RBuilder::Buttons)
                                .nestedBy(ButtonBuilder::solid)
                                .inline()
                                .lambdaContent(plusString("8"))
                        )
                )
        }
        // Todo Add Mixing with Input Groups
    }
}
