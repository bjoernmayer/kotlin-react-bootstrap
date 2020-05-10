@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Sizes
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
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.ktContainer
import react.dom.p

internal class AutoLayoutColumns : SectionComponent() {
    override val title: String = "Auto-layout columns"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
                Utilize breakpoint-specific equal-size enum values for easy column sizing without an explicit numbered
                enum value like <${Sizes.SZ_6.kt}|code>.
            """.trimIndent()
        }
        subSectionTitle("Equal-width", section)
        formattedText {
            """
                For example, here are two grid layouts that apply to every device and viewport, from <xs|code> to
                <xl|code>. Add any number of equal-size enums for each breakpoint you need and every column will be the
                same width.
            """.trimIndent()
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
                importGridEnum(Sizes::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        ktIB(it, colFun, "+\"1 of 2\"")
                        ktIB(it, colFun, "+\"2 of 2\"")
                        ln(it) { +"// Same as: col(all = ${Sizes.EQ.kt}) { +\"x of 2\" }" }
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
                Auto-layout for flexbox grid columns also means you can set the width of one column and have the sibling
                columns automatically resize around it. You may use predefined grid enumbs (as shown below), grid
                mixins, or inline widths. Note that the other columns will resize no matter the width of the center
                column.
            """.trimIndent()
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        col { +"1 of 3" }
                        col(all = Sizes.SZ_6) { +"2 of 3 (wider)" }
                        col { +"3 of 3" }
                    }
                    row {
                        col { +"1 of 3" }
                        col(all = Sizes.SZ_5) { +"2 of 3 (wider)" }
                        col { +"3 of 3" }
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
                        ktIB(it, colFun, "+\"1 of 3\"")
                        ktIB(it, colFun, "all" to Sizes.SZ_6.kt) { "+\"2 of 3 (wider)\"" }
                        ktIB(it, colFun, "+\"3 of 3\"")
                    }
                    ktRow(it) {
                        ktIB(it, colFun, "+\"1 of 3\"")
                        ktIB(it, colFun, "all" to Sizes.SZ_5.kt) { "+\"2 of 3 (wider)\"" }
                        ktIB(it, colFun, "+\"3 of 3\"")
                    }
                }
            }
        }
        subSectionTitle("Variable width content", section)
        formattedText {
            "Use the <${Sizes.AUTO.kt}|code> enum value to size columns based on the natural width of their content."
        }
        exampleRow {
            liveExample {
                container {
                    row(classes = "${ClassNames.JUSTIFY_CONTENT_MD_CENTER}") {
                        col(all = Sizes.EQ, lg = Sizes.SZ_2) { +"1 of 3" }
                        col(md = Sizes.AUTO) { +"Variable width content" }
                        col(all = Sizes.EQ, lg = Sizes.SZ_2) { +"3 of 3" }
                    }
                    row {
                        col { +"1 of 3" }
                        col(md = Sizes.AUTO) { +"Variable width content" }
                        col(all = Sizes.EQ, lg = Sizes.SZ_2) { +"3 of 3" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(Sizes::class)
                importColFun()
                importRowFun()
                importClassNames()
                ln { }
                ktContainer {
                    ktB(it, rowFun, "classes" to "\"\${${ClassNames.JUSTIFY_CONTENT_MD_CENTER.kt}}\"") {
                        ktIB(it, colFun, "all" to Sizes.EQ.kt, "lg" to Sizes.SZ_2.kt) { "+\"1 of 3\"" }
                        @Suppress("DuplicatedCode")
                        ktIB(it, colFun, "md" to Sizes.AUTO.kt) { "+\"Variable width content\"" }
                        ktIB(it, colFun, "all" to Sizes.EQ.kt, "lg" to Sizes.SZ_2.kt) { "+\"3 of 3\"" }
                    }
                    ktRow(it) {
                        ktIB(it, colFun, "+\"1 of 3\"")
                        ktIB(it, colFun, "md" to Sizes.AUTO.kt) { "+\"Variable width content\"" }
                        ktIB(it, colFun, "all" to Sizes.EQ.kt, "lg" to Sizes.SZ_2.kt) { "+\"3 of 3\"" }
                    }
                }
            }
        }
    }
}
