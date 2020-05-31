package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonType
import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.external.Markdown

internal class ButtonTags : SectionComponent() {
    override val title: String = "Button tags"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
This library's `button` component is designed to be used with the HTML `button` element. However, you can also use these
classes on `a` or `input` elements (though some browsers may apply a slightly different rendering). __Keep in mind, that
the `input` element cannot have child elements.__
            """
        }
        liveExample {
            Buttons.solid.primary(href = "#") { +"Link" }
            +" "
            Buttons.solid.primary(buttonType = ButtonType.submit) { +"Button" }
            +" "
            Buttons.solid.primary(value = "Input") { +"Input" }
            +" "
            Buttons.solid.primary(value = "Submit", type = Button.Types.Input.Type.SUBMIT) { }
            +" "
            Buttons.solid.primary(value = "Reset", type = Button.Types.Input.Type.RESET) { }
            +" "
            Buttons.solid.primary(value = "true", title="Checkbox", type = Button.Types.Input.Type.CHECKBOX) { }
            +" "
            Buttons.solid.primary(value = "true", title="Radio", type = Button.Types.Input.Type.RADIO) { }
        }
        codeExample {
            import("button.Button")
            import("button.Button.button")
            ln { }

           // todo add code example
        }
    }
}
