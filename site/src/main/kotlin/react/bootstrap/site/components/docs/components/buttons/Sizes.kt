package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button.Sizes
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.importButton
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

internal class Sizes : SectionComponent() {
    override val title: String = "Sizes"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Fancy larger or smaller buttons? Set `button(sizes: ${Sizes::class.simpleName}?)` to `${Sizes.LG.nestedName}` or
`${Sizes.SM.nestedName}`.
            """
        }
        liveExample {
            Buttons.solid.primary(sizes = Sizes.LG) { +"Large button" }
            +" "
            Buttons.solid.secondary(sizes = Sizes.LG) { +"Large button" }
        }
        codeExample {
            +Imports.builder()
                .importButton()
                .importButtonsBuilder()
                .build()

            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("sizes", Sizes.LG)
                .setLambdaArgument(plusString("Large button"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidSecondaryFun, FunCall.Style.INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("sizes", Sizes.LG)
                .setLambdaArgument(plusString("Large button"))
                .build()
        }
        liveExample {
            Buttons.solid.primary(sizes = Sizes.SM) { +"Small button" }
            +" "
            Buttons.solid.secondary(sizes = Sizes.SM) { +"Small button" }
        }
        codeExample {
            +Imports.builder()
                .importButton()
                .importButtonsBuilder()
                .build()

            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("sizes", Sizes.SM)
                .setLambdaArgument(plusString("Small button"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidSecondaryFun, FunCall.Style.INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("sizes", Sizes.SM)
                .setLambdaArgument(plusString("Small button"))
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
Create block level buttons—those that span the full width of a parent—by adding setting `button(blocksized: Boolean)` to
`true`.
            """
        }
        liveExample {
            Buttons.solid.primary(sizes = Sizes.LG, blockSized = true) { +"Block level button" }
            +" "
            Buttons.solid.secondary(sizes = Sizes.LG, blockSized = true) { +"Block level button" }
        }
        codeExample {
            +Imports.builder()
                .importButton()
                .importButtonsBuilder()
                .build()

            +FunCall.builder(solidPrimaryFun, FunCall.Style.NEW_INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("sizes", Sizes.LG)
                .addArgument("blockSized", true)
                .setLambdaArgument(plusString("Block level button"))
                .build()
            appendLine(plusString(" "))
            +FunCall.builder(solidSecondaryFun, FunCall.Style.INLINE)
                .nestedBy(RBuilder::Buttons)
                .nestedBy(ButtonBuilder::solid)
                .addArgument("sizes", Sizes.LG)
                .addArgument("blockSized", true)
                .setLambdaArgument(plusString("Block level button"))
                .build()
        }
    }
}
