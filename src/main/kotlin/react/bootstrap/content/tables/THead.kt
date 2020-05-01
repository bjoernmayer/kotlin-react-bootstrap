package react.bootstrap.content.tables

import kotlinx.html.THEAD
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.thead

fun RBuilder.thead(
    style: THeadStyles? = null,
    classes: String? = null,
    block: RDOMBuilder<THEAD>.() -> Unit
): ReactElement {
    val tHeadClasses = mutableSetOf<ClassNames>()

    style?.also {
        tHeadClasses.add(it.className)
    }

    return thead(classes = classes.appendClass(tHeadClasses), block = block)
}

enum class THeadStyles(val className: ClassNames) {
    LIGHT(ClassNames.THEAD_LIGHT),
    DARK(ClassNames.THEAD_DARK);
}
