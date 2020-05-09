package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonType
import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Button.Types.Input
import react.bootstrap.components.button.Button.Types.Link
import react.bootstrap.components.button.Button.Variants
import react.bootstrap.components.button.button
import react.bootstrap.site.components.docs.components.packageName
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.ln

internal class ButtonTags : SectionComponent() {
    override val title: String = "Button tags"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText('[', ']') {
            """
                This library's [button|code] component is designed to be used with the HTML [button|code] element.
                However, you can also use these classes on [a|code] or [input|code] elements (though some browsers may
                apply a slightly different rendering).
            """.trimIndent()
        }
        example {
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
        codeBox {
            ln { +"${packageName}button.Button.${Button.Types::class.simpleName}.${Input::class.simpleName}" }
            ln { +"${packageName}button.Button.${Button.Types::class.simpleName}.${Link::class.simpleName}" }
            ln { +"${packageName}button.Button.${Variants::class.simpleName}" }
            ln { +"${packageName}button.button" }
            ln { }
            val prim = "${Variants.Solid.nestedName}.${Variants.Solid.Companion::PRIMARY.name}"
            val link = Link::class.simpleName!!
            val input = Input::class.simpleName!!
            ln { +"button(variant = $prim, type = $link(href = \"#\")) { +\"Link\" }" }
            ln { +"+\" \"" }
            ln { +"button(variant = $prim, type = ButtonType.submit) { +\"Button\" }" }
            ln { +"+\" \"" }
            ln { +"button(variant = $prim, type = $input($input.${Input.Type.BUTTON.kt}, value = \"Input\")) { }" }
            ln { +"+\" \"" }
            ln { +"button(variant = $prim, type = $input($input.${Input.Type.SUBMIT.kt}, value = \"Submit\")) { }" }
            ln { +"+\" \"" }
            ln { +"button(variant = $prim, type = $input($input.${Input.Type.RESET.kt}, value = \"Reset\")) { }" }
        }
    }
}
