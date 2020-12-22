package react.bootstrap.site.components.docs.components.navbar

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Navbar : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Navbar")
        pageLead {
            +"""
Documentation and examples for Bootstrap’s powerful, responsive navigation header, the navbar. Includes support for
branding, navigation, and more.
            """
        }
        child(HowItWorks::class)
        child(SupportedContent::class)
    }
}
