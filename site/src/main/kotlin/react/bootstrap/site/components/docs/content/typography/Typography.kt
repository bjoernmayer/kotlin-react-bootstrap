package react.bootstrap.site.components.docs.content.typography

import react.RProps
import react.bootstrap.site.components.docs.contentPageLead
import react.bootstrap.site.components.docs.contentPageTitle
import react.functionalComponent

val Typography = functionalComponent<RProps> {
    contentPageTitle { +"Typography" }
    contentPageLead {
        +"Documentation and examples for Bootstrap typography, including global settings, headings, body text, "
        +"lists, and more."
    }
    globalSettings()
    headings()
    displayHeadings()
    lead()
    inlineTextElements()
    textUtilities()
    abbreviations()
    blockquotes()
}

