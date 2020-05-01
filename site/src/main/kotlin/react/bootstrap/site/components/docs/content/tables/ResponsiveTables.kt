package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.td
import react.bootstrap.content.tables.thead
import react.bootstrap.content.tables.tr
import react.bootstrap.lib.Breakpoints
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.code
import react.dom.h3
import react.dom.p
import react.dom.strong
import react.dom.tbody
import react.dom.th

fun RBuilder.responsiveTables() {
    contentTitle("Responsive tables")
    p {
        +"Responsive tables allow tables to be scrolled horizontally with ease. Make any table responsive across the "
        +"usual viewport breakpoints by setting the "; code { +"table(responsive)" }; +"-argument."
    }
    contentTitle(RBuilder::h3, "Always responsive")
    p {
        +"Across every breakpoint, set "; code { +"responsive" }; +" to "; code { +Breakpoints.ALL.kt }; +"."
    }
    example {
        table(responsive = Breakpoints.ALL) {
            exampleTableBody()
        }
    }
    codeBox {
        ktBlock(0, "table(responsive = ${Breakpoints.ALL.kt}") { il ->
            ln(il) { +"..." }
        }
    }
    contentTitle(RBuilder::h3, "Breakpoint specific")
    p {
        +"Use "
        code {
            +"${Breakpoints::class.simpleName}{.${Breakpoints.SM.name}|.${Breakpoints.MD.name}|."
            +"${Breakpoints.LG.name}|.${Breakpoints.XL.name}|}"
        }; +" as needed to create responsive tables up to a particular breakpoint. From that breakpoint and up, the "
        +"table will behave normally and not scroll horizontally."
    }
    p {
        strong {
            +"These tables may appear broken until their responsive styles apply at specific viewport widths."
        }
    }
    example {
        table(responsive = Breakpoints.SM) {
            exampleTableBody()
        }
    }
    codeBox {
        ktBlock(0, "table(responsive = ${Breakpoints.SM.kt}") { il ->
            ln(il) { +"..." }
        }
    }
    example {
        table(responsive = Breakpoints.MD) {
            exampleTableBody()
        }
    }
    codeBox {
        ktBlock(0, "table(responsive = ${Breakpoints.MD.kt}") { il ->
            ln(il) { +"..." }
        }
    }
    example {
        table(responsive = Breakpoints.LG) {
            exampleTableBody()
        }
    }
    codeBox {
        ktBlock(0, "table(responsive = ${Breakpoints.LG.kt}") { il ->
            ln(il) { +"..." }
        }
    }
    example {
        table(responsive = Breakpoints.XL) {
            exampleTableBody()
        }
    }
    codeBox {
        ktBlock(0, "table(responsive = ${Breakpoints.XL.kt}") { il ->
            ln(il) { +"..." }
        }
    }
}

fun RBuilder.exampleTableBody() {
    thead {
        tr {
            th(ThScope.col) { +"#" }
            for (x in 1..9) {
                th(ThScope.col) { +"Heading" }
            }
        }
    }
    tbody {
        for (x in 1..3) {
            tr {
                th(ThScope.row) { +"$x" }
                for (y in 1..9) {
                    td { +"Cell" }
                }
            }
        }
    }
}
