@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.table
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.br
import react.dom.code
import react.dom.p
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr

internal fun RBuilder.examples() {
    contentTitle("Examples")
    p {
        +"Due to the widespread use of tables across third-party widgets like calendars and date pickers, Bootstrap has"
        +"designed their tables to be opt-in. Just use the this package's "; code { +"table { }" }; +" with its various"
        +" arguments to modify the table."
    }
    p {
        +"Using this package's "; code { +"table { }" }; +" without arguments, here’s how such tables look in Bootstrap"
        +". All table styles are inherited in Bootstrap 4, meaning any nested tables will be styled in the same manner "
        +"as the parent."
    }
    example {
        table {
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
        ln { +"import react.bootstrap.content.table" }
        br { }
        ktBlock(opener = "table") { il ->
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
