package react.bootstrap.site.components.docs

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ColAttributes
import react.bootstrap.layout.grid.ColCounts
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.dom.RDOMBuilder
import kotlin.browser.document
import kotlin.reflect.KFunction8
import kotlin.reflect.KFunction9

typealias ColFun = KFunction8<RBuilder, ColAttributes?, ColAttributes?, ColAttributes?, ColAttributes?, ColAttributes?,
    String?, (RDOMBuilder<DIV>.() -> Unit), ReactElement>

typealias RowFun = KFunction9<RBuilder, ColCounts?, ColCounts?, ColCounts?, ColCounts?, ColCounts?, Boolean, String?,
    (RDOMBuilder<DIV>.() -> Unit), ReactElement>

fun pageTitle(pagetitle: String) {
    document.title = "$pagetitle · Kotlin React Bootstrap"
}

val RBuilder.containerFun: String
    get() = RBuilder::container.name

private val colFunFun: ColFun = RBuilder::col

val RBuilder.colFun: String
    get() = colFunFun.name

private val rowFunFun: RowFun = RBuilder::row

val RBuilder.rowFun: String
    get() = rowFunFun.name

val Enum<*>.kt: String
    get() = "${this::class.simpleName}.$name"
