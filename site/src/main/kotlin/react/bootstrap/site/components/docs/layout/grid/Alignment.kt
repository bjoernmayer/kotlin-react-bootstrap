@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Alignments
import react.bootstrap.layout.grid.ItemsXs
import react.bootstrap.layout.grid.ItemsYs
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.exampleRow
import react.bootstrap.site.components.docs.fixings.flexColsExampleRow
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.ln
import react.dom.a
import react.dom.h3
import react.dom.p

internal fun RBuilder.alignment() {
    contentTitle("Alignment")
    formattedText {
        """
            Use flexbox alignment utilities to vertically and horizontally align columns. <Internet Explorer 10-11 do
            not support vertical alignment of flex items when the flex container has a |strong><min-height|code>< as
            shown below. |strong>
        """.trimIndent()
    }
    p {
        a(href = "https://github.com/philipwalton/flexbugs#flexbug-3") { +" See Flexbugs #3 for more details" }; +"."
    }
    contentTitle(RBuilder::h3, "Vertical alignment")
    flexColsExampleRow {
        example {
            container {
                row(all = ItemsYs.START) {
                    for (x in 1..3) {
                        col { +"One of three columns" }
                    }
                }
                row(all = ItemsYs.CENTER) {
                    for (x in 1..3) {
                        col { +"One of three columns" }
                    }
                }
                row(all = ItemsYs.END) {
                    for (x in 1..3) {
                        col { +"One of three columns" }
                    }
                }
            }
        }
        codeBox {
            containerFunImport()
            gridEnumImport(ItemsYs::class)
            colFunImport()
            rowFunImport()
            ln { }
            ktContainer { il ->
                ktBlock(il, "$rowFun(all = ${ItemsYs.START.kt})") { il ->
                    for (x in 1..3) {
                        ln(il) { +"$colFun { +\"One of three columns\" }" }
                    }
                }
                ktBlock(il, "$rowFun(all = ${ItemsYs.CENTER.kt})") { il ->
                    for (x in 1..3) {
                        ln(il) { +"$colFun { +\"One of three columns\" }" }
                    }
                }
                ktBlock(il, "$rowFun(all = ${ItemsYs.END.kt})") { il ->
                    for (x in 1..3) {
                        ln(il) { +"$colFun { +\"One of three columns\" }" }
                    }
                }
            }
        }
    }
    flexColsExampleRow {
        example {
            container {
                row {
                    col(all = Alignments.START) { +"One of three columns" }
                    col(all = Alignments.CENTER) { +"One of three columns" }
                    col(all = Alignments.END) { +"One of three columns" }
                }
            }
        }
        codeBox {
            containerFunImport()
            gridEnumImport(Alignments::class)
            colFunImport()
            rowFunImport()
            ln { }
            ktConRow { il ->
                ln(il) { +"$colFun(all = ${Alignments.START.kt}) { +\"One of three columns\" }" }
                ln(il) { +"$colFun(all = ${Alignments.CENTER.kt}) { +\"One of three columns\" }" }
                ln(il) { +"$colFun(all = ${Alignments.END.kt}) { +\"One of three columns\" }" }
            }
        }
    }
    contentTitle(RBuilder::h3, "Horizontal alignment")
    exampleRow {
        example {
            container {
                row(all = ItemsXs.START) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
                row(all = ItemsXs.CENTER) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
                row(all = ItemsXs.END) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
                row(all = ItemsXs.AROUND) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
                row(all = ItemsXs.BETWEEN) {
                    for (x in 1..2) {
                        col(all = Sizes.SZ_4) { +"One of two columns" }
                    }
                }
            }
        }
        codeBox {
            containerFunImport()
            gridEnumImport(ItemsXs::class)
            gridEnumImport(Sizes::class)
            colFunImport()
            rowFunImport()
            ln { }
            ktContainer { il ->
                ktBlock(il, "rowFun(all = ${ItemsXs.START.kt})") { il ->
                    for (x in 1..2) {
                        ln(il) { +"$colFun(all = ${Sizes.SZ_4.kt}) { +\"One of two columns\" }" }
                    }
                }
                ktBlock(il, "$rowFun(all = ${ItemsXs.CENTER.kt})") { il ->
                    for (x in 1..2) {
                        ln(il) { +"$colFun(all = ${Sizes.SZ_4.kt}) { +\"One of two columns\" }" }
                    }
                }
                ktBlock(il, "$rowFun(all = ${ItemsXs.END.kt})") { il ->
                    for (x in 1..2) {
                        ln(il) { +"$colFun(all = ${Sizes.SZ_4.kt}) { +\"One of two columns\" }" }
                    }
                }
                ktBlock(il, "$rowFun(all = ${ItemsXs.AROUND.kt})") { il ->
                    for (x in 1..2) {
                        ln(il) { +"$colFun(all = ${Sizes.SZ_4.kt}) { +\"One of two columns\" }" }
                    }
                }
                ktBlock(il, "$rowFun(all = ${ItemsXs.BETWEEN.kt})") { il ->
                    for (x in 1..2) {
                        ln(il) { +"$colFun(all = ${Sizes.SZ_4.kt}) { +\"One of two columns\" }" }
                    }
                }
            }
        }
    }
}
