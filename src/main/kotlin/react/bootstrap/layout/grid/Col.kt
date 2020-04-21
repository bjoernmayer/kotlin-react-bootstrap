package react.bootstrap.layout.grid

import kotlinx.html.DIV
import kotlinx.html.TagConsumer
import react.*
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.div

data class WidthOffsetPair(
    val first: Widths,
    val second: Offsets
) : Width, Offset {
    override fun width(): Widths? = first.width()

    override fun offset(): Offsets? = second.offset()

    override fun order(): Orderings? = null

    override fun toString(): String = "($first, $second)"

    infix fun ord(that: Orderings): WidthOffsetOrderTriple =
        WidthOffsetOrderTriple(first, second, that)
}

data class WidthOrderPair(
    val first: Widths,
    val second: Orderings
) : Width, Order {
    override fun width(): Widths? = first.width()

    override fun offset(): Offsets? = null

    override fun order(): Orderings? = second.order()

    override fun toString(): String = "($first, $second)"
}

data class OffsetOrderPair(
    val first: Offsets,
    val second: Orderings
) : Offset, Order {
    override fun width(): Widths? = null

    override fun offset(): Offsets? = first.offset()

    override fun order(): Orderings? = second.order()

    override fun toString(): String = "($first, $second)"
}

data class WidthOffsetOrderTriple(
    val first: Widths,
    val second: Offsets,
    val third: Orderings
) : Width, Offset, Order {
    override fun width(): Widths? = first.width()

    override fun offset(): Offsets? = second.offset()

    override fun order(): Orderings? = third.order()

    override fun toString(): String = "($first, $second, $third)"
}

interface ColAttribute {
    fun width(): Widths?
    fun offset(): Offsets?
    fun order(): Orderings?
}

interface Width : ColAttribute {
    override fun offset(): Offsets? = null
    override fun order(): Orderings? = null
}

interface Offset : ColAttribute {
    override fun width(): Widths? = null
    override fun order(): Orderings? = null
}

interface Order : ColAttribute {
    override fun width(): Widths? = null
    override fun offset(): Offsets? = null
}

@Suppress("unused")
enum class Widths(val postfix: String) : Width {
    WD_1("_1"),
    WD_2("_2"),
    WD_3("_3"),
    WD_4("_4"),
    WD_5("_5"),
    WD_6("_6"),
    WD_7("_7"),
    WD_8("_8"),
    WD_9("_9"),
    WD_10("_10"),
    WD_11("_11"),
    WD_12("_12"),
    WD_AUTO("_AUTO"),
    WD_COL("");

    override fun width(): Widths? {
        return this
    }

    infix fun off(that: Offsets) =
        WidthOffsetPair(this, that)

    infix fun ord(that: Orderings) =
        WidthOrderPair(this, that)
}

@Suppress("unused")
enum class Offsets(val postfix: String) : Offset {
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

    override fun offset(): Offsets? {
        return this
    }

    infix fun ord(that: Orderings) =
        OffsetOrderPair(this, that)
}

@Suppress("unused")
enum class Orderings(val postfix: String) : Order {
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

    override fun order(): Orderings? {
        return this
    }
}

class COL(initialAttributes: Map<String, String>, consumer: TagConsumer<*>) : DIV(initialAttributes, consumer)

interface ColWidthProps : RProps {
    var col: Widths?
    var sm: Widths?
    var md: Widths?
    var lg: Widths?
    var xl: Widths?

    companion object {
        fun empty(): ColWidthProps =
            object : ColWidthProps {
                override var col: Widths? = null
                override var sm: Widths? = null
                override var md: Widths? = null
                override var lg: Widths? = null
                override var xl: Widths? = null
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
    var block: RDOMBuilder<COL>.() -> Unit
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

        col(classes) {
            val block = props.block
            block()
        }
    }

    companion object {
        private fun RBuilder.col(classes: String? = null, block: RDOMBuilder<COL>.() -> Unit): ReactElement =
            @Suppress("UNCHECKED_CAST")
            div(classes, block as RDOMBuilder<DIV>.() -> Unit)
    }
}

fun RBuilder.col(
    classes: String? = null,
    block: RDOMBuilder<COL>.() -> Unit
): ReactElement = child(Col::class) {
    attrs.widths = ColWidthProps.empty().apply { col = Widths.WD_COL }

    attrs.classes = classes
    attrs.block = block
}

fun RBuilder.col(
    col: ColAttribute? = null,
    sm: ColAttribute? = null,
    md: ColAttribute? = null,
    lg: ColAttribute? = null,
    xl: ColAttribute? = null,
    classes: String? = null,
    block: RDOMBuilder<COL>.() -> Unit
): ReactElement {
    return child(Col::class) {
        attrs.widths = ColWidthProps.empty().apply {
            if (col is Width) {
                this.col = col.width()
            }

            if (sm is Width) {
                this.sm = sm.width()
            }

            if (md is Width) {
                this.md = md.width()
            }

            if (lg is Width) {
                this.lg = lg.width()
            }

            if (xl is Width) {
                this.xl = xl.width()
            }
        }
        attrs.offsets = ColOffsetProps.empty().apply {
            if (col is Offset) {
                this.col = col.offset()
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
            if (col is Order) {
                this.col = col.order()
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

