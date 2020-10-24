package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.blockQuote
import react.bootstrap.content.typography.blockQuoteFooter
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
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
            +Imports.builder()
                .addImport("content.typography.${RBuilder::blockQuote.name}")
                .importClassNames()
                .build()

            +FunCall.builder(RBuilder::blockQuote)
                .addArgument(ClassNames.MB_0)
                .setLambdaArgument(
                    plusString("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                )
                .build()
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
            +Imports.builder()
                .addImport("content.typography.${RBuilder::blockQuoteFooter.name}")
                .addImport("content.typography.${RBuilder::blockQuote.name}")
                .importClassNames()
                .build()

            +FunCall.builder(RBuilder::blockQuote)
                .addArgument(ClassNames.MB_0)
                .setLambdaArgument(
                    plusString(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante."
                    ),
                    "\n",
                    FunCall.builder(RBuilder::blockQuoteFooter, FunCall.Style.INLINE)
                        .setLambdaArgument(
                            plusString("Someone famous in "),
                            "; ",
                            FunCall.builder(RBuilder::cite, FunCall.Style.INLINE)
                                .setLambdaArgument(plusString("Source Title"))
                                .build()
                        ).build()

                )
                .build()
        }
    }
}
