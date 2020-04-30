package react.bootstrap.site.components.docs

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import kotlin.browser.document

fun pageTitle(pagetitle: String) {
    document.title = "$pagetitle · Kotlin React Bootstrap"
}

val RBuilder.containerFun: String
    get() = RBuilder::container.name

private val colFunFun = RBuilder::col

val RBuilder.colFun: String
    get() = colFunFun.name

private val rowFunFun = RBuilder::row

val RBuilder.rowFun: String
    get() = rowFunFun.name

val Enum<*>.kt: String
    get() = "${this::class.simpleName}.$name"
