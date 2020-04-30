package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.contentPageLead
import react.bootstrap.site.components.docs.fixings.contentPageTitle
import react.dom.div

fun RBuilder.typography() =
    div {
        contentPageTitle("Typography")
        contentPageLead {
            +"Documentation and examples for Bootstrap typography, including global settings, headings, body text, "
            +"lists, and more."
        }
        headings()
        displayHeadings()
        lead()
        inlineTextElements()
        blockquotes()
        lists()
    }
