@file:Suppress("unused", "ClassName")

package react.bootstrap.layout.grid

import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.layout.grid.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.lib.AttributePair
import react.bootstrap.lib.AttributeQuadruple
import react.bootstrap.lib.AttributeTriple
import react.bootstrap.lib.Breakpoints
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.CombinedAttributes
import react.bootstrap.lib.RenderAsComponent
import react.bootstrap.lib.WithRenderAs
import react.dom.WithClassName
import react.dom.div

sealed class ColAttributes : CombinedAttributes {
    abstract val size: Sizes?
    abstract val offset: Offsets?
    abstract val order: Orderings?
    abstract val alignment: Alignments?

    @Suppress("unused")
    sealed class Sizes(override val classNamePostfix: String?) : ColAttributes() {
        class SZ_1 internal constructor() : Sizes("1")
        class SZ_2 internal constructor() : Sizes("2")
        class SZ_3 internal constructor() : Sizes("3")
        class SZ_4 internal constructor() : Sizes("4")
        class SZ_5 internal constructor() : Sizes("5")
        class SZ_6 internal constructor() : Sizes("6")
        class SZ_7 internal constructor() : Sizes("7")
        class SZ_8 internal constructor() : Sizes("8")
        class SZ_9 internal constructor() : Sizes("9")
        class SZ_10 internal constructor() : Sizes("10")
        class SZ_11 internal constructor() : Sizes("11")
        class SZ_12 internal constructor() : Sizes("12")
        class AUTO internal constructor() : Sizes("AUTO")
        class EQ internal constructor() : Sizes(null)

        override val classNamePrefix: String? = "COL"

        override val size: Sizes
            get() = this

        override val offset: Offsets? = null
        override val order: Orderings? = null
        override val alignment: Alignments? = null

        infix fun off(that: Offsets) = SizeOffsetPair(this, that)

        infix fun ord(that: Orderings) = SizeOrderPair(this, that)

        infix fun align(that: Alignments) = SizeAlignmentPair(this, that)

        companion object {
            val SZ_1 = Sizes.SZ_1()
            val SZ_2 = Sizes.SZ_2()
            val SZ_3 = Sizes.SZ_3()
            val SZ_4 = Sizes.SZ_4()
            val SZ_5 = Sizes.SZ_5()
            val SZ_6 = Sizes.SZ_6()
            val SZ_7 = Sizes.SZ_7()
            val SZ_8 = Sizes.SZ_8()
            val SZ_9 = Sizes.SZ_9()
            val SZ_10 = Sizes.SZ_10()
            val SZ_11 = Sizes.SZ_11()
            val SZ_12 = Sizes.SZ_12()
            val AUTO = Sizes.AUTO()
            val EQ = Sizes.EQ()
        }
    }

    @Suppress("unused")
    sealed class Offsets(private val value: Int) : ColAttributes() {
        class OFF_1 internal constructor() : Offsets(1)
        class OFF_2 internal constructor() : Offsets(2)
        class OFF_3 internal constructor() : Offsets(3)
        class OFF_4 internal constructor() : Offsets(4)
        class OFF_5 internal constructor() : Offsets(5)
        class OFF_6 internal constructor() : Offsets(6)
        class OFF_7 internal constructor() : Offsets(7)
        class OFF_8 internal constructor() : Offsets(8)
        class OFF_9 internal constructor() : Offsets(9)
        class OFF_10 internal constructor() : Offsets(10)
        class OFF_11 internal constructor() : Offsets(11)
        class OFF_12 internal constructor() : Offsets(12)

        override val classNamePrefix: String? = "OFFSET"
        override val classNamePostfix: String?
            get() = offset.value.toString()

        override val size: Sizes? = null
        override val offset: Offsets
            get() = this
        override val order: Orderings? = null
        override val alignment: Alignments? = null

        infix fun sz(that: Sizes) = SizeOffsetPair(that, this)

        infix fun ord(that: Orderings) = OffsetOrderPair(this, that)

        infix fun align(that: Alignments) = OffsetAlignmentPair(this, that)

        companion object {
            val OFF_1 = Offsets.OFF_1()
            val OFF_2 = Offsets.OFF_2()
            val OFF_3 = Offsets.OFF_3()
            val OFF_4 = Offsets.OFF_4()
            val OFF_5 = Offsets.OFF_5()
            val OFF_6 = Offsets.OFF_6()
            val OFF_7 = Offsets.OFF_7()
            val OFF_8 = Offsets.OFF_8()
            val OFF_9 = Offsets.OFF_9()
            val OFF_10 = Offsets.OFF_10()
            val OFF_11 = Offsets.OFF_11()
            val OFF_12 = Offsets.OFF_12()
        }
    }

    @Suppress("unused")
    sealed class Orderings(override val classNamePostfix: String) : ColAttributes() {
        class ORD_0 internal constructor() : Orderings("0")
        class ORD_1 internal constructor() : Orderings("1")
        class ORD_2 internal constructor() : Orderings("2")
        class ORD_3 internal constructor() : Orderings("3")
        class ORD_4 internal constructor() : Orderings("4")
        class ORD_5 internal constructor() : Orderings("5")
        class ORD_6 internal constructor() : Orderings("6")
        class ORD_7 internal constructor() : Orderings("7")
        class ORD_8 internal constructor() : Orderings("8")
        class ORD_9 internal constructor() : Orderings("9")
        class ORD_10 internal constructor() : Orderings("10")
        class ORD_11 internal constructor() : Orderings("11")
        class ORD_12 internal constructor() : Orderings("12")
        class FIRST internal constructor() : Orderings("FIRST")
        class LAST internal constructor() : Orderings("LAST")

        override val classNamePrefix: String? = "ORDER"

        override val size: Sizes? = null
        override val offset: Offsets? = null
        override val order: Orderings
            get() = this
        override val alignment: Alignments? = null

        infix fun sz(that: Sizes) = SizeOrderPair(that, this)

        infix fun off(that: Offsets) = OffsetOrderPair(that, this)

        infix fun align(that: Alignments) = OrderAlignmentPair(this, that)

        companion object {
            val ORD_0 = Orderings.ORD_0()
            val ORD_1 = Orderings.ORD_1()
            val ORD_2 = Orderings.ORD_2()
            val ORD_3 = Orderings.ORD_3()
            val ORD_4 = Orderings.ORD_4()
            val ORD_5 = Orderings.ORD_5()
            val ORD_6 = Orderings.ORD_6()
            val ORD_7 = Orderings.ORD_7()
            val ORD_8 = Orderings.ORD_8()
            val ORD_9 = Orderings.ORD_9()
            val ORD_10 = Orderings.ORD_10()
            val ORD_11 = Orderings.ORD_11()
            val ORD_12 = Orderings.ORD_12()
            val FIRST = Orderings.FIRST()
            val LAST = Orderings.LAST()
        }
    }

    @Suppress("unused")
    sealed class Alignments : ColAttributes() {
        class AUTO internal constructor() : Alignments()
        class BASELINE internal constructor() : Alignments()
        class CENTER internal constructor() : Alignments()
        class END internal constructor() : Alignments()
        class START internal constructor() : Alignments()
        class STRETCH internal constructor() : Alignments()

        override val classNamePrefix: String? = "ALIGN_SELF"
        override val classNamePostfix: String?
            get() = alignment::class.simpleName!!

        override val size: Sizes? = null
        override val offset: Offsets? = null
        override val order: Orderings? = null
        override val alignment: Alignments
            get() = this

        infix fun sz(that: Sizes) = SizeAlignmentPair(that, this)

        infix fun off(that: Offsets) = OffsetAlignmentPair(that, this)

        infix fun ord(that: Orderings) = OrderAlignmentPair(that, this)

        companion object {
            val AUTO = Alignments.AUTO()
            val BASELINE = Alignments.BASELINE()
            val CENTER = Alignments.CENTER()
            val END = Alignments.END()
            val START = Alignments.START()
            val STRETCH = Alignments.STRETCH()
        }
    }

    data class SizeOffsetPair internal constructor(
        override val first: Sizes,
        override val second: Offsets
    ) : ColAttributes(), AttributePair {
        override val size: Sizes = first
        override val offset: Offsets = second
        override val order: Orderings? = null
        override val alignment: Alignments? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun ord(that: Orderings): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, second, that)

        infix fun align(that: Alignments): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(first, second, that)
    }

    data class SizeOrderPair(
        override val first: Sizes,
        override val second: Orderings
    ) : ColAttributes(), AttributePair {
        override val size: Sizes = first
        override val offset: Offsets? = null
        override val order: Orderings = second
        override val alignment: Alignments? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun off(that: Offsets): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, that, second)

        infix fun align(that: Alignments): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(first, second, that)
    }

    data class SizeAlignmentPair(
        override val first: Sizes,
        override val second: Alignments
    ) : ColAttributes(), AttributePair {
        override val size: Sizes = first
        override val offset: Offsets? = null
        override val order: Orderings? = null
        override val alignment: Alignments = second

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun off(that: Offsets): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(first, that, second)

        infix fun ord(that: Orderings): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(first, that, second)
    }

    data class OffsetOrderPair(
        override val first: Offsets,
        override val second: Orderings
    ) : ColAttributes(), AttributePair {
        override val size: Sizes? = null
        override val offset: Offsets = first
        override val order: Orderings = second
        override val alignment: Alignments? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun sz(that: Sizes): SizeOffsetOrderTriple = SizeOffsetOrderTriple(that, first, second)

        infix fun align(that: Alignments): OffsetOrderAlignmentTriple = OffsetOrderAlignmentTriple(first, second, that)
    }

    data class OffsetAlignmentPair(
        override val first: Offsets,
        override val second: Alignments
    ) : ColAttributes(), AttributePair {
        override val size: Sizes? = null
        override val offset: Offsets = first
        override val order: Orderings? = null
        override val alignment: Alignments = second

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun sz(that: Sizes): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(that, first, second)

        infix fun ord(that: Orderings): OffsetOrderAlignmentTriple = OffsetOrderAlignmentTriple(first, that, second)
    }

    data class OrderAlignmentPair(
        override val first: Orderings,
        override val second: Alignments
    ) : ColAttributes(), AttributePair {
        override val size: Sizes? = null
        override val offset: Offsets? = null
        override val order: Orderings = first
        override val alignment: Alignments = second

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun sz(that: Sizes): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(that, first, second)

        infix fun off(that: Offsets): OffsetOrderAlignmentTriple = OffsetOrderAlignmentTriple(that, first, second)
    }

    data class SizeOffsetOrderTriple(
        override val first: Sizes,
        override val second: Offsets,
        override val third: Orderings
    ) : ColAttributes(), AttributeTriple {
        override val size: Sizes = first
        override val offset: Offsets = second
        override val order: Orderings = third
        override val alignment: Alignments? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun align(that: Alignments): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(first, second, third, that)
    }

    data class SizeOffsetAlignmentTriple(
        override val first: Sizes,
        override val second: Offsets,
        override val third: Alignments
    ) : ColAttributes(), AttributeTriple {
        override val size: Sizes = first
        override val offset: Offsets = second
        override val order: Orderings? = null
        override val alignment: Alignments = third

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun ord(that: Orderings): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(first, second, that, third)
    }

    data class SizeOrderAlignmentTriple(
        override val first: Sizes,
        override val second: Orderings,
        override val third: Alignments
    ) : ColAttributes(), AttributeTriple {
        override val size: Sizes = first
        override val offset: Offsets? = null
        override val order: Orderings = second
        override val alignment: Alignments = third

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun off(that: Offsets): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(first, that, second, third)
    }

    data class OffsetOrderAlignmentTriple(
        override val first: Offsets,
        override val second: Orderings,
        override val third: Alignments
    ) : ColAttributes(), AttributeTriple {
        override val size: Sizes? = null
        override val offset: Offsets = first
        override val order: Orderings = second
        override val alignment: Alignments = third

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun sz(that: Sizes): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(that, first, second, third)
    }

    data class SizeOffsetOrderAlignmentQuadruple(
        override val first: Sizes,
        override val second: Offsets,
        override val third: Orderings,
        override val fourth: Alignments
    ) : ColAttributes(), AttributeQuadruple<Sizes, Offsets, Orderings, Alignments> {
        override val size: Sizes = first
        override val offset: Offsets = second
        override val order: Orderings = third
        override val alignment: Alignments = fourth

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null
    }
}

fun RBuilder.col(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    renderAs: (RBuilder.() -> ReactElement)? = null,
    classes: String? = null,
    block: RHandler<Col.Props>
): ReactElement = child(Col::class) {
    attrs {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.renderAs = renderAs
        this.className = classes
    }

    block()
}

class Col : RenderAsComponent<Col.Props, WithClassName, RState>() {
    override fun WithClassName.handleProps() {
        // Pairs and Triples match in multiple of those. That's why we need a Set
        val colClasses = mutableSetOf<ClassNames>()

        with(props) {
            if (all?.size == null && sm?.size == null && md?.size == null && lg?.size == null && xl?.size == null) {
                EQ.getClassNames(null).let(colClasses::addAll)
            }

            all?.getClassNames(null)?.let(colClasses::addAll)
            sm?.getClassNames(Breakpoints.SM)?.let(colClasses::addAll)
            md?.getClassNames(Breakpoints.MD)?.let(colClasses::addAll)
            lg?.getClassNames(Breakpoints.LG)?.let(colClasses::addAll)
            xl?.getClassNames(Breakpoints.XL)?.let(colClasses::addAll)
        }

        className = props.className.appendClass(colClasses)
    }

    override fun RBuilder.getDefaultRenderer(): ReactElement = div { }

    interface Props : WithRenderAs, WithClassName {
        var all: ColAttributes?
        var sm: ColAttributes?
        var md: ColAttributes?
        var lg: ColAttributes?
        var xl: ColAttributes?
    }
}
