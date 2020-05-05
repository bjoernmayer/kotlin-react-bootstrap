package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Tables : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Tables")
        pageLead {
            +"Documentation and examples for opt-in styling of tables with Bootstrap."
        }
        child(Examples::class)
        child(TableHeadOptions::class)
        child(StripedRows::class)
        child(BorderStyles::class)
        child(HoverableRows::class)
        child(SmallTable::class)
        child(ContextualStyles::class)
        child(ResponsiveTables::class)
    }
}
