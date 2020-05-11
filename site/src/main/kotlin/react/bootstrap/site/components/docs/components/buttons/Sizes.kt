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
Fancy larger or smaller buttons? Set `button(sizes: ${Sizes::class.simpleName}?)` to `${Sizes.LG.ktN}` or
`${Sizes.SM.ktN}`.
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
                RBuilder::button,
                "variant" to (Variants.Solid.PRIMARY).ktN,
                "sizes" to Sizes.LG.ktN
            ) { "+\"Large button\"" }
            ln { +"+\" \"" }
            ktIB(
                0,
                RBuilder::button,
                "variant" to (Variants.Solid.SECONDARY).ktN,
                "sizes" to Sizes.LG.ktN
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
                RBuilder::button,
                "variant" to (Variants.Solid.PRIMARY).ktN,
                "sizes" to Sizes.SM.ktN
            ) { "+\"Small button\"" }
            ln { +"+\" \"" }
            ktIB(
                0,
                RBuilder::button,
                "variant" to (Variants.Solid.SECONDARY).ktN,
                "sizes" to Sizes.SM.ktN
            ) { "+\"Small button\"" }
        }
        Markdown {
            //language=Markdown
            +"""
Create block level buttons—those that span the full width of a parent—by adding setting `button(blocksized: Boolean)` to
`true`.
            """
        }
        liveExample {
            button(variant = Variants.Solid.PRIMARY, sizes = Sizes.LG, blockSized = true) { +"Block level button" }
            +" "
            button(variant = Variants.Solid.SECONDARY, sizes = Sizes.LG, blockSized = true) { +"Block level button" }
        }
        codeExample {
            import("components.button.Button")
            import("components.button.button")
            ln { }
            ktIB(
                0,
                RBuilder::button,
                "variant" to (Variants.Solid.PRIMARY).ktN,
                "sizes" to Sizes.LG.ktN,
                "blockSized" to true
            ) { "+\"Block level button\"" }
            ln { +"+\" \"" }
            ktIB(
                0,
                RBuilder::button,
                "variant" to (Variants.Solid.SECONDARY).ktN,
                "sizes" to Sizes.LG.ktN,
                "blockSized" to true
            ) { "+\"Block level button\"" }
        }
    }
}
