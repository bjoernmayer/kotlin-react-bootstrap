package react.bootstrap.site.components.docs.layout.grid

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.layout.gridImport
import react.bootstrap.site.components.docs.layout.ktContainer
import react.dom.div
import kotlin.reflect.KClass

private val colFunFun = RBuilder::col
internal val RBuilder.colFun: String
    get() = colFunFun.name
private val rowFunFun = RBuilder::row
internal val RBuilder.rowFun: String
    get() = rowFunFun.name

internal fun CodeExampleBuilder.ktRow(
    indentationLevel: Int = 1,
    block: CodeExampleBuilder.(indentationLevel: Int) -> Unit
) {
    ktB(indentationLevel, rowFun) {
        block(indentationLevel + 1)
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
    gridImport(colFun)
}

internal fun CodeExampleBuilder.importRowFun() {
    gridImport(rowFun)
}

internal fun <T : Enum<*>> CodeExampleBuilder.importGridEnum(clazz: KClass<T>) {
    gridImport(clazz.simpleName!!)
}

internal fun RBuilder.exampleRow(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    div(classes.appendClass("bd-example-row")) {
        block()
    }

internal fun RBuilder.flexColsExampleRow(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    exampleRow(classes.appendClass("bd-example-row-flex-cols"), block)
