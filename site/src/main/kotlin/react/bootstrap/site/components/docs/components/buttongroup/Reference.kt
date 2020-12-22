package react.bootstrap.site.components.docs.components.buttongroup

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.ButtonToolbar
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.components.button.buttonToolbar
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
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
                .addParameter<String?>("classes", null)
                .addParameter<ButtonGroup.Appearance>("appearance", null)
                .addParameter<ButtonGroup.Behaviours>("behaviour", null)
                .addParameter<ButtonGroup.Sizes>("sizes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(ButtonGroup.Props::class, DIV::class).build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic.builder<RDOMHandler<*>, DIV>())
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
                .addParameter<String?>("classes", null)
                .addParameter<ButtonGroup.Appearance>("appearance", null)
                .addParameter<ButtonGroup.Behaviours>("behaviour", null)
                .addParameter<ButtonGroup.Sizes>("sizes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(ButtonGroup.Props::class, "T").build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic(RDOMHandler::class, "T"))
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
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(ButtonToolbar.Props::class, DIV::class).build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic.builder<RDOMHandler<*>, DIV>())
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
                    Generic(PropHandler::class, Generic(ButtonToolbar.Props::class, "T").build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic(RDOMHandler::class, "T"))
                .returns("ReactElement")
                .build()
        }
    }
}
