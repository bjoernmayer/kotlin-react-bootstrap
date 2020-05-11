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

internal class DisabledState : SectionComponent() {
    override val title: String = "Disabled state"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Make buttons look inactive by setting the `disabled` boolean attribute to any `button { }`.
            """
        }
        liveExample {
            button(
                variant = Button.Variants.Solid.PRIMARY,
                sizes = Button.Sizes.LG,
                disabled = true
            ) { +"Primary button" }
            +" "
            button(
                variant = Button.Variants.Solid.SECONDARY,
                sizes = Button.Sizes.LG,
                disabled = true
            ) { +"Button" }
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
                "disabled" to true
            ) { "+\"Primary button\"" }
            ln { +"+\" \"" }

            ktIB(
                0,
                RBuilder::button,
                true,
                "variant" to (Button.Variants.Solid.SECONDARY).ktN,
                "sizes" to Button.Sizes.LG.ktN,
                "disabled" to true
            ) { "+\"Button\"" }
        }
        Markdown {
            //language=Markdown
            +"""
Disabled buttons using the `<a>` element behave a bit different. That's why their HTML Code looks a bit different.
Usage for you stays the same, though:
            """
        }
        liveExample {
            button(
                variant = Button.Variants.Solid.PRIMARY,
                sizes = Button.Sizes.LG,
                type = Button.Types.Link("#"),
                disabled = true
            ) { +"Primary button" }
            +" "
            button(
                variant = Button.Variants.Solid.SECONDARY,
                sizes = Button.Sizes.LG,
                type = Button.Types.Link("#"),
                disabled = true
            ) { +"Button" }
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
                "disabled" to true
            ) { "+\"Primary button\"" }
            ln { +"+\" \"" }

            ktIB(
                0,
                RBuilder::button,
                true,
                "variant" to (Button.Variants.Solid.SECONDARY).ktN,
                "sizes" to Button.Sizes.LG.ktN,
                "type" to "${Button.Types.Link::class.nestedName}(\"#\")",
                "disabled" to true
            ) { "+\"Button\"" }
        }
    }
}
