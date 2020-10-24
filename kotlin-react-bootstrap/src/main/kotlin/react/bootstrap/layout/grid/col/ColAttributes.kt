@file:Suppress("ClassName")

package react.bootstrap.layout.grid.col

import react.bootstrap.lib.component.AttributePair
import react.bootstrap.lib.component.AttributeQuadruple
import react.bootstrap.lib.component.AttributeTriple
import react.bootstrap.lib.component.CombinedAttributes

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

        final override val classNamePrefix: String = "COL"

        final override val size: Sizes
            get() = this

        final override val offset: Offsets? = null
        final override val order: Orderings? = null
        final override val alignment: Alignments? = null

        infix fun off(that: Offsets) = SizeOffsetPair(this, that)

        infix fun ord(that: Orderings) = SizeOrderPair(this, that)

        infix fun align(that: Alignments) = SizeAlignmentPair(this, that)

        companion object {
            val SZ_1 = SZ_1()
            val SZ_2 = SZ_2()
            val SZ_3 = SZ_3()
            val SZ_4 = SZ_4()
            val SZ_5 = SZ_5()
            val SZ_6 = SZ_6()
            val SZ_7 = SZ_7()
            val SZ_8 = SZ_8()
            val SZ_9 = SZ_9()
            val SZ_10 = SZ_10()
            val SZ_11 = SZ_11()
            val SZ_12 = SZ_12()
            val AUTO = AUTO()
            val EQ = EQ()
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

        final override val classNamePrefix: String = "OFFSET"
        final override val classNamePostfix: String = offset.value.toString()

        final override val size: Sizes? = null
        final override val offset: Offsets
            get() = this
        final override val order: Orderings? = null
        final override val alignment: Alignments? = null

        infix fun sz(that: Sizes) = SizeOffsetPair(that, this)

        infix fun ord(that: Orderings) = OffsetOrderPair(this, that)

        infix fun align(that: Alignments) = OffsetAlignmentPair(this, that)

        companion object {
            val OFF_1 = OFF_1()
            val OFF_2 = OFF_2()
            val OFF_3 = OFF_3()
            val OFF_4 = OFF_4()
            val OFF_5 = OFF_5()
            val OFF_6 = OFF_6()
            val OFF_7 = OFF_7()
            val OFF_8 = OFF_8()
            val OFF_9 = OFF_9()
            val OFF_10 = OFF_10()
            val OFF_11 = OFF_11()
            val OFF_12 = OFF_12()
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

        final override val classNamePrefix: String = "ORDER"

        final override val size: Sizes? = null
        final override val offset: Offsets? = null
        final override val order: Orderings
            get() = this
        final override val alignment: Alignments? = null

        infix fun sz(that: Sizes) = SizeOrderPair(that, this)

        infix fun off(that: Offsets) = OffsetOrderPair(that, this)

        infix fun align(that: Alignments) = OrderAlignmentPair(this, that)

        companion object {
            val ORD_0 = ORD_0()
            val ORD_1 = ORD_1()
            val ORD_2 = ORD_2()
            val ORD_3 = ORD_3()
            val ORD_4 = ORD_4()
            val ORD_5 = ORD_5()
            val ORD_6 = ORD_6()
            val ORD_7 = ORD_7()
            val ORD_8 = ORD_8()
            val ORD_9 = ORD_9()
            val ORD_10 = ORD_10()
            val ORD_11 = ORD_11()
            val ORD_12 = ORD_12()
            val FIRST = FIRST()
            val LAST = LAST()
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

        final override val classNamePrefix: String = "ALIGN_SELF"
        final override val classNamePostfix: String = this::class.simpleName!!

        final override val size: Sizes? = null
        final override val offset: Offsets? = null
        final override val order: Orderings? = null
        final override val alignment: Alignments
            get() = this

        infix fun sz(that: Sizes) = SizeAlignmentPair(that, this)

        infix fun off(that: Offsets) = OffsetAlignmentPair(that, this)

        infix fun ord(that: Orderings) = OrderAlignmentPair(that, this)

        companion object {
            val AUTO = AUTO()
            val BASELINE = BASELINE()
            val CENTER = CENTER()
            val END = END()
            val START = START()
            val STRETCH = STRETCH()
        }
    }

    data class SizeOffsetPair internal constructor(
        override val first: Sizes,
        override val second: Offsets
    ) : ColAttributes(),
        AttributePair {
        override val size: Sizes = first
        override val offset: Offsets = second
        override val order: Orderings? = null
        override val alignment: Alignments? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun ord(that: Orderings): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, second, that)

        infix fun align(that: Alignments): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(first, second, that)
    }

    data class SizeOrderPair internal constructor(
        override val first: Sizes,
        override val second: Orderings
    ) : ColAttributes(),
        AttributePair {
        override val size: Sizes = first
        override val offset: Offsets? = null
        override val order: Orderings = second
        override val alignment: Alignments? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun off(that: Offsets): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, that, second)

        infix fun align(that: Alignments): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(first, second, that)
    }

    data class SizeAlignmentPair internal constructor(
        override val first: Sizes,
        override val second: Alignments
    ) : ColAttributes(),
        AttributePair {
        override val size: Sizes = first
        override val offset: Offsets? = null
        override val order: Orderings? = null
        override val alignment: Alignments = second

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun off(that: Offsets): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(first, that, second)

        infix fun ord(that: Orderings): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(first, that, second)
    }

    data class OffsetOrderPair internal constructor(
        override val first: Offsets,
        override val second: Orderings
    ) : ColAttributes(),
        AttributePair {
        override val size: Sizes? = null
        override val offset: Offsets = first
        override val order: Orderings = second
        override val alignment: Alignments? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun sz(that: Sizes): SizeOffsetOrderTriple = SizeOffsetOrderTriple(that, first, second)

        infix fun align(that: Alignments): OffsetOrderAlignmentTriple = OffsetOrderAlignmentTriple(first, second, that)
    }

    data class OffsetAlignmentPair internal constructor(
        override val first: Offsets,
        override val second: Alignments
    ) : ColAttributes(),
        AttributePair {
        override val size: Sizes? = null
        override val offset: Offsets = first
        override val order: Orderings? = null
        override val alignment: Alignments = second

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun sz(that: Sizes): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(that, first, second)

        infix fun ord(that: Orderings): OffsetOrderAlignmentTriple = OffsetOrderAlignmentTriple(first, that, second)
    }

    data class OrderAlignmentPair internal constructor(
        override val first: Orderings,
        override val second: Alignments
    ) : ColAttributes(),
        AttributePair {
        override val size: Sizes? = null
        override val offset: Offsets? = null
        override val order: Orderings = first
        override val alignment: Alignments = second

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun sz(that: Sizes): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(that, first, second)

        infix fun off(that: Offsets): OffsetOrderAlignmentTriple = OffsetOrderAlignmentTriple(that, first, second)
    }

    data class SizeOffsetOrderTriple internal constructor(
        override val first: Sizes,
        override val second: Offsets,
        override val third: Orderings
    ) : ColAttributes(),
        AttributeTriple {
        override val size: Sizes = first
        override val offset: Offsets = second
        override val order: Orderings = third
        override val alignment: Alignments? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun align(that: Alignments): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(first, second, third, that)
    }

    data class SizeOffsetAlignmentTriple internal constructor(
        override val first: Sizes,
        override val second: Offsets,
        override val third: Alignments
    ) : ColAttributes(),
        AttributeTriple {
        override val size: Sizes = first
        override val offset: Offsets = second
        override val order: Orderings? = null
        override val alignment: Alignments = third

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun ord(that: Orderings): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(first, second, that, third)
    }

    data class SizeOrderAlignmentTriple internal constructor(
        override val first: Sizes,
        override val second: Orderings,
        override val third: Alignments
    ) : ColAttributes(),
        AttributeTriple {
        override val size: Sizes = first
        override val offset: Offsets? = null
        override val order: Orderings = second
        override val alignment: Alignments = third

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun off(that: Offsets): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(first, that, second, third)
    }

    data class OffsetOrderAlignmentTriple internal constructor(
        override val first: Offsets,
        override val second: Orderings,
        override val third: Alignments
    ) : ColAttributes(),
        AttributeTriple {
        override val size: Sizes? = null
        override val offset: Offsets = first
        override val order: Orderings = second
        override val alignment: Alignments = third

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun sz(that: Sizes): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(that, first, second, third)
    }

    data class SizeOffsetOrderAlignmentQuadruple internal constructor(
        override val first: Sizes,
        override val second: Offsets,
        override val third: Orderings,
        override val fourth: Alignments
    ) : ColAttributes(),
        AttributeQuadruple<Sizes, Offsets, Orderings, Alignments> {
        override val size: Sizes = first
        override val offset: Offsets = second
        override val order: Orderings = third
        override val alignment: Alignments = fourth

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null
    }
}
