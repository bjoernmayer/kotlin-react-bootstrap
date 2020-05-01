package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.contentPageLead
import react.bootstrap.site.components.docs.fixings.contentPageTitle
import react.bootstrap.site.external.Fragment

fun RBuilder.grid() =
    Fragment {
        contentPageTitle("Grid system")
        contentPageLead {
            +"Use Bootstrap's powerful mobile-first flexbox grid to build layouts of all shapes and sizes thanks to a "
            +"twelve column system, five default responsive tiers and dozens of predefined classes."
        }
        howItWorks()
        gridOptions()
        autoLayoutColumns()
        responsiveClasses()
        alignment()
        reordering()
        combining()
    }
