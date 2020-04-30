package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.title
import react.RBuilder
import react.bootstrap.content.typography.blockQuoteFooter
import react.bootstrap.content.typography.blockQuote
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.kotlinExample
import react.bootstrap.site.components.docs.kt
import react.dom.abbr
import react.dom.br
import react.dom.cite
import react.dom.code
import react.dom.h3
import react.dom.p

fun RBuilder.blockquotes() {
    contentTitle("Blockquotes") { }
    p {
        +"For quoting blocks of content from another source within your document. Wrap "
        code { +"${RBuilder::blockQuote.name} { }" }
        +" around any "; abbr { attrs { title = "HyperText Markup Language" }; +"HTML" }; +" as the quote."
    }
    example {
        blockQuote("${ClassNames.MB_0}") {
            +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante."
        }
    }
    kotlinExample {
        +"${RBuilder::blockQuote.name}(\"\${${ClassNames.MB_0.kt}}\") {"; br { }
        +"    +\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.\""; br { }
        +"}"
    }
    contentTitle(RBuilder::h3, "Naming a source") { }
    p {
        +"Add a "; code { +"${RBuilder::blockQuoteFooter.name} { }" }; +" for identifying the source. Wrap the name of "
        +"the source work in "; code { +"cite { }" }; +"."
    }
    example {
        blockQuote("${ClassNames.MB_0}") {
            +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante."
            blockQuoteFooter { +"Someone famous in "; cite { +"Source Title" } }
        }
    }
    kotlinExample {
        +"${RBuilder::blockQuote.name}(\"\${${ClassNames.MB_0.kt}}\") {"; br { }
        +"    +\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.\""; br { }
        +"    ${RBuilder::blockQuoteFooter.name} { +\"Someone famous in \"; cite { +\"Source Title\" } }"; br { }
        +"}"
    }
}
