package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.button
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.external.Markdown

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
            ktIB(
                0,
                RBuilder::button,
                true,
                "variant" to (Button.Variants.Solid.PRIMARY).ktN,
                "sizes" to Button.Sizes.LG.ktN,
                "type" to "${Button.Types.Link::class.nestedName}(\"#\")",
                "active" to true
            ) { "+\"Primary link\"" }
            ln { +"+\" \"" }
            ktIB(
                0,
                RBuilder::button,
                true,
                "variant" to (Button.Variants.Solid.SECONDARY).ktN,
                "sizes" to Button.Sizes.LG.ktN,
                "type" to "${Button.Types.Link::class.nestedName}(\"#\")",
                "active" to true
            ) { "+\"Link\"" }
        }
    }
}