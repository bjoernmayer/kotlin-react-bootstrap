package react.bootstrap.content.tables

import kotlinx.html.THEAD
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.RDOMHandler
import react.dom.thead as reactThead

/**
 * Creates a [THEAD] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 * @param style Set a style for light and dark colouring.
 */
public fun RBuilder.thead(
    classes: String? = null,
    style: THeadStyles? = null,
    block: RDOMHandler<THEAD>
): ReactElement {
    val tHeadClasses = mutableSetOf<ClassNames>()

    style?.also {
        tHeadClasses.add(it.className)
    }

    return reactThead(classes = classes.appendClass(tHeadClasses)) {
        val builder = this
        with(block) {
            builder.handle()
        }
    }
}

public enum class THeadStyles(public val className: ClassNames) {
    LIGHT(ClassNames.THEAD_LIGHT),
    DARK(ClassNames.THEAD_DARK);
}
