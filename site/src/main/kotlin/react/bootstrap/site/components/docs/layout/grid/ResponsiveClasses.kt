package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ColAttributes
import react.bootstrap.layout.grid.ColCounts
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.colFun
import react.bootstrap.site.components.docs.containerFun
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.exampleRow
import react.bootstrap.site.components.docs.fixings.kotlinExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.rowFun
import react.dom.br
import react.dom.code
import react.dom.em
import react.dom.h3
import react.dom.p

fun RBuilder.responsiveClasses() {
    contentTitle("Responsive classes") { }
    p {
        +"Bootstrap’s grid includes five tiers of predefined classes for building complex responsive layouts. Customize"
        +"the size of your columns on extra small, small, medium, large, or extra large devices however you see fit."
    }
    contentTitle(RBuilder::h3, "All breakpoints") { }
    p {
        +"For grids that are the same from the smallest of devices to the largest, set the "
        code { +"all = "; em { +"${ColAttributes::class.simpleName}?" } }; +" argument. Specify a numbered "
        code { +"${Sizes::class.simpleName}" }; +" enum value when you need a particularly sized column; otherwise, "
        +"feel free to not set the argument at all, which defaults to "
        code { +"all = ${Sizes.EQ.kt}" }; +"."
    }
    exampleRow {
        example {
            container {
                row {
                    for (x in 1..4) {
                        col { em { +"all = ${Sizes.EQ.kt}" } }
                    }
                }
                row {
                    col(all = Sizes.SZ_8) { +"all = ${Sizes.SZ_8.kt}" }
                    col(all = Sizes.SZ_4) { +"all = ${Sizes.SZ_4.kt}" }
                }
            }
        }
        kotlinExample {
            +"$containerFun {"; br { }
            +"    $rowFun {"; br { }
            for (x in 1..4) {
                +"        $colFun { em { +\"all = ${Sizes.EQ.kt}\" } }"; br { }
            }
            +"    }"; br { }
            +"    $rowFun {"; br { }
            +"        $colFun(all = ${Sizes.SZ_8.kt}) { +\"all = ${Sizes.SZ_8.kt}\" }"; br { }
            +"        $colFun(all = ${Sizes.SZ_4.kt}) { +\"all = ${Sizes.SZ_4.kt}\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3, "Stacked to horizontal") { }
    p {
        +"By setting the "; code { +"sm = "; em { +"${ColAttributes::class.simpleName}?" } }; +" argument, you can "
        +"create a basic grid system that starts out stacked and becomes horizontal at the small breakpoint ("
        code { +"sm" }; +")."
    }
    exampleRow {
        example {
            container {
                row {
                    col(sm = Sizes.SZ_8) { +"sm = ${Sizes.SZ_8.kt}" }
                    col(sm = Sizes.SZ_4) { +"sm = ${Sizes.SZ_4.kt}" }
                }
                row {
                    for (x in 1..3) {
                        col(sm = Sizes.EQ) { +"sm = ${Sizes.EQ.kt}" }
                    }
                }
            }
        }
        kotlinExample {
            +"$containerFun {"; br { }
            +"    $rowFun {"; br { }
            +"        $colFun(sm = ${Sizes.SZ_8.kt}) { +\"sm = ${Sizes.SZ_8.kt}\" }"; br { }
            +"        $colFun(sm = ${Sizes.SZ_4.kt}) { +\"sm = ${Sizes.SZ_4.kt}\" }"; br { }
            +"    }"; br { }
            +"    $rowFun {"; br { }
            for (x in 1..3) {
                +"        $colFun(sm = ${Sizes.EQ.kt}) { +\"sm = ${Sizes.EQ.kt}\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3, "Mix and match") { }
    p {
        +"Don’t want your columns to simply stack in some grid tiers? Use a combination of different classes for each "
        +"tier as needed. See the example below for a better idea of how it all works."
    }
    exampleRow {
        example {
            container {
                row {
                    col(md = Sizes.SZ_8) { +"md = ${Sizes.SZ_8.kt}" }
                    col(all = Sizes.SZ_6, md = Sizes.SZ_4) { +"all = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_4.kt}" }
                }
                row {
                    for (x in 1..3) {
                        col(all = Sizes.SZ_6, md = Sizes.SZ_4) { +"all = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_4.kt}" }
                    }
                }
                row {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_6) { +"all = ${Sizes.SZ_6.kt}" }
                    }
                }
            }
        }
        kotlinExample {
            +"$containerFun {"; br { }
            +"    $rowFun {"; br { }
            +"        // Stack the columns on mobile by making one full-width and the other half-width"; br { }
            +"        $colFun(md = ${Sizes.SZ_8.kt}) { +\"md = ${Sizes.SZ_8.kt}\" }"; br { }
            +"        $colFun(all = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_4.kt}) { +\"all = ${Sizes.SZ_6.kt}, "
            +"md = ${Sizes.SZ_4.kt}\" }"; br { }
            +"    }"; br { }
            +"    $rowFun {"; br { }
            +"        // Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop"; br { }
            for (x in 1..3) {
                +"        $colFun(all = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_4.kt}) { +\"all = ${Sizes.SZ_6.kt}, md = "
                +"${Sizes.SZ_4.kt}\" }"; br { }
            }
            +"    }"; br { }
            +"    $rowFun {"; br { }
            +"        // Columns are always 50% wide, on mobile and desktop"; br { }
            for (x in 1..2) {
                +"        $colFun(all = ${Sizes.SZ_6.kt}) { +\"all = ${Sizes.SZ_6.kt}\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3, "Row columns") { }
    p {
        +"Set the "; code { +"${ColCounts::class.simpleName}" }; +" argument to quickly set the number of columns "
        +"that best render your content and layout. The row columns classes are set on the parent "
        code { +"$rowFun { }" }; +" as a shortcut."
    }
    exampleRow {
        example {
            container {
                row(all = ColCounts.CNT_2) {
                    for (x in 1..4) {
                        col { +"Column" }
                    }
                }
            }
        }
        kotlinExample {
            +"$containerFun {"; br { }
            +"    $rowFun(all = ${ColCounts.CNT_2.kt}) {"; br { }
            for (x in 1..4) {
                +"        $colFun { +\"Column\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    exampleRow {
        example {
            container {
                row(all = ColCounts.CNT_3) {
                    for (x in 1..4) {
                        col { +"Column" }
                    }
                }
            }
        }
        kotlinExample {
            +"$containerFun {"; br { }
            +"    $rowFun(all = ${ColCounts.CNT_3.kt}) {"; br { }
            for (x in 1..4) {
                +"        $colFun { +\"Column\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    exampleRow {
        example {
            container {
                row(all = ColCounts.CNT_4) {
                    for (x in 1..4) {
                        col { +"Column" }
                    }
                }
            }
        }
        kotlinExample {
            +"$containerFun {"; br { }
            +"    $rowFun(all = ${ColCounts.CNT_4.kt}) {"; br { }
            for (x in 1..4) {
                +"        $colFun { +\"Column\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    exampleRow {
        example {
            container {
                row(all = ColCounts.CNT_4) {
                    for (x in 1..2) {
                        col { +"Column" }
                    }
                    col(all = Sizes.SZ_6) { +"Colum" }
                    col { +"Column" }
                }
            }
        }
        kotlinExample {
            +"$containerFun {"; br { }
            +"    $rowFun(all = ${ColCounts.CNT_4.kt}) {"; br { }
            for (x in 1..2) {
                +"        $colFun { +\"Column\" }"; br { }
            }
            +"        $colFun(all = ${Sizes.SZ_6.kt}) { +\"Column\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    exampleRow {
        example {
            container {
                row(all = ColCounts.CNT_1, sm = ColCounts.CNT_2, md = ColCounts.CNT_4) {
                    for (x in 1..4) {
                        col { +"Column" }
                    }
                }
            }
        }
        kotlinExample {
            +"$containerFun {"; br { }
            +"    $rowFun(all = ${ColCounts.CNT_1.kt}, sm = ${ColCounts.CNT_2.kt}, md = ${ColCounts.CNT_4.kt}) {"
            br { }
            for (x in 1..4) {
                +"        $colFun { +\"Column\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3, "No gutters") { }
    p {
        +"The gutters between columns in Bootstrap's predefined grid classes can be removed by setting "
        code { +"gutters = false" }; +". This removes the negative "; code { +"margin" }; +"s from "
        code { +"$rowFun { }" }; +" and the horizontal "; code { +"padding" }; +" from all immediate "
        +"children columns."
    }
    p {
        +"In practice, here’s how it looks. Note you can continue to use this with all other predefined grid settings"
        +" (including column widths, responsive tiers, reorders, and more)."
    }
    exampleRow {
        example {
            container {
                row(gutters = false) {
                    col(sm = Sizes.SZ_6, md = Sizes.SZ_8) { +"sm = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_8.kt}" }
                    col(all = Sizes.SZ_6, md = Sizes.SZ_4) { +"all = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_4.kt}" }
                }
            }
        }
        kotlinExample {
            +"$containerFun {"; br { }
            +"    $rowFun(gutters = false) {"; br { }
            +"        $colFun(sm = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_8.kt}) { +\"sm = ${Sizes.SZ_6.kt}, md"
            +" = ${Sizes.SZ_8.kt}\" }"; br { }
            +"        $colFun(all = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_4.kt}) { +\"all = ${Sizes.SZ_6.kt}, "
            +"md = ${Sizes.SZ_4.kt}\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
}
