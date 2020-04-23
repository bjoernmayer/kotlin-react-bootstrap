package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ColAttribute
import react.bootstrap.layout.grid.ColumnCount
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.ColFun
import react.bootstrap.site.components.docs.RowFun
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.exampleRow
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.br
import react.dom.code
import react.dom.em
import react.dom.h3
import react.dom.p

fun RBuilder.responsiveClasses() {
    val rowFun: RowFun = RBuilder::row
    val colFun: ColFun = RBuilder::col
    val enumName = Sizes::class.simpleName
    val eqName = Sizes.EQ.name
    val sz8Name = Sizes.SZ_8.name
    val sz6Name = Sizes.SZ_6.name
    val sz4Name = Sizes.SZ_4.name
    contentTitle { +"Responsive classes" }
    p {
        +"Bootstrap’s grid includes five tiers of predefined classes for building complex responsive layouts. Customize"
        +"the size of your columns on extra small, small, medium, large, or extra large devices however you see fit."
    }
    contentTitle(RBuilder::h3) { +"All breakpoints" }
    p {
        +"For grids that are the same from the smallest of devices to the largest, set the "
        code { +"all = "; em { +"${ColAttribute::class.simpleName}?" } }; +" argument. Specify a numbered "
        code { +"$enumName" }; +" enum value when you need a particularly sized column; otherwise, "
        +"feel free to not set the argument at all, which defaults to "
        code { +"all = $enumName.$eqName" }; +"."
    }
    exampleRow {
        example {
            container {
                row {
                    for (x in 1..4) {
                        col { em { +"all = $enumName.$eqName" } }
                    }
                }
                row {
                    col(all = Sizes.SZ_8) { +"all = $enumName.$sz8Name" }
                    col(all = Sizes.SZ_4) { +"all = $enumName.$sz4Name" }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name} {"; br { }
            for (x in 1..4) {
                +"        ${colFun.name} { em { +\"all = $enumName.$eqName\" } }"; br { }
            }
            +"    }"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        ${colFun.name}(all = $enumName.$sz8Name) { +\"all = $enumName.$sz8Name\" }"; br { }
            +"        ${colFun.name}(all = $enumName.$sz4Name) { +\"all = $enumName.$sz4Name\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3) { +"Stacked to horizontal" }
    p {
        +"By setting the "; code { +"sm = "; em { +"${ColAttribute::class.simpleName}?" } }; +" argument, you can "
        +"create a basic grid system that starts out stacked and becomes horizontal at the small breakpoint ("
        code { +"sm" }; +")."
    }
    exampleRow {
        example {
            container {
                row {
                    col(sm = Sizes.SZ_8) { +"sm = $enumName.$sz8Name" }
                    col(sm = Sizes.SZ_4) { +"sm = $enumName.$sz4Name" }
                }
                row {
                    for (x in 1..3) {
                        col(sm = Sizes.EQ) { +"sm = $enumName.$eqName" }
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        ${colFun.name}(sm = $enumName.$sz8Name) { +\"sm = $enumName.$sz8Name\" }"; br { }
            +"        ${colFun.name}(sm = $enumName.$sz4Name) { +\"sm = $enumName.$sz4Name\" }"; br { }
            +"    }"; br { }
            +"    ${rowFun.name} {"; br { }
            for (x in 1..3) {
                +"        ${colFun.name}(sm = $enumName.$eqName) { +\"sm = $enumName.$eqName\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3) { +"Mix and match" }
    p {
        +"Don’t want your columns to simply stack in some grid tiers? Use a combination of different classes for each "
        +"tier as needed. See the example below for a better idea of how it all works."
    }
    exampleRow {
        example {
            container {
                row {
                    col(md = Sizes.SZ_8) { +"md = $enumName.$sz8Name" }
                    col(all = Sizes.SZ_6, md = Sizes.SZ_4) { +"all = $enumName.$sz6Name, md = $enumName.$sz4Name" }
                }
                row {
                    for (x in 1..3) {
                        col(all = Sizes.SZ_6, md = Sizes.SZ_4) { +"all = $enumName.$sz6Name, md = $enumName.$sz4Name" }
                    }
                }
                row {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_6) { +"all = $enumName.$sz6Name" }
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        // Stack the columns on mobile by making one full-width and the other half-width"; br { }
            +"        ${colFun.name}(md = $enumName.$sz8Name) { +\"md = $enumName.$sz8Name\" }"; br { }
            +"        ${colFun.name}(all = $enumName.$sz6Name, md = $enumName.$sz4Name) { +\"all = $enumName.$sz6Name, "
            +"md = $enumName.$sz4Name\" }"; br { }
            +"    }"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        // Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop"; br { }
            for (x in 1..3) {
                +"        ${colFun.name}(all = $enumName.$sz6Name, md = $enumName.$sz4Name) { +\"all = $enumName."
                +"$sz6Name, md = $enumName.$sz4Name\" }"; br { }
            }
            +"    }"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        // Columns are always 50% wide, on mobile and desktop"; br { }
            for (x in 1..2) {
                +"        ${colFun.name}(all = $enumName.$sz6Name) { +\"all = $enumName.$sz6Name\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3) { +"Row columns" }
    p {
        +"Set the "; code { +"${ColumnCount::class.simpleName}" }; +" argument to quickly set the number of columns "
        +"that best render your content and layout. The row columns classes are set on the parent "
        code { +"${rowFun.name} { }" }; +" as a shortcut."
    }
    exampleRow {
        example {
            container {
                row(all = ColumnCount.CNT_2) {
                    for (x in 1..4) {
                        col { +"Column" }
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name}(all = ${ColumnCount::class.simpleName}.${ColumnCount.CNT_2.name}) {"; br { }
            for (x in 1..4) {
                +"        ${colFun.name} { +\"Column\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    exampleRow {
        example {
            container {
                row(all = ColumnCount.CNT_3) {
                    for (x in 1..4) {
                        col { +"Column" }
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name}(all = ${ColumnCount::class.simpleName}.${ColumnCount.CNT_3.name}) {"; br { }
            for (x in 1..4) {
                +"        ${colFun.name} { +\"Column\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    exampleRow {
        example {
            container {
                row(all = ColumnCount.CNT_4) {
                    for (x in 1..4) {
                        col { +"Column" }
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name}(all = ${ColumnCount::class.simpleName}.${ColumnCount.CNT_4.name}) {"; br { }
            for (x in 1..4) {
                +"        ${colFun.name} { +\"Column\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    exampleRow {
        example {
            container {
                row(all = ColumnCount.CNT_4) {
                    for (x in 1..2) {
                        col { +"Column" }
                    }
                    col(all = Sizes.SZ_6) { +"Colum" }
                    col { +"Column" }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name}(all = ${ColumnCount::class.simpleName}.${ColumnCount.CNT_4.name}) {"; br { }
            for (x in 1..2) {
                +"        ${colFun.name} { +\"Column\" }"; br { }
            }
            +"        ${colFun.name}(all = $enumName.$sz6Name) { +\"Column\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    exampleRow {
        example {
            container {
                row(all = ColumnCount.CNT_1, sm = ColumnCount.CNT_2, md = ColumnCount.CNT_4) {
                    for (x in 1..4) {
                        col { +"Column" }
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name}(all = ${ColumnCount::class.simpleName}.${ColumnCount.CNT_1.name}, sm = "
            +"${ColumnCount::class.simpleName}.${ColumnCount.CNT_2.name}, md = "
            +"${ColumnCount::class.simpleName}.${ColumnCount.CNT_4.name}) {"; br { }
            for (x in 1..4) {
                +"        ${colFun.name} { +\"Column\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3) { +"No gutters" }
    p {
        +"The gutters between columns in Bootstrap's predefined grid classes can be removed by setting "
        code { +"gutters = false" }; +". This removes the negative "; code { +"margin" }; +"s from "
        code { +"${rowFun.name} { }" }; +" and the horizontal "; code { +"padding" }; +" from all immediate "
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
                    col(sm = Sizes.SZ_6, md = Sizes.SZ_8) { +"sm = $enumName.$sz6Name, md = $enumName.$sz8Name" }
                    col(all = Sizes.SZ_6, md = Sizes.SZ_4) { +"all = $enumName.$sz6Name, md = $enumName. $sz4Name" }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name}(gutters = false) {"; br { }
            +"        ${colFun.name}(sm = $enumName.$sz6Name, md = $enumName.$sz8Name) { +\"sm = $enumName.$sz6Name, md"
            +" = $enumName.$sz8Name\" }"; br { }
            +"        ${colFun.name}(all = $enumName.$sz6Name, md = $enumName.$sz4Name) { +\"all = $enumName.$sz6Name, "
            +"md = $enumName. $sz4Name\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
}
