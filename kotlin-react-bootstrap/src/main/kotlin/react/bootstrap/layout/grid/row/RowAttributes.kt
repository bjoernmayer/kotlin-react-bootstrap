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
public sealed class RowAttributes : CombinedAttributes {
    public abstract val colCount: ColCounts?
    public abstract val itemsX: ItemsXs?
    public abstract val itemsY: ItemsYs?

    /**
     * [ColCounts] of a [Row]. Use this to quickly set the number of columns in this [Row].
     *
     * Use [ColCounts.xs] to combine [ColCounts] with [ItemsXs].
     * Use [ColCounts.ys] to combine [ColCounts] with [ItemsYs].
     */
    @Suppress("ClassName")
    public sealed class ColCounts(private val value: Int) : RowAttributes() {
        public class CNT_1 internal constructor() : ColCounts(1)
        public class CNT_2 internal constructor() : ColCounts(2)
        public class CNT_3 internal constructor() : ColCounts(3)
        public class CNT_4 internal constructor() : ColCounts(4)
        public class CNT_5 internal constructor() : ColCounts(5)
        public class CNT_6 internal constructor() : ColCounts(6)

        final override val classNamePrefix: String = "ROW_COLS"
        final override val classNamePostfix: String = colCount.value.toString()

        final override val colCount: ColCounts
            get() = this
        final override val itemsX: ItemsXs? = null
        final override val itemsY: ItemsYs? = null

        @Suppress("MemberVisibilityCanBePrivate")
        public infix fun xs(that: ItemsXs): ColCountItemXsPair = ColCountItemXsPair(this, that)

        @Suppress("MemberVisibilityCanBePrivate")
        public infix fun ys(that: ItemsYs): ColCountItemYsPair = ColCountItemYsPair(this, that)

        public companion object {
            public val CNT_1: CNT_1 = CNT_1()
            public val CNT_2: CNT_2 = CNT_2()
            public val CNT_3: CNT_3 = CNT_3()
            public val CNT_4: CNT_4 = CNT_4()
            public val CNT_5: CNT_5 = CNT_5()
            public val CNT_6: CNT_6 = CNT_6()
        }
    }

    /**
     * [ItemsXs] of a [Row]. Use this to change horizontal alignment of the cols in this [Row].
     *
     * Use [ItemsXs.colCount] to combine [ItemsXs] with [ColCounts].
     * Use [ItemsXs.ys] to combine [ItemsXs] with [ItemsYs].
     */
    public sealed class ItemsXs : RowAttributes() {
        public class AROUND internal constructor() : ItemsXs()
        public class BETWEEN internal constructor() : ItemsXs()
        public class CENTER internal constructor() : ItemsXs()
        public class END internal constructor() : ItemsXs()
        public class START internal constructor() : ItemsXs()

        final override val classNamePrefix: String = "JUSTIFY_CONTENT"
        final override val classNamePostfix: String = this::class.simpleName!!

        final override val colCount: ColCounts? = null
        final override val itemsX: ItemsXs
            get() = this
        final override val itemsY: ItemsYs? = null

        public infix fun colcount(that: ColCounts): ColCountItemXsPair = ColCountItemXsPair(that, this)
        public infix fun ys(that: ItemsYs): ItemsXsItemsYsPair = ItemsXsItemsYsPair(this, that)

        public companion object {
            public val AROUND: AROUND = AROUND()
            public val BETWEEN: BETWEEN = BETWEEN()
            public val CENTER: CENTER = CENTER()
            public val END: END = END()
            public val START: START = START()
        }
    }

    /**
     * [ItemsYs] of a [Row]. Use this to change vertical alignment of the cols in this [Row].
     *
     * Use [ItemsYs.colCount] to combine [ItemsYs] with [ColCounts].
     * Use [ItemsYs.xs] to combine [ItemsYs] with [ItemsXs].
     */
    public sealed class ItemsYs : RowAttributes() {
        public class BASELINE internal constructor() : ItemsYs()
        public class CENTER internal constructor() : ItemsYs()
        public class END internal constructor() : ItemsYs()
        public class START internal constructor() : ItemsYs()
        public class STRETCH internal constructor() : ItemsYs()

        final override val classNamePrefix: String = "ALIGN_ITEMS"
        final override val classNamePostfix: String = this::class.simpleName!!

        final override val colCount: ColCounts? = null
        final override val itemsX: ItemsXs? = null
        final override val itemsY: ItemsYs
            get() = this

        public infix fun colcount(that: ColCounts): ColCountItemYsPair = ColCountItemYsPair(that, this)

        @Suppress("MemberVisibilityCanBePrivate")
        public infix fun xs(that: ItemsXs): ItemsXsItemsYsPair = ItemsXsItemsYsPair(that, this)

        public companion object {
            public val BASELINE: BASELINE = BASELINE()
            public val CENTER: CENTER = CENTER()
            public val END: END = END()
            public val START: START = START()
            public val STRETCH: STRETCH = STRETCH()
        }
    }

    public data class ColCountItemXsPair internal constructor(
        override val first: ColCounts,
        override val second: ItemsXs
    ) : RowAttributes(),
        AttributePair {
        override val colCount: ColCounts = first
        override val itemsX: ItemsXs = second
        override val itemsY: ItemsYs? = null

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        public infix fun ys(that: ItemsYs): ColCountItemXsItemYsTriple = ColCountItemXsItemYsTriple(first, second, that)
    }

    public data class ColCountItemYsPair internal constructor(
        override val first: ColCounts,
        override val second: ItemsYs
    ) : RowAttributes(),
        AttributePair {
        override val colCount: ColCounts = first
        override val itemsX: ItemsXs? = null
        override val itemsY: ItemsYs = second

        override val classNamePrefix: String? = null
        override val classNamePostfix: String? = null

        public infix fun xs(that: ItemsXs): ColCountItemXsItemYsTriple = ColCountItemXsItemYsTriple(first, that, second)
    }

    public data class ItemsXsItemsYsPair internal constructor(
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

    public data class ColCountItemXsItemYsTriple internal constructor(
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
