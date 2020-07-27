package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.ContextualStyle
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.tr
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.kt
import react.dom.p
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead

internal class ContextualStyles : SectionComponent() {
    override val title: String = "Contextual styles"

    override fun RBuilder.render() {
        sectionTitle(section)
        p {
            +"Use contextual styles to color table rows or individual cells."
        }

        liveExample {
            table {
                thead {
                    tr {
                        th(ThScope.col) { +"Class" }
                        th(ThScope.col) { +"Heading" }
                        th(ThScope.col) { +"Heading" }
                    }
                }
                tbody {
                    tr {
                        th(ThScope.row) { +"Default" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    ContextualStyle.values().forEach {
                        tr(it) {
                            th(ThScope.row) { +it.name.toLowerCase().capitalize() }
                            td { +"Cell" }
                            td { +"Cell" }
                        }
                    }
                }
            }
        }
        codeExample {
            import("content.tables.${ContextualStyle::class.simpleName}")
            import("content.tables.table")
            import("content.tables.td")
            import("content.tables.tr")
            ln { }
            ln { +"// On rows" }
            ContextualStyle.values().forEach {
                ktFun(RBuilder::tr, style = FunStyle.INLINE_BLOCK, args = mapOf(null to it.kt)) { string("...") }
            }
            ln { }
            ln { +"// On cells (`td` or `th`)" }
            ktFun(RBuilder::tr) {
                ContextualStyle.values().forEach {
                    ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK, args = mapOf(null to it.kt)) { string("...") }
                }
            }
        }
        p {
            +"Regular table background variants are not available with the dark table"
        }
    }
}
