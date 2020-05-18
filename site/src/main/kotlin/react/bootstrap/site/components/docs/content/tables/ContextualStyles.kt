package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.ContextualStyle
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.tr
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktF
import react.bootstrap.site.components.docs.fixings.ktIF
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
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
                    tr(ContextualStyle.ACTIVE) {
                        th(ThScope.row) { +"Active" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    tr {
                        th(ThScope.row) { +"Default" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    tr(ContextualStyle.PRIMARY) {
                        th(ThScope.row) { +"Primary" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    tr(ContextualStyle.SECONDARY) {
                        th(ThScope.row) { +"Secondary" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    tr(ContextualStyle.SUCCESS) {
                        th(ThScope.row) { +"Success" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    tr(ContextualStyle.DANGER) {
                        th(ThScope.row) { +"Danger" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    tr(ContextualStyle.WARNING) {
                        th(ThScope.row) { +"Warning" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    tr(ContextualStyle.INFO) {
                        th(ThScope.row) { +"Info" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    tr(ContextualStyle.LIGHT) {
                        th(ThScope.row) { +"Light" }
                        td { +"Cell" }
                        td { +"Cell" }
                    }
                    tr(ContextualStyle.DARK) {
                        th(ThScope.row) { +"Dark" }
                        td { +"Cell" }
                        td { +"Cell" }
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
            ktIF(0, RBuilder::tr, ContextualStyle.ACTIVE.kt, "...")
            ln { }
            ktIF(0, RBuilder::tr, ContextualStyle.PRIMARY.kt, "...")
            ktIF(0, RBuilder::tr, ContextualStyle.SECONDARY.kt, "...")
            ktIF(0, RBuilder::tr, ContextualStyle.SUCCESS.kt, "...")
            ktIF(0, RBuilder::tr, ContextualStyle.DANGER.kt, "...")
            ktIF(0, RBuilder::tr, ContextualStyle.WARNING.kt, "...")
            ktIF(0, RBuilder::tr, ContextualStyle.INFO.kt, "...")
            ktIF(0, RBuilder::tr, ContextualStyle.LIGHT.kt, "...")
            ktIF(0, RBuilder::tr, ContextualStyle.DARK.kt, "...")
            ln { }
            ln { +"// On cells (`td` or `th`)" }
            ktF(0, RBuilder::tr) {
                ktIF(it, RBuilder::td, ContextualStyle.ACTIVE.kt, "...")
                ln { }
                ktIF(it, RBuilder::td, ContextualStyle.PRIMARY.kt, "...")
                ktIF(it, RBuilder::td, ContextualStyle.SECONDARY.kt, "...")
                ktIF(it, RBuilder::td, ContextualStyle.SUCCESS.kt, "...")
                ktIF(it, RBuilder::td, ContextualStyle.DANGER.kt, "...")
                ktIF(it, RBuilder::td, ContextualStyle.WARNING.kt, "...")
                ktIF(it, RBuilder::td, ContextualStyle.INFO.kt, "...")
                ktIF(it, RBuilder::td, ContextualStyle.LIGHT.kt, "...")
                ktIF(it, RBuilder::td, ContextualStyle.DARK.kt, "...")
            }
        }
        p {
            +"Regular table background variants are not available with the dark table"
        }
    }
}
