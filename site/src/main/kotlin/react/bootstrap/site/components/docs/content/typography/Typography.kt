package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Typography : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Typography")
        pageLead {
            +"""
Documentation and examples for Bootstrap typography, including global settings, headings, body text, lists, and more.
            """
        }
        child(Headings::class)
        child(DisplayHeadings::class)
        child(Lead::class)
        child(InlineTextElements::class)
        child(Blockquotes::class)
        child(Lists::class)
    }
}
