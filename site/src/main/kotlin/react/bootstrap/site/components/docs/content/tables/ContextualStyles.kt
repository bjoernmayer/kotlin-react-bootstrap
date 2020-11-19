package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.ContextualStyle
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.tr
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.bootstrap.site.lib.codepoet.LineComment
import react.dom.p
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead

internal class ContextualStyles : SectionComponent() {
    override val title: String = "Contextual styles"

    override fun RBuilder.render() {
        sectionTitle()
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
                        tr(contextualStyle = it) {
                            th(ThScope.row) { +it.name.toLowerCase().capitalize() }
                            td { +"Cell" }
                            td { +"Cell" }
                        }
                    }
                }
            }
        }
        codeExample {
            +Imports.builder()
                .addImport("content.tables.${ContextualStyle::class.simpleName}")
                .addImport("content.tables.table")
                .addImport("content.tables.td")
                .addImport("content.tables.tr")
                .build()

            +LineComment.builder("On rows").build()
            ContextualStyle.values().forEach {
                +FunCall.builder(RBuilder::tr, FunCall.Style.NEW_INLINE)
                    .addArgument("contextualStyle", it)
                    .setLambdaArgument(plusString("..."))
                    .build()
            }
            appendLine("")
            +LineComment.builder("On cells (`td` or `th`)").build()
            +FunCall.builder(RBuilder::tr)
                .setLambdaArgument(
                    ContextualStyle.values().joinToString("\n") {
                        FunCall.builder(RBuilder::td, FunCall.Style.INLINE)
                            .addArgument(it)
                            .setLambdaArgument(plusString("..."))
                            .build()
                    }
                )
                .build()
        }
        p {
            +"Regular table background variants are not available with the dark table"
        }
    }
}
