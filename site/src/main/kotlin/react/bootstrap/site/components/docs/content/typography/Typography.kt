package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.site.components.docs.contentPageLead
import react.bootstrap.site.components.docs.contentPageTitle
import react.router.dom.RouteResultProps

class Typography : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
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
}
