@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.grid.col.ColAttributes.Alignments.Companion.CENTER
import react.bootstrap.layout.grid.col.ColAttributes.Alignments.Companion.END
import react.bootstrap.layout.grid.col.ColAttributes.Alignments.Companion.START
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_4
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.container
import react.bootstrap.layout.grid.row.row
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.ktContainer
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.layout.grid.row.RowAttributes.ItemsXs.Companion.AROUND as rxAROUND
import react.bootstrap.layout.grid.row.RowAttributes.ItemsXs.Companion.BETWEEN as rxBETWEEN
import react.bootstrap.layout.grid.row.RowAttributes.ItemsXs.Companion.CENTER as rxCENTER
import react.bootstrap.layout.grid.row.RowAttributes.ItemsXs.Companion.END as rxEND
import react.bootstrap.layout.grid.row.RowAttributes.ItemsXs.Companion.START as rxSTART
import react.bootstrap.layout.grid.row.RowAttributes.ItemsYs.Companion.CENTER as ryCENTER
import react.bootstrap.layout.grid.row.RowAttributes.ItemsYs.Companion.END as ryEND
import react.bootstrap.layout.grid.row.RowAttributes.ItemsYs.Companion.START as rySTART

internal class Alignment : SectionComponent() {
    override val title: String = "Alignment"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Use flexbox alignment utilities to vertically and horizontally align columns. __Internet Explorer 10-11 do not support
vertical alignment of flex items when the flex container has a `min-height` as shown below__. [See Flexbugs #3 for more
details]("https://github.com/philipwalton/flexbugs#flexbug-3").
            """
        }
        subSectionTitle("Vertical alignment", section)
        flexColsExampleRow {
            liveExample {
                container {
                    row(all = rySTART) {
                        for (x in 1..3) {
                            col { +"One of three columns" }
                        }
                    }
                    row(all = ryCENTER) {
                        for (x in 1..3) {
                            col { +"One of three columns" }
                        }
                    }
                    row(all = ryEND) {
                        for (x in 1..3) {
                            col { +"One of three columns" }
                        }
                    }
                }
            }
            codeExample {
                importColFun()
                importContainerFun()
                importFromGrid("row", ryCENTER.import)
                importFromGrid("row", ryEND.import)
                importFromGrid("row", rySTART.import)
                importRowFun()
                ln { }

                ktContainer {
                    ktFun(RBuilder::row, args = mapOf("all" to rySTART.name)) {
                        for (x in 1..3) {
                            ktFun(RBuilder::col, style = FunStyle.INLINE_BLOCK) { string("One of three columns") }
                        }
                    }
                    ktFun(RBuilder::row, args = mapOf("all" to ryCENTER.name)) {
                        for (x in 1..3) {
                            ktFun(RBuilder::col, style = FunStyle.INLINE_BLOCK) { string("One of three columns") }
                        }
                    }
                    ktFun(RBuilder::row, args = mapOf("all" to ryEND.name)) {
                        for (x in 1..3) {
                            ktFun(RBuilder::col, style = FunStyle.INLINE_BLOCK) { string("One of three columns") }
                        }
                    }
                }
            }
        }
        flexColsExampleRow {
            liveExample {
                container {
                    row {
                        col(all = START) { +"One of three columns" }
                        col(all = CENTER) { +"One of three columns" }
                        col(all = END) { +"One of three columns" }
                    }
                }
            }
            codeExample {
                importFromGrid("col", CENTER.import)
                importFromGrid("col", END.import)
                importFromGrid("col", START.import)
                importColFun()
                importContainerFun()
                importRowFun()
                ln { }
                ktConRow {
                    ktFun(
                        RBuilder::col,
                        style = FunStyle.INLINE_BLOCK,
                        args = mapOf("all" to START.name)
                    ) { string("One of three columns") }
                    ktFun(
                        RBuilder::col,
                        style = FunStyle.INLINE_BLOCK,
                        args = mapOf("all" to CENTER.name)
                    ) { string("One of three columns") }
                    ktFun(
                        RBuilder::col,
                        style = FunStyle.INLINE_BLOCK,
                        args = mapOf("all" to END.name)
                    ) { string("One of three columns") }
                }
            }
        }
        subSectionTitle("Horizontal alignment", section)
        exampleRow {
            liveExample {
                container {
                    listOf(rxSTART, rxCENTER, rxEND, rxAROUND, rxBETWEEN).forEach {
                        row(all = it) {
                            for (x in 1..2) {
                                col(all = SZ_4) { +"One of two columns" }
                            }
                        }
                    }
                }
            }
            codeExample {
                importFromGrid("col", SZ_4.import)
                importFromGrid("row", rxAROUND.import)
                importFromGrid("row", rxBETWEEN.import)
                importFromGrid("row", rxCENTER.import)
                importFromGrid("row", rxEND.import)
                importFromGrid("row", rxSTART.import)
                importColFun()
                importContainerFun()
                importRowFun()
                ln { }

                ktContainer {
                    listOf(rxSTART.name, rxCENTER.name, rxEND.name, rxAROUND.name, rxBETWEEN.name).forEach {
                        ktFun(RBuilder::row, args = mapOf("all" to it)) {
                            for (x in 1..2) {
                                ktFun(
                                    RBuilder::col,
                                    style = FunStyle.INLINE_BLOCK,
                                    args = mapOf("all" to SZ_4.name)
                                ) { string("One of two columns") }
                            }
                        }
                    }
                }
            }
        }
    }
}
