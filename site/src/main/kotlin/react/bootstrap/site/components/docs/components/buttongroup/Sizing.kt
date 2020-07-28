package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.components.buttons.importButtonsBuilder
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.Quoted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.dom.br

internal class Sizing : SectionComponent() {
    override val title: String = "Sizing"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Instead of applying button sizing classes to every button in a group, just set `sizes` to each
`${RBuilder::buttonGroup.name}`, including each one when nesting multiple groups.
            """
        }
        val leftMiddleRight = listOf("Left", "Middle", "Right")
        liveExample {
            buttonGroup(sizes = ButtonGroup.Sizes.LG, label = "...") {
                leftMiddleRight.forEach {
                    Buttons.solid.secondary { +it }
                }
            }
            br { }
            buttonGroup(label = "...") {
                leftMiddleRight.forEach {
                    Buttons.solid.secondary { +it }
                }
            }
            br { }
            buttonGroup(sizes = ButtonGroup.Sizes.SM, label = "...") {
                leftMiddleRight.forEach {
                    Buttons.solid.secondary { +it }
                }
            }
            br { }
        }
        codeExample {
            import("components.button.ButtonGroup")
            importButtonsBuilder()
            import("components.button.${RBuilder::buttonGroup.name}")
            ln { }
            ktFun(
                RBuilder::buttonGroup,
                args = mapOf("sizes" to ButtonGroup.Sizes.LG.ktN, "label" to Quoted("..."))
            ) {
                ln { +"..." }
            }
            ktFun(RBuilder::br, style = FunStyle.INLINE_BLOCK) { }
            ktFun(
                RBuilder::buttonGroup,
                args = mapOf("label" to Quoted("..."))
            ) {
                ln { +"..." }
            }
            ktFun(RBuilder::br, style = FunStyle.INLINE_BLOCK) { }
            ktFun(
                RBuilder::buttonGroup,
                args = mapOf("sizes" to ButtonGroup.Sizes.SM.ktN, "label" to Quoted("..."))
            ) {
                ln { +"..." }
            }
        }
    }
}
