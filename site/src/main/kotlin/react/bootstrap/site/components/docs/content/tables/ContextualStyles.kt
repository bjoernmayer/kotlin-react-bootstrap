package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.ContextualStyle
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.tr
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
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
        example {
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
        codeBox {
            ln { +"import react.bootstrap.content.tables.${ContextualStyle::class.simpleName}" }
            ln { +"import react.bootstrap.content.tables.table" }
            ln { +"import react.bootstrap.content.tables.td" }
            ln { +"import react.bootstrap.content.tables.tr" }
            ln { }
            ln { +"// On rows" }
            ln { +"tr(${ContextualStyle.ACTIVE.kt}) { ... }" }
            ln { }
            ln { +"tr(${ContextualStyle.PRIMARY.kt}) { ... }" }
            ln { +"tr(${ContextualStyle.SECONDARY.kt}) { ... }" }
            ln { +"tr(${ContextualStyle.SUCCESS.kt}) { ... }" }
            ln { +"tr(${ContextualStyle.DANGER.kt}) { ... }" }
            ln { +"tr(${ContextualStyle.WARNING.kt}) { ... }" }
            ln { +"tr(${ContextualStyle.INFO.kt}) { ... }" }
            ln { +"tr(${ContextualStyle.LIGHT.kt}) { ... }" }
            ln { +"tr(${ContextualStyle.DARK.kt}) { ... }" }
            ln { }
            ln { +"// On cells (`td` or `th`)" }
            ktBlock(0, "tr") { il ->
                ln(il) { +"td(${ContextualStyle.ACTIVE.kt}) { ... }" }
                ln { }
                ln(il) { +"td(${ContextualStyle.PRIMARY.kt}) { ... }" }
                ln(il) { +"td(${ContextualStyle.SECONDARY.kt}) { ... }" }
                ln(il) { +"td(${ContextualStyle.SUCCESS.kt}) { ... }" }
                ln(il) { +"td(${ContextualStyle.DANGER.kt}) { ... }" }
                ln(il) { +"td(${ContextualStyle.WARNING.kt}) { ... }" }
                ln(il) { +"td(${ContextualStyle.INFO.kt}) { ... }" }
                ln(il) { +"td(${ContextualStyle.LIGHT.kt}) { ... }" }
                ln(il) { +"td(${ContextualStyle.DARK.kt}) { ... }" }
            }
        }
        p {
            +"Regular table background variants are not available with the dark table"
        }
    }
}
