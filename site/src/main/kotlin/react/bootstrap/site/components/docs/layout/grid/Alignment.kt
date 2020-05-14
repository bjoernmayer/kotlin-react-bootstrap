@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ColAttributes.Alignment.Companion.CENTER
import react.bootstrap.layout.grid.ColAttributes.Alignment.Companion.END
import react.bootstrap.layout.grid.ColAttributes.Alignment.Companion.START
import react.bootstrap.layout.grid.ColAttributes.Size.Companion.SZ_4
import react.bootstrap.layout.grid.ItemsXs
import react.bootstrap.layout.grid.ItemsYs
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.ktContainer
import react.bootstrap.site.external.Markdown

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
                        col(all = START) { +"One of three columns" }
                        col(all = CENTER) { +"One of three columns" }
                        col(all = END) { +"One of three columns" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                import("layout.grid.ColAttributes.Alignment.Companion.CENTER")
                import("layout.grid.ColAttributes.Alignment.Companion.END")
                import("layout.grid.ColAttributes.Alignment.Companion.START")
                importColFun()
                importRowFun()
                ln { }
                ktConRow {
                    ktIB(it, colFun, "all" to START.name) { "+\"One of three columns\"" }
                    ktIB(it, colFun, "all" to CENTER.name) { "+\"One of three columns\"" }
                    ktIB(it, colFun, "all" to END.name) { "+\"One of three columns\"" }
                }
            }
        }
        subSectionTitle("Horizontal alignment", section)
        exampleRow {
            liveExample {
                container {
                    row(all = ItemsXs.START) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = ItemsXs.CENTER) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = ItemsXs.END) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = ItemsXs.AROUND) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
                        }
                    }
                    row(all = ItemsXs.BETWEEN) {
                        for (x in 1..2) {
                            col(all = SZ_4) { +"One of two columns" }
                        }
                    }
                }
            }
            codeExample {
                importContainerFun()
                import("layout.grid.ColAttributes.Size.Companion.SZ_4")
                importGridEnum(ItemsXs::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "all" to ItemsXs.START.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsXs.CENTER.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsXs.END.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsXs.AROUND.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                    ktB(it, rowFun, "all" to ItemsXs.BETWEEN.kt) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "all" to SZ_4.name) { "+\"One of two columns\"" }
                        }
                    }
                }
            }
        }
    }
}
