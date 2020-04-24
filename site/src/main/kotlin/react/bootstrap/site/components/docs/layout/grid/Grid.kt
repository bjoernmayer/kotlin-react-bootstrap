package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.site.components.docs.contentPageLead
import react.bootstrap.site.components.docs.contentPageTitle
import react.dom.div

fun RBuilder.grid() =
    div {
        contentPageTitle { +"Grid system" }
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
