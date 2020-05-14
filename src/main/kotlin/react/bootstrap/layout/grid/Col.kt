package react.bootstrap.layout.grid

import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.layout.grid.ColAttributes.Size.Companion.EQ
import react.bootstrap.layout.grid.ColAttributes.Sizes
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

    val name = this::class.simpleName!!

    abstract class Size : ColAttributes() {
        override val classNamePrefix: String? = "COL"

        abstract override val size: Sizes
        override val offset: Offsets? = null
        override val order: Orderings? = null
        override val alignment: Alignments? = null

        companion object {
            val SZ_1 = Sizes.Size1()
            val SZ_2 = Sizes.Size2()
            val SZ_3 = Sizes.Size3()
            val SZ_4 = Sizes.Size4()
            val SZ_5 = Sizes.Size5()
            val SZ_6 = Sizes.Size6()
            val SZ_7 = Sizes.Size7()
            val SZ_8 = Sizes.Size8()
            val SZ_9 = Sizes.Size9()
            val SZ_10 = Sizes.Size10()
            val SZ_11 = Sizes.Size11()
            val SZ_12 = Sizes.Size12()
            val AUTO = Sizes.SizeAuto()
            val EQ = Sizes.SizeEqualWidth()
        }
    }

    abstract class Offset : ColAttributes() {
        override val classNamePrefix: String? = "OFFSET"
        override val classNamePostfix: String?
            get() = offset.value.toString()

        override val size: Sizes? = null
        abstract override val offset: Offsets
        override val order: Orderings? = null
        override val alignment: Alignments? = null

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

    abstract class Order : ColAttributes() {
        override val classNamePrefix: String? = "ORDER"

        override val size: Sizes? = null
        override val offset: Offsets? = null
        abstract override val order: Orderings
        override val alignment: Alignments? = null

        companion object {
            val ORD_0 = Orderings.Order0()
            val ORD_1 = Orderings.Order1()
            val ORD_2 = Orderings.Order2()
            val ORD_3 = Orderings.Order3()
            val ORD_4 = Orderings.Order4()
            val ORD_5 = Orderings.Order5()
            val ORD_6 = Orderings.Order6()
            val ORD_7 = Orderings.Order7()
            val ORD_8 = Orderings.Order8()
            val ORD_9 = Orderings.Order9()
            val ORD_10 = Orderings.Order10()
            val ORD_11 = Orderings.Order11()
            val ORD_12 = Orderings.Order12()
            val ORD_FIRST = Orderings.OrderFirst()
            val ORD_LAST = Orderings.OrderLast()
        }
    }

    abstract class Alignment : ColAttributes() {
        override val classNamePrefix: String? = "ALIGN_SELF"
        override val classNamePostfix: String?
            get() = alignment.name

        override val size: Sizes? = null
        override val offset: Offsets? = null
        override val order: Orderings? = null
        abstract override val alignment: Alignments

        companion object {
            val AUTO = Alignments.AUTO()
            val BASELINE = Alignments.BASELINE()
            val CENTER = Alignments.CENTER()
            val END = Alignments.END()
            val START = Alignments.START()
            val STRETCH = Alignments.STRETCH()
        }
    }

    @Suppress("unused")
    sealed class Sizes(override val classNamePostfix: String?) : Size() {
        class Size1 internal constructor() : Sizes("1")
        class Size2 internal constructor() : Sizes("2")
        class Size3 internal constructor() : Sizes("3")
        class Size4 internal constructor() : Sizes("4")
        class Size5 internal constructor() : Sizes("5")
        class Size6 internal constructor() : Sizes("6")
        class Size7 internal constructor() : Sizes("7")
        class Size8 internal constructor() : Sizes("8")
        class Size9 internal constructor() : Sizes("9")
        class Size10 internal constructor() : Sizes("10")
        class Size11 internal constructor() : Sizes("11")
        class Size12 internal constructor() : Sizes("12")
        class SizeAuto internal constructor() : Sizes("AUTO")
        class SizeEqualWidth internal constructor() : Sizes(null)

        override val size: Sizes
            get() = this

        infix fun off(that: Offsets) = SizeOffsetPair(this, that)

        infix fun ord(that: Orderings) = SizeOrderPair(this, that)

        infix fun align(that: Alignments) = SizeAlignmentPair(this, that)
    }

    @Suppress("unused")
    sealed class Offsets(internal val value: Int) : Offset() {
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

        override val offset: Offsets
            get() = this

        infix fun sz(that: Sizes) = SizeOffsetPair(that, this)

        infix fun ord(that: Orderings) = OffsetOrderPair(this, that)

        infix fun align(that: Alignments) = OffsetAlignmentPair(this, that)
    }

    @Suppress("unused")
    sealed class Orderings(override val classNamePostfix: String) : Order() {
        class Order0 internal constructor() : Orderings("0")
        class Order1 internal constructor() : Orderings("1")
        class Order2 internal constructor() : Orderings("2")
        class Order3 internal constructor() : Orderings("3")
        class Order4 internal constructor() : Orderings("4")
        class Order5 internal constructor() : Orderings("5")
        class Order6 internal constructor() : Orderings("6")
        class Order7 internal constructor() : Orderings("7")
        class Order8 internal constructor() : Orderings("8")
        class Order9 internal constructor() : Orderings("9")
        class Order10 internal constructor() : Orderings("10")
        class Order11 internal constructor() : Orderings("11")
        class Order12 internal constructor() : Orderings("12")
        class OrderFirst internal constructor() : Orderings("FIRST")
        class OrderLast internal constructor() : Orderings("LAST")

        override val order: Orderings
            get() = this

        infix fun sz(that: Sizes) = SizeOrderPair(that, this)

        infix fun off(that: Offsets) = OffsetOrderPair(that, this)

        infix fun align(that: Alignments) = OrderAlignmentPair(this, that)
    }

    @Suppress("unused")
    sealed class Alignments : Alignment() {
        class AUTO internal constructor() : Alignments()
        class BASELINE internal constructor() : Alignments()
        class CENTER internal constructor() : Alignments()
        class END internal constructor() : Alignments()
        class START internal constructor() : Alignments()
        class STRETCH internal constructor() : Alignments()

        override val alignment: Alignments
            get() = this

        infix fun sz(that: Sizes) = SizeAlignmentPair(that, this)

        infix fun off(that: Offsets) = OffsetAlignmentPair(that, this)

        infix fun ord(that: Orderings) = OrderAlignmentPair(that, this)
    }

    data class SizeOffsetPair internal constructor (
        override val first: Sizes,
        override val second: Offsets
    ) : ColAttributes(), AttributePair<Size, Offset> {
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
    ) : ColAttributes(), AttributePair<Size, Order> {
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
    ) : ColAttributes(), AttributePair<Size, Alignment> {
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
    ) : ColAttributes(), AttributePair<Offset, Order> {
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
    ) : ColAttributes(), AttributePair<Offset, Alignment> {
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
    ) : ColAttributes(), AttributePair<Order, Alignment> {
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
    ) : ColAttributes(), AttributeTriple<Size, Offset, Order> {
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
    ) : ColAttributes(), AttributeTriple<Size, Offset, Alignment> {
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
    ) : ColAttributes(), AttributeTriple<Size, Order, Alignment> {
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
    ) : ColAttributes(), AttributeTriple<Offset, Order, Alignment> {
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
    ) : ColAttributes(), AttributeQuadruple<Size, Offset, Order, Alignment> {
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
