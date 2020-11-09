package react.bootstrap.content.tables

import kotlinx.html.THEAD
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.thead

/**
 * Creates a [THEAD] element.
 *
 * @param style Set a style for light and dark colouring.
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.thead(
    style: THeadStyles? = null,
    classes: String? = null,
    block: RDOMHandler<THEAD>
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
