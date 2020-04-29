package react.bootstrap.layout.grid

import react.Children
import react.RBuilder
import react.RComponent
import react.RElementBuilder
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.AttributePair
import react.bootstrap.lib.AttributeQuadruple
import react.bootstrap.lib.AttributeTriple
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.CombinedAttributes
import react.bootstrap.lib.resolveAttributeClassNames
import react.children
import react.cloneElement
import react.dom.WithClassName
import react.dom.div

interface ColAttributes : CombinedAttributes {
    val size: Sizes?
    val offset: Offsets?
    val order: Orderings?
    val alignment: Alignments?
}

interface Size : ColAttributes {
    override val classNamePrefix: String?
        get() = "COL"

    override val size: Sizes
    override val offset: Offsets?
        get() = null
    override val order: Orderings?
        get() = null
    override val alignment: Alignments?
        get() = null
}

interface Offset : ColAttributes {
    override val classNamePrefix: String?
        get() = "OFFSET"
    override val classNamePostfix: String?
        get() = "${offset.value}"

    override val size: Sizes?
        get() = null
    override val offset: Offsets
    override val order: Orderings?
        get() = null
    override val alignment: Alignments?
        get() = null
}

interface Order : ColAttributes {
    override val classNamePrefix: String?
        get() = "ORDER"

    override val size: Sizes?
        get() = null
    override val offset: Offsets?
        get() = null
    override val order: Orderings
    override val alignment: Alignments?
        get() = null
}

interface Alignment : ColAttributes {
    override val classNamePrefix: String?
        get() = "ALIGN_SELF"
    override val classNamePostfix: String?
        get() = alignment.name

    override val size: Sizes?
        get() = null
    override val offset: Offsets?
        get() = null
    override val order: Orderings?
        get() = null
    override val alignment: Alignments
}

@Suppress("unused")
enum class Sizes(override val classNamePostfix: String?) : Size {
    SZ_1("1"),
    SZ_2("2"),
    SZ_3("3"),
    SZ_4("4"),
    SZ_5("5"),
    SZ_6("6"),
    SZ_7("7"),
    SZ_8("8"),
    SZ_9("9"),
    SZ_10("10"),
    SZ_11("11"),
    SZ_12("12"),
    AUTO("AUTO"),
    EQ(null);

    override val size: Sizes = this

    infix fun off(that: Offsets) = SizeOffsetPair(this, that)

    infix fun ord(that: Orderings) = SizeOrderPair(this, that)

    infix fun align(that: Alignments) = SizeAlignmentPair(this, that)
}

@Suppress("unused")
enum class Offsets(internal val value: Int) : Offset {
    OFF_1(1),
    OFF_2(2),
    OFF_3(3),
    OFF_4(4),
    OFF_5(5),
    OFF_6(6),
    OFF_7(7),
    OFF_8(8),
    OFF_9(9),
    OFF_10(10),
    OFF_11(11),
    OFF_12(12);

    override val offset: Offsets = this

    infix fun sz(that: Sizes) = SizeOffsetPair(that, this)

    infix fun ord(that: Orderings) = OffsetOrderPair(this, that)

    infix fun align(that: Alignments) = OffsetAlignmentPair(this, that)
}

@Suppress("unused")
enum class Orderings(override val classNamePostfix: String) : Order {
    ORD_0("0"),
    ORD_1("1"),
    ORD_2("2"),
    ORD_3("3"),
    ORD_4("4"),
    ORD_5("5"),
    ORD_6("6"),
    ORD_7("7"),
    ORD_8("8"),
    ORD_9("9"),
    ORD_10("10"),
    ORD_11("11"),
    ORD_12("12"),
    ORD_FIRST("FIRST"),
    ORD_LAST("LAST");

    override val order: Orderings = this

    infix fun sz(that: Sizes) = SizeOrderPair(that, this)

    infix fun off(that: Offsets) = OffsetOrderPair(that, this)

    infix fun align(that: Alignments) = OrderAlignmentPair(this, that)
}

@Suppress("unused")
enum class Alignments : Alignment {
    AUTO,
    BASELINE,
    CENTER,
    END,
    START,
    STRETCH;

    override val alignment: Alignments = this

    infix fun sz(that: Sizes) = SizeAlignmentPair(that, this)

    infix fun off(that: Offsets) = OffsetAlignmentPair(that, this)

    infix fun ord(that: Orderings) = OrderAlignmentPair(that, this)
}

data class SizeOffsetPair(
    override val first: Sizes,
    override val second: Offsets
) : Size, Offset, AttributePair<Size, Offset> {
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
) : Size, Order, AttributePair<Size, Order> {
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
) : Size, Alignment, AttributePair<Size, Alignment> {
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
) : Offset, Order, AttributePair<Offset, Order> {
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
) : Offset, Alignment, AttributePair<Offset, Alignment> {
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
) : Order, Alignment, AttributePair<Order, Alignment> {
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
) : Size, Offset, Order, AttributeTriple<Size, Offset, Order> {
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
) : Size, Offset, Alignment, AttributeTriple<Size, Offset, Alignment> {
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
) : Size, Order, Alignment, AttributeTriple<Size, Order, Alignment> {
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
) : Offset, Order, Alignment, AttributeTriple<Offset, Order, Alignment> {
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
) : Size, Offset, Order, Alignment, AttributeQuadruple<Size, Offset, Order, Alignment> {
    override val size: Sizes = first
    override val offset: Offsets = second
    override val order: Orderings = third
    override val alignment: Alignments = fourth

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null
}

fun RBuilder.col(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    renderAs: (RBuilder.() -> ReactElement)? = null,
    classes: String? = null,
    block: RElementBuilder<Col.Props>.() -> Unit
): ReactElement = child(Col::class) {
    attrs {
        this.renderAs = renderAs
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.classes = classes
    }

    block()
}

class Col : RComponent<Col.Props, RState>() {
    interface Props : RProps {
        var renderAs: (RBuilder.() -> ReactElement)?
        var all: ColAttributes?
        var sm: ColAttributes?
        var md: ColAttributes?
        var lg: ColAttributes?
        var xl: ColAttributes?
        var classes: String?
    }

    override fun RBuilder.render() {
        // Pairs and Triples match in multiple of those. That's why we need a Set
        val colClasses = mutableSetOf<ClassNames>()

        with(props) {
            if (all?.size == null && sm?.size == null && md?.size == null && lg?.size == null && xl?.size == null) {
                Sizes.EQ.getClassNames(null).let(colClasses::addAll)
            }

            colClasses.addAll(
                resolveAttributeClassNames<Size>(all, sm, md, lg, xl)
            )
            colClasses.addAll(
                resolveAttributeClassNames<Offset>(all, sm, md, lg, xl)
            )
            colClasses.addAll(
                resolveAttributeClassNames<Order>(all, sm, md, lg, xl)
            )
            colClasses.addAll(
                resolveAttributeClassNames<Alignment>(all, sm, md, lg, xl)
            )
        }

        if (props.renderAs !== null) {
            child(cloneElement<WithClassName>(props.renderAs!!(), *Children.toArray(props.children)) {
                className = className.appendClass(colClasses)
            })
        } else {
            div(props.classes.appendClass(colClasses)) {
                children()
            }
        }
    }

    override fun render(): dynamic {
        return if (props.renderAs !== null) {
            RBuilder().apply {
                this.render()
            }.childList.last()
        } else {
            super.render()
        }
    }
}
