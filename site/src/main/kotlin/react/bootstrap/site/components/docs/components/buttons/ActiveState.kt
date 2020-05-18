@file:Suppress("NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.RProps
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.button
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
import react.functionalComponent
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
                ln(it) { +"val (active, setActive) = useState(false)" }
                ln { }
                ktF(
                    it,
                    RBuilder::button,
                    false,
                    "variants" to (Button.Variants.Solid.PRIMARY).ktN,
                    "active" to "active"
                ) {
                    ktB(it, "attrs") {
                        ln(it) { +"onClick = { setActive(!active) }" }
                    }
                    ln(it) { +"+\"Single toggle\"" }
                }
            }
        }
    }

    private val toggleableButton = functionalComponent<RProps> {
        val (active, setActive) = useState(false)

        button(variant = Button.Variants.Solid.PRIMARY, active = active) {
            attrs {
                onClick = { setActive(!active) }
            }
            +"Single toggle"
        }
    }
}
