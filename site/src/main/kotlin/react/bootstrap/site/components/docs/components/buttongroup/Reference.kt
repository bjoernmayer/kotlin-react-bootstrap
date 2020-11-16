package react.bootstrap.site.components.docs.components.buttongroup

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.ButtonToolbar
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.components.button.buttonToolbar
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.FunSpec.Parameter.Modifier.CROSSINLINE
import react.bootstrap.site.lib.codepoet.FunSpec.Parameter.Modifier.NOINLINE
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
                .addParameter<ButtonGroup.Sizes>("sizes", null)
                .addParameter(
                    "props",
                    Generic("PropHandler", Generic(ButtonGroup.Props::class, DIV::class).build()),
                    default = "{ }"
                )
                .addParameter("block", Generic("RDOMHandler", DIV::class))
                .returns("ReactElement")
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${ButtonGroup::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::buttonGroup, inline = true)
                .nestedBy<RBuilder>()
                .addTypeParameter("T", HtmlBlockTag::class, true)
                .addParameter<ButtonGroup.Appearance>("appearance", null)
                .addParameter<ButtonGroup.Behaviours>("behaviour", null)
                .addParameter<String?>("classes", null)
                .addParameter<ButtonGroup.Sizes>("sizes", null)
                .addParameter(
                    "props",
                    Generic("PropHandler", Generic(ButtonGroup.Props::class, "T").build()),
                    default = "{ }",
                    modifier = CROSSINLINE
                )
                .addParameter("block", Generic("RDOMHandler", "T"), modifier = NOINLINE)
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
                .addParameter("block", Generic("RHandler", ButtonToolbar.Props::class))
                .returns("ReactElement")
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${ButtonToolbar::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::buttonToolbar)
                .nestedBy<RBuilder>()
                .addTypeParameter("T", HtmlBlockTag::class, true)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic("PropHandler", Generic(ButtonToolbar.Props::class, "T").build()),
                    default = "{ }",
                    modifier = NOINLINE
                )
                .addParameter("block", Generic("RDOMHandler", "T"), modifier = NOINLINE)
                .returns("ReactElement")
                .build()
        }
    }
}
