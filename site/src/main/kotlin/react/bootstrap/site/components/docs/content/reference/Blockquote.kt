package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.BLOCKQUOTE
import react.RBuilder
import react.bootstrap.content.typography.blockquote.BlockQuoteFooter
import react.bootstrap.content.typography.blockquote.blockQuote
import react.bootstrap.content.typography.blockquote.blockQuoteFooter
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
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
                .addParameter("block", Generic("RDOMHandler", BLOCKQUOTE::class))
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
                .addParameter("block", Generic("RHandler", BlockQuoteFooter.Props::class))
                .returns("ReactElement")
                .build()
        }
    }
}
