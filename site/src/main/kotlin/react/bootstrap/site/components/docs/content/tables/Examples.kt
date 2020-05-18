@file:Suppress("NAME_SHADOWING", "DuplicatedCode", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktF
import react.bootstrap.site.components.docs.fixings.ktIF
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr

internal class Examples : SectionComponent() {
    override val title: String = "Examples"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Due to the widespread use of tables across third-party widgets like calendars and date pickers, Bootstrap has designed
their tables to be __opt-in__. Just use the `table { }` extension function provided with this library with its various
arguments to modify the table.
            """
        }
        Markdown {
            //language=Markdown
            +"""
Using the most basic table markup, here’s how `table { }`-based tables look in Bootstrap. __All table styles are
inherited in Bootstrap 4__, meaning any nested tables will be styled in the same manner as the parent.
            """
        }
        liveExample {
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
        codeExample {
            import("content.tables.table")
            ln { }
            ktF(0, RBuilder::table) {
                ktF(it, RBuilder::thead) {
                    ktF(it, RBuilder::tr) {
                        ktIF(it, RBuilder::th, ThScope.col.kt, "+\"#\"")
                        ktIF(it, RBuilder::th, ThScope.col.kt, "+\"First\"")
                        ktIF(it, RBuilder::th, ThScope.col.kt, "+\"Last\"")
                        ktIF(it, RBuilder::th, ThScope.col.kt, "+\"Handle\"")
                    }
                }
                ktF(it, RBuilder::tbody) {
                    ktF(it, RBuilder::tr) {
                        ktIF(it, RBuilder::th, ThScope.row.kt, "+\"1\"")
                        ktIF(it, RBuilder::td, "+\"Mark\"")
                        ktIF(it, RBuilder::td, "+\"Otto\"")
                        ktIF(it, RBuilder::td, "+\"@mdo\"")
                    }
                    ktF(it, RBuilder::tr) {
                        ktIF(it, RBuilder::th, ThScope.row.kt, "+\"2\"")
                        ktIF(it, RBuilder::td, "+\"Jacob\"")
                        ktIF(it, RBuilder::td, "+\"Thornton\"")
                        ktIF(it, RBuilder::td, "+\"@fat\"")
                    }
                    ktF(it, RBuilder::tr) {
                        ktIF(it, RBuilder::th, ThScope.row.kt, "+\"3\"")
                        ktIF(it, RBuilder::td, "+\"Larry\"")
                        ktIF(it, RBuilder::td, "+\"the Bird\"")
                        ktIF(it, RBuilder::td, "+\"@twitter\"")
                    }
                }
            }
        }
        Markdown {
            //language=Markdown
            +"""
You can also invert the colors - with light text on dark background - by setting `table(dark = true)`.
            """
        }
        liveExample {
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
        codeExample {
            import("content.tables.table")
            ln { }
            ktF(0, RBuilder::table, "dark" to true) {
                ktF(it, RBuilder::thead) {
                    ktF(it, RBuilder::tr) {
                        ktIF(it, RBuilder::th, ThScope.col.kt, "+\"#\"")
                        ktIF(it, RBuilder::th, ThScope.col.kt, "+\"First\"")
                        ktIF(it, RBuilder::th, ThScope.col.kt, "+\"Last\"")
                        ktIF(it, RBuilder::th, ThScope.col.kt, "+\"Handle\"")
                    }
                }
                ktF(it, RBuilder::tbody) {
                    ktF(it, RBuilder::tr) {
                        ktIF(it, RBuilder::th, ThScope.row.kt, "+\"1\"")
                        ktIF(it, RBuilder::td, "+\"Mark\"")
                        ktIF(it, RBuilder::td, "+\"Otto\"")
                        ktIF(it, RBuilder::td, "+\"@mdo\"")
                    }
                    ktF(it, RBuilder::tr) {
                        ktIF(it, RBuilder::th, ThScope.row.kt, "+\"2\"")
                        ktIF(it, RBuilder::td, "+\"Jacob\"")
                        ktIF(it, RBuilder::td, "+\"Thornton\"")
                        ktIF(it, RBuilder::td, "+\"@fat\"")
                    }
                    ktF(it, RBuilder::tr) {
                        ktIF(it, RBuilder::th, ThScope.row.kt, "+\"3\"")
                        ktIF(it, RBuilder::td, "+\"Larry\"")
                        ktIF(it, RBuilder::td, "+\"the Bird\"")
                        ktIF(it, RBuilder::td, "+\"@twitter\"")
                    }
                }
            }
        }
    }
}
