package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.ButtonToolbar
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.components.button.buttonToolbar
import react.bootstrap.site.components.docs.FunReference
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.components.buttons.ktN
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.dom.p

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle(section)
        subSectionTitle(RBuilder::buttonGroup.name, section)
        p {
            +"Adds a button group."
        }
        codeExample {
            +FunReference(
                RBuilder::buttonGroup,
                setOf(RBuilder::class.simpleName!!),
                setOf(
                    FunReference.Argument(
                        "appearance",
                        buildNestedName(ButtonGroup.Appearance::class, ButtonGroup::class),
                        false,
                        ButtonGroup.Appearance.DEFAULT.ktN
                    ),
                    FunReference.Argument(
                        "behaviour",
                        buildNestedName(ButtonGroup.Behaviours::class, ButtonGroup::class),
                        true,
                        FunReference.Argument.NULL
                    ),
                    FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
                    FunReference.Argument("label", String::class, true, FunReference.Argument.NULL),
                    FunReference.Argument(
                        "sizes",
                        buildNestedName(ButtonGroup.Sizes::class, ButtonGroup::class),
                        true,
                        FunReference.Argument.NULL
                    ),
                    FunReference.Argument(
                        "block",
                        "RHandler<${buildNestedName(ButtonGroup.Props::class, ButtonGroup::class)}>"
                    )
                ),
                "ReactElement"
            ).print(false)
        }
        subSectionTitle(RBuilder::buttonToolbar.name, section)
        p {
            +"Add a button toolbar."
        }
        codeExample {
            +FunReference(
                RBuilder::buttonToolbar,
                setOf(RBuilder::class.simpleName!!),
                setOf(
                    FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
                    FunReference.Argument("label", String::class, true, FunReference.Argument.NULL),
                    FunReference.Argument(
                        "block",
                        "RHandler<${buildNestedName(ButtonToolbar.Props::class, ButtonToolbar::class)}>"
                    )
                ),
                "ReactElement"
            ).print(false)
        }
    }
}
