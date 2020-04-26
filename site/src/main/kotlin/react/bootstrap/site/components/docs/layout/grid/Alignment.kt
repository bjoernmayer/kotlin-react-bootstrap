package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Alignments
import react.bootstrap.layout.grid.ItemsXs
import react.bootstrap.layout.grid.ItemsYs
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.colFun
import react.bootstrap.site.components.docs.containerFun
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.exampleRow
import react.bootstrap.site.components.docs.fixings.flexColsExampleRow
import react.bootstrap.site.components.docs.fixings.kotlinExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.rowFun
import react.dom.a
import react.dom.br
import react.dom.code
import react.dom.h3
import react.dom.p
import react.dom.strong

fun RBuilder.alignment() {
    contentTitle("Alignment") { }
    p {
        +"Use flexbox alignment utilities to vertically and horizontally align columns. "
        strong {
            +"Internet Explorer 10-11 do not support vertical alignment of flex items when the flex container has "
            +"a "; code { +"min-height" }; +" as shown below. "
        }
        a(href = "https://github.com/philipwalton/flexbugs#flexbug-3") { +" See Flexbugs #3 for more details" }; +"."
    }
    contentTitle(RBuilder::h3, "Vertical alignment") { }
    flexColsExampleRow {
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
            +"$containerFun {"; br { }
            +"    $rowFun(all = ${ItemsYs.START.kt}) {"; br { }
            for (x in 1..3) {
                +"        $colFun { +\"One of three columns\" }"; br { }
            }
            +"    }"; br { }
            +"    $rowFun(all = ${ItemsYs.CENTER.kt}) {"; br { }
            for (x in 1..3) {
                +"        $colFun { +\"One of three columns\" }"; br { }
            }
            +"    }"; br { }
            +"    $rowFun(all = ${ItemsYs.END.kt}) {"; br { }
            for (x in 1..3) {
                +"        $colFun { +\"One of three columns\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
    flexColsExampleRow {
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
            +"$containerFun {"; br { }
            +"    $rowFun {"; br { }
            +"        $colFun(all = ${Alignments.START.kt}) { +\"One of three columns\" }"; br { }
            +"        $colFun(all = ${Alignments.CENTER.kt}) { +\"One of three columns\" }"; br { }
            +"        $colFun(all = ${Alignments.END.kt}) { +\"One of three columns\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3, "Horizontal alignment") { }
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
            +"$containerFun {"; br { }
            +"    $rowFun(all = ${ItemsXs.START.kt}) { "; br { }
            for (x in 1..2) {
                +"        $colFun(all = $sizes.${Sizes.SZ_4}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"    $rowFun(all = ${ItemsXs.CENTER.kt}) { "; br { }
            for (x in 1..2) {
                +"        $colFun(all = $sizes.${Sizes.SZ_4}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"    $rowFun(all = ${ItemsXs.END.kt}) { "; br { }
            for (x in 1..2) {
                +"        $colFun(all = $sizes.${Sizes.SZ_4}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"    $rowFun(all = ${ItemsXs.AROUND.kt}) { "; br { }
            for (x in 1..2) {
                +"        $colFun(all = $sizes.${Sizes.SZ_4}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"    $rowFun(all = ${ItemsXs.BETWEEN.kt}) { "; br { }
            for (x in 1..2) {
                +"        $colFun(all = $sizes.${Sizes.SZ_4}) { +\"One of two columns\" }"; br { }
            }
            +"    }"; br { }
            +"}"
        }
    }
}
