package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.content.typography.toH3
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.exampleRow
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.br
import react.dom.code
import react.dom.p

fun RBuilder.autoLayoutColumns() {
    contentTitle { +"Auto-layout columns" }
    p {
        +"Utilize breakpoint-specific equal-size enum values for easy column sizing without an explicit numbered enum "
        +"value like "; code { +"${Sizes::class.simpleName}.${Sizes.SZ_6.name}" }; +"."
    }
    contentTitle { +"Equal-width"; toH3() }
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
                        col(all = Sizes.EQ) { +"$x of 2" }
                    }
                }
                row {
                    for (x in 1..3) {
                        col(all = Sizes.EQ) { +"$x of 3" }
                    }
                }
            }
        }
        kotlinExample {
            +"container {"; br { }
            +"    row {"; br { }
            +"        for (x in 1..2) {"; br { }
            +"            col { +\"\$x of 2\" }"; br { }
            +"            // Same as: col(all = ${Sizes::class.simpleName}.${Sizes.EQ.name}) { +\"\$x of 2\" }"; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    row {"; br { }
            +"        for (x in 1..3) {"; br { }
            +"            col { +\"\$x of 3\" }"; br { }
            +"            // Same as: col(all = ${Sizes::class.simpleName}.${Sizes.EQ.name}) { +\"\$x of 2\" }"; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
}
