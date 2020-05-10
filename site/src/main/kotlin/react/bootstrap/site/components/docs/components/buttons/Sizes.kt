package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button.Sizes
import react.bootstrap.components.button.Button.Variants
import react.bootstrap.components.button.button
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.external.Markdown

internal class Sizes : SectionComponent() {
    override val title: String = "Sizes"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Fancy larger or smaller buttons? Set `button(sizes: ${Sizes::class.simpleName}?)` to `${Sizes.LG.kt}` or
`${Sizes.SM.kt}`.
            """
        }
        liveExample {
            button(variant = Variants.Solid.PRIMARY, sizes = Sizes.LG) { +"Large button" }
            +" "
            button(variant = Variants.Solid.SECONDARY, sizes = Sizes.LG) { +"Large button" }
        }
        codeExample {
            import("components.button.Button")
            import("components.button.button")
            ln { }
            ktIB(
                0,
                "button",
                "variant" to (Variants.Solid.PRIMARY).kt,
                "sizes" to Sizes.LG.kt
            ) { "+\"Large button\"" }
            ln { +"+\" \"" }
            ktIB(
                0,
                "button",
                "variant" to (Variants.Solid.SECONDARY).kt,
                "sizes" to Sizes.LG.kt
            ) { "+\"Large button\"" }
        }
        liveExample {
            button(variant = Variants.Solid.PRIMARY, sizes = Sizes.SM) { +"Small button" }
            +" "
            button(variant = Variants.Solid.SECONDARY, sizes = Sizes.SM) { +"Small button" }
        }
        codeExample {
            import("components.button.Button")
            import("components.button.button")
            ln { }
            ktIB(
                0,
                "button",
                "variant" to (Variants.Solid.PRIMARY).kt,
                "sizes" to Sizes.SM.kt
            ) { "+\"Small button\"" }
            ln { +"+\" \"" }
            ktIB(
                0,
                "button",
                "variant" to (Variants.Solid.SECONDARY).kt,
                "sizes" to Sizes.SM.kt
            ) { "+\"Small button\"" }
        }
    }
}
