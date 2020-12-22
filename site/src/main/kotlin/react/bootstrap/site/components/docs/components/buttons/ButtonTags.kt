package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonType
import kotlinx.html.SPAN
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.bootstrap.components.alert.Alerts
import react.bootstrap.components.alert.h5
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.ButtonComponent
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importButton
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

internal class ButtonTags : SectionComponent() {
    override val title: String = "Button tags"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
This library's `button` component is designed to be used with the HTML `button` element. However, you can also use these
classes on `a` or `input` elements (though some browsers may apply a slightly different rendering).
            """
        }
        Alerts.info {
            h5<SPAN> { +"Child elements" }
            Markdown {
                //language=Markdown
                +"""
Keep in mind: Buttons based on `${ButtonComponent.Input.Type.BUTTON.nestedName}`,
`${ButtonComponent.Input.Type.SUBMIT.nestedName}` and `${ButtonComponent.Input.Type.RESET}` cannot have child elements.
                """
            }
        }
        Alerts.warning {
            h5<SPAN> { +"onClickFunction" }
            Markdown {
                //language=Markdown
                +"""
For buttons based on `${ButtonComponent.Box.Type.CHECKBOX}` and `${ButtonComponent.Box.Type.RADIO}` you should not bind
the `onClick` event on the wrapping label.
[Otherwise the event will be triggered twice](https://stackoverflow.com/a/50819392).
                """
            }
        }
        liveExample {
            Buttons.solid.primary(href = "#") { attrs { onClickFunction = { it.preventDefault() } }; +"Link" }
            +" "
            Buttons.solid.primary(type = ButtonType.submit) { +"Button" }
            +" "
            Buttons.solid.primary(type = ButtonComponent.Input.Type.SUBMIT, value = "Submit") { }
            +" "
            Buttons.solid.primary(type = ButtonComponent.Input.Type.RESET, value = "Reset") { }
            +" "
            Buttons.solid.primary(type = ButtonComponent.Input.Type.BUTTON, value = "Input Button") { }
            +" "
            Buttons.solid.primary(type = ButtonComponent.Box.Type.CHECKBOX) { +"Checkbox" }
            +" "
            Buttons.solid.primary(type = ButtonComponent.Box.Type.RADIO) { +"Radio" }
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
                .addArgument("type", ButtonType.submit)
                .setLambdaArgument(plusString("Button"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("type", ButtonComponent.Input.Type.SUBMIT)
                .addArgument("value", "Submit")
                .setEmptyLambdaArgument()
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("type", ButtonComponent.Input.Type.RESET)
                .addArgument("value", "Reset")
                .setEmptyLambdaArgument()
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("type", ButtonComponent.Input.Type.BUTTON)
                .addArgument("value", "Input Button")
                .setEmptyLambdaArgument()
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("type", ButtonComponent.Box.Type.CHECKBOX)
                .setLambdaArgument(plusString("Checkbox"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidPrimaryFun, FunCall.Style.INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("type", ButtonComponent.Box.Type.RADIO)
                .setLambdaArgument(plusString("Radio"))
                .build()
        }
    }
}
