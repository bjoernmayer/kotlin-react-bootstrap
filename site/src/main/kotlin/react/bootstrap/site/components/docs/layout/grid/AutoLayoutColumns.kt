@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.classNamesImport
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.exampleRow
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.ln
import react.dom.h3
import react.dom.p

internal fun RBuilder.autoLayoutColumns() {
    contentTitle("Auto-layout columns")
    formattedText {
        """
            Utilize breakpoint-specific equal-size enum values for easy column sizing without an explicit numbered enum
            value like <${Sizes.SZ_6.kt}|code>.
        """.trimIndent()
    }
    contentTitle(RBuilder::h3, "Equal-width")
    formattedText {
        """
            For example, here are two grid layouts that apply to every device and viewport, from <xs|code> to <xl|code>.
            Add any number of equal-size enums for each breakpoint you need and every column will be the same width.
        """.trimIndent()
    }
    exampleRow {
        example {
            container {
                row {
                    for (x in 1..2) {
                        col { +"$x of 2" }
                    }
                }
                row {
                    for (x in 1..3) {
                        col { +"$x of 3" }
                    }
                }
            }
        }
        codeBox {
            containerFunImport()
            gridEnumImport(Sizes::class)
            colFunImport()
            rowFunImport()
            ln { }
            ktContainer { il ->
                ktRow(il) { il ->
                    ln(il) { +"$colFun { +\"1 of 2\" }" }
                    ln(il) { +"$colFun { +\"2 of 2\" }" }
                    ln(il) { +"// Same as: col(all = ${Sizes.EQ.kt}) { +\"x of 2\" }" }
                }
                ktRow(il) { il ->
                    ln(il) { +"$colFun { +\"1 of 3\" }" }
                    ln(il) { +"$colFun { +\"2 of 3\" }" }
                    ln(il) { +"$colFun { +\"3 of 3\" }" }
                }
            }
        }
    }
    contentTitle(RBuilder::h3, "Setting one column width")
    p {
        +"""
            Auto-layout for flexbox grid columns also means you can set the width of one column and have the sibling
            columns automatically resize around it. You may use predefined grid enumbs (as shown below), grid mixins, or
            inline widths. Note that the other columns will resize no matter the width of the center column.
        """.trimIndent()
    }
    exampleRow {
        example {
            container {
                row {
                    col { +"1 of 3" }
                    col(all = Sizes.SZ_6) { +"2 of 3 (wider)" }
                    col { +"3 of 3" }
                }
                row {
                    col { +"1 of 3" }
                    col(all = Sizes.SZ_5) { +"2 of 3 (wider)" }
                    col { +"3 of 3" }
                }
            }
        }
        codeBox {
            containerFunImport()
            gridEnumImport(Sizes::class)
            colFunImport()
            rowFunImport()
            ln { }
            ktContainer { il ->
                ktRow(il) { il ->
                    ln(il) { +"$colFun { +\"1 of 3\" }" }
                    ln(il) { +"$colFun(all = ${Sizes.SZ_6.kt}) { +\"2 of 3 (wider)\" }" }
                    ln(il) { +"$colFun { +\"3 of 3\" }" }
                }
                ktRow(il) { il ->
                    ln(il) { +"$colFun { +\"1 of 3\" }" }
                    ln(il) { +"$colFun(all = ${Sizes.SZ_5.kt}) { +\"2 of 3 (wider)\" }" }
                    ln(il) { +"$colFun { +\"3 of 3\" }" }
                }
            }
        }
    }
    contentTitle(RBuilder::h3, "Variable width content")
    formattedText {
        "Use the <${Sizes.AUTO.kt}|code> enum value to size columns based on the natural width of their content."
    }
    exampleRow {
        example {
            container {
                row(classes = "${ClassNames.JUSTIFY_CONTENT_MD_CENTER}") {
                    col(all = Sizes.EQ, lg = Sizes.SZ_2) { +"1 of 3" }
                    col(md = Sizes.AUTO) { +"Variable width content" }
                    col(all = Sizes.EQ, lg = Sizes.SZ_2) { +"3 of 3" }
                }
                row {
                    col { +"1 of 3" }
                    col(md = Sizes.AUTO) { +"Variable width content" }
                    col(all = Sizes.EQ, lg = Sizes.SZ_2) { +"3 of 3" }
                }
            }
        }
        codeBox {
            containerFunImport()
            gridEnumImport(Sizes::class)
            colFunImport()
            rowFunImport()
            classNamesImport()
            ln { }
            ktContainer { il ->
                ktBlock(il, "$rowFun(classes = \"\${${ClassNames.JUSTIFY_CONTENT_MD_CENTER.kt}}\")") { il ->
                    ln(il) { +"$colFun(all = ${Sizes.EQ.kt}, lg =  ${Sizes.SZ_2.kt}) { +\"1 of 3\" }" }
                    ln(il) { +"$colFun(md = ${Sizes.AUTO.kt}) { +\"Variable width content\" }" }
                    ln(il) { +"$colFun(all = ${Sizes.EQ.kt}, lg = ${Sizes.SZ_2.kt}) { +\"3 of 3\" }" }
                }
                ktRow(il) { il ->
                    ln(il) { +"$colFun { +\"1 of 3\"}" }
                    ln(il) { +"$colFun(md = ${Sizes.AUTO.kt}) { +\"Variable width content\" }" }
                    ln(il) { +"$colFun(all = ${Sizes.EQ.kt}, lg = ${Sizes.SZ_2.kt}) { +\"3 of 3\" }" }
                }
            }
        }
    }
}
