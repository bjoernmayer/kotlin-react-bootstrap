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

internal class StripedRows : SectionComponent() {
    override val title: String = "Striped rows"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            "Use the <table(striped)|code>-argument to add zebra-striping to any table row within the tbody."
        }
        liveExample {
            table(striped = true) {
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
            ktB(0, "table", "striped = true") {
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
