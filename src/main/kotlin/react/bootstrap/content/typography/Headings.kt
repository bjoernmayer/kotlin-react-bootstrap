package react.bootstrap.content.typography

import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.RDOMHandler

enum class Headings(val className: ClassNames) {
    H1(ClassNames.H1),
    H2(ClassNames.H2),
    H3(ClassNames.H3),
    H4(ClassNames.H4),
    H5(ClassNames.H5),
    H6(ClassNames.H6);
}

fun <T : HTMLTag> RBuilder.h(
    headings: Headings,
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement =
    tagFun(classes.appendClass(headings.className), block)

fun <T : HTMLTag> RBuilder.h1(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = h(Headings.H1, tagFun, classes, block)

fun <T : HTMLTag> RBuilder.h2(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = h(Headings.H2, tagFun, classes, block)

fun <T : HTMLTag> RBuilder.h3(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = h(Headings.H3, tagFun, classes, block)

fun <T : HTMLTag> RBuilder.h4(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = h(Headings.H4, tagFun, classes, block)

fun <T : HTMLTag> RBuilder.h5(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
) = h(Headings.H5, tagFun, classes, block)

fun <T : HTMLTag> RBuilder.h6(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = h(Headings.H6, tagFun, classes, block)

// Todo: move this to the other text stuff
fun <T : HTMLTag> RBuilder.muted(
    tagFun: RBuilder.(classes: String?, block: RDOMHandler<T>) -> ReactElement,
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = tagFun(classes.appendClass(ClassNames.TEXT_MUTED), block)
