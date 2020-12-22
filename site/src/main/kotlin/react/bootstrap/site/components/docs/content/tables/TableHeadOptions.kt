@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.content.tables.THeadStyles
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.thead
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.tbody
import react.dom.tr

internal class TableHeadOptions : SectionComponent() {
    override val title: String = "Table head options"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Similar to tables and dark tables, use the `thead(style)`-argument to make table headers appear light or dark gray.
            """
        }
        liveExample {
            table {
                thead(style = THeadStyles.DARK) {
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

            table {
                thead(style = THeadStyles.LIGHT) {
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
        }
        codeExample {
            +Imports.builder()
                .addImport("content.tables.${THeadStyles::class.simpleName}")
                .addImport("content.tables.table")
                .addImport("content.tables.thead")
                .build()

            +listOf(THeadStyles.DARK, THeadStyles.LIGHT).joinToString("\n") { tHeadStyles ->
                FunCall.builder(RBuilder::table)
                    .setLambdaArgument(
                        FunCall.builder(RBuilder::thead)
                            .addArgument("style", tHeadStyles)
                            .setLambdaArgument(
                                FunCall.builder(RBuilder::tr)
                                    .setLambdaArgument(headerCells())
                                    .build()
                            )
                            .build(),
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
                    .build()
            }
        }
    }
}
