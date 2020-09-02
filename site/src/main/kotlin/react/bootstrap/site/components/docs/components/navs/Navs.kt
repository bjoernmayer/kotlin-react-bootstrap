package react.bootstrap.site.components.docs.components.navs

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Navs : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Navs")
        pageLead {
            +"""
Documentation and examples for how to use Bootstrap’s included navigation components.
            """
        }
        child(BaseNav::class)
    }
}
