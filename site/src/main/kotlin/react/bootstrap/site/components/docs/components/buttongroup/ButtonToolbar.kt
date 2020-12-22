package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.components.button.buttonToolbar
import react.bootstrap.helpers.classes
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.bootstrap.site.components.docs.components.buttons.solidSecondaryFun
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importButtonGroupBuilder
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.lib.codepoet.Assignment
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunCall.Style.INLINE
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.p

internal class ButtonToolbar : SectionComponent() {
    override val title: String = "Button toolbar"

    override fun RBuilder.render() {
        sectionTitle()
        p {
            +"""
Combine sets of button groups into button toolbars for more complex components. Use utility classes as needed to space
out groups, buttons, and more.
            """
        }
        liveExample {
            buttonToolbar {
                attrs {
                    ariaLabel = "Toolbar with button groups"
                }
                buttonGroup(classes(ClassNames.MR_2)) {
                    attrs {
                        ariaLabel = "First group"
                    }
                    for (x in 1..4) {
                        Buttons.solid.secondary { +x.toString() }
                    }
                }
                buttonGroup(classes(ClassNames.MR_2)) {
                    attrs {
                        ariaLabel = "Second group"
                    }
                    for (x in 5..7) {
                        Buttons.solid.secondary { +x.toString() }
                    }
                }
                buttonGroup {
                    attrs {
                        ariaLabel = "Third group"
                    }
                    Buttons.solid.secondary { +"8" }
                }
            }
        }
        codeExample {
            +Imports.builder()
                .importButtonsBuilder()
                .importButtonGroupBuilder()
                .addImport("components.button.${RBuilder::buttonToolbar.name}")
                .build()

            +FunCall.builder(RBuilder::buttonToolbar)
                .setLambdaArgument(
                    FunCall.builder(RElementBuilder<RProps>::attrs)
                        .setLambdaArgument(
                            Assignment.builder(DOMTag::ariaLabel)
                                .value("Toolbar with button groups")
                                .build()
                        )
                        .build(),
                    FunCall.builder(RBuilder::buttonGroup)
                        .addArgument(FunCall.builder(::classes, INLINE).addArgument(ClassNames.MR_2))
                        .setLambdaArgument(
                            FunCall.builder(RElementBuilder<RProps>::attrs)
                                .setLambdaArgument(
                                    Assignment.builder(DOMTag::ariaLabel)
                                        .value("First group")
                                        .build()
                                )
                                .build(),
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
                        .addArgument(FunCall.builder(::classes, INLINE).addArgument(ClassNames.MR_2))
                        .setLambdaArgument(
                            FunCall.builder(RElementBuilder<RProps>::attrs)
                                .setLambdaArgument(
                                    Assignment.builder(DOMTag::ariaLabel)
                                        .value("Second group")
                                        .build()
                                )
                                .build(),
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
                        .addArgument(FunCall.builder(::classes, INLINE).addArgument(ClassNames.MR_2))
                        .setLambdaArgument(
                            FunCall.builder(RElementBuilder<RProps>::attrs)
                                .setLambdaArgument(
                                    Assignment.builder(DOMTag::ariaLabel)
                                        .value("Third group")
                                        .build()
                                )
                                .build(),
                            FunCall.builder(solidSecondaryFun, INLINE)
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
