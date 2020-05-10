@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Offsets
import react.bootstrap.layout.grid.Orderings
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.ktContainer
import react.dom.a
import react.dom.code
import react.dom.h4
import react.dom.p

internal class Reordering : SectionComponent() {
    override val title: String = "Reordering"

    private val offsetsName = Offsets::class.simpleName!!
    private val orderingsName = Orderings::class.simpleName!!

    override fun RBuilder.render() {
        sectionTitle(section)
        subSectionTitle("$orderingsName enum", section)
        formattedText {
            """
                Use <$orderingsName|code> values for controlling the <visual order|strong>  of your content. The classes
                are responsive, so you can set the <order|code> by breakpoint (e.g., <all = ${Orderings.ORD_1.kt}, md =
                ${Orderings.ORD_2.kt}|code>). Includes support for 1 through 12 across all five grid tiers.
            """.trimIndent()
        }
        exampleRow {
            liveExample {
                container {
                    row {
                        col { +"First in DOM, no order applied" }
                        col(all = Orderings.ORD_12) { +" Second in DOM, with a larger order" }
                        col(all = Orderings.ORD_1) { +"Third in DOM, with an order of 1" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(Orderings::class)
                importColFun()
                importRowFun()
                ln { }
                ktConRow {
                    ktIB(it, colFun, "+\"First in DOM, no order applied\"")
                    ktIB(it, colFun, "all" to Orderings.ORD_12.kt) { "+\" Second in DOM, with a larger order\"" }
                    ktIB(it, colFun, "all" to Orderings.ORD_1.kt) { "+\"Third in DOM, with an order of 1\"" }
                }
            }
        }
        subSectionTitle("Offsetting columns", section)
        p {
            +"You can offset grid columns in two ways: our "; code { +offsetsName }; +" values and Bootstrap's "
            a("https://getbootstrap.com/docs/4.4/utilities/spacing/") { +"margin utilities" }; +". Grid classes "
            +"are sized to match columns while margins are more useful for quick layouts where the width of the offset "
            +"is variable."
        }
        contentTitle(RBuilder::h4, "$offsetsName enum")
        p {
            +"Move columns to the right by setting "; code { +offsetsName }; +" enum values. These increase the left"
            +" margin of a column by "; code { +"*" }; +" columns. For example, "
            code {
                +"md = ${Sizes.SZ_4.kt} off ${Offsets.OFF_4.kt}"
            }
            +" moves "; code { +"$colFun(md = ${Sizes.SZ_4.kt}) { }" }; +" over four columns."
        }
        val off = Sizes::off.name
        exampleRow {
            liveExample {
                container {
                    row {
                        col(md = Sizes.SZ_4) { +"md = ${Sizes.SZ_4.kt}" }
                        col(md = Sizes.SZ_4 off Offsets.OFF_4) { +"md = ${Sizes.SZ_4.kt} $off ${Offsets.OFF_4.kt}" }
                    }
                    row {
                        for (x in 1..2) {
                            col(md = Sizes.SZ_3 off Offsets.OFF_3) { +"md = ${Sizes.SZ_3.kt} $off ${Offsets.OFF_3.kt}" }
                        }
                    }
                    row {
                        col(md = Sizes.SZ_6 off Offsets.OFF_3) { +"md = ${Sizes.SZ_6.kt} $off ${Offsets.OFF_3.kt}" }
                    }
                }
            }
            codeExample {
                importContainerFun()
                importGridEnum(Offsets::class)
                importGridEnum(Sizes::class)
                importColFun()
                importRowFun()
                ln { }
                ktContainer {
                    ktRow(it) {
                        ktIB(it, colFun, "md" to Sizes.SZ_4.kt)
                        ktIB(it, colFun, "md" to "${Sizes.SZ_4.kt} $off ${Offsets.OFF_4.kt}")
                    }
                    ktRow(it) {
                        for (x in 1..2) {
                            ktIB(it, colFun, "md" to "${Sizes.SZ_3.kt} $off ${Offsets.OFF_3.kt}")
                        }
                    }
                    ktRow(it) {
                        ktIB(it, colFun, "md" to "${Sizes.SZ_6.kt} $off ${Offsets.OFF_3.kt}")
                    }
                }
            }
        }
    }
}
