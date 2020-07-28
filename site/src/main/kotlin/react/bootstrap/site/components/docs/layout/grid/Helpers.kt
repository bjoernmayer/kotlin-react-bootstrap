package react.bootstrap.site.components.docs.layout.grid

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.layout.grid.col.ColAttributes
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.row.RowAttributes
import react.bootstrap.layout.grid.row.row
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.components.docs.layout.ktContainer
import react.dom.div

internal val ColAttributes.Sizes.name
    get() = this::class.simpleName!!

internal val ColAttributes.Sizes.import
    get() = buildNestedName(
        this::class,
        ColAttributes::class,
        ColAttributes.Sizes::class,
        ColAttributes.Sizes.Companion::class
    )

internal val ColAttributes.Offsets.name
    get() = this::class.simpleName!!

internal val ColAttributes.Offsets.import
    get() = buildNestedName(
        this::class,
        ColAttributes::class,
        ColAttributes.Offsets::class,
        ColAttributes.Offsets.Companion::class
    )

internal val ColAttributes.Orderings.name
    get() = this::class.simpleName!!

internal val ColAttributes.Orderings.import
    get() = buildNestedName(
        this::class,
        ColAttributes::class,
        ColAttributes.Orderings::class,
        ColAttributes.Orderings.Companion::class
    )

internal val ColAttributes.Alignments.name
    get() = this::class.simpleName!!

internal val ColAttributes.Alignments.import
    get() = buildNestedName(
        this::class,
        ColAttributes::class,
        ColAttributes.Alignments::class,
        ColAttributes.Alignments.Companion::class
    )

internal val RowAttributes.ColCounts.name
    get() = this::class.simpleName!!

internal val RowAttributes.ColCounts.import
    get() = buildNestedName(
        this::class,
        RowAttributes::class,
        RowAttributes.ColCounts::class,
        RowAttributes.ColCounts.Companion::class
    )

internal val RowAttributes.ItemsXs.name
    get() = this::class.simpleName!!

internal val RowAttributes.ItemsXs.import
    get() = buildNestedName(
        this::class,
        RowAttributes::class,
        RowAttributes.ItemsXs::class,
        RowAttributes.ItemsXs.Companion::class
    )

internal val RowAttributes.ItemsYs.name
    get() = this::class.simpleName!!

internal val RowAttributes.ItemsYs.import
    get() = buildNestedName(
        this::class,
        RowAttributes::class,
        RowAttributes.ItemsYs::class,
        RowAttributes.ItemsYs.Companion::class
    )

internal val RBuilder.colFun: String
    get() = RBuilder::col.name
internal val RBuilder.rowFun: String
    get() = RBuilder::row.name

internal fun CodeExampleBuilder.ktRow(block: CodeExampleBuilder.() -> Unit) {
    ktFun(RBuilder::row) {
        block()
    }
}

internal fun CodeExampleBuilder.ktConRow(block: CodeExampleBuilder.(indentationLevel: Int) -> Unit) {
    ktContainer {
        ktRow {
            block(2)
        }
    }
}

internal fun CodeExampleBuilder.importColFun() {
    importFromGrid("col", colFun)
}

internal fun CodeExampleBuilder.importRowFun() {
    importFromGrid("row", rowFun)
}

internal fun CodeExampleBuilder.importFromGrid(`package`: String, className: String) {
    import("layout.grid.${`package`}.$className")
}

internal fun RBuilder.exampleRow(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    div(classes.appendClass("bd-example-row")) {
        block()
    }

internal fun RBuilder.flexColsExampleRow(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    exampleRow(classes.appendClass("bd-example-row-flex-cols"), block)
