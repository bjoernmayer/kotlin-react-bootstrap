@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ColAttributes
import react.bootstrap.layout.grid.ColAttributes.Offsets.Companion.OFF_3
import react.bootstrap.layout.grid.ColAttributes.Offsets.Companion.OFF_4
import react.bootstrap.layout.grid.ColAttributes.Orderings.Companion.ORD_1
import react.bootstrap.layout.grid.ColAttributes.Orderings.Companion.ORD_12
import react.bootstrap.layout.grid.ColAttributes.Orderings.Companion.ORD_2
import react.bootstrap.layout.grid.ColAttributes.Sizes.Companion.SZ_3
import react.bootstrap.layout.grid.ColAttributes.Sizes.Companion.SZ_4
import react.bootstrap.layout.grid.ColAttributes.Sizes.Companion.SZ_6
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.importFromGrid
import react.bootstrap.site.components.docs.layout.ktContainer
import react.bootstrap.site.external.Markdown
import react.dom.h4

internal class Reordering : SectionComponent() {
    override val title: String = "Reordering"

    private val offsetsName = ColAttributes.Offsets::class.simpleName!!
    private val orderingsName = ColAttributes.Orderings::class.simpleName!!
    private val off = ColAttributes.Sizes::off.name

    override fun RBuilder.render() {
        sectionTitle(section)
        subSectionTitle("$orderingsName enum", section)
        Markdown {
            //language=Markdown
            +"""
Use `$orderingsName` values for controlling the __visual order__  of your content. The classes are responsive, so you
can set the `order` by breakpoint (e.g., `all = ${ORD_1.name}, md = ${ORD_2.name}`). Includes support
for 1 through 12 across all five grid tiers.
            """
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        col { +"First in DOM, no order applied" }
                        col(all = ORD_12) { +" Second in DOM, with a larger order" }
                        col(all = ORD_1) { +"Third in DOM, with an order of 1" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importFromGrid(ORD_1.import)
                importFromGrid(ORD_12.import)
                importColFun()
                importRowFun()
                ln { }
                ktConRow {
                    ktIB(it, colFun, "+\"First in DOM, no order applied\"")
                    ktIB(it, colFun, "all" to ORD_12.name) { "+\" Second in DOM, with a larger order\"" }
                    ktIB(it, colFun, "all" to ORD_1.name) { "+\"Third in DOM, with an order of 1\"" }
                }
            }
        }
        subSectionTitle("Offsetting columns", section)
        Markdown {
            //language=Markdown
            +"""
You can offset grid columns in two ways: our `$offsetsName` values and Bootstrap's
[margin utilities](https://getbootstrap.com/docs/4.4/utilities/spacing/). Grid classes are sized to match columns while
margins are more useful for quick layouts where the width of the offset is variable.
            """
        }
        contentTitle(RBuilder::h4, "$offsetsName enum")
        Markdown {
            //language=Markdown
            +"""
Move columns to the right by setting `$offsetsName` enum values. These increase the left margin of a column by `*`
columns. For example, `md = ${SZ_4.name} $off ${OFF_4.name}` moves `$colFun(md = ${SZ_4.name}) { }` over four columns.
            """
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        col(md = SZ_4) { +"md = ${SZ_4.name}" }
                        col(md = SZ_4 off OFF_4) { +"md = ${SZ_4.name} $off ${OFF_4.name}" }
                    }
                    row {
                        for (x in 1..2) {
                            col(md = SZ_3 off OFF_3) { +"md = ${SZ_3.name} $off ${OFF_3.name}" }
                        }
                    }
                    row {
                        col(md = SZ_6 off OFF_3) { +"md = ${SZ_6.name} $off ${OFF_3.name}" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importFromGrid(OFF_4.import)
                importFromGrid(OFF_3.import)
                importFromGrid(SZ_3.import)
                importFromGrid(SZ_4.import)
                importFromGrid(SZ_6.import)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        ktIB(it, colFun, "md" to SZ_4.name)
                        ktIB(it, colFun, "md" to "${SZ_4.name} $off ${OFF_4.name}")
                    }
                    ktRow(it) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "md" to "${SZ_3.name} $off ${OFF_3.name}")
                        }
                    }
                    ktRow(it) {
                        ktIB(it, colFun, "md" to "${SZ_6.name} $off ${OFF_3.name}")
                    }
                }
            }
        }
    }
}
