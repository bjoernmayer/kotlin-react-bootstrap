package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button.Variants
import react.bootstrap.components.button.button
import react.bootstrap.site.components.docs.components.packageName
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.ln
import react.dom.p
import react.bootstrap.components.button.Button.Variants.Solid.Companion as SolidVariant

internal class Examples : SectionComponent() {
    override val title: String = "Examples"

    override fun RBuilder.render() {
        sectionTitle(section)
        p {
            +"""
                Bootstrap includes several predefined button styles, each serving its own semantic purpose, with a few
                extras thrown in for more control.
            """.trimIndent()
        }
        example {
            SolidVariant.all.forEach {
                button(it) { +it::class.normalName }
                +" "
            }
        }
        codeBox {
            ln { +"${packageName}button.Button.${Variants::class.simpleName}" }
            ln { +"${packageName}button.button" }
            ln { }
            SolidVariant.all.forEach {
                val variant = "${Variants.Solid.nestedName}.${it::class.simpleName}"
                ln { +"button($variant) { +\"${it::class.normalName}\" }" }
                ln { +"+\" \"" }
            }
        }
    }
}
