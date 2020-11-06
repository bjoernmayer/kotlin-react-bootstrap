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
                .nestedBy(RBuilder::class)
                .addParameter("appearance", ButtonGroup.Appearance::class, false, ButtonGroup.Appearance.DEFAULT)
                .addParameter("behaviour", ButtonGroup.Behaviours::class, true, FunSpec.Parameter.NULL)
                .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("label", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("sizes", ButtonGroup.Sizes::class, true, FunSpec.Parameter.NULL)
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
                .nestedBy(RBuilder::class)
                .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("label", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("block", Generic("RHandler", ButtonToolbar.Props::class))
                .returns("ReactElement")
                .build()
        }
    }
}
