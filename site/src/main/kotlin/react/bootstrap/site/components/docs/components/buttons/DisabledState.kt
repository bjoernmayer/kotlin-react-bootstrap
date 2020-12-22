package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.ButtonComponent
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importButton
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

internal class DisabledState : SectionComponent() {
    override val title: String = "Disabled state"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Make buttons look inactive by setting the `disabled` boolean attribute to any `button { }`.
            """
        }
        liveExample {
            Buttons.solid.primary(disabled = true, sizes = ButtonComponent.Sizes.LG) { +"Primary Button" }
            +" "
            Buttons.solid.secondary(disabled = true, sizes = ButtonComponent.Sizes.LG) { +"Button" }
        }
        codeExample {
            +Imports.builder()
                .importButton()
                .importButtonsBuilder()
                .build()

            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("disabled", true)
                .addArgument("sizes", ButtonComponent.Sizes.LG)
                .setLambdaArgument(plusString("Primary Button"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidSecondaryFun, FunCall.Style.INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("disabled", true)
                .addArgument("sizes", ButtonComponent.Sizes.LG)
                .setLambdaArgument(plusString("Button"))
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
Disabled buttons using the `<a>` element behave a bit different. That's why their HTML Code looks a bit different.
Usage for you stays the same, though:
            """
        }
        liveExample {
            Buttons.solid.primary(href = "#", disabled = true, sizes = ButtonComponent.Sizes.LG) { +"Primary Button" }
            +" "
            Buttons.solid.secondary(href = "#", disabled = true, sizes = ButtonComponent.Sizes.LG) { +"Button" }
        }
        codeExample {
            +Imports.builder()
                .importButton()
                .importButtonsBuilder()
                .build()

            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("disabled", true)
                .addArgument("href", "#")
                .addArgument("sizes", ButtonComponent.Sizes.LG)
                .setLambdaArgument(plusString("Primary Button"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidSecondaryFun, FunCall.Style.INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("disabled", true)
                .addArgument("href", "#")
                .addArgument("sizes", ButtonComponent.Sizes.LG)
                .setLambdaArgument(plusString("Button"))
                .build()
        }
    }
}
