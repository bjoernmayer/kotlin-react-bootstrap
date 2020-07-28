package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.components.button.Button.Sizes
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
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
            Buttons.solid.primary(sizes = Sizes.LG) { +"Large button" }
            +" "
            Buttons.solid.secondary(sizes = Sizes.LG) { +"Large button" }
        }
        codeExample {
            importButton()
            importButtonsBuilder()
            ln { }
            ktFun(
                solidPrimaryFun,
                parents = solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf("sizes" to Sizes.LG.ktN)
            ) {
                string("Large button")
            }
            ln(" ")
            ktFun(
                solidSecondaryFun,
                parents = solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf("sizes" to Sizes.LG.ktN)
            ) {
                string("Large button")
            }
        }
        liveExample {
            Buttons.solid.primary(sizes = Sizes.SM) { +"Small button" }
            +" "
            Buttons.solid.secondary(sizes = Sizes.SM) { +"Small button" }
        }
        codeExample {
            importButton()
            importButtonsBuilder()
            ln { }
            ktFun(
                solidPrimaryFun,
                parents = solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf("sizes" to Sizes.SM.ktN)
            ) {
                string("Small button")
            }
            ln(" ")
            ktFun(
                solidSecondaryFun,
                parents = solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf("sizes" to Sizes.SM.ktN)
            ) {
                string("Small button")
            }
        }
        Markdown {
            //language=Markdown
            +"""
Create block level buttons—those that span the full width of a parent—by adding setting `button(blocksized: Boolean)` to
`true`.
            """
        }
        liveExample {
            Buttons.solid.primary(sizes = Sizes.LG, blockSized = true) { +"Block level button" }
            +" "
            Buttons.solid.secondary(sizes = Sizes.LG, blockSized = true) { +"Block level button" }
        }
        codeExample {
            importButton()
            importButtonsBuilder()
            ln { }
            ktFun(
                solidPrimaryFun,
                parents = solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf("sizes" to Sizes.LG.ktN, "blockSized" to true)
            ) {
                string("Block level button")
            }
            ln(" ")
            ktFun(
                solidSecondaryFun,
                parents = solidButtonBuilderParents,
                style = FunStyle.INLINE_BLOCK,
                args = mapOf("sizes" to Sizes.LG.ktN, "blockSized" to true)
            ) {
                string("Block level button")
            }
        }
    }
}
