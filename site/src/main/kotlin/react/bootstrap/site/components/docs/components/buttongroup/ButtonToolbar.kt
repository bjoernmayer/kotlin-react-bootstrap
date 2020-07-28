package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.components.button.buttonToolbar
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.components.buttons.importButtonsBuilder
import react.bootstrap.site.components.docs.components.buttons.solidButtonBuilderParents
import react.bootstrap.site.components.docs.components.buttons.solidSecondaryFun
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.Quoted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.kt
import react.dom.p

internal class ButtonToolbar : SectionComponent() {
    override val title: String = "Button toolbar"

    override fun RBuilder.render() {
        sectionTitle(section)
        p {
            +"""
Combine sets of button groups into button toolbars for more complex components. Use utility classes as needed to space
out groups, buttons, and more.
            """
        }
        liveExample {
            buttonToolbar(label = "Toolbar with button groups") {
                buttonGroup(classes = "${ClassNames.MR_2}", label = "First group") {
                    for (x in 1..4) {
                        Buttons.solid.secondary { +x.toString() }
                    }
                }
                buttonGroup(classes = "${ClassNames.MR_2}", label = "Second group") {
                    for (x in 5..7) {
                        Buttons.solid.secondary { +x.toString() }
                    }
                }
                buttonGroup(label = "Third group") {
                    Buttons.solid.secondary { +"8" }
                }
            }
        }
        codeExample {
            importButtonsBuilder()
            import("components.button.${RBuilder::buttonGroup.name}")
            import("components.button.${RBuilder::buttonToolbar.name}")
            ln { }
            ktFun(RBuilder::buttonToolbar, args = mapOf("label" to Quoted("Toolbar with button groups"))) {
                ktFun(
                    RBuilder::buttonGroup,
                    args = mapOf("classes" to Quoted("\${${ClassNames.MR_2.kt}}"), "label" to Quoted("First group"))
                ) {
                    for (x in 1..4) {
                        ktFun(solidSecondaryFun, solidButtonBuilderParents, style = FunStyle.INLINE_BLOCK) {
                            string(x.toString())
                        }
                    }
                }
                ktFun(
                    RBuilder::buttonGroup,
                    args = mapOf("classes" to Quoted("\${${ClassNames.MR_2.kt}}"), "label" to Quoted("Second group"))
                ) {
                    for (x in 5..7) {
                        ktFun(solidSecondaryFun, solidButtonBuilderParents, style = FunStyle.INLINE_BLOCK) {
                            string(x.toString())
                        }
                    }
                }
                ktFun(
                    RBuilder::buttonGroup,
                    args = mapOf("label" to Quoted("Third group"))
                ) {
                    ktFun(solidSecondaryFun, solidButtonBuilderParents, style = FunStyle.INLINE_BLOCK) {
                        string("8")
                    }
                }
            }
        }
        // Todo Add Mixing with Input Groups
    }
}
