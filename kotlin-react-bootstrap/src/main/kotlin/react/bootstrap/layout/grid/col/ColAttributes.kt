@file:Suppress("ClassName", "unused")

package react.bootstrap.layout.grid.col

import react.bootstrap.lib.component.AttributePair
import react.bootstrap.lib.component.AttributeQuadruple
import react.bootstrap.lib.component.AttributeTriple
import react.bootstrap.lib.component.CombinedAttributes

/**
 * Sealed class for different column attributes.
 *
 * [ColAttributes] can be combined by using the provided infix functions: `sz`, `off`, `ord` & ` align`
 */
public sealed class ColAttributes : CombinedAttributes {
    public abstract val size: Sizes?
    public abstract val offset: Offsets?
    public abstract val order: Orderings?
    public abstract val alignment: Alignments?

    /**
     * [Sizes] of a [Col].
     *
     * Use [Sizes.off] to combine [Sizes] with [Offsets].
     * Use [Sizes.ord] to combine [Sizes] with [Orderings].
     * Use [Sizes.align] to combine [Sizes] with [Alignments].
     */
    public sealed class Sizes(override val classNamePostfix: String?) : ColAttributes() {
        public class SZ_1 internal constructor() : Sizes("1")
        public class SZ_2 internal constructor() : Sizes("2")
        public class SZ_3 internal constructor() : Sizes("3")
        public class SZ_4 internal constructor() : Sizes("4")
        public class SZ_5 internal constructor() : Sizes("5")
        public class SZ_6 internal constructor() : Sizes("6")
        public class SZ_7 internal constructor() : Sizes("7")
        public class SZ_8 internal constructor() : Sizes("8")
        public class SZ_9 internal constructor() : Sizes("9")
        public class SZ_10 internal constructor() : Sizes("10")
        public class SZ_11 internal constructor() : Sizes("11")
        public class SZ_12 internal constructor() : Sizes("12")
        public class AUTO internal constructor() : Sizes("AUTO")
        public class EQ internal constructor() : Sizes(null)

        final override val classNamePrefix: String = "COL"

        final override val size: Sizes
            get() = this

        final override val offset: Offsets? = null
        final override val order: Orderings? = null
        final override val alignment: Alignments? = null

        public infix fun off(that: Offsets): SizeOffsetPair = SizeOffsetPair(this, that)

        public infix fun ord(that: Orderings): SizeOrderPair = SizeOrderPair(this, that)

        public infix fun align(that: Alignments): SizeAlignmentPair = SizeAlignmentPair(this, that)

        @Suppress("unused")
        public companion object {
            public val SZ_1: SZ_1 = SZ_1()
            public val SZ_2: SZ_2 = SZ_2()
            public val SZ_3: SZ_3 = SZ_3()
            public val SZ_4: SZ_4 = SZ_4()
            public val SZ_5: SZ_5 = SZ_5()
            public val SZ_6: SZ_6 = SZ_6()
            public val SZ_7: SZ_7 = SZ_7()
            public val SZ_8: SZ_8 = SZ_8()
            public val SZ_9: SZ_9 = SZ_9()
            public val SZ_10: SZ_10 = SZ_10()
            public val SZ_11: SZ_11 = SZ_11()
            public val SZ_12: SZ_12 = SZ_12()
            public val AUTO: AUTO = AUTO()
            public val EQ: EQ = EQ()
        }
    }

    /**
     * [Offsets] of a [Col].
     *
     * Use [Offsets.sz] to combine [Offsets] with [Sizes].
     * Use [Offsets.ord] to combine [Offsets] with [Orderings].
     * Use [Offsets.align] to combine [Offsets] with [Alignments].
     */
    public sealed class Offsets(private val value: Int) : ColAttributes() {
        public class OFF_1 internal constructor() : Offsets(1)
        public class OFF_2 internal constructor() : Offsets(2)
        public class OFF_3 internal constructor() : Offsets(3)
        public class OFF_4 internal constructor() : Offsets(4)
        public class OFF_5 internal constructor() : Offsets(5)
        public class OFF_6 internal constructor() : Offsets(6)
        public class OFF_7 internal constructor() : Offsets(7)
        public class OFF_8 internal constructor() : Offsets(8)
        public class OFF_9 internal constructor() : Offsets(9)
        public class OFF_10 internal constructor() : Offsets(10)
        public class OFF_11 internal constructor() : Offsets(11)
        public class OFF_12 internal constructor() : Offsets(12)

        final override val classNamePrefix: String = "OFFSET"
        final override val classNamePostfix: String = offset.value.toString()

        final override val size: Sizes? = null
        final override val offset: Offsets
            get() = this
        final override val order: Orderings? = null
        final override val alignment: Alignments? = null

        public infix fun sz(that: Sizes): SizeOffsetPair = SizeOffsetPair(that, this)

        public infix fun ord(that: Orderings): OffsetOrderPair = OffsetOrderPair(this, that)

        public infix fun align(that: Alignments): OffsetAlignmentPair = OffsetAlignmentPair(this, that)

        @Suppress("unused")
        public companion object {
            public val OFF_1: OFF_1 = OFF_1()
            public val OFF_2: OFF_2 = OFF_2()
            public val OFF_3: OFF_3 = OFF_3()
            public val OFF_4: OFF_4 = OFF_4()
            public val OFF_5: OFF_5 = OFF_5()
            public val OFF_6: OFF_6 = OFF_6()
            public val OFF_7: OFF_7 = OFF_7()
            public val OFF_8: OFF_8 = OFF_8()
            public val OFF_9: OFF_9 = OFF_9()
            public val OFF_10: OFF_10 = OFF_10()
            public val OFF_11: OFF_11 = OFF_11()
            public val OFF_12: OFF_12 = OFF_12()
        }
    }

    /**
     * [Orderings] of a [Col].
     *
     * Use [Orderings.sz] to combine [Orderings] with [Sizes].
     * Use [Orderings.off] to combine [Orderings] with [Offsets].
     * Use [Orderings.align] to combine [Orderings] with [Alignments].
     */
    public sealed class Orderings(override val classNamePostfix: String) : ColAttributes() {
        public class ORD_0 internal constructor() : Orderings("0")
        public class ORD_1 internal constructor() : Orderings("1")
        public class ORD_2 internal constructor() : Orderings("2")
        public class ORD_3 internal constructor() : Orderings("3")
        public class ORD_4 internal constructor() : Orderings("4")
        public class ORD_5 internal constructor() : Orderings("5")
        public class ORD_6 internal constructor() : Orderings("6")
        public class ORD_7 internal constructor() : Orderings("7")
        public class ORD_8 internal constructor() : Orderings("8")
        public class ORD_9 internal constructor() : Orderings("9")
        public class ORD_10 internal constructor() : Orderings("10")
        public class ORD_11 internal constructor() : Orderings("11")
        public class ORD_12 internal constructor() : Orderings("12")
        public class FIRST internal constructor() : Orderings("FIRST")
        public class LAST internal constructor() : Orderings("LAST")

        final override val classNamePrefix: String = "ORDER"

        final override val size: Sizes? = null
        final override val offset: Offsets? = null
        final override val order: Orderings
            get() = this
        final override val alignment: Alignments? = null

        public infix fun sz(that: Sizes): SizeOrderPair = SizeOrderPair(that, this)

        public infix fun off(that: Offsets): OffsetOrderPair = OffsetOrderPair(that, this)

        public infix fun align(that: Alignments): OrderAlignmentPair = OrderAlignmentPair(this, that)

        @Suppress("unused")
        public companion object {
            public val ORD_0: ORD_0 = ORD_0()
            public val ORD_1: ORD_1 = ORD_1()
            public val ORD_2: ORD_2 = ORD_2()
            public val ORD_3: ORD_3 = ORD_3()
            public val ORD_4: ORD_4 = ORD_4()
            public val ORD_5: ORD_5 = ORD_5()
            public val ORD_6: ORD_6 = ORD_6()
            public val ORD_7: ORD_7 = ORD_7()
            public val ORD_8: ORD_8 = ORD_8()
            public val ORD_9: ORD_9 = ORD_9()
            public val ORD_10: ORD_10 = ORD_10()
            public val ORD_11: ORD_11 = ORD_11()
            public val ORD_12: ORD_12 = ORD_12()
            public val FIRST: FIRST = FIRST()
            public val LAST: LAST = LAST()
        }
    }

    /**
     * [Alignments] of a [Col].
     *
     * Use [Alignments.sz] to combine [Alignments] with [Sizes].
     * Use [Alignments.off] to combine [Alignments] with [Offsets].
     * Use [Alignments.ord] to combine [Alignments] with [Orderings].
     */
    public sealed class Alignments : ColAttributes() {
        public class AUTO internal constructor() : Alignments()
        public class BASELINE internal constructor() : Alignments()
        public class CENTER internal constructor() : Alignments()
        public class END internal constructor() : Alignments()
        public class START internal constructor() : Alignments()
        public class STRETCH internal constructor() : Alignments()

        final override val classNamePrefix: String = "ALIGN_SELF"
        final override val classNamePostfix: String = this::class.simpleName!!

        final override val size: Sizes? = null
        final override val offset: Offsets? = null
        final override val order: Orderings? = null
        final override val alignment: Alignments
            get() = this

        public infix fun sz(that: Sizes): SizeAlignmentPair = SizeAlignmentPair(that, this)

        public infix fun off(that: Offsets): OffsetAlignmentPair = OffsetAlignmentPair(that, this)

        public infix fun ord(that: Orderings): OrderAlignmentPair = OrderAlignmentPair(that, this)

        public companion object {
            public val AUTO: AUTO = AUTO()
            public val BASELINE: BASELINE = BASELINE()
            public val CENTER: CENTER = CENTER()
            public val END: END = END()
            public val START: START = START()
            public val STRETCH: STRETCH = STRETCH()
        }
    }

    public data class SizeOffsetPair internal constructor(
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

        public infix fun ord(that: Orderings): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, second, that)

        public infix fun align(that: Alignments): SizeOffsetAlignmentTriple =
            SizeOffsetAlignmentTriple(first, second, that)
    }

    public data class SizeOrderPair internal constructor(
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

        public infix fun off(that: Offsets): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, that, second)

        public infix fun align(that: Alignments): SizeOrderAlignmentTriple =
            SizeOrderAlignmentTriple(first, second, that)
    }

    public data class SizeAlignmentPair internal constructor(
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

        public infix fun off(that: Offsets): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(first, that, second)

        public infix fun ord(that: Orderings): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(first, that, second)
    }

    public data class OffsetOrderPair internal constructor(
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

        public infix fun sz(that: Sizes): SizeOffsetOrderTriple = SizeOffsetOrderTriple(that, first, second)

        public infix fun align(that: Alignments): OffsetOrderAlignmentTriple =
            OffsetOrderAlignmentTriple(first, second, that)
    }

    public data class OffsetAlignmentPair internal constructor(
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

        public infix fun sz(that: Sizes): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(that, first, second)

        public infix fun ord(that: Orderings): OffsetOrderAlignmentTriple =
            OffsetOrderAlignmentTriple(first, that, second)
    }

    public data class OrderAlignmentPair internal constructor(
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

        public infix fun sz(that: Sizes): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(that, first, second)

        public infix fun off(that: Offsets): OffsetOrderAlignmentTriple =
            OffsetOrderAlignmentTriple(that, first, second)
    }

    public data class SizeOffsetOrderTriple internal constructor(
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

        public infix fun align(that: Alignments): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(first, second, third, that)
    }

    public data class SizeOffsetAlignmentTriple internal constructor(
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

        public infix fun ord(that: Orderings): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(first, second, that, third)
    }

    public data class SizeOrderAlignmentTriple internal constructor(
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

        public infix fun off(that: Offsets): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(first, that, second, third)
    }

    public data class OffsetOrderAlignmentTriple internal constructor(
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

        public infix fun sz(that: Sizes): SizeOffsetOrderAlignmentQuadruple =
            SizeOffsetOrderAlignmentQuadruple(that, first, second, third)
    }

    public data class SizeOffsetOrderAlignmentQuadruple internal constructor(
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
