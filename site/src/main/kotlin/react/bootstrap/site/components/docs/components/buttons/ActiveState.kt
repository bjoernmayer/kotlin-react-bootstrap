@file:Suppress("NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
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
            import("components.button.Button")
            import("components.button.button")
            ln { }
            // todo code eample
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
                // todo code example
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
                    Buttons.solid.secondary(active = x == 1) {
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
                    // todo replace "secondary" with reference (needs explicit type)
                    ktF(
                        it,
                        buildNestedName("secondary", RBuilder::Buttons.name, Buttons::solid.name),
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
                        buildNestedName("secondary", RBuilder::Buttons.name, Buttons::solid.name),
                        ""
                    ) {
                        ktF(it, RElementBuilder<*>::attrs) {
                            ln(it) { +"onActive = { console.log(\"Checkbox$x\") }" }
                        }
                    }
                }
            }
        }
        Markdown {
            //language=Markdown
            +"""
Or you use actual checkboxes and radios and display them as buttons. If you do not like the looks of a `buttonGroup` you
can set `${ButtonGroup.Props::renderAsGroup.name}` to `false`.
            """
        }
        liveExample {
            buttonGroup(renderAsGroup = false) {
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
                            value = "${(x+1) / 2}",
                            title = "Actual Radio${(x+1) / 2}",
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
            import("components.button.ButtonGroup")
            import("components.button.Buttons")
            ln { }
            // todo code example
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
