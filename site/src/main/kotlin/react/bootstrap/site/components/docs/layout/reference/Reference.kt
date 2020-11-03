package react.bootstrap.site.components.docs.layout.reference

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Reference : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Reference")
        child(ContainersContainerBuilder::class)
        child(RowCol::class)
    }
}
