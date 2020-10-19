@file:Suppress("NAME_SHADOWING", "DuplicatedCode", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.grid.col.ColAttributes
import react.bootstrap.layout.grid.col.ColAttributes.Alignments.Companion.END
import react.bootstrap.layout.grid.col.ColAttributes.Offsets.Companion.OFF_1
import react.bootstrap.layout.grid.col.ColAttributes.Orderings.Companion.ORD_3
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_4
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.container
import react.bootstrap.layout.grid.row.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importColFun
import react.bootstrap.site.components.docs.importFromGrid
import react.bootstrap.site.components.docs.importRowFun
import react.bootstrap.site.components.docs.importContainerFun
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.h4
import react.dom.p
import kotlin.reflect.KFunction2

/* ktlint-disable parameter-list-wrapping */
internal class Combining : SectionComponent() {
    private val sz = ColAttributes.Offsets::sz.name
    private val ord = ColAttributes.Sizes::ord.name
    private val off = ColAttributes.Sizes::off.name
    private val align = ColAttributes.Sizes::align.name

    private val sizes = ColAttributes.Sizes::class.simpleName
    private val offsets = ColAttributes.Offsets::class.simpleName
    private val orderings = ColAttributes.Orderings::class.simpleName
    private val alignments = ColAttributes.Alignments::class.simpleName

    override val title: String = "$sizes, $offsets, $orderings, $alignments"

    override fun RBuilder.render() {
        sectionTitle(section)
        p {
            +"""
As you can see in the examples above, all col attributes are set using the same arguments. Custom
pairing functions are used to combine the values.
            """
        }
        subSectionTitle("Combine with $sizes", section)
        Markdown {
            //language=Markdown
            +"""
Combine other attributes with `$sizes` by using `$sz`.
            """
        }
        flexColsExampleRow {
            liveExample {
                container {
                    row {
                        col(all = OFF_1 sz SZ_4) { +"all = ${OFF_1.name} $sz ${SZ_4.name}" }
                        col { +"Reference" }
                    }
                    row {
                        col(all = ORD_3 sz SZ_4) { +"all = ${ORD_3.name} $sz ${SZ_4.name}" }
                        col { +"Reference" }
                    }
                    row {
                        col(all = END sz SZ_4) { +"all = ${END.name} $sz ${SZ_4.name}" }
                        col { +"Reference" }
                    }
                }
            }
            codeExample {
                +Imports.builder()
                    .importFromGrid("col", END.import)
                    .importFromGrid("col", OFF_1.import)
                    .importFromGrid("col", ORD_3.import)
                    .importFromGrid("col", SZ_4.import)
                    .importColFun()
                    .importContainerFun()
                    .importRowFun()
                    .build()

                +FunCall.builder(RBuilder::container)
                    .setLambdaArgument(
                        listOf(
                            "${OFF_1.name} $sz ${SZ_4.name}",
                            "${ORD_3.name} $sz ${SZ_4.name}",
                            "${END.name} $sz ${SZ_4.name}"
                        ).joinToString("") {
                            FunCall.builder(RBuilder::row)
                                .setLambdaArgument(
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .addArgument("all", FunCall.Argument.PureValue(it))
                                        .setLambdaArgument(plusString("all = $it"))
                                        .build(),
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .setLambdaArgument(plusString("Reference"))
                                        .build()
                                )
                                .build()
                        }
                    )
                    .build()
            }
        }

        subSectionTitle("Combine with $offsets", section)
        Markdown {
            //language=Markdown
            +"""
Combine other attributes with `$offsets` by using `$off`.
            """
        }
        flexColsExampleRow {
            liveExample {
                container {
                    row {
                        col(all = SZ_4 off OFF_1) { +"all = ${SZ_4.name} $off ${OFF_1.name}" }
                        col { +"Reference" }
                    }
                    row {
                        col(all = ORD_3 off OFF_1) { +"all = ${ORD_3.name} $off ${OFF_1.name}" }
                        col { +"Reference" }
                    }
                    row {
                        col(all = END off OFF_1) { +"all = ${END.name} $off ${OFF_1.name}" }
                        col { +"Reference" }
                    }
                }
            }
            codeExample {
                +Imports.builder()
                    .importFromGrid("col", END.import)
                    .importFromGrid("col", OFF_1.import)
                    .importFromGrid("col", ORD_3.import)
                    .importFromGrid("col", SZ_4.import)
                    .importColFun()
                    .importContainerFun()
                    .importRowFun()
                    .build()

                +FunCall.builder(RBuilder::container)
                    .setLambdaArgument(
                        listOf(
                            "${SZ_4.name} $off ${OFF_1.name}",
                            "${ORD_3.name} $off ${OFF_1.name}",
                            "${END.name} $off ${OFF_1.name}"
                        ).joinToString("") {
                            FunCall.builder(RBuilder::row)
                                .setLambdaArgument(
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .addArgument("all", FunCall.Argument.PureValue(it))
                                        .setLambdaArgument(plusString("all = $it"))
                                        .build(),
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .setLambdaArgument(plusString("Reference"))
                                        .build()
                                )
                                .build()
                        }
                    )
                    .build()
            }
        }

        subSectionTitle("Combine with $orderings", section)
        Markdown {
            //language=Markdown
            +"""
Combine other attributes with `$orderings` by using `$ord`.
            """
        }
        flexColsExampleRow {
            liveExample {
                container {
                    row {
                        col(all = SZ_4 ord ORD_3) { +"all = ${SZ_4.name} $ord ${ORD_3.name}" }
                        col { +"Reference" }
                    }
                    row {
                        col(all = OFF_1 ord ORD_3) { +"all = ${OFF_1.name} $ord ${ORD_3.name}" }
                        col { +"Reference" }
                    }
                    row {
                        col(all = END ord ORD_3) { +"all = ${END.name} $ord ${ORD_3.name}" }
                        col { +"Reference" }
                    }
                }
            }
            codeExample {
                +Imports.builder()
                    .importFromGrid("col", END.import)
                    .importFromGrid("col", OFF_1.import)
                    .importFromGrid("col", ORD_3.import)
                    .importFromGrid("col", SZ_4.import)
                    .importColFun()
                    .importContainerFun()
                    .importRowFun()
                    .build()

                +FunCall.builder(RBuilder::container)
                    .setLambdaArgument(
                        listOf(
                            "${SZ_4.name} $ord ${ORD_3.name}",
                            "${OFF_1.name} $ord ${ORD_3.name}",
                            "${END.name} $ord ${ORD_3.name}"
                        ).joinToString("") {
                            FunCall.builder(RBuilder::row)
                                .setLambdaArgument(
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .addArgument("all", FunCall.Argument.PureValue(it))
                                        .setLambdaArgument(plusString("all = $it"))
                                        .build(),
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .setLambdaArgument(plusString("Reference"))
                                        .build()
                                )
                                .build()
                        }
                    )
                    .build()
            }
        }

        subSectionTitle("Combine with $alignments", section)
        Markdown {
            //language=Markdown
            +"""
Combine other attributes with `$alignments` by using `$align`.
            """
        }
        flexColsExampleRow {
            liveExample {
                container {
                    row {
                        col(all = SZ_4 align END) { +"all = ${SZ_4.name} $align ${END.name}" }
                        col { +"Reference" }
                    }
                    row {
                        col(all = OFF_1 align END) { +"all = ${OFF_1.name} $align ${END.name}" }
                        col { +"Reference" }
                    }
                    row {
                        col(all = ORD_3 align END) { +"all = ${ORD_3.name} $align ${END.name}" }
                        col { +"Reference" }
                    }
                }
            }
            codeExample {
                +Imports.builder()
                    .importFromGrid("col", END.import)
                    .importFromGrid("col", OFF_1.import)
                    .importFromGrid("col", ORD_3.import)
                    .importFromGrid("col", SZ_4.import)
                    .importColFun()
                    .importContainerFun()
                    .importRowFun()
                    .build()

                +FunCall.builder(RBuilder::container)
                    .setLambdaArgument(
                        listOf(
                            "${SZ_4.name} $align ${END.name}",
                            "${OFF_1.name} $align ${END.name}",
                            "${ORD_3.name} $align ${END.name}"
                        ).joinToString("") {
                            FunCall.builder(RBuilder::row)
                                .setLambdaArgument(
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .addArgument("all", FunCall.Argument.PureValue(it))
                                        .setLambdaArgument(plusString("all = $it"))
                                        .build(),
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .setLambdaArgument(plusString("Reference"))
                                        .build()
                                )
                                .build()
                        }
                    )
                    .build()
            }
        }

        subSectionTitle("Combine all", section)
        p {
            +"You can use the same pairing functions in any order to combine all attributes."
        }
        allPossibleCombinations()
    }
}

private fun RBuilder.allPossibleCombinations() {
    val sizeOffsetOrderFun = ColAttributes.SizeOffsetPair::ord
    val sizeOffsetAlignmentFun = ColAttributes.SizeOffsetPair::align

    val sizeOrderOffsetFun = ColAttributes.SizeOrderPair::off
    val sizeOrderAlignmentFun = ColAttributes.SizeOrderPair::align

    val sizeAlignmentOffsetFun = ColAttributes.SizeAlignmentPair::off
    val sizeAlignmentOrderFun = ColAttributes.SizeAlignmentPair::ord

    val offsetOrderSizeFun = ColAttributes.OffsetOrderPair::sz
    val offsetOrderAlignmentFun = ColAttributes.OffsetOrderPair::align

    val offsetAlignmentSizeFun = ColAttributes.OffsetAlignmentPair::sz
    val offsetAlignmentOrderFun = ColAttributes.OffsetAlignmentPair::ord

    val orderAlignmentSizeFun = ColAttributes.OrderAlignmentPair::sz
    val orderAlignmentOffsetFun = ColAttributes.OrderAlignmentPair::off

    val sizeToOffset = Pairing(SZ_4, OFF_1, ColAttributes.Sizes::off)
    val sizeToOrder = Pairing(SZ_4, ORD_3, ColAttributes.Sizes::ord)
    val sizeToAlignment = Pairing(SZ_4, END, ColAttributes.Sizes::align)

    val offsetToOrder = Pairing(OFF_1, ORD_3, ColAttributes.Offsets::ord)
    val offsetToAlignment = Pairing(OFF_1, END, ColAttributes.Offsets::align)
    val offsetToSize = Pairing(OFF_1, SZ_4, ColAttributes.Offsets::sz)

    val orderToSize = Pairing(ORD_3, SZ_4, ColAttributes.Orderings::sz)
    val orderToOffset = Pairing(ORD_3, OFF_1, ColAttributes.Orderings::off)
    val orderToAlignment = Pairing(ORD_3, END, ColAttributes.Orderings::align)

    val alignmentToSize = Pairing(END, SZ_4, ColAttributes.Alignments::sz)
    val alignmentToOffset = Pairing(END, OFF_1, ColAttributes.Alignments::off)
    val alignmentToOrder = Pairing(END, ORD_3, ColAttributes.Alignments::ord)

    val sizeOffsetToOrder = Tripling(ORD_3, sizeToOffset, offsetToSize, sizeOffsetOrderFun)
    val sizeOffsetToAlignment = Tripling(END, sizeToOffset, offsetToSize, sizeOffsetAlignmentFun)

    val sizeOrderToOffset = Tripling(OFF_1, sizeToOrder, orderToSize, sizeOrderOffsetFun)
    val sizeOrderToAlignment = Tripling(END, sizeToOrder, orderToSize, sizeOrderAlignmentFun)

    val sizeAlignmentToOffset = Tripling(OFF_1, sizeToAlignment, alignmentToSize, sizeAlignmentOffsetFun)
    val sizeAlignmentToOrder = Tripling(ORD_3, sizeToAlignment, alignmentToSize, sizeAlignmentOrderFun)

    val offsetSizeToOrder = Tripling(ORD_3, offsetToSize, sizeToOffset, sizeOffsetOrderFun)
    val offsetSizeToAlignment = Tripling(END, offsetToSize, sizeToOffset, sizeOffsetAlignmentFun)

    val offsetOrderToSize = Tripling(SZ_4, offsetToOrder, orderToOffset, offsetOrderSizeFun)
    val offsetOrderToAlignment = Tripling(END, offsetToOrder, orderToOffset, offsetOrderAlignmentFun)

    val offsetAlignmentToSize = Tripling(SZ_4, offsetToAlignment, alignmentToOffset, offsetAlignmentSizeFun)
    val offsetAlignmentToOrder =
        Tripling(ORD_3, offsetToAlignment, alignmentToOffset, offsetAlignmentOrderFun)

    val orderSizeToOffset = Tripling(OFF_1, orderToSize, sizeToOrder, sizeOrderOffsetFun)
    val orderSizeToAlignment = Tripling(END, orderToSize, sizeToOrder, sizeOrderAlignmentFun)

    val orderOffsetToSize = Tripling(SZ_4, orderToOffset, offsetToOrder, offsetOrderSizeFun)
    val orderOffsetToAlignment = Tripling(END, orderToOffset, offsetToOrder, offsetOrderAlignmentFun)

    val orderAlignmentToSize = Tripling(SZ_4, orderToAlignment, alignmentToOrder, orderAlignmentSizeFun)
    val orderAlignmentToOffset = Tripling(OFF_1, orderToAlignment, alignmentToOrder, orderAlignmentOffsetFun)

    val alignmentSizeToOffset = Tripling(OFF_1, alignmentToSize, sizeToAlignment, sizeAlignmentOffsetFun)
    val alignmentSizeToOrder = Tripling(ORD_3, alignmentToSize, sizeToAlignment, sizeAlignmentOrderFun)

    val alignmentOffsetToSize = Tripling(SZ_4, alignmentToOffset, offsetToAlignment, offsetAlignmentSizeFun)
    val alignmentOffsetToOrder =
        Tripling(ORD_3, alignmentToOffset, offsetToAlignment, offsetAlignmentOrderFun)

    val alignmentOrderToSize = Tripling(SZ_4, alignmentToOrder, orderToAlignment, orderAlignmentSizeFun)
    val alignmentOrderToOffset = Tripling(OFF_1, alignmentToOrder, orderToAlignment, orderAlignmentOffsetFun)

    val sizeQuadruple = Quadruple(
        quadrupleThis = SZ_4,
        quadrupleWith1 = offsetOrderToAlignment,
        quadrupleWith2 = offsetAlignmentToOrder,
        quadrupleWith3 = orderAlignmentToOffset,
        quadrupleWith4 = orderOffsetToAlignment,
        quadrupleWith5 = alignmentOffsetToOrder,
        quadrupleWith6 = alignmentOrderToOffset,
        quadrupleUsing = ColAttributes.OffsetOrderAlignmentTriple::sz
    )

    val offsetQuadruple = Quadruple(
        quadrupleThis = OFF_1,
        quadrupleWith1 = sizeOrderToAlignment,
        quadrupleWith2 = sizeAlignmentToOrder,
        quadrupleWith3 = orderAlignmentToSize,
        quadrupleWith4 = orderSizeToAlignment,
        quadrupleWith5 = alignmentSizeToOrder,
        quadrupleWith6 = alignmentOrderToSize,
        quadrupleUsing = ColAttributes.SizeOrderAlignmentTriple::off
    )

    val orderQuadruple = Quadruple(
        quadrupleThis = ORD_3,
        quadrupleWith1 = sizeOffsetToAlignment,
        quadrupleWith2 = sizeAlignmentToOffset,
        quadrupleWith3 = offsetAlignmentToSize,
        quadrupleWith4 = offsetSizeToAlignment,
        quadrupleWith5 = alignmentSizeToOffset,
        quadrupleWith6 = alignmentOffsetToSize,
        quadrupleUsing = ColAttributes.SizeOffsetAlignmentTriple::ord
    )

    val alignmentQuadruple = Quadruple(
        quadrupleThis = END,
        quadrupleWith1 = sizeOffsetToOrder,
        quadrupleWith2 = sizeOrderToOffset,
        quadrupleWith3 = offsetOrderToSize,
        quadrupleWith4 = offsetSizeToOrder,
        quadrupleWith5 = orderSizeToOffset,
        quadrupleWith6 = orderOffsetToSize,
        quadrupleUsing = ColAttributes.SizeOffsetOrderTriple::align
    )

    val quadruples = listOf(sizeQuadruple, offsetQuadruple, orderQuadruple, alignmentQuadruple)

    val allTriplings = mutableListOf<Tripling<*, *, *, *, *>>()
    val allPairings = mutableListOf<Pairing<*, *, *>>()

    quadruples.forEach { quadruple ->
        quadruple.withList.forEach { tripling ->
            allTriplings.add(tripling)
            tripling.withList.forEach { pairing ->
                allPairings.add(pairing)
            }
        }
    }

    allPairings.toSet().forEach { pairing ->
        contentTitle(RBuilder::h4, "${pairing.thisClassName} + ${pairing.withClassName}")
        flexColsExampleRow {
            liveExample {
                container {
                    row {
                        col(all = pairing.getPair()) { +"all = ${pairing.argString}" }
                        col { +"Reference" }
                    }
                }
            }
            val imports = listOf(pairing.thisImport, pairing.withImport).sortedBy { it }
            codeExample {
                +Imports.builder()
                    .apply {
                        imports.forEach {
                            importFromGrid("col", it)
                        }
                    }
                    .importColFun()
                    .importContainerFun()
                    .importRowFun()
                    .build()

                +FunCall.builder(RBuilder::container)
                    .setLambdaArgument(
                        FunCall.builder(RBuilder::row)
                            .setLambdaArgument(
                                FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                    .addArgument("all", FunCall.Argument.PureValue(pairing.argString))
                                    .setLambdaArgument(plusString("all = ${pairing.argString}"))
                                    .build(),
                                FunCall.builder(RBuilder::col, FunCall.Style.INLINE)
                                    .setLambdaArgument(plusString("Reference"))
                                    .build()
                            )
                            .build()
                    )
                    .build()
            }
        }
    }

    val shownTriplings = mutableListOf<String>()
    allTriplings.toSet().forEach { tripling ->
        tripling.withList.forEach next@{ pairing ->
            val enumNames = listOf(pairing.thisClassName, pairing.withClassName, tripling.thisClassName)
            val combination = enumNames.joinToString(" + ")
            if (shownTriplings.contains(combination)) {
                return@next
            }
            shownTriplings.add(combination)

            val argString = "${pairing.argString} ${tripling.tripleUsing.name} ${tripling.thisString}"

            contentTitle(RBuilder::h4, combination) { }
            flexColsExampleRow {
                liveExample {
                    container {
                        row {
                            col(all = tripling.getTriple()) { +"all = $argString" }
                            col { +"Reference" }
                        }
                    }
                }
                val imports = listOf(pairing.thisImport, pairing.withImport, tripling.thisImport).sortedBy { it }
                codeExample {
                    +Imports.builder()
                        .apply {
                            imports.forEach {
                                importFromGrid("col", it)
                            }
                        }
                        .importColFun()
                        .importContainerFun()
                        .importRowFun()
                        .build()

                    +FunCall.builder(RBuilder::container)
                        .setLambdaArgument(
                            FunCall.builder(RBuilder::row)
                                .setLambdaArgument(
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .addArgument("all", FunCall.Argument.PureValue(argString))
                                        .setLambdaArgument(plusString("all = $argString"))
                                        .build(),
                                    FunCall.builder(RBuilder::col, FunCall.Style.INLINE)
                                        .setLambdaArgument(plusString("Reference"))
                                        .build()
                                )
                                .build()
                        )
                        .build()
                }
            }
        }
    }

    val shownQuadruples = mutableListOf<String>()
    quadruples.forEach { quadruple ->
        quadruple.withList.forEach { tripling ->
            tripling.withList.forEach next@{ pairing ->
                val combination =
                    "${pairing.thisClassName} + ${pairing.withClassName} + ${tripling.thisClassName} + " +
                        "${quadruple.thisClassName}"
                if (shownQuadruples.contains(combination)) {
                    return@next
                }
                shownQuadruples.add(combination)

                val argString =
                    "${pairing.argString} ${tripling.tripleUsing.name} ${tripling.thisString} " +
                        "${quadruple.quadrupleUsing.name} ${quadruple.thisString}"

                contentTitle(RBuilder::h4, combination)
                flexColsExampleRow {
                    liveExample {
                        container {
                            row {
                                col(all = quadruple.getQuadruple()) { +"all = $argString" }
                                col { +"Reference" }
                            }
                        }
                    }
                }
                codeExample {
                    +Imports.builder()
                        .importFromGrid("col", END.import)
                        .importFromGrid("col", OFF_1.import)
                        .importFromGrid("col", ORD_3.import)
                        .importFromGrid("col", SZ_4.import)
                        .importColFun()
                        .importContainerFun()
                        .importRowFun()
                        .build()

                    +FunCall.builder(RBuilder::container)
                        .setLambdaArgument(
                            FunCall.builder(RBuilder::row)
                                .setLambdaArgument(
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .addArgument("all", FunCall.Argument.PureValue(argString))
                                        .setLambdaArgument(plusString("all = $argString"))
                                        .build(),
                                    FunCall.builder(RBuilder::col, FunCall.Style.INLINE)
                                        .setLambdaArgument(plusString("Reference"))
                                        .build()
                                )
                                .build()
                        )
                        .build()
                }
            }
        }
    }
}

private data class Pairing<TA : ColAttributes, TB : ColAttributes, TP : ColAttributes>(
    val pairThis: TA,
    val pairWith: TB,
    val pairUsing: KFunction2<TA, TB, TP>
) {
    val thisClassName = when (pairThis) {
        is ColAttributes.Sizes -> ColAttributes.Sizes::class.simpleName
        is ColAttributes.Offsets -> ColAttributes.Offsets::class.simpleName
        is ColAttributes.Orderings -> ColAttributes.Orderings::class.simpleName
        is ColAttributes.Alignments -> ColAttributes.Alignments::class.simpleName
        else -> error("will never happen")
    }

    private val thisValueName = when (pairThis) {
        is ColAttributes.Sizes -> pairThis.name
        is ColAttributes.Offsets -> pairThis.name
        is ColAttributes.Orderings -> pairThis.name
        is ColAttributes.Alignments -> pairThis.name
        else -> error("will never happen")
    }

    val thisImport = when (pairThis) {
        is ColAttributes.Sizes -> pairThis.import
        is ColAttributes.Offsets -> pairThis.import
        is ColAttributes.Orderings -> pairThis.import
        is ColAttributes.Alignments -> pairThis.import
        else -> error("will never happen")
    }

    val withClassName = when (pairWith) {
        is ColAttributes.Sizes -> ColAttributes.Sizes::class.simpleName
        is ColAttributes.Offsets -> ColAttributes.Offsets::class.simpleName
        is ColAttributes.Orderings -> ColAttributes.Orderings::class.simpleName
        is ColAttributes.Alignments -> ColAttributes.Alignments::class.simpleName
        else -> error("will never happen")
    }

    private val withValueName = when (pairWith) {
        is ColAttributes.Sizes -> pairWith.name
        is ColAttributes.Offsets -> pairWith.name
        is ColAttributes.Orderings -> pairWith.name
        is ColAttributes.Alignments -> pairWith.name
        else -> error("will never happen")
    }

    val withImport = when (pairWith) {
        is ColAttributes.Sizes -> pairWith.import
        is ColAttributes.Offsets -> pairWith.import
        is ColAttributes.Orderings -> pairWith.import
        is ColAttributes.Alignments -> pairWith.import
        else -> error("will never happen")
    }

    val argString = "$thisValueName ${pairUsing.name} $withValueName"

    fun getPair() = pairUsing(pairThis, pairWith)
}

private data class Tripling<
    TA : ColAttributes,
    TB : ColAttributes,
    TC : ColAttributes,
    TP : ColAttributes,
    TT : ColAttributes
    >(
    val tripleThis: TA,
    val tripleWith1: Pairing<TB, TC, TP>,
    val tripleWith2: Pairing<TC, TB, TP>,
    val tripleUsing: KFunction2<TP, TA, TT>
) {
    val withList = listOf(
        tripleWith1,
        tripleWith2
    )

    val thisClassName = when (tripleThis) {
        is ColAttributes.Sizes -> ColAttributes.Sizes::class.simpleName
        is ColAttributes.Offsets -> ColAttributes.Offsets::class.simpleName
        is ColAttributes.Orderings -> ColAttributes.Orderings::class.simpleName
        is ColAttributes.Alignments -> ColAttributes.Alignments::class.simpleName
        else -> error("will never happen")
    }

    private val thisValueName = when (tripleThis) {
        is ColAttributes.Sizes -> tripleThis.name
        is ColAttributes.Offsets -> tripleThis.name
        is ColAttributes.Orderings -> tripleThis.name
        is ColAttributes.Alignments -> tripleThis.name
        else -> error("will never happen")
    }

    val thisImport = when (tripleThis) {
        is ColAttributes.Sizes -> tripleThis.import
        is ColAttributes.Offsets -> tripleThis.import
        is ColAttributes.Orderings -> tripleThis.import
        is ColAttributes.Alignments -> tripleThis.import
        else -> error("will never happen")
    }

    val thisString = thisValueName

    fun getTriple() = tripleUsing(tripleWith1.getPair(), tripleThis)
}

private data class Quadruple<
    TA : ColAttributes,
    TB : ColAttributes,
    TC : ColAttributes,
    TD : ColAttributes,
    TP1 : ColAttributes,
    TP2 : ColAttributes,
    TP3 : ColAttributes,
    TTT : ColAttributes
    >(
    val quadrupleThis: TA,
    val quadrupleWith1: Tripling<TD, TB, TC, TP1, TTT>,
    val quadrupleWith2: Tripling<TC, TB, TD, TP2, TTT>,
    val quadrupleWith3: Tripling<TB, TC, TD, TP3, TTT>,
    val quadrupleWith4: Tripling<TD, TC, TB, TP1, TTT>,
    val quadrupleWith5: Tripling<TC, TD, TB, TP2, TTT>,
    val quadrupleWith6: Tripling<TB, TD, TC, TP3, TTT>,
    val quadrupleUsing: KFunction2<TTT, TA, ColAttributes.SizeOffsetOrderAlignmentQuadruple>
) {
    val withList = listOf(
        quadrupleWith1,
        quadrupleWith2,
        quadrupleWith3,
        quadrupleWith4,
        quadrupleWith5,
        quadrupleWith6
    )

    val thisClassName = when (quadrupleThis) {
        is ColAttributes.Sizes -> ColAttributes.Sizes::class.simpleName
        is ColAttributes.Offsets -> ColAttributes.Offsets::class.simpleName
        is ColAttributes.Orderings -> ColAttributes.Orderings::class.simpleName
        is ColAttributes.Alignments -> ColAttributes.Alignments::class.simpleName
        else -> error("will never happen")
    }

    private val thisValueName = when (quadrupleThis) {
        is ColAttributes.Sizes -> quadrupleThis.name
        is ColAttributes.Offsets -> quadrupleThis.name
        is ColAttributes.Orderings -> quadrupleThis.name
        is ColAttributes.Alignments -> quadrupleThis.name
        else -> error("will never happen")
    }

    val thisString = thisValueName

    fun getQuadruple() = quadrupleUsing(quadrupleWith1.getTriple(), quadrupleThis)
}
/* ktlint-disable parameter-list-wrapping */
