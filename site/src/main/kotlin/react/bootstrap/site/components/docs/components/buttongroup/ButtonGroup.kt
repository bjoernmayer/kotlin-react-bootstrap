package react.bootstrap.site.components.docs.components.buttongroup

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class ButtonGroup : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Button group")
        pageLead {
            +"""
Group a series of buttons together on a single line with the button group, and super-power them with Kotlin JavaScript.
            """.trimIndent()
        }
        child(BasicExample::class)
        child(ButtonToolbar::class)
        child(Sizing::class)
        // Todo add Nesting when Dropdown component is done
        child(VerticalVariation::class)
        child(Reference::class)
    }
}
