package react.bootstrap.content.typography

import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder

fun <T : HTMLTag> RBuilder.small(
    tagFun: RBuilder.(classes: String?, block: RDOMBuilder<T>.() -> Unit) -> ReactElement,
    classes: String? = null,
    block: RDOMBuilder<T>.() -> Unit
): ReactElement = tagFun(classes.appendClass(ClassNames.SMALL), block)

fun <T : HTMLTag> RBuilder.mark(
    tagFun: RBuilder.(classes: String?, block: RDOMBuilder<T>.() -> Unit) -> ReactElement,
    classes: String? = null,
    block: RDOMBuilder<T>.() -> Unit
): ReactElement = tagFun(classes.appendClass(ClassNames.MARK), block)
