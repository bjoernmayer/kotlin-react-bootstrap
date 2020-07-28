package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.TABLE
import kotlinx.html.TR
import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.kt
import react.dom.RDOMBuilder
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr

internal data class ExampleRow(
    val first: String,
    val last: String,
    val handle: String
)

internal fun RDOMBuilder<TABLE>.defaultExample() {
    thead {
        tr {
            headerCells()
        }
    }
    tbody {
        exampleRows.forEachIndexed { key, example ->
            exampleRow(example, key)
        }
    }
}

internal fun CodeExampleBuilder.defaultExample() {
    ktFun(RBuilder::thead) {
        ktFun(RBuilder::tr) {
            headerCells()
        }
    }
    ktFun(RBuilder::tbody) {
        exampleRows.forEachIndexed { key, example ->
            exampleRow(example, key)
        }
    }
}

internal fun RDOMBuilder<TR>.headerCells() {
    th(ThScope.col) { +"#" }
    th(ThScope.col) { +"First" }
    th(ThScope.col) { +"Last" }
    th(ThScope.col) { +"Handle" }
}

internal fun CodeExampleBuilder.headerCells() {
    ktFun(
        RBuilder::th,
        style = FunStyle.INLINE_BLOCK,
        args = mapOf(null to ThScope.col.kt)
    ) { string("#") }
    ktFun(
        RBuilder::th,
        style = FunStyle.INLINE_BLOCK,
        args = mapOf(null to ThScope.col.kt)
    ) { string("First") }
    ktFun(
        RBuilder::th,
        style = FunStyle.INLINE_BLOCK,
        args = mapOf(null to ThScope.col.kt)
    ) { string("Last") }
    ktFun(
        RBuilder::th,
        style = FunStyle.INLINE_BLOCK,
        args = mapOf(null to ThScope.col.kt)
    ) { string("Handle") }
}

internal fun RBuilder.exampleRow(exampleRow: ExampleRow, index: Int) {
    tr {
        th(ThScope.row) { +"${index + 1}" }
        td { +exampleRow.first }
        td { +exampleRow.last }
        td { +exampleRow.handle }
    }
}

internal fun CodeExampleBuilder.exampleRow(exampleRow: ExampleRow, index: Int) {
    ktFun(RBuilder::tr) {
        ktFun(
            RBuilder::th,
            style = FunStyle.INLINE_BLOCK,
            args = mapOf(null to ThScope.row.kt)
        ) { string((index + 1).toString()) }
        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string(exampleRow.first) }
        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string(exampleRow.last) }
        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string(exampleRow.handle) }
    }
}

internal val exampleRows = listOf(
    ExampleRow("Mark", "Otto", "@mdo"),
    ExampleRow("Jacob", "Thornton", "@fat"),
    ExampleRow("Larry", "the Bird", "@twitter")
)
