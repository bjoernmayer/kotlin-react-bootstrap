@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.THeadStyles
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.thead
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktF
import react.bootstrap.site.components.docs.fixings.ktIF
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.tr

internal class TableHeadOptions : SectionComponent() {
    override val title: String = "Table head options"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Similar to tables and dark tables, use the `thead(style)`-argument to make table headers appear light or dark gray.
            """
        }
        liveExample {
            table {
                thead(THeadStyles.DARK) {
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

            table {
                thead(THeadStyles.LIGHT) {
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
            import("content.tables.${THeadStyles::class.simpleName}")
            import("content.tables.table")
            import("content.tables.thead")
            ln { }
            ktF(0, RBuilder::table) {
                ktF(it, RBuilder::thead, THeadStyles.DARK.kt) {
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
            ln { }
            ktF(0, RBuilder::table) {
                ktB(opener = "table") {
                    ktF(it, RBuilder::thead, THeadStyles.LIGHT.kt) {
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
}
