package react.bootstrap.content.typography

import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.RDOMHandler

enum class Headings(val className: ClassNames) {
    H1(ClassNames.H1),
    H2(ClassNames.H2),
    H3(ClassNames.H3),
    H4(ClassNames.H4),
    H5(ClassNames.H5),
    H6(ClassNames.H6);
}

// Todo: move this to the other text stuff
fun <T : HTMLTag> RBuilder.muted(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = tagFun(classes.appendClass(ClassNames.TEXT_MUTED), block)
