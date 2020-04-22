package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.ColFun
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.exampleRow
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.br
import react.dom.code
import react.dom.h3
import react.dom.p

fun RBuilder.autoLayoutColumns() {
    val colFun: ColFun = RBuilder::col
    val enumName = Sizes::class.simpleName
    val autoName = Sizes.AUTO.name

    contentTitle { +"Auto-layout columns" }
    p {
        +"Utilize breakpoint-specific equal-size enum values for easy column sizing without an explicit numbered enum "
        +"value like "; code { +"$enumName.${Sizes.SZ_6.name}" }; +"."
    }
    contentTitle(RBuilder::h3) { +"Equal-width" }
    p {
        +"For example, here are two grid layouts that apply to every device and viewport, from "; code { +"xs" }
        +" to "; code { +"xl" }; +". Add any number of equal-size enums for each breakpoint you need and every column"
        +"will be the same width."
    }
    exampleRow {
        example {
            container {
                row {
                    for (x in 1..2) {
                        col { +"$x of 2" }
                    }
                }
                row {
                    for (x in 1..3) {
                        col { +"$x of 3" }
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${RBuilder::row.name} {"; br { }
            +"        ${colFun.name} { +\"1 of 2\" }"; br { }
            +"        ${colFun.name} { +\"2 of 2\" }"; br { }
            +"        // Same as: col(all = $enumName.${Sizes.EQ.name}) { +\"x of 2\" }"; br { }
            +"    }"; br { }
            +"    ${RBuilder::row.name} {"; br { }
            +"        ${colFun.name} { +\"1 of 3\" }"; br { }
            +"        ${colFun.name} { +\"2 of 3\" }"; br { }
            +"        ${colFun.name} { +\"3 of 3\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3) { +"Setting one column width" }
    p {
        +"Auto-layout for flexbox grid columns also means you can set the width of one column and have the sibling "
        +"columns automatically resize around it. You may use predefined grid enumbs (as shown below), grid mixins, or "
        +"inline widths. Note that the other columns will resize no matter the width of the center column."
    }
    exampleRow {
        example {
            container {
                row {
                    col { +"1 of 3" }
                    col(all = Sizes.SZ_6) { +"2 of 3 (wider)" }
                    col { +"3 of 3" }
                }
                row {
                    col { +"1 of 3" }
                    col(all = Sizes.SZ_5) { +"2 of 3 (wider)" }
                    col { +"3 of 3" }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${RBuilder::row.name} {"; br { }
            +"        ${RBuilder::row.name} { +\"1 of 3\" }"; br { }
            +"        ${colFun.name}(all = $enumName.${Sizes.SZ_6.name}) { +\"2 of 3 (wider)\" }"; br { }
            +"        ${colFun.name} { +\"3 of 3\" }"; br { }
            +"    }"; br { }
            +"    ${RBuilder::row.name} {"; br { }
            +"        ${colFun.name} { +\"1 of 3\" }"; br { }
            +"        ${colFun.name}(all = $enumName.${Sizes.SZ_5.name}) { +\"2 of 3 (wider)\" }"; br { }
            +"        ${colFun.name} { +\"3 of 3\" }"; br { }
            +"    }"; br {}
            +"}"
        }
    }
    contentTitle(RBuilder::h3) { +"Variable width content" }
    p {
        +"Use the "; code { +"$enumName.$autoName" }; +" enum value to size columns based on the natural width of their"
        +"content."
    }
    exampleRow {
        example {
            container {
                row(classes = "${ClassNames.JUSTIFY_CONTENT_MD_CENTER}") {
                    col(all = Sizes.EQ, lg = Sizes.SZ_2) { +"1 of 3" }
                    col(md = Sizes.AUTO) { +"Variable width content" }
                    col(all = Sizes.EQ, lg = Sizes.SZ_2) { +"3 of 3" }
                }
                row {
                    col { +"1 of 3" }
                    col(md = Sizes.AUTO) { +"Variable width content" }
                    col(all = Sizes.EQ, lg = Sizes.SZ_2) { +"3 of 3" }
                }
            }
        }
        kotlinExample {
            val sz2Name = Sizes.SZ_2.name
            val eqName = Sizes.EQ.name
            val classNames = ClassNames::class.simpleName
            val justifyName = ClassNames.JUSTIFY_CONTENT_MD_CENTER.name
            +"${RBuilder::container.name} {"; br { }
            +"    ${RBuilder::row.name}(classes = \"\$$classNames.$justifyName}\") {"; br { }
            +"        ${colFun.name}(all = $enumName.$eqName, lg = $enumName.$sz2Name) { +\"1 of 3\" }"; br { }
            +"        ${colFun.name}(md = $enumName.$autoName) { +\"Variable width content\" }"; br { }
            +"        ${colFun.name}(all = $enumName.$eqName, lg = $enumName.$sz2Name) { +\"3 of 3\" }"; br { }
            +"    }"; br { }
            +"    ${RBuilder::row.name} {"; br { }
            +"        ${colFun.name} { +\"1 of 3\"}"; br { }
            +"        ${colFun.name}(md = $enumName.$autoName) { +\"Variable width content\" }"; br { }
            +"        ${colFun.name}(all = $enumName.$eqName, lg = $enumName.$sz2Name) { +\"3 of 3\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
}
