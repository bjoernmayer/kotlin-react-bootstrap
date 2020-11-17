@file:Suppress("unused")

package react.bootstrap.layout.grid.row

import react.bootstrap.lib.component.AttributePair
import react.bootstrap.lib.component.AttributeTriple
import react.bootstrap.lib.component.CombinedAttributes

/**
 * Sealed class for different row attributes.
 *
 * [RowAttributes] can be combined by using the provided infix functions: `xs`, `ys` & `colcount`
 */
sealed class RowAttributes : CombinedAttributes {
    abstract val colCount: ColCounts?
    abstract val itemsX: ItemsXs?
    abstract val itemsY: ItemsYs?

    /**
     * [ColCounts] of a [Row]. Use this to quickly set the number of columns in this [Row].
     *
     * Use [ColCounts.xs] to combine [ColCounts] with [ItemsXs].
     * Use [ColCounts.ys] to combine [ColCounts] with [ItemsYs].
     */
    @Suppress("ClassName")
    sealed class ColCounts(private val value: Int) : RowAttributes() {
        class CNT_1 internal constructor() : ColCounts(1)
        class CNT_2 internal constructor() : ColCounts(2)
        class CNT_3 internal constructor() : ColCounts(3)
        class CNT_4 internal constructor() : ColCounts(4)
        class CNT_5 internal constructor() : ColCounts(5)
        class CNT_6 internal constructor() : ColCounts(6)

        final override val classNamePrefix: String = "ROW_COLS"
        final override val classNamePostfix: String = colCount.value.toString()

        final override val colCount: ColCounts
            get() = this
        final override val itemsX: ItemsXs? = null
        final override val itemsY: ItemsYs? = null

        @Suppress("MemberVisibilityCanBePrivate")
        infix fun xs(that: ItemsXs): ColCountItemXsPair = ColCountItemXsPair(this, that)

        @Suppress("MemberVisibilityCanBePrivate")
        infix fun ys(that: ItemsYs): ColCountItemYsPair = ColCountItemYsPair(this, that)

        companion object {
            val CNT_1 = CNT_1()
            val CNT_2 = CNT_2()
            val CNT_3 = CNT_3()
            val CNT_4 = CNT_4()
            val CNT_5 = CNT_5()
            val CNT_6 = CNT_6()
        }
    }

    /**
     * [ItemsXs] of a [Row]. Use this to change horizontal alignment of the cols in this [Row].
     *
     * Use [ItemsXs.colCount] to combine [ItemsXs] with [ColCounts].
     * Use [ItemsXs.ys] to combine [ItemsXs] with [ItemsYs].
     */
    sealed class ItemsXs : RowAttributes() {
        class AROUND internal constructor() : ItemsXs()
        class BETWEEN internal constructor() : ItemsXs()
        class CENTER internal constructor() : ItemsXs()
        class END internal constructor() : ItemsXs()
        class START internal constructor() : ItemsXs()

        final override val classNamePrefix: String = "JUSTIFY_CONTENT"
        final override val classNamePostfix: String = this::class.simpleName!!

        final override val colCount: ColCounts? = null
        final override val itemsX: ItemsXs
            get() = this
        final override val itemsY: ItemsYs? = null

        infix fun colcount(that: ColCounts): ColCountItemXsPair = ColCountItemXsPair(that, this)
        infix fun ys(that: ItemsYs): ItemsXsItemsYsPair = ItemsXsItemsYsPair(this, that)

        companion object {
            val AROUND = AROUND()
            val BETWEEN = BETWEEN()
            val CENTER = CENTER()
            val END = END()
            val START = START()
        }
    }

    /**
     * [ItemsYs] of a [Row]. Use this to change vertical alignment of the cols in this [Row].
     *
     * Use [ItemsYs.colCount] to combine [ItemsYs] with [ColCounts].
     * Use [ItemsYs.xs] to combine [ItemsYs] with [ItemsXs].
     */
    sealed class ItemsYs : RowAttributes() {
        class BASELINE internal constructor() : ItemsYs()
        class CENTER internal constructor() : ItemsYs()
        class END internal constructor() : ItemsYs()
        class START internal constructor() : ItemsYs()
        class STRETCH internal constructor() : ItemsYs()

        final override val classNamePrefix: String = "ALIGN_ITEMS"
        final override val classNamePostfix: String = this::class.simpleName!!

        final override val colCount: ColCounts? = null
        final override val itemsX: ItemsXs? = null
        final override val itemsY: ItemsYs
            get() = this

        infix fun colcount(that: ColCounts): ColCountItemYsPair = ColCountItemYsPair(that, this)

        @Suppress("MemberVisibilityCanBePrivate")
        infix fun xs(that: ItemsXs): ItemsXsItemsYsPair = ItemsXsItemsYsPair(that, this)

        companion object {
            val BASELINE = BASELINE()
            val CENTER = CENTER()
            val END = END()
            val START = START()
            val STRETCH = STRETCH()
        }
    }

    data class ColCountItemXsPair internal constructor(
        override val first: ColCounts,
        override val second: ItemsXs
    ) : RowAttributes(),
        AttributePair {
        override val colCount: ColCounts = first
        override val itemsX: ItemsXs = second
        override val itemsY: ItemsYs? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun ys(that: ItemsYs): ColCountItemXsItemYsTriple = ColCountItemXsItemYsTriple(first, second, that)
    }

    data class ColCountItemYsPair internal constructor(
        override val first: ColCounts,
        override val second: ItemsYs
    ) : RowAttributes(),
        AttributePair {
        override val colCount: ColCounts = first
        override val itemsX: ItemsXs? = null
        override val itemsY: ItemsYs = second

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        infix fun xs(that: ItemsXs): ColCountItemXsItemYsTriple = ColCountItemXsItemYsTriple(first, that, second)
    }

    data class ItemsXsItemsYsPair internal constructor(
        override val first: ItemsXs,
        override val second: ItemsYs
    ) : RowAttributes(),
        AttributePair {
        override val colCount: ColCounts? = null
        override val itemsX: ItemsXs = first
        override val itemsY: ItemsYs = second

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null
    }

    data class ColCountItemXsItemYsTriple internal constructor(
        override val first: ColCounts,
        override val second: ItemsXs,
        override val third: ItemsYs
    ) : RowAttributes(),
        AttributeTriple {
        override val colCount: ColCounts = first
        override val itemsX: ItemsXs = second
        override val itemsY: ItemsYs = third

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null
    }
}
