package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonType
import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.FunctionCallCodeBuilder
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.components.importButtonsBuilder
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.Quoted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
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
            importButton()
            importButtonsBuilder()
            ln { }
            +FunctionCallCodeBuilder()
                .function(solidPrimaryFun)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .arg("href", "#")
                .lambdaCalls {
                    plusString("Link")
                }
                .inline()
                .build()
            ktFun(
                solidPrimaryFun,
                solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf(
                    "href" to Quoted("#")
                )
            ) {
                string("Link")
            }
            ln(" ")
            ktFun(
                solidPrimaryFun,
                solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf(
                    "buttonType" to buildNestedName(ButtonType.submit.name, ButtonType::class.simpleName!!)
                )
            ) {
                string("Button")
            }
            ln(" ")
            ktFun(
                solidPrimaryFun,
                solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf(
                    "value" to Quoted("Input")
                )
            ) {
                string("Input")
            }
            ln(" ")
            ktFun(
                solidPrimaryFun,
                solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf(
                    "value" to Quoted("Submit"),
                    "type" to Button.Types.Input.Type.SUBMIT.ktN
                )
            )
            ln(" ")
            ktFun(
                solidPrimaryFun,
                solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf(
                    "value" to Quoted("Reset"),
                    "type" to Button.Types.Input.Type.RESET.ktN
                )
            )
            ln(" ")
            ktFun(
                solidPrimaryFun,
                solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf(
                    "value" to Quoted("true"),
                    "title" to Quoted("Checkbox"),
                    "type" to Button.Types.Input.Type.CHECKBOX.ktN
                )
            )
            ln(" ")
            ktFun(
                solidPrimaryFun,
                solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf(
                    "value" to Quoted("true"),
                    "title" to Quoted("Radio"),
                    "type" to Button.Types.Input.Type.RADIO.ktN
                )
            )
        }
    }
}
