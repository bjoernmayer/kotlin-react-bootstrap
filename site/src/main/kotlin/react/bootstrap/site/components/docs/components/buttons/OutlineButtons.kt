package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Button.Variants
import react.bootstrap.components.button.button
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktIB
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
In need of a button, but not the hefty background colors they bring? Use the `${Variants.Outline::class.simpleName}`
variants!
            """
        }
        liveExample {
            Variants.Outline.all.forEach {
                button(it) { +it::class.normalName }
                +" "
            }
        }
        codeExample {
            import("button.Button")
            import("button.button")
            ln { }
            Variants.Outline.all.forEach {
                val variant = buildNestedName(
                    it::class,
                    Button::class,
                    Variants::class,
                    Variants.Outline::class
                )
                ktIB(0, RBuilder::button, variant, "+\"${it::class.normalName}\"")
                ln { +"+\" \"" }
            }
        }
    }
}
