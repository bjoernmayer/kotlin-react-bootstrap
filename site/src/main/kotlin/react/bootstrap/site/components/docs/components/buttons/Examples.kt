package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.dom.p

internal class Examples : SectionComponent() {
    override val title: String = "Examples"

    override fun RBuilder.render() {
        sectionTitle(section)
        p {
            +"""
Bootstrap includes several predefined button styles, each serving its own semantic purpose, with a few extras thrown in
for more control.
            """
        }
        liveExample {
            Buttons.solid.danger { +Button.Variants.Solid.DANGER::class.normalName }
            +" "
            Buttons.solid.dark { +Button.Variants.Solid.DARK::class.normalName }
            +" "
            Buttons.solid.info { +Button.Variants.Solid.INFO::class.normalName }
            +" "
            Buttons.solid.light { +Button.Variants.Solid.LIGHT::class.normalName }
            +" "
            Buttons.solid.link { +Button.Variants.Solid.LINK::class.normalName }
            +" "
            Buttons.solid.primary { +Button.Variants.Solid.PRIMARY::class.normalName }
            +" "
            Buttons.solid.secondary { +Button.Variants.Solid.SECONDARY::class.normalName }
            +" "
            Buttons.solid.success { +Button.Variants.Solid.SUCCESS::class.normalName }
            +" "
            Buttons.solid.warning { +Button.Variants.Solid.WARNING::class.normalName }
            +" "
        }
        val parents = listOf(Buttons::class.simpleName!!, Buttons::solid.name)
        codeExample {
            import("components.button.Buttons")
            ln { }
            // todo: code example
        }
    }
}
