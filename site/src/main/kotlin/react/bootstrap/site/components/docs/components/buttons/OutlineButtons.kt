package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
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
            import("button.Button")
            import("button.button")
            ln { }
            // todo code example
        }
    }
}
