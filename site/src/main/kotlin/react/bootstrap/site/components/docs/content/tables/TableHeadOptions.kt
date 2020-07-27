@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.content.tables.THeadStyles
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.thead
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.tbody
import react.dom.tr

internal class TableHeadOptions : SectionComponent() {
    override val title: String = "Table head options"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Similar to tables and dark tables, use the `thead(style)`-argument to make table headers appear light or dark gray.
            """
        }
        liveExample {
            table {
                thead(THeadStyles.DARK) {
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
                thead(THeadStyles.LIGHT) {
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
            import("content.tables.${THeadStyles::class.simpleName}")
            import("content.tables.table")
            import("content.tables.thead")
            ln { }
            ktFun(RBuilder::table) {
                ktFun(RBuilder::thead, args = mapOf(null to THeadStyles.DARK.kt)) {
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
            ln { }
            ktFun(RBuilder::table) {
                ktFun(RBuilder::thead, args = mapOf(null to THeadStyles.LIGHT.kt)) {
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
        }
    }
}
