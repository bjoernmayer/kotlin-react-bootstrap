package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ItemsYs
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
}
