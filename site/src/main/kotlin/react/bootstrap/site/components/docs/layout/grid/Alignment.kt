@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter", "DuplicatedCode")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.grid.col.ColAttributes.Alignments.Companion.CENTER
import react.bootstrap.layout.grid.col.ColAttributes.Alignments.Companion.END
import react.bootstrap.layout.grid.col.ColAttributes.Alignments.Companion.START
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_4
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.container
import react.bootstrap.layout.grid.row.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.ktF
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.ktIF
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.ktContainer
import react.bootstrap.site.external.Markdown
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
                    ktF(it, rowFun, "all" to rySTART.name) {
                        for (x in 1..3) {
                            ktIB(it, colFun) { "+\"One of three columns\"" }
                        }
                    }
                    ktF(it, rowFun, "all" to ryCENTER.name) {
                        for (x in 1..3) {
                            ktIB(it, colFun) { "+\"One of three columns\"" }
                        }
                    }
                    ktF(it, rowFun, "all" to ryEND.name) {
                        for (x in 1..3) {
                            ktIB(it, colFun) { "+\"One of three columns\"" }
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
                    ktIF(it, colFun, "all" to START.name) { "+\"One of three columns\"" }
                    ktIF(it, colFun, "all" to CENTER.name) { "+\"One of three columns\"" }
                    ktIF(it, colFun, "all" to END.name) { "+\"One of three columns\"" }
                }
            }
        }
        subSectionTitle("Horizontal alignment", section)
        exampleRow {
            liveExample {
                container {
                    row(all = rxSTART) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = rxCENTER) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = rxEND) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = rxAROUND) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = rxBETWEEN) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
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
                    ktF(it, rowFun, "all" to rxSTART.name) {
                        for (x in 1..2) {
                            ktIF(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                    ktF(it, rowFun, "all" to rxCENTER.name) {
                        for (x in 1..2) {
                            ktIF(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                    ktF(it, rowFun, "all" to rxEND.name) {
                        for (x in 1..2) {
                            ktIF(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                    ktF(it, rowFun, "all" to rxAROUND.name) {
                        for (x in 1..2) {
                            ktIF(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                    ktF(it, rowFun, "all" to rxBETWEEN.name) {
                        for (x in 1..2) {
                            ktIF(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                }
            }
        }
    }
}
