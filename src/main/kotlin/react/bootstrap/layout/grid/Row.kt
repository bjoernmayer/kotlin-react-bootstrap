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
    val itemsAlignments: ItemsAlignments?

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

interface ColCount : RowAttributes {
    override val classNamePrefix: String?
        get() = "ROW_COLS_"
    override val classNamePostfix: String?
        get() = colCount.value.toString()

    override val colCount: ColCounts
    override val itemsAlignments: ItemsAlignments?
        get() = null
}

interface ItemAlignment : RowAttributes {
    override val classNamePrefix: String?
        get() = "ALIGN_ITEMS_"
    override val classNamePostfix: String?
        get() = "_${itemsAlignments.name}"

    override val colCount: ColCounts?
        get() = null
    override val itemsAlignments: ItemsAlignments
}

enum class ColCounts(internal val value: Int) : ColCount {
    CNT_1(1),
    CNT_2(2),
    CNT_3(3),
    CNT_4(4),
    CNT_5(5),
    CNT_6(6);

    override val colCount: ColCounts = this

    infix fun align(that: ItemsAlignments): ColCountItemsAlignmentPair = ColCountItemsAlignmentPair(this, that)
}

enum class ItemsAlignments : ItemAlignment {
    START,
    CENTER,
    END,
    BASELINE,
    STRETCH;

    override val itemsAlignments: ItemsAlignments = this

    infix fun colcount(that: ColCounts): ColCountItemsAlignmentPair = ColCountItemsAlignmentPair(that, this)
}

data class ColCountItemsAlignmentPair(
    val first: ColCounts,
    val second: ItemsAlignments
) : ColCount, ItemAlignment {
    override val colCount: ColCounts = first
    override val itemsAlignments: ItemsAlignments = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    override fun getClassName(breakpoints: Breakpoints?): String? {
        return "${colCount.getClassName(breakpoints)} ${itemsAlignments.getClassName(breakpoints)}"
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
        resolveRowClasses<ItemAlignment>(all, sm, md, lg, xl)
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
