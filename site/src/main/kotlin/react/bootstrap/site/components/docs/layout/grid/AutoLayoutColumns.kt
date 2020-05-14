@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter", "DuplicatedCode")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ColAttributes.Sizes.Companion.AUTO
import react.bootstrap.layout.grid.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.layout.grid.ColAttributes.Sizes.Companion.SZ_2
import react.bootstrap.layout.grid.ColAttributes.Sizes.Companion.SZ_5
import react.bootstrap.layout.grid.ColAttributes.Sizes.Companion.SZ_6
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.importClassNames
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.importFromGrid
import react.bootstrap.site.components.docs.layout.ktContainer
import react.bootstrap.site.external.Markdown
import react.dom.p

internal class AutoLayoutColumns : SectionComponent() {
    override val title: String = "Auto-layout columns"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Utilize breakpoint-specific equal-size enum values for easy column sizing without an explicit numbered enum value like
`${SZ_6.name}`.
            """
        }
        subSectionTitle("Equal-width", section)
        Markdown {
            //language=Markdown
            +"""
For example, here are two grid layouts that apply to every device and viewport, from `xs` to `xl`. Add any number of
equal-size enums for each breakpoint you need and every column will be the same width.
            """
        }
        exampleRow {
            liveExample {
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
            codeExample {
                importContainerFun()
                importFromGrid(EQ.import)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        ktIB(it, colFun, "+\"1 of 2\"")
                        ktIB(it, colFun, "+\"2 of 2\"")
                        ln(it) { +"// Same as: col(all = ${EQ.name}) { +\"x of 2\" }" }
                    }
                    ktRow(it) {
                        ktIB(it, colFun, "+\"1 of 3\"")
                        ktIB(it, colFun, "+\"2 of 3\"")
                        ktIB(it, colFun, "+\"3 of 3\"")
                    }
                }
            }
        }
        subSectionTitle("Setting one column width", section)
        p {
            +"""
Auto-layout for flexbox grid columns also means you can set the width of one column and have the sibling columns
automatically resize around it. You may use predefined grid enumbs (as shown below), grid mixins, or inline widths.
Note that the other columns will resize no matter the width of the center column.
            """
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        col { +"1 of 3" }
                        col(all = SZ_6) { +"2 of 3 (wider)" }
                        col { +"3 of 3" }
                    }
                    row {
                        col { +"1 of 3" }
                        col(all = SZ_5) { +"2 of 3 (wider)" }
                        col { +"3 of 3" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importFromGrid(SZ_5.import)
                importFromGrid(SZ_6.import)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        ktIB(it, colFun, "+\"1 of 3\"")
                        ktIB(it, colFun, "all" to SZ_6.name) { "+\"2 of 3 (wider)\"" }
                        ktIB(it, colFun, "+\"3 of 3\"")
                    }
                    ktRow(it) {
                        ktIB(it, colFun, "+\"1 of 3\"")
                        ktIB(it, colFun, "all" to SZ_5.name) { "+\"2 of 3 (wider)\"" }
                        ktIB(it, colFun, "+\"3 of 3\"")
                    }
                }
            }
        }
        subSectionTitle("Variable width content", section)
        Markdown {
            //language=Markdown
            +"""
Use the `${AUTO.name}` enum value to size columns based on the natural width of their content.
            """
        }
        exampleRow {
            liveExample {
                container {
                    row(classes = "${ClassNames.JUSTIFY_CONTENT_MD_CENTER}") {
                        col(all = EQ, lg = SZ_2) { +"1 of 3" }
                        col(md = AUTO) { +"Variable width content" }
                        col(all = EQ, lg = SZ_2) { +"3 of 3" }
                    }
                    row {
                        col { +"1 of 3" }
                        col(md = AUTO) { +"Variable width content" }
                        col(all = EQ, lg = SZ_2) { +"3 of 3" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importFromGrid(AUTO.import)
                importFromGrid(EQ.import)
                importFromGrid(SZ_2.import)
                importColFun()
                importRowFun()
                importClassNames()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "classes" to "\"\${${ClassNames.JUSTIFY_CONTENT_MD_CENTER.kt}}\"") {
                        ktIB(it, colFun, "all" to EQ.name, "lg" to SZ_2.name) { "+\"1 of 3\"" }
                        ktIB(it, colFun, "md" to AUTO.name) { "+\"Variable width content\"" }
                        ktIB(it, colFun, "all" to EQ.name, "lg" to SZ_2.name) { "+\"3 of 3\"" }
                    }
                    ktRow(it) {
                        ktIB(it, colFun, "+\"1 of 3\"")
                        ktIB(it, colFun, "md" to AUTO.name) { "+\"Variable width content\"" }
                        ktIB(it, colFun, "all" to EQ.name, "lg" to SZ_2.name) { "+\"3 of 3\"" }
                    }
                }
            }
        }
    }
}
