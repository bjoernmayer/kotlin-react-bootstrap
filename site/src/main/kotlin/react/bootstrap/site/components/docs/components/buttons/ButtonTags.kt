package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonType
import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.button
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktIF
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.kt
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
            button(
                variant = Button.Variants.Solid.PRIMARY,
                type = Button.Types.Link(href = "#")
            ) { +"Link" }
            +" "
            button(
                variant = Button.Variants.Solid.PRIMARY,
                type = Button.Types.Button(type = ButtonType.submit)
            ) { +"Button" }
            +" "
            button(
                variant = Button.Variants.Solid.PRIMARY,
                type = Button.Types.Input(Button.Types.Input.Type.BUTTON, value = "Input")
            ) { }
            +" "
            button(
                variant = Button.Variants.Solid.PRIMARY,
                type = Button.Types.Input(Button.Types.Input.Type.SUBMIT, value = "Submit")
            ) { }
            +" "
            button(
                variant = Button.Variants.Solid.PRIMARY,
                type = Button.Types.Input(Button.Types.Input.Type.RESET, value = "Reset")
            ) { }
        }
        codeExample {
            import("button.Button")
            import("button.Button.button")
            ln { }
            val prim = (Button.Variants.Solid.PRIMARY).ktN
            val link = Button.Types.Link::class.nestedName
            val input = Button.Types.Input::class.nestedName
            val button = Button.Types.Button::class.nestedName

            ktIF(
                0,
                RBuilder::button,
                true,
                "variant" to prim,
                "type" to "$link(href = \"#\")"
            ) { "+\"Link\"" }
            ln { +"+\" \"" }

            ktIF(
                0,
                RBuilder::button,
                true,
                "variant" to prim,
                "type" to "$button(type = ${ButtonType.submit.kt})"
            ) { "+\"Button\"" }
            ln { +"+\" \"" }

            ktIF(
                0,
                RBuilder::button,
                true,
                "variant" to prim,
                "type" to "$input(${Button.Types.Input.Type.BUTTON.ktN}, value = \"Input\")"
            ) { "" }
            ln { +"+\" \"" }

            ktIF(
                0,
                RBuilder::button,
                true,
                "variant" to prim,
                "type" to "$input(${Button.Types.Input.Type.SUBMIT.ktN}, value = \"Submit\")"
            ) { "" }
            ln { +"+\" \"" }

            ktIF(
                0,
                RBuilder::button,
                true,
                "variant" to prim,
                "type" to "$input(${Button.Types.Input.Type.RESET.ktN}, value = \"Reset\")"
            ) { "" }
        }
    }
}
