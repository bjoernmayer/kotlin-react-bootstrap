package react.bootstrap.layout.grid

import kotlinx.html.DIV
import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.Breakpoints
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.div

interface ColAttributes {
    val size: Sizes?
    val offset: Offsets?
    val order: Orderings?
    val alignment: Alignments?

    val classNamePrefix: String?
    val classNamePostfix: String?

    fun getClassName(breakpoints: Breakpoints?): String? {
        if (classNamePrefix == null && classNamePostfix == null) {
            return null
        }

        val breakpoint: String? = if (breakpoints !== null) {
            breakpoints.name.toUpperCase()
        } else null

        val className = listOfNotNull(classNamePrefix, breakpoint, classNamePostfix).joinToString("_")

        return ClassNames.valueOf(className).toString()
    }
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
    val first: Sizes,
    val second: Offsets
) : Size, Offset {
    override val size: Sizes = first
    override val offset: Offsets = second
    override val order: Orderings? = null
    override val alignment: Alignments? = null

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun ord(that: Orderings): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, second, that)

    infix fun align(that: Alignments): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(first, second, that)
}

data class SizeOrderPair(
    val first: Sizes,
    val second: Orderings
) : Size, Order {
    override val size: Sizes = first
    override val offset: Offsets? = null
    override val order: Orderings = second
    override val alignment: Alignments? = null

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun off(that: Offsets): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, that, second)

    infix fun align(that: Alignments): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(first, second, that)
}

data class SizeAlignmentPair(
    val first: Sizes,
    val second: Alignments
) : Size, Alignment {
    override val size: Sizes = first
    override val offset: Offsets? = null
    override val order: Orderings? = null
    override val alignment: Alignments = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun off(that: Offsets): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(first, that, second)

    infix fun ord(that: Orderings): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(first, that, second)
}

data class OffsetOrderPair(
    val first: Offsets,
    val second: Orderings
) : Offset, Order {
    override val size: Sizes? = null
    override val offset: Offsets = first
    override val order: Orderings = second
    override val alignment: Alignments? = null

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun sz(that: Sizes): SizeOffsetOrderTriple = SizeOffsetOrderTriple(that, first, second)

    infix fun align(that: Alignments): OffsetOrderAlignmentTriple = OffsetOrderAlignmentTriple(first, second, that)
}

data class OffsetAlignmentPair(
    val first: Offsets,
    val second: Alignments
) : Offset, Alignment {
    override val size: Sizes? = null
    override val offset: Offsets = first
    override val order: Orderings? = null
    override val alignment: Alignments = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun sz(that: Sizes): SizeOffsetAlignmentTriple = SizeOffsetAlignmentTriple(that, first, second)

    infix fun ord(that: Orderings): OffsetOrderAlignmentTriple = OffsetOrderAlignmentTriple(first, that, second)
}

data class OrderAlignmentPair(
    val first: Orderings,
    val second: Alignments
) : Order, Alignment {
    override val size: Sizes? = null
    override val offset: Offsets? = null
    override val order: Orderings = first
    override val alignment: Alignments = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun sz(that: Sizes): SizeOrderAlignmentTriple = SizeOrderAlignmentTriple(that, first, second)

    infix fun off(that: Offsets): OffsetOrderAlignmentTriple = OffsetOrderAlignmentTriple(that, first, second)
}

data class SizeOffsetOrderTriple(
    val first: Sizes,
    val second: Offsets,
    val third: Orderings
) : Size, Offset, Order {
    override val size: Sizes = first
    override val offset: Offsets = second
    override val order: Orderings = third
    override val alignment: Alignments? = null

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} " +
            "${second.getClassName(breakpoints)} " +
            "${third.getClassName(breakpoints)}"
    }

    infix fun align(that: Alignments): SizeOffsetOrderAlignmentQuadruple =
        SizeOffsetOrderAlignmentQuadruple(first, second, third, that)
}

data class SizeOffsetAlignmentTriple(
    val first: Sizes,
    val second: Offsets,
    val third: Alignments
) : Size, Offset, Alignment {
    override val size: Sizes = first
    override val offset: Offsets = second
    override val order: Orderings? = null
    override val alignment: Alignments = third

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} " +
            "${second.getClassName(breakpoints)} " +
            "${third.getClassName(breakpoints)}"
    }

    infix fun ord(that: Orderings): SizeOffsetOrderAlignmentQuadruple =
        SizeOffsetOrderAlignmentQuadruple(first, second, that, third)
}

data class SizeOrderAlignmentTriple(
    val first: Sizes,
    val second: Orderings,
    val third: Alignments
) : Size, Order, Alignment {
    override val size: Sizes = first
    override val offset: Offsets? = null
    override val order: Orderings = second
    override val alignment: Alignments = third

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} " +
            "${second.getClassName(breakpoints)} " +
            "${third.getClassName(breakpoints)}"
    }

    infix fun off(that: Offsets): SizeOffsetOrderAlignmentQuadruple =
        SizeOffsetOrderAlignmentQuadruple(first, that, second, third)
}

data class OffsetOrderAlignmentTriple(
    val first: Offsets,
    val second: Orderings,
    val third: Alignments
) : Offset, Order, Alignment {
    override val size: Sizes? = null
    override val offset: Offsets = first
    override val order: Orderings = second
    override val alignment: Alignments = third

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} " +
            "${second.getClassName(breakpoints)} " +
            "${third.getClassName(breakpoints)}"
    }

    infix fun sz(that: Sizes): SizeOffsetOrderAlignmentQuadruple =
        SizeOffsetOrderAlignmentQuadruple(that, first, second, third)
}

data class SizeOffsetOrderAlignmentQuadruple(
    val first: Sizes,
    val second: Offsets,
    val third: Orderings,
    val fourth: Alignments
) : Size, Offset, Order, Alignment {
    override val size: Sizes = first
    override val offset: Offsets = second
    override val order: Orderings = third
    override val alignment: Alignments = fourth

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} " +
            "${second.getClassName(breakpoints)} " +
            "${third.getClassName(breakpoints)} " +
            "${fourth.getClassName(breakpoints)}"
    }
}

fun RBuilder.col(
    classes: String? = null,
    block: RDOMBuilder<DIV>.() -> Unit
): ReactElement = col(all = Sizes.EQ, classes = classes, block = block)

fun <T : HTMLTag> RBuilder.col(
    tagFun: RBuilder.(String?, RDOMBuilder<T>.() -> Unit) -> ReactElement,
    classes: String? = null,
    block: RDOMBuilder<T>.() -> Unit
): ReactElement =
    col(tagFun = tagFun, all = Sizes.EQ, classes = classes, block = block)

fun RBuilder.col(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    classes: String? = null,
    block: RDOMBuilder<DIV>.() -> Unit
): ReactElement = col(
    tagFun = RBuilder::div,
    all = all,
    sm = sm,
    md = md,
    lg = lg,
    xl = xl,
    classes = classes,
    block = block
)

fun <T : HTMLTag> RBuilder.col(
    tagFun: RBuilder.(String?, RDOMBuilder<T>.() -> Unit) -> ReactElement,
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    classes: String? = null,
    block: RDOMBuilder<T>.() -> Unit
): ReactElement {
    // Pairs and Triples match in multiple of those. That's why we need a Set
    val colClasses = mutableSetOf<String>()

    if (all?.size == null && sm?.size == null && md?.size == null && lg?.size == null && xl?.size == null) {
        Sizes.EQ.getClassName(null)?.let(colClasses::add)
    }

    colClasses.addAll(
        resolveColClasses<Size>(all, sm, md, lg, xl)
    )
    colClasses.addAll(
        resolveColClasses<Offset>(all, sm, md, lg, xl)
    )
    colClasses.addAll(
        resolveColClasses<Order>(all, sm, md, lg, xl)
    )
    colClasses.addAll(
        resolveColClasses<Alignment>(all, sm, md, lg, xl)
    )

    return tagFun(classes.appendClass(colClasses), block)
}

private inline fun <reified T : ColAttributes> resolveColClasses(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null
): Set<String> {
    val classes = mutableSetOf<String>()

    if (all is T) {
        all.getClassName(null)?.let(classes::add)
    }

    if (sm is T) {
        sm.getClassName(Breakpoints.SM)?.let(classes::add)
    }

    if (md is T) {
        md.getClassName(Breakpoints.MD)?.let(classes::add)
    }

    if (lg is T) {
        lg.getClassName(Breakpoints.LG)?.let(classes::add)
    }

    if (xl is T) {
        xl.getClassName(Breakpoints.XL)?.let(classes::add)
    }

    return classes
}
