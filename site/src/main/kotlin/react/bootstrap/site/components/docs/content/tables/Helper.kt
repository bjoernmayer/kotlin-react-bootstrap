package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.TABLE
import kotlinx.html.TR
import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.lib.codepoet.FunCall
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

internal fun CodeExampleBuilder.defaultExample() = buildString {
    append(
        FunCall.builder(RBuilder::thead)
            .setLambdaArgument(
                FunCall.builder(RBuilder::tr)
                    .setLambdaArgument(
                        headerCells()
                    )
                    .build()
            )
            .build()
    )
    append(
        FunCall.builder(RBuilder::tbody)
            .setLambdaArgument(
                buildString {
                    exampleRows.forEachIndexed { key, example ->
                        append(exampleRow(example, key))
                    }
                }
            )
            .build()
    )
}

internal fun RDOMBuilder<TR>.headerCells() {
    listOf(
        "#",
        "First",
        "Last",
        "Handle"
    ).forEach {
        th(ThScope.col) { +it }
    }
}

internal fun CodeExampleBuilder.headerCells() =
    listOf(
        "#",
        "First",
        "Last",
        "Handle"
    ).joinToString("\n") { content ->
        FunCall.builder(RBuilder::th, FunCall.Style.INLINE)
            .addArgument(ThScope.col)
            .setLambdaArgument(plusString(content))
            .build()
    }

internal fun RBuilder.exampleRow(exampleRow: ExampleRow, index: Int) {
    tr {
        th(ThScope.row) { +"${index + 1}" }
        td { +exampleRow.first }
        td { +exampleRow.last }
        td { +exampleRow.handle }
    }
}

internal fun CodeExampleBuilder.exampleRow(exampleRow: ExampleRow, index: Int) =
    FunCall.builder(RBuilder::tr)
        .setLambdaArgument(
            FunCall.builder(RBuilder::th, FunCall.Style.INLINE)
                .addArgument(ThScope.row)
                .setLambdaArgument(plusString((index + 1).toString()))
                .build(),
            "\n",
            listOf(exampleRow.first, exampleRow.last, exampleRow.handle).joinToString("\n") { content ->
                FunCall.builder(RBuilder::td, FunCall.Style.INLINE)
                    .setLambdaArgument(plusString(content))
                    .build()
            }
        )
        .build()

internal val exampleRows = listOf(
    ExampleRow("Mark", "Otto", "@mdo"),
    ExampleRow("Jacob", "Thornton", "@fat"),
    ExampleRow("Larry", "the Bird", "@twitter")
)
