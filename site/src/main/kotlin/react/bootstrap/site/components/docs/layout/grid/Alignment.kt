@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Alignments
import react.bootstrap.layout.grid.ItemsXs
import react.bootstrap.layout.grid.ItemsYs
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.ktContainer
import react.dom.a
import react.dom.p

internal class Alignment : SectionComponent() {
    override val title: String = "Alignment"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
                Use flexbox alignment utilities to vertically and horizontally align columns. <Internet Explorer 10-11
                do not support vertical alignment of flex items when the flex container has a |strong><min-height|code>
                <as shown below|strong>.
            """.trimIndent()
        }
        p {
            a(href = "https://github.com/philipwalton/flexbugs#flexbug-3") { +" See Flexbugs #3 for more details" }
            +"."
        }
        subSectionTitle("Vertical alignment", section)
        flexColsExampleRow {
            liveExample {
                container {
                    row(all = ItemsYs.START) {
                        for (x in 1..3) {
                            col { +"One of three columns" }
                        }
                    }
                    row(all = ItemsYs.CENTER) {
                        for (x in 1..3) {
                            col { +"One of three columns" }
                        }
                    }
                    row(all = ItemsYs.END) {
                        for (x in 1..3) {
                            col { +"One of three columns" }
                        }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(ItemsYs::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to ItemsYs.START.kt) {
                        for (x in 1..3) {
                            ktIB(it, colFun) { "+\"One of three columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsYs.CENTER.kt) {
                        for (x in 1..3) {
                            ktIB(it, colFun) { "+\"One of three columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsYs.END.kt) {
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
                        col(all = Alignments.START) { +"One of three columns" }
                        col(all = Alignments.CENTER) { +"One of three columns" }
                        col(all = Alignments.END) { +"One of three columns" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(Alignments::class)
                importColFun()
                importRowFun()
                ln { }
                ktConRow {
                    ktIB(it, colFun, "all" to Alignments.START.kt) { "+\"One of three columns\"" }
                    ktIB(it, colFun, "all" to Alignments.CENTER.kt) { "+\"One of three columns\"" }
                    ktIB(it, colFun, "all" to Alignments.END.kt) { "+\"One of three columns\"" }
                }
            }
        }
        subSectionTitle("Horizontal alignment", section)
        exampleRow {
            liveExample {
                container {
                    row(all = ItemsXs.START) {
                        for (x in 1..2) {
                            col(all = Sizes.SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = ItemsXs.CENTER) {
                        for (x in 1..2) {
                            col(all = Sizes.SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = ItemsXs.END) {
                        for (x in 1..2) {
                            col(all = Sizes.SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = ItemsXs.AROUND) {
                        for (x in 1..2) {
                            col(all = Sizes.SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = ItemsXs.BETWEEN) {
                        for (x in 1..2) {
                            col(all = Sizes.SZ_4) { +"One of two columns" }
                        }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(ItemsXs::class)
                importGridEnum(Sizes::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to ItemsXs.START.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to Sizes.SZ_4.kt) { "+\"One of two columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsXs.CENTER.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to Sizes.SZ_4.kt) { "+\"One of two columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsXs.END.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to Sizes.SZ_4.kt) { "+\"One of two columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsXs.AROUND.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to Sizes.SZ_4.kt) { "+\"One of two columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsXs.BETWEEN.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to Sizes.SZ_4.kt) { "+\"One of two columns\"" }
                        }
                    }
                }
            }
        }
    }
}
