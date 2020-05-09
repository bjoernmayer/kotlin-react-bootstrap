package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button.Variants
import react.bootstrap.components.button.button
import react.bootstrap.site.components.docs.components.packageName
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.ln

internal class OutlineButtons : SectionComponent() {
    override val title: String = "Outline buttons"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
                In need of a button, but not the hefty background colors they bring? Use the
                <${Variants.Outline::class.simpleName}|code> variants!
            """.trimIndent()
        }
        example {
            Variants.Outline.all.forEach {
                button(it) { +it::class.normalName }
                +" "
            }
        }
        codeBox {
            ln { +"${packageName}button.Button.${Variants::class.simpleName}" }
            ln { +"${packageName}button.button" }
            ln { }
            Variants.Outline.all.forEach {
                val variant = "${Variants.Outline.nestedName}.${it::class.simpleName}"
                ln { +"button($variant) { +\"${it::class.normalName}\" }" }
                ln { +"+\" \"" }
            }
        }
    }
}
