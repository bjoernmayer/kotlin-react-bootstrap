package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonType
import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importButton
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

internal class ButtonTags : SectionComponent() {
    override val title: String = "Button tags"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
This library's `button` component is designed to be used with the HTML `button` element. However, you can also use these
classes on `a` or `input` elements (though some browsers may apply a slightly different rendering).
__Keep in mind, that the `input` element cannot have child elements.__
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
            Buttons.solid.primary(value = "true", title = "Checkbox", type = Button.Types.Input.Type.CHECKBOX) { }
            +" "
            Buttons.solid.primary(value = "true", title = "Radio", type = Button.Types.Input.Type.RADIO) { }
        }
        codeExample {
            +Imports.builder()
                .importButton()
                .importButtonsBuilder()
                .build()

            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("href", "#")
                .setLambdaArgument(plusString("Link"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("buttonType", ButtonType.submit)
                .setLambdaArgument(plusString("Button"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("value", "Input")
                .setLambdaArgument(plusString("Input"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("value", "Submit")
                .addArgument("type", Button.Types.Input.Type.SUBMIT)
                .setEmptyLambdaArgument()
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("value", "Reset")
                .addArgument("type", Button.Types.Input.Type.RESET)
                .setEmptyLambdaArgument()
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("value", "true")
                .addArgument("title", "Checkbox")
                .addArgument("type", Button.Types.Input.Type.CHECKBOX)
                .setEmptyLambdaArgument()
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("value", "true")
                .addArgument("title", "Radio")
                .addArgument("type", Button.Types.Input.Type.RADIO)
                .setEmptyLambdaArgument()
                .build()
        }
    }
}
