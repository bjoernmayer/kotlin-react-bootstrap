package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.components.buttons.importButtonsBuilder
import react.bootstrap.site.components.docs.components.buttons.solidButtonBuilderParents
import react.bootstrap.site.components.docs.components.buttons.solidSecondaryFun
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown

internal class BasicExample : SectionComponent() {
    override val title: String = "Basic example"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Wrap a series of buttons in `${RBuilder::buttonGroup.name}`.
            """
        }
        val leftMiddleRight = listOf("Left", "Middle", "Right")
        liveExample {
            buttonGroup {
                leftMiddleRight.forEach {
                    Buttons.solid.secondary { +it }
                }
            }
        }
        codeExample {
            importButtonsBuilder()
            import("components.button.${RBuilder::buttonGroup.name}")
            ln { }
            ktFun(RBuilder::buttonGroup) {
                leftMiddleRight.forEach {
                    ktFun(solidSecondaryFun, solidButtonBuilderParents, style = FunStyle.INLINE_BLOCK) {
                        string(it)
                    }
                }
            }
        }
    }
}
