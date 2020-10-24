package react.bootstrap.content.typography

import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.RDOMHandler

fun <T : HTMLTag> RBuilder.small(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = tagFun(classes.appendClass(ClassNames.SMALL), block)

fun <T : HTMLTag> RBuilder.mark(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = tagFun(classes.appendClass(ClassNames.MARK), block)
