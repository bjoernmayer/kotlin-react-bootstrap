package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.BLOCKQUOTE
import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.bootstrap.content.typography.blockquote.BlockQuoteFooter
import react.bootstrap.content.typography.blockquote.blockQuote
import react.bootstrap.content.typography.blockquote.blockQuoteFooter
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import react.dom.RDOMBuilder

internal class Blockquote : SectionComponent() {
    override val title: String = "Blockquote"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle(RBuilder::blockQuote.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `blockquote` element and adds `${ClassNames.BLOCKQUOTE.nestedName}` to it.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::blockQuote)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic.builder<RDOMHandler<*>, BLOCKQUOTE>())
                .returns("ReactElement")
                .build()
        }

        subSectionTitle(RDOMBuilder<BLOCKQUOTE>::blockQuoteFooter.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${BlockQuoteFooter::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RDOMBuilder<BLOCKQUOTE>::blockQuoteFooter)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic.builder<BlockQuoteFooter.Props<*>, DIV>().build()),
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
Creates a generic `${BlockQuoteFooter::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RDOMBuilder<BLOCKQUOTE>::blockQuoteFooter, inline = true)
                .addTypeParameter("T", HtmlBlockTag::class, true)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(BlockQuoteFooter.Props::class, "T").build()),
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
