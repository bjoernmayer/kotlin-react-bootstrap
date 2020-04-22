package react.bootstrap.layout.grid

import kotlinx.html.DIV
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.div

data class SizeOffsetPair(
    val first: Sizes,
    val second: Offsets
) : Size, Offset {
    override fun size(): Sizes? = first.size()

    override fun offset(): Offsets? = second.offset()

    override fun order(): Orderings? = null

    override fun toString(): String = "($first, $second)"

    infix fun ord(that: Orderings): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, second, that)
}

data class SizeOrderPair(
    val first: Sizes,
    val second: Orderings
) : Size, Order {
    override fun size(): Sizes? = first.size()

    override fun offset(): Offsets? = null

    override fun order(): Orderings? = second.order()

    override fun toString(): String = "($first, $second)"

    infix fun off(that: Offsets): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, that, second)
}

data class OffsetOrderPair(
    val first: Offsets,
    val second: Orderings
) : Offset, Order {
    override fun size(): Sizes? = null

    override fun offset(): Offsets? = first.offset()

    override fun order(): Orderings? = second.order()

    override fun toString(): String = "($first, $second)"

    infix fun sz(that: Sizes): SizeOffsetOrderTriple = SizeOffsetOrderTriple(that, first, second)
}

data class SizeOffsetOrderTriple(
    val first: Sizes,
    val second: Offsets,
    val third: Orderings
) : Size, Offset, Order {
    override fun size(): Sizes? = first.size()

    override fun offset(): Offsets? = second.offset()

    override fun order(): Orderings? = third.order()

    override fun toString(): String = "($first, $second, $third)"
}

interface ColAttribute {
    fun size(): Sizes?
    fun offset(): Offsets?
    fun order(): Orderings?
}

interface Size : ColAttribute {
    override fun offset(): Offsets? = null
    override fun order(): Orderings? = null
}

interface Offset : ColAttribute {
    override fun size(): Sizes? = null
    override fun order(): Orderings? = null
}

interface Order : ColAttribute {
    override fun size(): Sizes? = null
    override fun offset(): Offsets? = null
}

@Suppress("unused")
enum class Sizes(internal val postfix: String) : Size {
    SZ_1("_1"),
    SZ_2("_2"),
    SZ_3("_3"),
    SZ_4("_4"),
    SZ_5("_5"),
    SZ_6("_6"),
    SZ_7("_7"),
    SZ_8("_8"),
    SZ_9("_9"),
    SZ_10("_10"),
    SZ_11("_11"),
    SZ_12("_12"),
    AUTO("_AUTO"),
    EQ("");

    override fun size(): Sizes? = this

    infix fun off(that: Offsets) = SizeOffsetPair(this, that)

    infix fun ord(that: Orderings) = SizeOrderPair(this, that)
}

@Suppress("unused")
enum class Offsets(internal val postfix: String) : Offset {
    OFF_1("_1"),
    OFF_2("_2"),
    OFF_3("_3"),
    OFF_4("_4"),
    OFF_5("_5"),
    OFF_6("_6"),
    OFF_7("_7"),
    OFF_8("_8"),
    OFF_9("_9"),
    OFF_10("_10"),
    OFF_11("_11"),
    OFF_12("_12");

    override fun offset(): Offsets? = this

    infix fun sz(that: Sizes) = SizeOffsetPair(that, this)

    infix fun ord(that: Orderings) = OffsetOrderPair(this, that)
}

@Suppress("unused")
enum class Orderings(internal val postfix: String) : Order {
    ORD_0("_0"),
    ORD_1("_1"),
    ORD_2("_2"),
    ORD_3("_3"),
    ORD_4("_4"),
    ORD_5("_5"),
    ORD_6("_6"),
    ORD_7("_7"),
    ORD_8("_8"),
    ORD_9("_9"),
    ORD_10("_10"),
    ORD_11("_11"),
    ORD_12("_12"),
    ORD_FIRST("_FIRST"),
    ORD_LAST("_LAST");

    override fun order(): Orderings? = this

    infix fun sz(that: Sizes) = SizeOrderPair(that, this)

    infix fun off(that: Offsets) = OffsetOrderPair(that, this)
}

interface ColWidthProps : RProps {
    var col: Sizes?
    var sm: Sizes?
    var md: Sizes?
    var lg: Sizes?
    var xl: Sizes?

    companion object {
        fun empty(): ColWidthProps =
            object : ColWidthProps {
                override var col: Sizes? = null
                override var sm: Sizes? = null
                override var md: Sizes? = null
                override var lg: Sizes? = null
                override var xl: Sizes? = null
            }
    }
}

internal interface ColOffsetProps : RProps {
    var col: Offsets?
    var sm: Offsets?
    var md: Offsets?
    var lg: Offsets?
    var xl: Offsets?

    companion object {
        fun empty(): ColOffsetProps =
            object : ColOffsetProps {
                override var col: Offsets? = null
                override var sm: Offsets? = null
                override var md: Offsets? = null
                override var lg: Offsets? = null
                override var xl: Offsets? = null
            }
    }
}

internal interface ColOrderProps : RProps {
    var col: Orderings?
    var sm: Orderings?
    var md: Orderings?
    var lg: Orderings?
    var xl: Orderings?

    companion object {
        fun empty(): ColOrderProps =
            object : ColOrderProps {
                override var col: Orderings? = null
                override var sm: Orderings? = null
                override var md: Orderings? = null
                override var lg: Orderings? = null
                override var xl: Orderings? = null
            }
    }
}

internal interface ColProps : RProps {
    var widths: ColWidthProps?
    var offsets: ColOffsetProps?
    var orderings: ColOrderProps?
    var classes: String?
    var block: RDOMBuilder<DIV>.() -> Unit
}

internal class Col : RComponent<ColProps, RState>() {
    override fun RBuilder.render() {
        val colClasses = listOfNotNull(
            props.widths?.col?.let { ClassNames.valueOf("COL${it.postfix}") },
            props.widths?.sm?.let { ClassNames.valueOf("COL_SM${it.postfix}") },
            props.widths?.md?.let { ClassNames.valueOf("COL_MD${it.postfix}") },
            props.widths?.lg?.let { ClassNames.valueOf("COL_LG${it.postfix}") },
            props.widths?.xl?.let { ClassNames.valueOf("COL_XL${it.postfix}") },
            props.offsets?.col?.let { ClassNames.valueOf("OFFSET${it.postfix}") },
            props.offsets?.sm?.let { ClassNames.valueOf("OFFSET_SM${it.postfix}") },
            props.offsets?.md?.let { ClassNames.valueOf("OFFSET_MD${it.postfix}") },
            props.offsets?.lg?.let { ClassNames.valueOf("OFFSET_LG${it.postfix}") },
            props.offsets?.xl?.let { ClassNames.valueOf("OFFSET_XL${it.postfix}") },
            props.orderings?.col?.let { ClassNames.valueOf("ORDER${it.postfix}") },
            props.orderings?.sm?.let { ClassNames.valueOf("ORDER_SM${it.postfix}") },
            props.orderings?.md?.let { ClassNames.valueOf("ORDER_MD${it.postfix}") },
            props.orderings?.lg?.let { ClassNames.valueOf("ORDER_LG${it.postfix}") },
            props.orderings?.xl?.let { ClassNames.valueOf("ORDER_XL${it.postfix}") }
        )
        val classes = props.classes.appendClass(colClasses.joinToString(" "))

        div(classes) {
            val block = props.block
            block()
        }
    }
}

fun RBuilder.col(
    classes: String? = null,
    block: RDOMBuilder<DIV>.() -> Unit
): ReactElement = col(all = Sizes.EQ, classes = classes, block = block)

fun RBuilder.col(
    all: ColAttribute? = null,
    sm: ColAttribute? = null,
    md: ColAttribute? = null,
    lg: ColAttribute? = null,
    xl: ColAttribute? = null,
    classes: String? = null,
    block: RDOMBuilder<DIV>.() -> Unit
): ReactElement {
    return child(Col::class) {
        attrs.widths = ColWidthProps.empty().apply {
            if (all is Size) {
                this.col = all.size()
            }

            if (sm is Size) {
                this.sm = sm.size()
            }

            if (md is Size) {
                this.md = md.size()
            }

            if (lg is Size) {
                this.lg = lg.size()
            }

            if (xl is Size) {
                this.xl = xl.size()
            }

            if (all !is Size && sm !is Size && md !is Size && lg !is Size && xl !is Size) {
                this.col = Sizes.EQ
            }
        }
        attrs.offsets = ColOffsetProps.empty().apply {
            if (all is Offset) {
                this.col = all.offset()
            }

            if (sm is Offset) {
                this.sm = sm.offset()
            }

            if (md is Offset) {
                this.md = md.offset()
            }

            if (lg is Offset) {
                this.lg = lg.offset()
            }

            if (xl is Offset) {
                this.xl = xl.offset()
            }
        }
        attrs.orderings = ColOrderProps.empty().apply {
            if (all is Order) {
                this.col = all.order()
            }

            if (sm is Order) {
                this.sm = sm.order()
            }

            if (md is Order) {
                this.md = md.order()
            }

            if (lg is Order) {
                this.lg = lg.order()
            }

            if (xl is Order) {
                this.xl = xl.order()
            }
        }

        attrs.classes = classes
        attrs.block = block
    }
}
