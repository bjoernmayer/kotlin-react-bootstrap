package react.bootstrap.site.components.docs.components.buttons

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Buttons : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Buttons")
        pageLead {
            +"""
                Use Bootstrap’s custom button styles for actions in forms, dialogs, and more with support for multiple
                sizes, states, and more.
            """.trimIndent()
        }
        child(Examples::class)
        child(ButtonTags::class)
        child(OutlineButtons::class)
    }
}
