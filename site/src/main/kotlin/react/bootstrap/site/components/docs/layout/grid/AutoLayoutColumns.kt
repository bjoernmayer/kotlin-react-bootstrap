@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.AUTO
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_2
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_5
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_6
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.container
import react.bootstrap.layout.grid.row.row
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importColFun
import react.bootstrap.site.components.docs.importFromGrid
import react.bootstrap.site.components.docs.importRowFun
import react.bootstrap.site.components.docs.importContainerFun
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
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
                +Imports.builder()
                    .importFromGrid("col", EQ.import)
                    .importColFun()
                    .importContainerFun()
                    .importRowFun()
                    .build()

                +FunCall.builder(RBuilder::container)
                    .setLambdaArgument(
                        FunCall.builder(RBuilder::row)
                            .setLambdaArgument(
                                buildString {
                                    for (x in 1..2) {
                                        append(
                                            FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                                .setLambdaArgument(plusString("$x of 2"))
                                                .build()
                                        )
                                    }
                                },
                                "// Same as: \n// ",
                                FunCall.builder(RBuilder::col, FunCall.Style.INLINE)
                                    .addArgument(FunCall.Argument.PureValue(EQ.name))
                                    .setLambdaArgument(plusString("x of 2"))
                                    .build()
                            )
                            .build(),
                        FunCall.builder(RBuilder::row)
                            .setLambdaArgument(
                                buildString {
                                    for (x in 1..3) {
                                        append(
                                            FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                                .setLambdaArgument(plusString("$x of 3"))
                                                .build()
                                        )
                                    }
                                }
                            )
                            .build()
                    )
                    .build()
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
                +Imports.builder()
                    .importFromGrid("col", SZ_5.import)
                    .importFromGrid("col", SZ_6.import)
                    .importColFun()
                    .importContainerFun()
                    .importRowFun()
                    .build()

                +FunCall.builder(RBuilder::container)
                    .setLambdaArgument(
                        listOf(SZ_5, SZ_6).joinToString("") { size ->
                            FunCall.builder(RBuilder::row)
                                .setLambdaArgument(
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .setLambdaArgument(plusString("1 of 3"))
                                        .build(),
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .addArgument("all", FunCall.Argument.PureValue(size.name))
                                        .setLambdaArgument(plusString("2 of 3 (wider)"))
                                        .build(),
                                    FunCall.builder(RBuilder::col, FunCall.Style.INLINE)
                                        .setLambdaArgument(plusString("3 of 3"))
                                        .build(),
                                )
                                .build()
                        }
                    )
                    .build()
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
                +Imports.builder()
                    .importFromGrid("col", AUTO.import)
                    .importFromGrid("col", EQ.import)
                    .importFromGrid("col", SZ_2.import)
                    .importColFun()
                    .importContainerFun()
                    .importRowFun()
                    .importClassNames()
                    .build()

                +FunCall.builder(RBuilder::container)
                    .setLambdaArgument(
                        FunCall.builder(RBuilder::row)
                            .addArgument("classes", ClassNames.JUSTIFY_CONTENT_MD_CENTER)
                            .setLambdaArgument(
                                FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                    .addArgument("all", FunCall.Argument.PureValue(EQ.name))
                                    .addArgument("lg", FunCall.Argument.PureValue(SZ_2.name))
                                    .setLambdaArgument(plusString("1 of 3"))
                                    .build(),
                                FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                    .addArgument("md", FunCall.Argument.PureValue(AUTO.name))
                                    .setLambdaArgument(plusString("Variable width content"))
                                    .build(),
                                FunCall.builder(RBuilder::col, FunCall.Style.INLINE)
                                    .addArgument("all", FunCall.Argument.PureValue(EQ.name))
                                    .addArgument("lg", FunCall.Argument.PureValue(SZ_2.name))
                                    .setLambdaArgument(plusString("3 of 3"))
                                    .build(),
                            )
                            .build(),
                        FunCall.builder(RBuilder::row)
                            .setLambdaArgument(
                                FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                    .setLambdaArgument(plusString("1 of 3"))
                                    .build(),
                                FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                    .addArgument("md", FunCall.Argument.PureValue(AUTO.name))
                                    .setLambdaArgument(plusString("Variable width content"))
                                    .build(),
                                FunCall.builder(RBuilder::col, FunCall.Style.INLINE)
                                    .addArgument("all", FunCall.Argument.PureValue(EQ.name))
                                    .addArgument("lg", FunCall.Argument.PureValue(SZ_2.name))
                                    .setLambdaArgument(plusString("3 of 3"))
                                    .build(),
                            )
                            .build()
                    )
                    .build()
            }
        }
    }
}
