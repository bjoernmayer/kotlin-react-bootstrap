package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.blockQuote
import react.bootstrap.content.typography.blockQuoteFooter
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.classNamesImport
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.cite

internal class Blockquotes : SectionComponent() {
    override val title: String = "Blockquotes"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
            For quoting blocks of content from another source within your document. Wrap <${RBuilder::blockQuote.name}
            { }|code> around any HTML as the quote.
        """.trimIndent()
        }
        example {
            blockQuote("${ClassNames.MB_0}") {
                +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante."
            }
        }
        codeBox {
            ln { +"import react.bootstrap.content.typography.${RBuilder::blockQuote.name}" }
            classNamesImport()
            ln { }
            ktBlock(0, "${RBuilder::blockQuote.name}(\"\${${ClassNames.MB_0.kt}}\")") { il ->
                ln(il) { +"+\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.\"" }
            }
        }
        subSectionTitle("Naming a source", section)
        formattedText {
            """
            Add a <${RBuilder::blockQuoteFooter.name} { }|code>  for identifying the source. Wrap the name of the source
            work in <cite { }|code>.
        """.trimIndent()
        }
        example {
            blockQuote("${ClassNames.MB_0}") {
                +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante."
                blockQuoteFooter { +"Someone famous in "; cite { +"Source Title" } }
            }
        }
        codeBox {
            ln { +"import react.bootstrap.content.typography.${RBuilder::blockQuoteFooter.name}" }
            ln { +"import react.bootstrap.content.typography.${RBuilder::blockQuote.name}" }
            classNamesImport()
            ln { }
            ktBlock(0, "${RBuilder::blockQuote.name}(\"\${${ClassNames.MB_0.kt}}\")") { il ->
                ln(il) { +"+\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.\"" }
                ln(il) { +"${RBuilder::blockQuoteFooter.name} { +\"Someone famous in \"; cite { +\"Source Title\" } }" }
            }
        }
    }
}
