@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ColAttributes
import react.bootstrap.layout.grid.ColCounts
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.kt
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
${ColAttributes::class.simpleName}?`-argument. Specify a numbered `${Sizes::class.simpleName}` enum value when you need
a particularly sized column; otherwise, feel free to not set the argument at all, which defaults to `all =
${Sizes.EQ.kt}`.
            """
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        for (x in 1..4) {
                            col { em { +"all = ${Sizes.EQ.kt}" } }
                        }
                    }
                    row {
                        col(all = Sizes.SZ_8) { +"all = ${Sizes.SZ_8.kt}" }
                        col(all = Sizes.SZ_4) { +"all = ${Sizes.SZ_4.kt}" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(Sizes::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        for (x in 1..4) {
                            ktIB(it, colFun) { "em { +\"all = ${Sizes.EQ.kt}\" }" }
                        }
                    }
                    ktRow(it) {
                        ktIB(it, colFun, "all" to Sizes.SZ_8.kt)
                        ktIB(it, colFun, "all" to Sizes.SZ_4.kt)
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
                        col(sm = Sizes.SZ_8) { +"sm = ${Sizes.SZ_8.kt}" }
                        col(sm = Sizes.SZ_4) { +"sm = ${Sizes.SZ_4.kt}" }
                    }
                    row {
                        for (x in 1..3) {
                            col(sm = Sizes.EQ) { +"sm = ${Sizes.EQ.kt}" }
                        }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(Sizes::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        ktIB(it, colFun, "sm" to Sizes.SZ_8.kt)
                        ktIB(it, colFun, "sm" to Sizes.SZ_4.kt)
                    }
                    ktRow(it) {
                        for (x in 1..3) {
                            ktIB(it, colFun, "sm" to Sizes.EQ.kt)
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
                        col(md = Sizes.SZ_8) { +"md = ${Sizes.SZ_8.kt}" }
                        col(all = Sizes.SZ_6, md = Sizes.SZ_4) { +"all = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_4.kt}" }
                    }
                    row {
                        for (x in 1..3) {
                            col(all = Sizes.SZ_6, md = Sizes.SZ_4) { +"all = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_4.kt}" }
                        }
                    }
                    row {
                        for (x in 1..2) {
                            col(all = Sizes.SZ_6) { +"all = ${Sizes.SZ_6.kt}" }
                        }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(Sizes::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        ln(it) { +"// Stack the columns on mobile by making one full-width and the other half-width" }
                        ktIB(it, colFun, "md" to Sizes.SZ_8.kt) { "+\"md = ${Sizes.SZ_8.kt}\"" }
                        ktIB(it, colFun, "all" to Sizes.SZ_6.kt, "md" to Sizes.SZ_4.kt)
                    }
                    ktRow(it) {
                        ln(it) { +"// Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop" }
                        for (x in 1..3) {
                            ktIB(it, colFun, "all" to Sizes.SZ_6.kt, "md" to Sizes.SZ_4.kt)
                        }
                    }
                    ktRow(it) {
                        ln(2) { +"// Columns are always 50% wide, on mobile and desktop" }
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to Sizes.SZ_6.kt)
                        }
                    }
                }
            }
        }
        subSectionTitle("Row columns", section)
        Markdown {
            //language=Markdown
            +"""
Set the `${ColCounts::class.simpleName}`-argument to quickly set the number of columns that best
render your content and layout. The row columns classes are set on the parent `$rowFun { }` as a
shortcut.
            """
        }
        exampleRow {
            liveExample {
                container {
                    row(all = ColCounts.CNT_2) {
                        for (x in 1..4) {
                            col { +"Column" }
                        }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(ColCounts::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to ColCounts.CNT_2.kt) {
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
                    row(all = ColCounts.CNT_3) {
                        for (x in 1..4) {
                            col { +"Column" }
                        }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(ColCounts::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to ColCounts.CNT_3.kt) {
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
                    row(all = ColCounts.CNT_4) {
                        for (x in 1..4) {
                            col { +"Column" }
                        }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(ColCounts::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to ColCounts.CNT_4.kt) {
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
                    row(all = ColCounts.CNT_4) {
                        for (x in 1..2) {
                            col { +"Column" }
                        }
                        col(all = Sizes.SZ_6) { +"Colum" }
                        col { +"Column" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(ColCounts::class)
                importGridEnum(Sizes::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to ColCounts.CNT_4.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "+\"Column\"")
                        }
                    }
                    ktB(it, rowFun, "all" to ColCounts.CNT_4.kt) {
                        ktIB(it, colFun, "all" to Sizes.SZ_6.kt) { "+\"Column\"" }
                    }
                }
            }
        }
        exampleRow {
            liveExample {
                container {
                    row(all = ColCounts.CNT_1, sm = ColCounts.CNT_2, md = ColCounts.CNT_4) {
                        for (x in 1..4) {
                            col { +"Column" }
                        }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(ColCounts::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(
                        it, rowFun, "all" to ColCounts.CNT_1.kt, "sm" to ColCounts.CNT_2.kt, "md" to ColCounts.CNT_4.kt
                    ) {
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
                        col(sm = Sizes.SZ_6, md = Sizes.SZ_8) { +"sm = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_8.kt}" }
                        col(all = Sizes.SZ_6, md = Sizes.SZ_4) { +"all = ${Sizes.SZ_6.kt}, md = ${Sizes.SZ_4.kt}" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(Sizes::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "gutters" to "false") {
                        ktIB(it, colFun, "sm" to Sizes.SZ_6.kt, "md" to Sizes.SZ_8.kt)
                        ktIB(it, colFun, "all" to Sizes.SZ_6.kt, "md" to Sizes.SZ_4.kt)
                    }
                }
            }
        }
    }
}
