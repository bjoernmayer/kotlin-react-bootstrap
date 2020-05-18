@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.grid.col.ColAttributes
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_4
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_6
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_8
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.container
import react.bootstrap.layout.grid.row.RowAttributes
import react.bootstrap.layout.grid.row.RowAttributes.ColCounts.Companion.CNT_1
import react.bootstrap.layout.grid.row.RowAttributes.ColCounts.Companion.CNT_2
import react.bootstrap.layout.grid.row.RowAttributes.ColCounts.Companion.CNT_3
import react.bootstrap.layout.grid.row.RowAttributes.ColCounts.Companion.CNT_4
import react.bootstrap.layout.grid.row.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.ktContainer
import react.bootstrap.site.external.Markdown
import react.dom.em
import react.dom.p

internal class ResponsiveClasses : SectionComponent() {
    override val title: String = "Responsive classes"

    override fun RBuilder.render() {
        sectionTitle(section)
        p {
            +"""
Bootstrap’s grid includes five tiers of predefined classes for building complex responsive layouts. Customize the size
of your columns on extra small, small, medium, large, or extra large devices however you see fit.
            """
        }
        subSectionTitle("All breakpoints", section)
        Markdown {
            //language=Markdown
            +"""
For grids that are the same from the smallest of devices to the largest, set the `all =
${ColAttributes::class.simpleName}?`-argument. Specify a numbered `${ColAttributes.Sizes::class.simpleName}` enum value when you need
a particularly sized column; otherwise, feel free to not set the argument at all, which defaults to `all =
${EQ.name}`.
            """
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        for (x in 1..4) {
                            col { em { +"all = ${EQ.name}" } }
                        }
                    }
                    row {
                        col(all = SZ_8) { +"all = ${SZ_8.name}" }
                        col(all = SZ_4) { +"all = ${SZ_4.name}" }
                    }
                }
            }
            codeExample {
                importFromGrid("col", EQ.import)
                importFromGrid("col", SZ_4.import)
                importFromGrid("col", SZ_8.import)
                importColFun()
                importContainerFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        for (x in 1..4) {
                            ktIB(it, colFun) { "em { +\"all = ${EQ.name}\" }" }
                        }
                    }
                    ktRow(it) {
                        ktIB(it, colFun, "all" to SZ_8.name)
                        ktIB(it, colFun, "all" to SZ_4.name)
                    }
                }
            }
        }
        subSectionTitle("Stacked to horizontal", section)
        Markdown {
            //language=Markdown
            +"""
By setting the `sm = ${ColAttributes::class.simpleName}?`-argument, you can create a basic grid system that starts out
stacked and becomes horizontal at the small breakpoint (`sm`).
            """
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        col(sm = SZ_8) { +"sm = ${SZ_8.name}" }
                        col(sm = SZ_4) { +"sm = ${SZ_4.name}" }
                    }
                    row {
                        for (x in 1..3) {
                            col(sm = EQ) { +"sm = ${EQ.name}" }
                        }
                    }
                }
            }
            codeExample {
                importFromGrid("col", EQ.import)
                importFromGrid("col", SZ_4.import)
                importFromGrid("col", SZ_8.import)
                importColFun()
                importContainerFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        ktIB(it, colFun, "sm" to SZ_8.name)
                        ktIB(it, colFun, "sm" to SZ_4.name)
                    }
                    ktRow(it) {
                        for (x in 1..3) {
                            ktIB(it, colFun, "sm" to EQ.name)
                        }
                    }
                }
            }
        }
        subSectionTitle("Mix and match", section)
        p {
            +"""
Don’t want your columns to simply stack in some grid tiers? Use a combination of different classes for each tier as
needed. See the example below for a better idea of how it all works.
            """
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        col(md = SZ_8) { +"md = ${SZ_8.name}" }
                        col(all = SZ_6, md = SZ_4) { +"all = ${SZ_6.name}, md = ${SZ_4.name}" }
                    }
                    row {
                        for (x in 1..3) {
                            col(all = SZ_6, md = SZ_4) { +"all = ${SZ_6.name}, md = ${SZ_4.name}" }
                        }
                    }
                    row {
                        for (x in 1..2) {
                            col(all = SZ_6) { +"all = ${SZ_6.name}" }
                        }
                    }
                }
            }
            codeExample {
                importFromGrid("col", SZ_4.import)
                importFromGrid("col", SZ_6.import)
                importFromGrid("col", SZ_8.import)
                importColFun()
                importContainerFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        ln(it) { +"// Stack the columns on mobile by making one full-width and the other half-width" }
                        ktIB(it, colFun, "md" to SZ_8.name)
                        ktIB(it, colFun, "all" to SZ_6.name, "md" to SZ_4.name)
                    }
                    ktRow(it) {
                        ln(it) { +"// Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop" }
                        for (x in 1..3) {
                            ktIB(it, colFun, "all" to SZ_6.name, "md" to SZ_4.name)
                        }
                    }
                    ktRow(it) {
                        ln(2) { +"// Columns are always 50% wide, on mobile and desktop" }
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to SZ_6.name)
                        }
                    }
                }
            }
        }
        subSectionTitle("Row columns", section)
        Markdown {
            //language=Markdown
            +"""
Set the `${RowAttributes.ColCounts::class.simpleName}`-argument to quickly set the number of columns that best render
your content and layout. The row columns classes are set on the parent `$rowFun { }` as a shortcut.
            """
        }
        exampleRow {
            liveExample {
                container {
                    row(all = CNT_2) {
                        for (x in 1..4) {
                            col { +"Column" }
                        }
                    }
                }
            }
            codeExample {
                importColFun()
                importContainerFun()
                importFromGrid("row", CNT_2.import)
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to CNT_2.name) {
                        for (x in 1..4) {
                            ktIB(it, colFun, "+\"Column\"")
                        }
                    }
                }
            }
        }
        exampleRow {
            liveExample {
                container {
                    row(all = CNT_3) {
                        for (x in 1..4) {
                            col { +"Column" }
                        }
                    }
                }
            }
            codeExample {
                importColFun()
                importContainerFun()
                importFromGrid("row", CNT_3.import)
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to CNT_3.name) {
                        for (x in 1..4) {
                            ktIB(it, colFun, "+\"Column\"")
                        }
                    }
                }
            }
        }
        exampleRow {
            liveExample {
                container {
                    row(all = CNT_4) {
                        for (x in 1..4) {
                            col { +"Column" }
                        }
                    }
                }
            }
            codeExample {
                importColFun()
                importContainerFun()
                importFromGrid("row", CNT_4.import)
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to CNT_4.name) {
                        for (x in 1..4) {
                            ktIB(it, colFun, "+\"Column\"")
                        }
                    }
                }
            }
        }
        exampleRow {
            liveExample {
                container {
                    row(all = CNT_4) {
                        for (x in 1..2) {
                            col { +"Column" }
                        }
                        col(all = SZ_6) { +"Colum" }
                        col { +"Column" }
                    }
                }
            }
            codeExample {
                importFromGrid("col", SZ_6.import)
                importColFun()
                importContainerFun()
                importFromGrid("row", CNT_4.import)
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to CNT_4.name) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "+\"Column\"")
                        }
                    }
                    ktB(it, rowFun, "all" to CNT_4.name) {
                        ktIB(it, colFun, "all" to SZ_6.name) { "+\"Column\"" }
                    }
                }
            }
        }
        exampleRow {
            liveExample {
                container {
                    row(all = CNT_1, sm = CNT_2, md = CNT_4) {
                        for (x in 1..4) {
                            col { +"Column" }
                        }
                    }
                }
            }
            codeExample {
                importColFun()
                importContainerFun()
                importFromGrid("row", CNT_1.import)
                importFromGrid("row", CNT_2.import)
                importFromGrid("row", CNT_4.import)
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to CNT_1.name, "sm" to CNT_2.name, "md" to CNT_4.name) {
                        for (x in 1..4) {
                            ktIB(it, colFun, "+\"Column\"")
                        }
                    }
                }
            }
        }
        subSectionTitle("No gutters", section)
        Markdown {
            //language=Markdown
            +"""
The gutters between columns in Bootstrap's predefined grid classes can be removed by setting `gutters = false`. This
removes the negative `margin`s from `$rowFun { }` and the horizontal `padding` from all immediate children columns.
            """
        }
        p {
            +"""
In practice, here’s how it looks. Note you can continue to use this with all other predefined grid settings (including
column widths, responsive tiers, reorders, and more).
            """
        }
        exampleRow {
            liveExample {
                container {
                    row(gutters = false) {
                        col(sm = SZ_6, md = SZ_8) { +"sm = ${SZ_6.name}, md = ${SZ_8.name}" }
                        col(all = SZ_6, md = SZ_4) { +"all = ${SZ_6.name}, md = ${SZ_4.name}" }
                    }
                }
            }
            codeExample {
                importFromGrid("col", SZ_4.import)
                importFromGrid("col", SZ_6.import)
                importFromGrid("col", SZ_8.import)
                importColFun()
                importContainerFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "gutters" to "false") {
                        ktIB(it, colFun, "sm" to SZ_6.name, "md" to SZ_8.name)
                        ktIB(it, colFun, "all" to SZ_6.name, "md" to SZ_4.name)
                    }
                }
            }
        }
    }
}
