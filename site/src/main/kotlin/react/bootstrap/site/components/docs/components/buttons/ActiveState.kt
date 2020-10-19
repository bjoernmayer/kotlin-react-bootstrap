@file:Suppress("NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.importButton
import react.bootstrap.site.components.docs.importButtonGroup
import react.bootstrap.site.components.docs.importButtonGroupBuilder
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.Assignment
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Generic
import react.bootstrap.site.lib.codepoet.If
import react.bootstrap.site.lib.codepoet.Imports
import react.bootstrap.site.lib.codepoet.LambdaValue
import react.child
import react.dom.br
import react.functionalComponent
import react.getValue
import react.setValue
import react.useState
import kotlin.js.Console

internal class ActiveState : SectionComponent() {
    override val title: String = "Active state"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Buttons will appear pressed (with a darker background, darker border, and inset shadow) when active. __There’s no need
to add a class to `<button>`s as they use a pseudo-class__. However, you can still force the same active appearance by
setting `button(active: Boolean)` to `true` should you need to replicate the state programmatically.
            """
        }
        liveExample {
            Buttons.solid.primary(href = "#", active = true, sizes = Button.Sizes.LG) {
                attrs {
                    onClick = { e -> e.preventDefault() }
                }
                +"Primary link"
            }
            +" "
            Buttons.solid.secondary(href = "#", active = true, sizes = Button.Sizes.LG) {
                attrs {
                    onClick = { e -> e.preventDefault() }
                }
                +"Link"
            }
        }
        codeExample {
            +Imports.builder()
                .importButton()
                .importButtonsBuilder()
                .build()

            +FunCall.builder(solidPrimaryFun)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("href", "#")
                .addArgument("active", true)
                .addArgument("sizes", Button.Sizes.LG)
                .setLambdaArgument(
                    FunCall.builder(RElementBuilder<RProps>::attrs)
                        .setLambdaArgument(
                            Assignment.builder(Button.Props::onClick)
                                .value(
                                    LambdaValue(
                                        "e -> e.preventDefault()",
                                        LambdaValue.Style.INLINE
                                    )
                                )
                                .build()
                        ).build(),
                    plusString("Primary link")
                )
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidSecondaryFun)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("href", "#")
                .addArgument("active", true)
                .addArgument("sizes", Button.Sizes.LG)
                .setLambdaArgument(
                    FunCall.builder(RElementBuilder<RProps>::attrs)
                        .setLambdaArgument(
                            Assignment.builder(Button.Props::onClick)
                                .value(
                                    LambdaValue(
                                        "e -> e.preventDefault()",
                                        LambdaValue.Style.INLINE
                                    )
                                )
                                .build()
                        ).build(),
                    plusString("Link")
                )
                .build()
        }
        subSectionTitle("Toggleable button", section)
        Markdown {
            //language=Markdown
            +"""
Since we are working with react here, implementing a toggleable button is quite easy.
            """
        }
        liveExample {
            child(toggleableButton)
        }
        codeExample {
            +Imports.builder()
                .importButtonsBuilder()
                .build()

            +Assignment.builder("toggleableButton")
                .addModifier("private")
                .valType()
                .value(
                    FunCall.builder(Generic("functionalComponent", "RProps"))
                        .setLambdaArgument(
                            Assignment.builder("active")
                                .varType()
                                .value(
                                    Assignment.FunCallDelegate(
                                        FunCall.builder("useState")
                                            .addArgument(false)
                                    )
                                )
                                .build(),
                            "\n\n",
                            FunCall.builder(solidPrimaryFun)
                                .nestedBy(RBuilder::Buttons)
                                .nestedBy(ButtonBuilder::solid)
                                .addArgument("active", FunCall.Argument.PureValue("active"))
                                .setLambdaArgument(
                                    FunCall.builder(RElementBuilder<RProps>::attrs)
                                        .setLambdaArgument(
                                            Assignment.builder(Button.Props::onClick)
                                                .value(
                                                    LambdaValue(
                                                        "active = !active",
                                                        LambdaValue.Style.INLINE
                                                    )
                                                )
                                                .build()
                                        )
                                        .build(),
                                    If.builder("active")
                                        .setContent(plusString("I am toggled"))
                                        .setElseContent(plusString("Toggle me!"))
                                        .build()

                                )
                                .build()
                        )
                )
                .build()
        }
        subSectionTitle("Radio- and Checkbox Behaviour", section)
        Markdown {
            //language=Markdown
            +"""
When wrapped in a `buttonGroup` a bunch of buttons can behave like radio- or checkboxes.
            """
        }
        liveExample {
            buttonGroup(behaviour = ButtonGroup.Behaviours.RADIOS) {
                for (x in 1..3) {
                    Buttons.solid.secondary(active = x == 1) {
                        attrs {
                            onActive = { console.log("Radio$x") }
                        }
                        +"Radio$x"
                    }
                }
            }
            br { }
            buttonGroup(behaviour = ButtonGroup.Behaviours.CHECKBOXES) {
                for (x in 1..3) {
                    Buttons.solid.secondary {
                        attrs {
                            onActive = { console.log("Checkbox$x") }
                        }
                        +"Checkbox$x"
                    }
                }
            }
        }
        codeExample {
            +Imports.builder()
                .importButtonGroup()
                .importButtonsBuilder()
                .importButtonGroupBuilder()
                .build()

            +FunCall.builder(RBuilder::buttonGroup)
                .addArgument("behaviour", ButtonGroup.Behaviours.RADIOS)
                .setLambdaArgument(
                    buildString {
                        for (x in 1..3) {
                            append(
                                FunCall.builder(solidSecondaryFun)
                                    .nestedBy(RBuilder::Buttons)
                                    .nestedBy(ButtonBuilder::solid)
                                    .apply {
                                        if (x == 1) {
                                            addArgument("active", true)
                                        }
                                    }
                                    .setLambdaArgument(
                                        FunCall.builder(RElementBuilder<RProps>::attrs)
                                            .setLambdaArgument(
                                                Assignment.builder(Button.Props::onActive)
                                                    .value(
                                                        LambdaValue(
                                                            FunCall.builder(Console::log, FunCall.Style.INLINE)
                                                                .nestedBy(::console)
                                                                .addArgument("Radio$x")
                                                                .build()
                                                        )
                                                    )
                                                    .build()
                                            )
                                            .build(),
                                        plusString("Radio$x")
                                    )
                                    .build()
                            )
                        }
                    }
                )
                .build()
            +FunCall.builder(RBuilder::br, FunCall.Style.NEW_INLINE)
                .setEmptyLambdaArgument()
                .build()
            +FunCall.builder(RBuilder::buttonGroup)
                .addArgument("behaviour", ButtonGroup.Behaviours.CHECKBOXES)
                .setLambdaArgument(
                    buildString {
                        for (x in 1..3) {
                            append(
                                FunCall.builder(solidSecondaryFun)
                                    .nestedBy(RBuilder::Buttons)
                                    .nestedBy(ButtonBuilder::solid)
                                    .setLambdaArgument(
                                        FunCall.builder(RElementBuilder<RProps>::attrs)
                                            .setLambdaArgument(
                                                Assignment.builder(Button.Props::onActive)
                                                    .value(
                                                        LambdaValue(
                                                            FunCall.builder(Console::log, FunCall.Style.INLINE)
                                                                .nestedBy(::console)
                                                                .addArgument("Checkbox$x")
                                                                .build()
                                                        )
                                                    )
                                                    .build()
                                            )
                                            .build(),
                                        plusString("Checkbox$x")
                                    )
                                    .build()
                            )
                        }
                    }
                )
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
Or you use actual checkboxes and radios and display them as buttons. If you do not like the looks of a `buttonGroup` you
can set `${ButtonGroup.Props::appearance.name}` to `${ButtonGroup.Appearance.NONE.nestedName}`.
            """
        }
        liveExample {
            buttonGroup(appearance = ButtonGroup.Appearance.NONE) {
                for (x in 1..6) {
                    if (x % 2 == 0) {
                        Buttons.solid.secondary(
                            value = "${x / 2}",
                            title = "Actual Checkbox${x / 2}",
                            name = "checkboxes",
                            type = Button.Types.Input.Type.CHECKBOX
                        ) { }
                        +" "
                    } else {
                        Buttons.solid.secondary(
                            value = "${(x + 1) / 2}",
                            title = "Actual Radio${(x + 1) / 2}",
                            name = "radios",
                            active = x == 1,
                            type = Button.Types.Input.Type.RADIO
                        ) { }
                        +" "
                    }
                }
            }
        }
        codeExample {
            +Imports.builder()
                .importButton()
                .importButtonGroup()
                .importButtonsBuilder()
                .importButtonGroupBuilder()
                .build()

            +FunCall.builder(RBuilder::buttonGroup)
                .addArgument("appearance", ButtonGroup.Appearance.NONE)
                .setLambdaArgument(
                    buildString {
                        for (x in 1..6) {
                            if (x % 2 == 0) {
                                append(
                                    FunCall.builder(solidSecondaryFun, FunCall.Style.INLINE, true)
                                        .nestedBy(RBuilder::Buttons)
                                        .nestedBy(ButtonBuilder::solid)
                                        .addArgument("value", "${x / 2}")
                                        .addArgument("title", "Actual Checkbox${x / 2}")
                                        .addArgument("name", "checkboxes")
                                        .addArgument("type", Button.Types.Input.Type.CHECKBOX)
                                        .setEmptyLambdaArgument()
                                        .build()
                                )
                            } else {
                                append(
                                    FunCall.builder(solidSecondaryFun, FunCall.Style.INLINE, true)
                                        .nestedBy(RBuilder::Buttons)
                                        .nestedBy(ButtonBuilder::solid)
                                        .apply {
                                            if (x == 1) {
                                                addArgument("active", true)
                                            }
                                        }
                                        .addArgument("value", "${(x + 1) / 2}")
                                        .addArgument("title", "Actual Radio${(x + 1) / 2}")
                                        .addArgument("name", "radios")
                                        .addArgument("type", Button.Types.Input.Type.RADIO)
                                        .setEmptyLambdaArgument()
                                        .build()
                                )
                            }
                            if (x < 6) {
                                append("\n")
                                append(plusString(" "))
                                append("\n")
                            }
                        }
                    }
                )
                .build()
        }
    }

    private val toggleableButton = functionalComponent<RProps> {
        var active by useState(false)

        Buttons.solid.primary(active = active) {
            attrs {
                onClick = { active = !active }
            }
            if (active) {
                +"I am toggled"
            } else {
                +"Toggle me!"
            }
        }
    }
}
