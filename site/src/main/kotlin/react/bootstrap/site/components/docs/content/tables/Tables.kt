package react.bootstrap.site.components.docs.content.tables

import react.Fragment
import react.RBuilder
import react.bootstrap.site.components.docs.fixings.contentPageLead
import react.bootstrap.site.components.docs.fixings.contentPageTitle

fun RBuilder.tables() = Fragment {
    contentPageTitle("Tables")
    contentPageLead {
        +"Documentation and examples for opt-in styling of tables with Bootstrap."
    }
    examples()
    tableHeadOptions()
    stripedRows()
    borderStyles()
    hoverableRows()
    smallTable()
    contextualStyles()
    responsiveTables()
}
