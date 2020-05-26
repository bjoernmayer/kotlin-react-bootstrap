@file:Suppress("NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.button
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktF
import react.bootstrap.site.components.docs.fixings.ktIF
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.external.Markdown
import react.child
import react.dom.br
import react.functionalComponent
import react.getValue
import react.setValue
import react.useState

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
            button(
                variant = Button.Variants.Solid.PRIMARY,
                sizes = Button.Sizes.LG,
                type = Button.Types.Link("#"),
                active = true
            ) {
                attrs {
                    onClick = { e -> e.preventDefault() }
                }
                +"Primary link"
            }
            +" "
            button(
                variant = Button.Variants.Solid.SECONDARY,
                sizes = Button.Sizes.LG,
                type = Button.Types.Link("#"),
                active = true
            ) {
                attrs {
                    onClick = { e -> e.preventDefault() }
                }
                +"Link"
            }
        }
        codeExample {
            import("components.button.Button")
            import("components.button.button")
            ln { }
            ktIF(
                0,
                RBuilder::button,
                true,
                "variant" to (Button.Variants.Solid.PRIMARY).ktN,
                "sizes" to Button.Sizes.LG.ktN,
                "type" to "${Button.Types.Link::class.nestedName}(\"#\")",
                "active" to true
            ) { "+\"Primary link\"" }
            ln { +"+\" \"" }
            ktIF(
                0,
                RBuilder::button,
                true,
                "variant" to (Button.Variants.Solid.SECONDARY).ktN,
                "sizes" to Button.Sizes.LG.ktN,
                "type" to "${Button.Types.Link::class.nestedName}(\"#\")",
                "active" to true
            ) { "+\"Link\"" }
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
            import("components.button.Button")
            import("components.button.button")
            ln { }
            ktB(0, "private val toggleableButton = functionalComponent<RProps>") {
                ln(it) { +"var active by useState(false)" }
                ln { }
                ktF(
                    it,
                    RBuilder::button,
                    false,
                    "variants" to (Button.Variants.Solid.PRIMARY).ktN,
                    "active" to "active"
                ) {
                    ktF(it, RElementBuilder<*>::attrs) {
                        ln(it) { +"onClick = { active = !active }" }
                    }
                    ktB(it, "if (active)") {
                        ln(it) { +"+\"I am toggled\"" }
                    }
                    ktB(it, "else") {
                        ln(it) { +"+\"Toggle me!\"" }
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
            buttonGroup(ButtonGroup.Behaviours.RADIOS) {
                for (x in 1..3) {
                    Buttons.solid.secondary(x == 1) {
                        attrs {
                            onActive = { console.log("Radio$x") }
                        }
                        +"Radio$x"
                    }
                }
            }
            br { }
            buttonGroup(ButtonGroup.Behaviours.CHECKBOXES) {
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
            import("components.button.ButtonGroup")
            import("components.button.Buttons")
            ln { }
            ktF(0, RBuilder::buttonGroup, ButtonGroup.Behaviours.RADIOS.ktN) {
                for (x in 1..3) {
                    val args = if (x == 1) {
                        "true"
                    } else {
                        ""
                    }
                    ktF(
                        it,
                        buildNestedName(Buttons.solid::secondary.name, RBuilder::Buttons.name, Buttons::solid.name),
                        args
                    ) {
                        ktF(it, RElementBuilder<*>::attrs) {
                            ln(it) { +"onActive = { console.log(\"Radio$x\") }" }
                        }
                    }
                }
            }
            ktIF(0, RBuilder::br, "")
            ktF(0, RBuilder::buttonGroup, ButtonGroup.Behaviours.CHECKBOXES.ktN) {
                for (x in 1..3) {
                    ktF(
                        it,
                        buildNestedName(Buttons.solid::secondary.name, RBuilder::Buttons.name, Buttons::solid.name),
                        ""
                    ) {
                        ktF(it, RElementBuilder<*>::attrs) {
                            ln(it) { +"onActive = { console.log(\"Checkbox$x\") }" }
                        }
                    }
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
