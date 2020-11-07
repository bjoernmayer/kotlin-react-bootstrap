package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.td
import react.bootstrap.content.tables.thead
import react.bootstrap.content.tables.tr
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.p
import react.dom.strong
import react.dom.tbody
import react.dom.th

internal class ResponsiveTables : SectionComponent() {
    override val title: String = "Responsive tables"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Responsive tables allow tables to be scrolled horizontally with ease. Make any table responsive accross
the usual viewport breakpoints by setting the `table(responsive)`-argument.
            """
        }
        subSectionTitle("Always responsive")
        Markdown {
            //language=Markdown
            +"""
Accross every breakpoint, set `table(responsive)` to `${Breakpoints.ALL.nestedName}`.
            """
        }
        liveExample {
            table(responsive = Breakpoints.ALL) {
                exampleTableBody()
            }
        }
        codeExample {
            exampleImports()
            +FunCall.builder(RBuilder::table)
                .addArgument("responsive", Breakpoints.ALL)
                .setLambdaArgument("...")
                .build()
        }
        subSectionTitle("Breakpoint specific")
        Markdown {
            //language=Markdown
            +"""
Use `${Breakpoints::class.simpleName}{.${Breakpoints.SM.name} |.${Breakpoints.MD.name} |.${Breakpoints.LG.name}
|.${Breakpoints.XL.name}}` as needed to create responsive tables up to a particular breakpoint. From that breakpoint and
up, the table will behave normally and not scroll horizontally.
            """
        }
        p {
            strong {
                +"These tables may appear broken until their responsive styles apply at specific viewport widths."
            }
        }
        listOf(Breakpoints.SM, Breakpoints.MD, Breakpoints.LG, Breakpoints.XL).forEach { breakpoints ->
            liveExample {
                table(responsive = breakpoints) {
                    exampleTableBody()
                }
            }
            codeExample {
                exampleImports()
                +FunCall.builder(RBuilder::table)
                    .addArgument("responsive", breakpoints)
                    .setLambdaArgument("...")
                    .build()
            }
        }
    }

    private fun CodeExampleBuilder.exampleImports() {
        +Imports.builder()
            .addImport("content.tables.table")
            .addImport("lib.bootstrap.${Breakpoints::class.simpleName}")
            .build()
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
