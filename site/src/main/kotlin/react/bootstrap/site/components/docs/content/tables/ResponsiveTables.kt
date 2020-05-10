package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.td
import react.bootstrap.content.tables.thead
import react.bootstrap.content.tables.tr
import react.bootstrap.lib.Breakpoints
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.dom.p
import react.dom.strong
import react.dom.tbody
import react.dom.th

internal class ResponsiveTables : SectionComponent() {
    override val title: String = "Responsive tables"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
                Responsive tables allow tables to be scrolled horizontally with ease. Make any table responsive accross
                the usual viewport breakpoints by setting the <table(responsive)|code>-argument.
            """.trimIndent()
        }
        subSectionTitle("Always responsive", section)
        formattedText {
            "Accross every breakpoint, set <table(responsive)|code> to <${Breakpoints.ALL.kt}|code>."
        }
        liveExample {
            table(responsive = Breakpoints.ALL) {
                exampleTableBody()
            }
        }
        codeExample {
            exampleImports()
            ktB(0, "table", "responsive" to Breakpoints.ALL.kt) {
                ln(it) { +"..." }
            }
        }
        subSectionTitle("Breakpoint specific", section)
        formattedText {
            """
                Use <${Breakpoints::class.simpleName}{.${Breakpoints.SM.name} |.${Breakpoints.MD.name}
                |.${Breakpoints.LG.name} |.${Breakpoints.XL.name}}|code> as needed to create responsive tables up to a
                particular breakpoint. From that breakpoint and up, the table will behave normally and not scroll
                horizontally.
            """.trimIndent()
        }
        p {
            strong {
                +"These tables may appear broken until their responsive styles apply at specific viewport widths."
            }
        }
        liveExample {
            table(responsive = Breakpoints.SM) {
                exampleTableBody()
            }
        }
        codeExample {
            exampleImports()
            ktB(0, "table", "responsive" to Breakpoints.SM.kt) {
                ln(it) { +"..." }
            }
        }
        liveExample {
            table(responsive = Breakpoints.MD) {
                exampleTableBody()
            }
        }
        codeExample {
            exampleImports()
            ktB(0, "table", "responsive" to Breakpoints.MD.kt) {
                ln(it) { +"..." }
            }
        }
        liveExample {
            table(responsive = Breakpoints.LG) {
                exampleTableBody()
            }
        }
        codeExample {
            exampleImports()
            ktB(0, "table", "responsive" to Breakpoints.LG.kt) {
                ln(it) { +"..." }
            }
        }
        liveExample {
            table(responsive = Breakpoints.XL) {
                exampleTableBody()
            }
        }
        codeExample {
            exampleImports()
            ktB(0, "table", "responsive" to Breakpoints.XL.kt) {
                ln(it) { +"..." }
            }
        }
    }

    private fun CodeExampleBuilder.exampleImports() {
        import("content.tables.table")
        import("lib.${Breakpoints::class.simpleName}")
        ln { }
    }

    private fun RBuilder.exampleTableBody() {
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
}
