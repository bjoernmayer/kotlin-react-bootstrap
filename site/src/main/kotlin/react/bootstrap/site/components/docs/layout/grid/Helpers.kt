package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.ln
import kotlin.reflect.KClass

internal val RBuilder.containerFun: String
    get() = RBuilder::container.name
private val colFunFun = RBuilder::col
internal val RBuilder.colFun: String
    get() = colFunFun.name
private val rowFunFun = RBuilder::row
internal val RBuilder.rowFun: String
    get() = rowFunFun.name

internal fun RBuilder.gridImport(className: String) {
    ln { +"import react.bootstrap.layout.grid.$className" }
}

internal fun RBuilder.containerFunImport() {
    gridImport(containerFun)
}

internal fun RBuilder.colFunImport() {
    gridImport(colFun)
}

internal fun RBuilder.rowFunImport() {
    gridImport(rowFun)
}

internal fun <T : Enum<*>> RBuilder.gridEnumImport(clazz: KClass<T>) {
    gridImport(clazz.simpleName!!)
}

internal fun RBuilder.ktConRow(block: RBuilder.(indentationLevel: Int) -> Unit) {
    ktContainer {
        ktRow {
            block(2)
        }
    }
}

internal fun RBuilder.ktContainer(block: RBuilder.(indentationLevel: Int) -> Unit) {
    ktBlock(opener = containerFun) {
        block(1)
    }
}

internal fun RBuilder.ktRow(indentationLevel: Int = 1, block: RBuilder.(indentationLevel: Int) -> Unit) {
    ktBlock(indentationLevel, rowFun) {
        block(indentationLevel + 1)
    }
}

internal fun RBuilder.ktBlock(
    indentationLevel: Int = 0,
    opener: String,
    block: RBuilder.(indentationLevel: Int) -> Unit
) {
    ln(indentationLevel) { +"$opener {" }
    block(indentationLevel + 1)
    ln(indentationLevel) { +"}" }
}

internal fun RBuilder.ktFun(
    indentationLevel: Int = 0,
    opener: String,
    block: RBuilder.(indentationLevel: Int) -> Unit
) {
    ln(indentationLevel) { +"$opener (" }
    block(indentationLevel + 1)
    ln(indentationLevel) { +")" }
}
