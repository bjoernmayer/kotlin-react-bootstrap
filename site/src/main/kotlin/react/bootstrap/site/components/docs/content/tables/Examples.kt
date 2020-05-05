@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr

internal class Examples : SectionComponent() {
    override val title: String = "Examples"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
            Due to the widespread use of tables across third-party widgets like calendars and date pickers, Bootstrap
            has designed their tables to be <opt-in|strong>. Just use the <table { }|code> extension function provided
            with this library with its various arguments to modify the table.
        """.trimIndent()
        }
        formattedText {
            """
            Using the most basic table markup, here’s how <table { }|code>-based tables look in Bootstrap. <All table
            styles are inherited in Bootstrap 4|strong>, meaning any nested tables will be styled in the same manner as
            the parent.
        """.trimIndent()
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
            ln { +"import react.bootstrap.content.tables.table" }
            ln { }
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
        formattedText {
            """
                You can also invert the colors - with light text on dark background - by setting
                <table(dark = true)|code>.
            """.trimIndent()
        }
        example {
            table(dark = true) {
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
            ktBlock(opener = "table(dark = true)") { il ->
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
}
