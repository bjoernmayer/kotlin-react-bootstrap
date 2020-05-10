@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.formattedText
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr

internal class HoverableRows : SectionComponent() {
    override val title: String = "Hoverable Rows"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
                Set the <table(hoverable)|code>-argument to <true|code> to enable a hover state on table rows within a
                tbody.
            """.trimIndent()
        }
        liveExample {
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
        codeExample {
            import("content.tables.table")
            ln { }
            ktB(0, "table", "hoverable" to "true") {
                ktB(it, "thead") {
                    ktB(it, "tr") {
                        ktIB(it, "th", "ThScope.col", "+\"#\"")
                        ktIB(it, "th", "ThScope.col", "+\"First\"")
                        ktIB(it, "th", "ThScope.col", "+\"Last\"")
                        ktIB(it, "th", "ThScope.col", "+\"Handle\"")
                    }
                }
                ktB(it, "tbody") {
                    ktB(it, "tr") {
                        ktIB(it, "th", "ThScope.row", "+\"1\"")
                        ktIB(it, "td", "+\"Mark\"")
                        ktIB(it, "td", "+\"Otto\"")
                        ktIB(it, "td", "+\"@mdo\"")
                    }
                    ktB(it, "tr") {
                        ktIB(it, "th", "ThScope.row", "+\"2\"")
                        ktIB(it, "td", "+\"Jacob\"")
                        ktIB(it, "td", "+\"Thornton\"")
                        ktIB(it, "td", "+\"@fat\"")
                    }
                    ktB(it, "tr") {
                        ktIB(it, "th", "ThScope.row", "+\"3\"")
                        ktIB(it, "td", "+\"Larry\"")
                        ktIB(it, "td", "+\"the Bird\"")
                        ktIB(it, "td", "+\"@twitter\"")
                    }
                }
            }
            ln { }
            ktB(0, "table", "hoverable" to "true", "dark" to "true") {
                ktB(it, "thead") {
                    ktB(it, "tr") {
                        ktIB(it, "th", "ThScope.col", "+\"#\"")
                        ktIB(it, "th", "ThScope.col", "+\"First\"")
                        ktIB(it, "th", "ThScope.col", "+\"Last\"")
                        ktIB(it, "th", "ThScope.col", "+\"Handle\"")
                    }
                }
                ktB(it, "tbody") {
                    ktB(it, "tr") {
                        ktIB(it, "th", "ThScope.row", "+\"1\"")
                        ktIB(it, "td", "+\"Mark\"")
                        ktIB(it, "td", "+\"Otto\"")
                        ktIB(it, "td", "+\"@mdo\"")
                    }
                    ktB(it, "tr") {
                        ktIB(it, "th", "ThScope.row", "+\"2\"")
                        ktIB(it, "td", "+\"Jacob\"")
                        ktIB(it, "td", "+\"Thornton\"")
                        ktIB(it, "td", "+\"@fat\"")
                    }
                    ktB(it, "tr") {
                        ktIB(it, "th", "ThScope.row", "+\"3\"")
                        ktIB(it, "td", "+\"Larry\"")
                        ktIB(it, "td", "+\"the Bird\"")
                        ktIB(it, "td", "+\"@twitter\"")
                    }
                }
            }
        }
    }
}
