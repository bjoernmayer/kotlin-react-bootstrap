package react.bootstrap.layout.grid

import kotlinx.html.DIV
import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.AttributePair
import react.bootstrap.lib.AttributeTriple
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.CombinedAttributes
import react.bootstrap.lib.resolveAttributeClassNames
import react.dom.RDOMBuilder
import react.dom.div

interface RowAttributes : CombinedAttributes {
    val colCount: ColCounts?
    val itemsX: ItemsXs?
    val itemsY: ItemsYs?
}

interface ColCount : RowAttributes {
    override val classNamePrefix: String?
        get() = "ROW_COLS"
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
        get() = "JUSTIFY_CONTENT"
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
        get() = "ALIGN_ITEMS"
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
    END,
    START;

    override val itemsX: ItemsXs = this

    infix fun colcount(that: ColCounts): ColCountItemXsPair = ColCountItemXsPair(that, this)
    infix fun ys(that: ItemsYs): ItemsXsItemsYsPair = ItemsXsItemsYsPair(this, that)
}

@Suppress("unused")
enum class ItemsYs : ItemsY {
    BASELINE,
    CENTER,
    END,
    START,
    STRETCH;

    override val itemsY: ItemsYs = this

    infix fun colcount(that: ColCounts): ColCountItemYsPair = ColCountItemYsPair(that, this)
    infix fun xs(that: ItemsXs): ItemsXsItemsYsPair = ItemsXsItemsYsPair(that, this)
}

data class ColCountItemXsPair(
    override val first: ColCounts,
    override val second: ItemsXs
) : ColCount, ItemsX, AttributePair<ColCount, ItemsX> {
    override val colCount: ColCounts = first
    override val itemsX: ItemsXs = second
    override val itemsY: ItemsYs? = null

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    @Suppress("unused")
    infix fun ys(that: ItemsYs): ColCountItemXsItemYsTriple = ColCountItemXsItemYsTriple(first, second, that)
}

data class ColCountItemYsPair(
    override val first: ColCounts,
    override val second: ItemsYs
) : ColCount, ItemsY, AttributePair<ColCount, ItemsY> {
    override val colCount: ColCounts = first
    override val itemsX: ItemsXs? = null
    override val itemsY: ItemsYs = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null

    @Suppress("unused")
    infix fun xs(that: ItemsXs): ColCountItemXsItemYsTriple = ColCountItemXsItemYsTriple(first, that, second)
}

data class ItemsXsItemsYsPair(
    override val first: ItemsXs,
    override val second: ItemsYs
) : ItemsX, ItemsY, AttributePair<ItemsX, ItemsY> {
    override val colCount: ColCounts? = null
    override val itemsX: ItemsXs = first
    override val itemsY: ItemsYs = second

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null
}

data class ColCountItemXsItemYsTriple(
    override val first: ColCounts,
    override val second: ItemsXs,
    override val third: ItemsYs
) : ColCount, ItemsX, ItemsY, AttributeTriple<ColCount, ItemsX, ItemsY> {
    override val colCount: ColCounts = first
    override val itemsX: ItemsXs = second
    override val itemsY: ItemsYs = third

    override val classNamePrefix: String? = null
    override val classNamePostfix: String? = null
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
    tagFun: RBuilder.(classes: String?, block: RDOMBuilder<T>.() -> Unit) -> ReactElement,
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
    val rowClasses = mutableSetOf(ClassNames.ROW)

    if (!gutters) {
        rowClasses.add(ClassNames.NO_GUTTERS)
    }

    rowClasses.addAll(
        resolveAttributeClassNames<ColCount>(all, sm, md, lg, xl)
    )
    rowClasses.addAll(
        resolveAttributeClassNames<ItemsY>(all, sm, md, lg, xl)
    )

    rowClasses.addAll(
        resolveAttributeClassNames<ItemsX>(all, sm, md, lg, xl)
    )

    return tagFun(
        classes.appendClass(rowClasses.joinToString(" "))
    ) {
        block()
    }
}
