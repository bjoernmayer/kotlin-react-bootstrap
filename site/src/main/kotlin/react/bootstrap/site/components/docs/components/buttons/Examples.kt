package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.ButtonComponent
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importButtonsBuilder
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.p

internal class Examples : SectionComponent() {
    override val title: String = "Examples"

    override fun RBuilder.render() {
        sectionTitle()
        p {
            +"""
Bootstrap includes several predefined button styles, each serving its own semantic purpose, with a few extras thrown in
for more control.
            """
        }
        liveExample {
            Buttons.solid.danger { +ButtonComponent.Variants.Solid.DANGER::class.normalName }
            +" "
            Buttons.solid.dark { +ButtonComponent.Variants.Solid.DARK::class.normalName }
            +" "
            Buttons.solid.info { +ButtonComponent.Variants.Solid.INFO::class.normalName }
            +" "
            Buttons.solid.light { +ButtonComponent.Variants.Solid.LIGHT::class.normalName }
            +" "
            Buttons.solid.link { +ButtonComponent.Variants.Solid.LINK::class.normalName }
            +" "
            Buttons.solid.primary { +ButtonComponent.Variants.Solid.PRIMARY::class.normalName }
            +" "
            Buttons.solid.secondary { +ButtonComponent.Variants.Solid.SECONDARY::class.normalName }
            +" "
            Buttons.solid.success { +ButtonComponent.Variants.Solid.SUCCESS::class.normalName }
            +" "
            Buttons.solid.warning { +ButtonComponent.Variants.Solid.WARNING::class.normalName }
            +" "
        }

        codeExample {
            +Imports.builder()
                .importButtonsBuilder()
                .build()

            mapOf(
                solidDangerFun to ButtonComponent.Variants.Solid.DANGER,
                solidDarkFun to ButtonComponent.Variants.Solid.DARK,
                solidInfoFun to ButtonComponent.Variants.Solid.INFO,
                solidLightFun to ButtonComponent.Variants.Solid.LIGHT,
                solidLinkFun to ButtonComponent.Variants.Solid.LINK,
                solidPrimaryFun to ButtonComponent.Variants.Solid.PRIMARY,
                solidSecondaryFun to ButtonComponent.Variants.Solid.SECONDARY,
                solidSuccessFun to ButtonComponent.Variants.Solid.SUCCESS,
                solidWarningFun to ButtonComponent.Variants.Solid.WARNING
            ).forEach {
                +FunCall.builder(it.key, FunCall.Style.NEW_INLINE)
                    .nestedBy(RBuilder::Buttons)
                    .nestedBy(ButtonBuilder::solid)
                    .setLambdaArgument(plusString(it.value::class.normalName))
                    .build()
                appendLine(plusString(" "))
            }
        }
    }
}
