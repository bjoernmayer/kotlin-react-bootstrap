package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown

internal class OutlineButtons : SectionComponent() {
    override val title: String = "Outline buttons"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
In need of a button, but not the hefty background colors they bring? Use the
`${Button.Variants.Outline::class.nestedName}` variants!
            """
        }
        liveExample {
            Buttons.outline.danger { +Button.Variants.Outline.DANGER::class.normalName }
            +" "
            Buttons.outline.dark { +Button.Variants.Outline.DARK::class.normalName }
            +" "
            Buttons.outline.info { +Button.Variants.Outline.INFO::class.normalName }
            +" "
            Buttons.outline.light { +Button.Variants.Outline.LIGHT::class.normalName }
            +" "
            Buttons.outline.primary { +Button.Variants.Outline.PRIMARY::class.normalName }
            +" "
            Buttons.outline.secondary { +Button.Variants.Outline.SECONDARY::class.normalName }
            +" "
            Buttons.outline.success { +Button.Variants.Outline.SUCCESS::class.normalName }
            +" "
            Buttons.outline.warning { +Button.Variants.Outline.WARNING::class.normalName }
            +" "
        }

        codeExample {
            importButtonsBuilder()
            ln { }
            mapOf(
                outlineDangerFun to Button.Variants.Outline.DANGER,
                outlineDarkFun to Button.Variants.Outline.DARK,
                outlineInfoFun to Button.Variants.Outline.INFO,
                outlineLightFun to Button.Variants.Outline.LIGHT,
                outlinePrimaryFun to Button.Variants.Outline.PRIMARY,
                outlineSecondaryFun to Button.Variants.Outline.SECONDARY,
                outlineSuccessFun to Button.Variants.Outline.SUCCESS,
                outlineWarningFun to Button.Variants.Outline.WARNING
            ).forEach {
                ktFun(it.key, outlineButtonBuilderParents, style = FunStyle.INLINE_BLOCK) {
                    string(it.value::class.normalName)
                }
                ln(" ")
            }
        }
    }
}
