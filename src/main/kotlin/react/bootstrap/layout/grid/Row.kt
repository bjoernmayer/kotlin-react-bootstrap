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

interface RowAttributes {
    val colCount: ColCounts?
    val itemsX: ItemsXs?
    val itemsY: ItemsYs?

    val classNamePrefix: String?
    val classNamePostfix: String?

    fun getClassName(breakpoints: Breakpoints?): String? {
        if (classNamePrefix == null && classNamePostfix == null) {
            return null
        }

        val breakpoint = if (breakpoints !== null) {
            "${breakpoints.name.toUpperCase()}_"
        } else ""

        return ClassNames.valueOf("$classNamePrefix$breakpoint$classNamePostfix").toString()
    }
}

interface ColCount : RowAttributes {
    override val classNamePrefix: String?
        get() = "ROW_COLS_"
    override val classNamePostfix: String?
        get() = "${colCount.value}"

    override val colCount: ColCounts
    override val itemsX: ItemsXs?
        get() = null
    override val itemsY: ItemsYs?
        get() = null
}

interface ItemsX : RowAttributes {
    override val classNamePrefix: String?
        get() = "JUSTIFY_CONTENT_"
    override val classNamePostfix: String?
        get() = itemsX.name

    override val colCount: ColCounts?
        get() = null
    override val itemsY: ItemsYs?
        get() = null
    override val itemsX: ItemsXs
}

interface ItemsY : RowAttributes {
    override val classNamePrefix: String?
        get() = "ALIGN_ITEMS_"
    override val classNamePostfix: String?
        get() = itemsY.name

    override val colCount: ColCounts?
        get() = null
    override val itemsX: ItemsXs?
        get() = null
    override val itemsY: ItemsYs
}

@Suppress("unused")
enum class ColCounts(internal val value: Int) : ColCount {
    CNT_1(1),
    CNT_2(2),
    CNT_3(3),
    CNT_4(4),
    CNT_5(5),
    CNT_6(6);

    override val colCount: ColCounts = this

    infix fun xs(that: ItemsXs): ColCountItemXsPair = ColCountItemXsPair(this, that)
    infix fun ys(that: ItemsYs): ColCountItemYsPair = ColCountItemYsPair(this, that)
}

@Suppress("unused")
enum class ItemsXs : ItemsX {
    AROUND,
    BETWEEN,
    CENTER,
    END;

    override val itemsX: ItemsXs = this

    infix fun colcount(that: ColCounts): ColCountItemXsPair = ColCountItemXsPair(that, this)
    infix fun ys(that: ItemsYs): ItemsXsItemsYsPair = ItemsXsItemsYsPair(this, that)
}

@Suppress("unused")
enum class ItemsYs : ItemsY {
    START,
    CENTER,
    END,
    BASELINE,
    STRETCH;

    override val itemsY: ItemsYs = this

    infix fun colcount(that: ColCounts): ColCountItemYsPair = ColCountItemYsPair(that, this)
    infix fun xs(that: ItemsXs): ItemsXsItemsYsPair = ItemsXsItemsYsPair(that, this)
}

data class ColCountItemXsPair(
    val first: ColCounts,
    val second: ItemsXs
) : ColCount, ItemsX {
    override val colCount: ColCounts = first
    override val itemsX: ItemsXs = second
    override val itemsY: ItemsYs? = null

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun ys(that: ItemsYs): ColCountItemXsItemYsTriple = ColCountItemXsItemYsTriple(first, second, that)
}

data class ColCountItemYsPair(
    val first: ColCounts,
    val second: ItemsYs
) : ColCount, ItemsY {
    override val colCount: ColCounts = first
    override val itemsX: ItemsXs? = null
    override val itemsY: ItemsYs = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} ${second.getClassName(breakpoints)}"
    }

    infix fun xs(that: ItemsXs): ColCountItemXsItemYsTriple = ColCountItemXsItemYsTriple(first, that, second)
}

data class ItemsXsItemsYsPair(
    val first: ItemsXs,
    val second: ItemsYs
) : ItemsX, ItemsY {
    override val colCount: ColCounts? = null
    override val itemsX: ItemsXs = first
    override val itemsY: ItemsYs = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null
}

data class ColCountItemXsItemYsTriple(
    val first: ColCounts,
    val second: ItemsXs,
    val third: ItemsYs
) : ColCount, ItemsX, ItemsY {
    override val colCount: ColCounts = first
    override val itemsX: ItemsXs = second
    override val itemsY: ItemsYs = third

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${first.getClassName(breakpoints)} " +
            "${second.getClassName(breakpoints)} " +
            "${third.getClassName(breakpoints)}"
    }
}

fun RBuilder.row(
    all: RowAttributes? = null,
    sm: RowAttributes? = null,
    md: RowAttributes? = null,
    lg: RowAttributes? = null,
    xl: RowAttributes? = null,
    gutters: Boolean = true,
    classes: String? = null,
    block: RDOMBuilder<DIV>.() -> Unit
): ReactElement = row(
    tagFun = RBuilder::div,
    all = all,
    sm = sm,
    md = md,
    lg = lg,
    xl = xl,
    gutters = gutters,
    classes = classes,
    block = block
)

fun <T : HTMLTag> RBuilder.row(
    tagFun: RBuilder.(String?, RDOMBuilder<T>.() -> Unit) -> ReactElement,
    all: RowAttributes? = null,
    sm: RowAttributes? = null,
    md: RowAttributes? = null,
    lg: RowAttributes? = null,
    xl: RowAttributes? = null,
    gutters: Boolean = true,
    classes: String? = null,
    block: RDOMBuilder<T>.() -> Unit
): ReactElement {
    // Pairs and Triples match in multiple of those. That's why we need a Set
    val rowClasses = mutableSetOf("${ClassNames.ROW}")

    if (!gutters) {
        rowClasses.add("${ClassNames.NO_GUTTERS}")
    }

    rowClasses.addAll(
        resolveRowClasses<ColCount>(all, sm, md, lg, xl)
    )
    rowClasses.addAll(
        resolveRowClasses<ItemsY>(all, sm, md, lg, xl)
    )

    return tagFun(
        classes.appendClass(rowClasses.joinToString(" "))
    ) {
        block()
    }
}

private inline fun <reified T : RowAttributes> resolveRowClasses(
    all: RowAttributes? = null,
    sm: RowAttributes? = null,
    md: RowAttributes? = null,
    lg: RowAttributes? = null,
    xl: RowAttributes? = null
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
