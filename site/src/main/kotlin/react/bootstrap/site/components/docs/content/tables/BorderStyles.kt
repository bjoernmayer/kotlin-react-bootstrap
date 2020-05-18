@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.BorderStyles
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

internal class BorderStyles : SectionComponent() {
    override val title: String = "Border styles"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Use the `table(borderStyle)`-argument with the value `${BorderStyles.BORDERED.kt}` to get borders on all sides of the
table and cells. Or set the value to `${BorderStyles.BORDERLESS.kt}` for a table without borders.
            """
        }
        liveExample {
            table(borderStyle = BorderStyles.BORDERED) {
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

            table(borderStyle = BorderStyles.BORDERED, dark = true) {
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

            table(borderStyle = BorderStyles.BORDERLESS) {
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

            table(borderStyle = BorderStyles.BORDERLESS, dark = true) {
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
            import("content.tables.${BorderStyles::class.simpleName}")
            import("content.tables.table")
            ln { }
            ktF(0, RBuilder::table, "borderStyle" to BorderStyles.BORDERED.kt) {
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
            ln { }
            ktF(0, RBuilder::table, "borderStyle" to BorderStyles.BORDERED.kt, "dark" to true) {
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
            ln { }
            ktF(0, RBuilder::table, "borderStyle" to BorderStyles.BORDERLESS.kt) {
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
            ln { }
            ktF(0, RBuilder::table, "borderStyle" to BorderStyles.BORDERLESS.kt, "dark" to true) {
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
