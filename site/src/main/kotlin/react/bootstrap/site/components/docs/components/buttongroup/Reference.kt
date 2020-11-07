package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.ButtonToolbar
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.components.button.buttonToolbar
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle(RBuilder::buttonGroup.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${ButtonGroup::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::buttonGroup)
                .nestedBy<RBuilder>()
                .addParameter<ButtonGroup.Appearance>("appearance", null)
                .addParameter<ButtonGroup.Behaviours>("behaviour", null)
                .addParameter<String?>("classes", null)
                .addParameter<String?>("label", null)
                .addParameter<ButtonGroup.Sizes>("sizes", null)
                .addParameter("block", Generic("RHandler", ButtonGroup.Props::class))
                .returns("ReactElement")
                .build()
        }
        subSectionTitle(RBuilder::buttonToolbar.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${ButtonToolbar::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::buttonToolbar)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter<String?>("label", null)
                .addParameter("block", Generic("RHandler", ButtonToolbar.Props::class))
                .returns("ReactElement")
                .build()
        }
    }
}
