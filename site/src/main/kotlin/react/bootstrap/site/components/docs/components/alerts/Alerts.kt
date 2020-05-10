package react.bootstrap.site.components.docs.components.alerts

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Alerts : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Alerts")
        pageLead {
            +"""
Provide contextual feedback messages for typical user actions with the handful of available and flexible alert messages.
            """
        }
        child(Examples::class)
        child(Reference::class)
    }
}
