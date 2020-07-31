@file:Suppress("NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.components.importButtonGroup
import react.bootstrap.site.components.docs.components.importButtonGroupBuilder
import react.bootstrap.site.components.docs.components.importButtonsBuilder
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.Quoted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
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
            importButton()
            importButtonsBuilder()
            ln { }
            ktFun(
                solidPrimaryFun,
                parents = solidButtonBuilderParents,
                style = FunStyle.BLOCK,
                args = mapOf("href" to Quoted("#"), "active" to true, "sizes" to Button.Sizes.LG.ktN)
            ) {
                ktFun(RElementBuilder<RProps>::attrs) {
                    ln {
                        +"onClick = { e -> e.preventDefault() }"
                    }
                }
                ln("Primary link")
            }
            ln(" ")
            ktFun(
                solidSecondaryFun,
                parents = solidButtonBuilderParents,
                style = FunStyle.BLOCK,
                args = mapOf("href" to Quoted("#"), "active" to true, "sizes" to Button.Sizes.LG.ktN)
            ) {
                ktFun(RElementBuilder<RProps>::attrs) {
                    ln {
                        +"onClick = { e -> e.preventDefault() }"
                    }
                }
                ln("Link")
            }
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
            importButtonsBuilder()
            ln { }
            ktBlock("private val toggleableButton = functionalComponent<RProps> {") {
                ln {
                    +"var active by useState(false)"
                }
                ln { }
                ktFun(
                    solidPrimaryFun,
                    parents = solidButtonBuilderParents,
                    args = mapOf("active" to "active")
                ) {
                    ktFun(RElementBuilder<RProps>::attrs) {
                        ln { +"onClick = { active = !active }" }
                    }
                    ktBlock("if (active)") {
                        ln("I am toggled")
                    }
                    ktBlock("else") {
                        ln("Toggle me!")
                    }
                }
            }
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
            importButtonGroup()
            importButtonsBuilder()
            importButtonGroupBuilder()
            ln { }
            ktFun(RBuilder::buttonGroup, args = mapOf("behaviour" to ButtonGroup.Behaviours.RADIOS.ktN)) {
                for (x in 1..3) {
                    val args = if (x == 1) {
                        mapOf<String?, Any>("active" to true)
                    } else {
                        emptyMap()
                    }
                    ktFun(solidSecondaryFun, solidButtonBuilderParents, args = args) {
                        ktFun(RElementBuilder<RProps>::attrs) {
                            ktBlock("${Button.Props::onActive.name} =") {
                                ktFun(
                                    Console::log,
                                    listOf("console"),
                                    style = FunStyle.INLINE,
                                    args = mapOf(
                                        null to Quoted(
                                            "Radio$x"
                                        )
                                    )
                                )
                            }
                        }
                        ln("Radio$x")
                    }
                }
            }
            ktFun(RBuilder::br, style = FunStyle.INLINE_BLOCK) { }
            ktFun(RBuilder::buttonGroup, args = mapOf("behaviour" to ButtonGroup.Behaviours.CHECKBOXES.ktN)) {
                for (x in 1..3) {
                    ktFun(solidSecondaryFun, solidButtonBuilderParents) {
                        ktFun(RElementBuilder<RProps>::attrs) {
                            ktBlock("${Button.Props::onActive.name} =") {
                                ktFun(
                                    Console::log,
                                    listOf("console"),
                                    style = FunStyle.INLINE,
                                    args = mapOf(
                                        null to Quoted(
                                            "Checkbox$x"
                                        )
                                    )
                                )
                            }
                        }
                        ln("Checkbox$x")
                    }
                }
            }
        }
        Markdown {
            //language=Markdown
            +"""
Or you use actual checkboxes and radios and display them as buttons. If you do not like the looks of a `buttonGroup` you
can set `${ButtonGroup.Props::appearance.name}` to `${ButtonGroup.Appearance.NONE.ktN}`.
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
            importButton()
            importButtonGroup()
            importButtonsBuilder()
            importButtonGroupBuilder()
            ln { }
            ktFun(RBuilder::buttonGroup, args = mapOf("appearance" to ButtonGroup.Appearance.NONE.ktN)) {
                for (x in 1..6) {
                    if (x % 2 == 0) {
                        ktFun(
                            solidSecondaryFun,
                            solidButtonBuilderParents,
                            breakDownArgs = true,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(
                                "value" to Quoted("${x / 2}"),
                                "title" to Quoted("Actual Checkbox${x / 2}"),
                                "name" to Quoted("checkboxes"),
                                "type" to Button.Types.Input.Type.CHECKBOX.ktN
                            )
                        ) { }
                    } else {
                        ktFun(
                            solidSecondaryFun,
                            solidButtonBuilderParents,
                            breakDownArgs = true,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf<String?, Any>(
                                "value" to Quoted("${(x + 1) / 2}"),
                                "title" to Quoted("Actual Radio${(x + 1) / 2}"),
                                "name" to Quoted("radios"),
                                "type" to Button.Types.Input.Type.RADIO.ktN
                            ).run {
                                if (x == 1) {
                                    val map = toMutableMap()
                                    map["active"] = true
                                    map
                                } else {
                                    this
                                }
                            }
                        ) { }
                    }
                    ln(" ")
                }
            }
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
