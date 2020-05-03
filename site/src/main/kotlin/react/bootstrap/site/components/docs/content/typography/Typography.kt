package react.bootstrap.site.components.docs.content.typography

import react.Fragment
import react.RBuilder
import react.bootstrap.site.components.docs.fixings.contentPageLead
import react.bootstrap.site.components.docs.fixings.contentPageTitle

fun RBuilder.typography() = Fragment {
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
