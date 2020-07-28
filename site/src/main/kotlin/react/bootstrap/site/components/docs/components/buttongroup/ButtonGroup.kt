package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class ButtonGroup : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Button group")
        pageLead {
            +"""
Group a series of buttons together on a single line with the button group, and super-power them with JavaScript.
            """.trimIndent()
        }
        child(BasicExample::class)
    }
}
