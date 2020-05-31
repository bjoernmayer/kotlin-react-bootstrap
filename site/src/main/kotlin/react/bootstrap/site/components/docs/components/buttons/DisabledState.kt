package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
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
            Buttons.solid.primary(disabled = true, sizes = Button.Sizes.LG) { +"Primary Button" }
            +" "
            Buttons.solid.secondary(disabled = true, sizes = Button.Sizes.LG) { +"Button" }
        }
        codeExample {
            import("components.button.Button")
            import("components.button.button")
            ln { }
            // todo code example
        }
        Markdown {
            //language=Markdown
            +"""
Disabled buttons using the `<a>` element behave a bit different. That's why their HTML Code looks a bit different.
Usage for you stays the same, though:
            """
        }
        liveExample {
            Buttons.solid.primary(href = "#", disabled = true, sizes = Button.Sizes.LG) { +"Primary Button" }
            +" "
            Buttons.solid.secondary(href = "#", disabled = true, sizes = Button.Sizes.LG) { +"Button" }
        }
        codeExample {
            import("components.button.Button")
            import("components.button.button")
            ln { }
            // todo code example
        }
    }
}
