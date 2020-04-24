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

// Todo: Add Alignment
interface ColAttributes {
    val size: Sizes?
    val offset: Offsets?
    val order: Orderings?

    val classNamePrefix: String?
    val classNamePostfix: String?

    fun getClassName(breakpoints: Breakpoints?): String? {
        if (classNamePrefix == null && classNamePostfix == null) {
            return null
        }

        val breakpoint = if (breakpoints !== null) {
            "_${breakpoints.name.toUpperCase()}"
        } else ""

        return ClassNames.valueOf("$classNamePrefix$breakpoint$classNamePostfix").toString()
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
}

interface Offset : ColAttributes {
    override val classNamePrefix: String?
        get() = "OFFSET"

    override val size: Sizes?
        get() = null
    override val offset: Offsets
    override val order: Orderings?
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
}

@Suppress("unused")
enum class Sizes(override val classNamePostfix: String) : Size {
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

    override val size: Sizes = this

    infix fun off(that: Offsets) = SizeOffsetPair(this, that)

    infix fun ord(that: Orderings) = SizeOrderPair(this, that)
}

@Suppress("unused")
enum class Offsets(override val classNamePostfix: String) : Offset {
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

    override val offset: Offsets = this

    infix fun sz(that: Sizes) = SizeOffsetPair(that, this)

    infix fun ord(that: Orderings) = OffsetOrderPair(this, that)
}

@Suppress("unused")
enum class Orderings(override val classNamePostfix: String) : Order {
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

    override val order: Orderings = this

    infix fun sz(that: Sizes) = SizeOrderPair(that, this)

    infix fun off(that: Offsets) = OffsetOrderPair(that, this)
}

data class SizeOffsetPair(
    val first: Sizes,
    val second: Offsets
) : Size, Offset {
    override val size: Sizes = first
    override val offset: Offsets = second
    override val order: Orderings? = null

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun ord(that: Orderings): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, second, that)
}

data class SizeOrderPair(
    val first: Sizes,
    val second: Orderings
) : Size, Order {
    override val size: Sizes = first
    override val offset: Offsets? = null
    override val order: Orderings = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun off(that: Offsets): SizeOffsetOrderTriple = SizeOffsetOrderTriple(first, that, second)
}

data class OffsetOrderPair(
    val first: Offsets,
    val second: Orderings
) : Offset, Order {
    override val size: Sizes? = null
    override val offset: Offsets = first
    override val order: Orderings = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun sz(that: Sizes): SizeOffsetOrderTriple = SizeOffsetOrderTriple(that, first, second)
}

data class SizeOffsetOrderTriple(
    val first: Sizes,
    val second: Offsets,
    val third: Orderings
) : Size, Offset, Order {
    override val size: Sizes = first
    override val offset: Offsets = second
    override val order: Orderings = third

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} " +
            "${second.getClassName(breakpoints)} " +
            "${third.getClassName(breakpoints)}"
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
