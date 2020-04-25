package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Alignments
import react.bootstrap.layout.grid.ItemsXs
import react.bootstrap.layout.grid.ItemsYs
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.ColFun
import react.bootstrap.site.components.docs.RowFun
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.exampleRow
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.a
import react.dom.br
import react.dom.code
import react.dom.h3
import react.dom.p
import react.dom.strong

fun RBuilder.alignment() {
    val rowFun: RowFun = RBuilder::row
    val colFun: ColFun = RBuilder::col
    contentTitle { +"Alignment" }
    p {
        +"Use flexbox alignment utilities to vertically and horizontally align columns. "
        strong {
            +"Internet Explorer 10-11 do not support vertical alignment of flex items when the flex container has "
            +"a "; code { +"min-height" }; +" as shown below. "
        }
        a(href = "https://github.com/philipwalton/flexbugs#flexbug-3") { +" See Flexbugs #3 for more details" }; +"."
    }
    contentTitle(RBuilder::h3) { +"Vertical alignment" }
    exampleRow("bd-example-row-flex-cols") {
        example {
            container {
                row(all = ItemsYs.START) {
                    for (x in 1..3) {
                        col { +"One of three columns" }
                    }
                }
                row(all = ItemsYs.CENTER) {
                    for (x in 1..3) {
                        col { +"One of three columns" }
                    }
                }
                row(all = ItemsYs.END) {
                    for (x in 1..3) {
                        col { +"One of three columns" }
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name}(all = ${ItemsYs::class.simpleName}.${ItemsYs.START.name}) {"; br { }
            for (x in 1..3) {
                +"        ${colFun.name} { +\"One of three columns\" }"; br { }
            }
            +"    }"; br { }
            +"    ${rowFun.name}(all = ${ItemsYs::class.simpleName}.${ItemsYs.CENTER.name}) {"; br { }
            for (x in 1..3) {
                +"        ${colFun.name} { +\"One of three columns\" }"; br { }
            }
            +"    }"; br { }
            +"    ${rowFun.name}(all = ${ItemsYs::class.simpleName}.${ItemsYs.END.name}) {"; br { }
            for (x in 1..3) {
                +"        ${colFun.name} { +\"One of three columns\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    exampleRow("bd-example-row-flex-cols") {
        example {
            container {
                row {
                    col(all = Alignments.START) { +"One of three columns" }
                    col(all = Alignments.CENTER) { +"One of three columns" }
                    col(all = Alignments.END) { +"One of three columns" }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        ${colFun.name}(all = ${Alignments::class.simpleName}.${Alignments.START.name}) { +\"One of "
            +"three columns\" }"; br { }
            +"        ${colFun.name}(all = ${Alignments::class.simpleName}.${Alignments.CENTER.name}) { +\"One of "
            +"three columns\" }"; br { }
            +"        ${colFun.name}(all = ${Alignments::class.simpleName}.${Alignments.END.name}) { +\"One of "
            +"three columns\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3) { +"Horizontal alignment" }
    exampleRow {
        example {
            container {
                row(all = ItemsXs.START) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
                row(all = ItemsXs.CENTER) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
                row(all = ItemsXs.END) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
                row(all = ItemsXs.AROUND) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
                row(all = ItemsXs.BETWEEN) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
            }
        }
        val sizes = Sizes::class.simpleName
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name}(all = ${ItemsXs::class.simpleName}.${ItemsXs.START.name}) { "; br { }
            for (x in 1..2) {
                +"        ${colFun.name}(all = $sizes.${Sizes.SZ_4.name}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"    ${rowFun.name}(all = ${ItemsXs::class.simpleName}.${ItemsXs.CENTER.name}) { "; br { }
            for (x in 1..2) {
                +"        ${colFun.name}(all = $sizes.${Sizes.SZ_4.name}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"    ${rowFun.name}(all = ${ItemsXs::class.simpleName}.${ItemsXs.END.name}) { "; br { }
            for (x in 1..2) {
                +"        ${colFun.name}(all = $sizes.${Sizes.SZ_4.name}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"    ${rowFun.name}(all = ${ItemsXs::class.simpleName}.${ItemsXs.AROUND.name}) { "; br { }
            for (x in 1..2) {
                +"        ${colFun.name}(all = $sizes.${Sizes.SZ_4.name}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"    ${rowFun.name}all = ${ItemsXs::class.simpleName}.${ItemsXs.BETWEEN.name}) { "; br { }
            for (x in 1..2) {
                +"        ${colFun.name}(all = $sizes.${Sizes.SZ_4.name}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
}
