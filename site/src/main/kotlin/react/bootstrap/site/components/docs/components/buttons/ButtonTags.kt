package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonType
import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Button.Types.Input
import react.bootstrap.components.button.Button.Types.Link
import react.bootstrap.components.button.Button.Variants
import react.bootstrap.components.button.button
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktIB
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
classes on `a` or `input` elements (though some browsers may apply a slightly different rendering).
            """
        }
        liveExample {
            button(variant = Variants.Solid.PRIMARY, type = Link(href = "#")) { +"Link" }
            +" "
            button(variant = Variants.Solid.PRIMARY, type = ButtonType.submit) { +"Button" }
            +" "
            button(variant = Variants.Solid.PRIMARY, type = Input(Input.Type.BUTTON, value = "Input")) { }
            +" "
            button(variant = Variants.Solid.PRIMARY, type = Input(Input.Type.SUBMIT, value = "Submit")) { }
            +" "
            button(variant = Variants.Solid.PRIMARY, type = Input(Input.Type.RESET, value = "Reset")) { }
        }
        codeExample {
            import("button.Button.${Button.Types::class.simpleName}.${Input::class.simpleName}")
            import("button.Button.${Button.Types::class.simpleName}.${Link::class.simpleName}")
            import("button.Button.${Variants::class.simpleName}")
            import("button.Button.button")
            ln { }
            val prim = "${Variants.Solid.nestedName}.${Variants.Solid.Companion::PRIMARY.name}"
            val link = Link::class.simpleName!!
            val input = Input::class.simpleName!!
            ktIB(0, "button", "variant" to prim, "type" to "$link(href = \"#\")") { "+\"Link\"" }
            ln { +"+\" \"" }
            ktIB(0, "button", "variant" to prim, "type" to ButtonType.submit.kt) { "+\"Button\"" }
            ln { +"+\" \"" }
            ktIB(
                0,
                "button",
                "variant" to prim,
                "type" to "$input($input.${Input.Type.BUTTON.kt}, value = \"Input\")"
            ) { "" }
            ln { +"+\" \"" }
            ktIB(
                0,
                "button",
                "variant" to prim,
                "type" to "$input($input.${Input.Type.SUBMIT.kt}, value = \"Submit\")"
            ) { "" }
            ln { +"+\" \"" }
            ktIB(
                0,
                "button",
                "variant" to prim,
                "type" to "$input($input.${Input.Type.RESET.kt}, value = \"Reset\")"
            ) { "" }
        }
    }
}
