@file:Suppress("DuplicatedCode", "NAME_SHADOWING")

package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.code
import react.dom.p
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr

internal fun RBuilder.hoverableRows() {
    contentTitle("Hoverable Rows")
    p {
        +"Set the "; code { +"table(hoverable)" }; +"-argument to "; code { +"true" }; +" to enable a hover state on "
        +"table rows within a tbody."
    }
    example {
        table(hoverable = true) {
            thead {
                tr {
                    th(ThScope.col) { +"#" }
                    th(ThScope.col) { +"First" }
                    th(ThScope.col) { +"Last" }
                    th(ThScope.col) { +"Handle" }
                }
            }
            tbody {
                tr {
                    th(ThScope.row) { +"1" }
                    td { +"Mark" }
                    td { +"Otto" }
                    td { +"@mdo" }
                }
                tr {
                    th(ThScope.row) { +"2" }
                    td { +"Jacob" }
                    td { +"Thornton" }
                    td { +"@fat" }
                }
                tr {
                    th(ThScope.row) { +"3" }
                    td { +"Larry" }
                    td { +"the Bird" }
                    td { +"@twitter" }
                }
            }
        }

        table(hoverable = true, dark = true) {
            thead {
                tr {
                    th(ThScope.col) { +"#" }
                    th(ThScope.col) { +"First" }
                    th(ThScope.col) { +"Last" }
                    th(ThScope.col) { +"Handle" }
                }
            }
            tbody {
                tr {
                    th(ThScope.row) { +"1" }
                    td { +"Mark" }
                    td { +"Otto" }
                    td { +"@mdo" }
                }
                tr {
                    th(ThScope.row) { +"2" }
                    td { +"Jacob" }
                    td { +"Thornton" }
                    td { +"@fat" }
                }
                tr {
                    th(ThScope.row) { +"3" }
                    td { +"Larry" }
                    td { +"the Bird" }
                    td { +"@twitter" }
                }
            }
        }
    }
    codeBox {
        ln { +"import react.bootstrap.content.tables.table" }
        ln { }
        ktBlock(opener = "table(hoverable = true)") { il ->
            ktBlock(il, "thead") { il ->
                ktBlock(il, "tr") { il ->
                    ln(il) { +"th(ThScope.col) { +\"#\" }" }
                    ln(il) { +"th(ThScope.col) { +\"First\" }" }
                    ln(il) { +"th(ThScope.col) { +\"Last\" }" }
                    ln(il) { +"th(ThScope.col) { +\"Handle\" }" }
                }
            }
            ktBlock(il, "tbody") { il ->
                ktBlock(il, "tr") { il ->
                    ln(il) { +"th(ThScope.row) { +\"1\" }" }
                    ln(il) { +"td { +\"Mark\" }" }
                    ln(il) { +"td { +\"Otto\" }" }
                    ln(il) { +"td { +\"@mdo\" }" }
                }
                ktBlock(il, "tr") { il ->
                    ln(il) { +"th(ThScope.row) { +\"2\" }" }
                    ln(il) { +"td { +\"Jacob\" }" }
                    ln(il) { +"td { +\"Thornton\" }" }
                    ln(il) { +"td { +\"@fat\" }" }
                }
                ktBlock(il, "tr") { il ->
                    ln(il) { +"th(ThScope.row) { +\"3\" }" }
                    ln(il) { +"td { +\"Larry\" }" }
                    ln(il) { +"td { +\"the Bird\" }" }
                    ln(il) { +"td { +\"@twitter\" }" }
                }
            }
        }
        ln { }
        ktBlock(opener = "table(hoverable = true, dark = true)") { il ->
            ktBlock(il, "thead") { il ->
                ktBlock(il, "tr") { il ->
                    ln(il) { +"th(ThScope.col) { +\"#\" }" }
                    ln(il) { +"th(ThScope.col) { +\"First\" }" }
                    ln(il) { +"th(ThScope.col) { +\"Last\" }" }
                    ln(il) { +"th(ThScope.col) { +\"Handle\" }" }
                }
            }
            ktBlock(il, "tbody") { il ->
                ktBlock(il, "tr") { il ->
                    ln(il) { +"th(ThScope.row) { +\"1\" }" }
                    ln(il) { +"td { +\"Mark\" }" }
                    ln(il) { +"td { +\"Otto\" }" }
                    ln(il) { +"td { +\"@mdo\" }" }
                }
                ktBlock(il, "tr") { il ->
                    ln(il) { +"th(ThScope.row) { +\"2\" }" }
                    ln(il) { +"td { +\"Jacob\" }" }
                    ln(il) { +"td { +\"Thornton\" }" }
                    ln(il) { +"td { +\"@fat\" }" }
                }
                ktBlock(il, "tr") { il ->
                    ln(il) { +"th(ThScope.row) { +\"3\" }" }
                    ln(il) { +"td { +\"Larry\" }" }
                    ln(il) { +"td { +\"the Bird\" }" }
                    ln(il) { +"td { +\"@twitter\" }" }
                }
            }
        }
    }
}
