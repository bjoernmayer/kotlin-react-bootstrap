package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.ButtonComponent
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

internal class OutlineButtons : SectionComponent() {
    override val title: String = "Outline buttons"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
In need of a button, but not the hefty background colors they bring? Use the
`${ButtonComponent.Variants.Outline::class.nestedName}` variants!
            """
        }
        liveExample {
            Buttons.outline.danger { +ButtonComponent.Variants.Outline.DANGER::class.normalName }
            +" "
            Buttons.outline.dark { +ButtonComponent.Variants.Outline.DARK::class.normalName }
            +" "
            Buttons.outline.info { +ButtonComponent.Variants.Outline.INFO::class.normalName }
            +" "
            Buttons.outline.light { +ButtonComponent.Variants.Outline.LIGHT::class.normalName }
            +" "
            Buttons.outline.primary { +ButtonComponent.Variants.Outline.PRIMARY::class.normalName }
            +" "
            Buttons.outline.secondary { +ButtonComponent.Variants.Outline.SECONDARY::class.normalName }
            +" "
            Buttons.outline.success { +ButtonComponent.Variants.Outline.SUCCESS::class.normalName }
            +" "
            Buttons.outline.warning { +ButtonComponent.Variants.Outline.WARNING::class.normalName }
            +" "
        }

        codeExample {
            +Imports.builder()
                .importButtonsBuilder()
                .build()

            mapOf(
                outlineDangerFun to ButtonComponent.Variants.Outline.DANGER,
                outlineDarkFun to ButtonComponent.Variants.Outline.DARK,
                outlineInfoFun to ButtonComponent.Variants.Outline.INFO,
                outlineLightFun to ButtonComponent.Variants.Outline.LIGHT,
                outlinePrimaryFun to ButtonComponent.Variants.Outline.PRIMARY,
                outlineSecondaryFun to ButtonComponent.Variants.Outline.SECONDARY,
                outlineSuccessFun to ButtonComponent.Variants.Outline.SUCCESS,
                outlineWarningFun to ButtonComponent.Variants.Outline.WARNING
            ).forEach {
                +FunCall.builder(it.key, FunCall.Style.NEW_INLINE)
                    .nestedBy(RBuilder::Buttons)
                    .nestedBy(ButtonBuilder::outline)
                    .setLambdaArgument(plusString(it.value::class.normalName))
                    .build()
                appendLine(plusString(" "))
            }
        }
    }
}
