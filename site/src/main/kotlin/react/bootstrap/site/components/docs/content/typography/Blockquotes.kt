package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.blockQuote
import react.bootstrap.content.typography.blockQuoteFooter
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.importClassNames
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.cite

internal class Blockquotes : SectionComponent() {
    override val title: String = "Blockquotes"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
For quoting blocks of content from another source within your document. Wrap `${RBuilder::blockQuote.name} { }` around
any HTML as the quote.
            """
        }
        liveExample {
            blockQuote("${ClassNames.MB_0}") {
                +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante."
            }
        }
        codeExample {
            import("content.typography.${RBuilder::blockQuote.name}")
            importClassNames()
            ln { }
            ktB(0, RBuilder::blockQuote.name, ClassNames.MB_0.kt) {
                ln(it) { +"+\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.\"" }
            }
        }
        subSectionTitle("Naming a source", section)
        Markdown {
            //language=Markdown
            +"""
Add a `${RBuilder::blockQuoteFooter.name} { }`  for identifying the source. Wrap the name of the source work in
`cite { }`.
            """
        }
        liveExample {
            blockQuote("${ClassNames.MB_0}") {
                +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante."
                blockQuoteFooter { +"Someone famous in "; cite { +"Source Title" } }
            }
        }
        codeExample {
            import("content.typography.${RBuilder::blockQuoteFooter.name}")
            import("content.typography.${RBuilder::blockQuote.name}")
            importClassNames()
            ln { }
            ktB(0, RBuilder::blockQuote.name, ClassNames.MB_0.kt) {
                ln(it) { +"+\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.\"" }
                ln(it) { +"${RBuilder::blockQuoteFooter.name} { +\"Someone famous in \"; cite { +\"Source Title\" } }" }
            }
        }
    }
}
