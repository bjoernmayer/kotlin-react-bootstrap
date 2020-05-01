package react.bootstrap.content.typography

import kotlinx.html.LI
import kotlinx.html.UL
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.li
import react.dom.ul

enum class ListStyles(override val className: ClassNames) : ClassNameEnum {
    UNSTYLED(ClassNames.LIST_UNSTYLED),
    INLINE(ClassNames.LIST_INLINE);
}

fun RBuilder.ul(
    listStyles: ListStyles,
    classes: String? = null,
    block: RDOMBuilder<UL>.() -> Unit
): ReactElement =
    ul(classes = classes.appendClass(listStyles.className), block = block)

enum class ListItemStyles(override val className: ClassNames) : ClassNameEnum {
    INLINE(ClassNames.LIST_INLINE);
}

fun RBuilder.li(
    listItemStyles: ListItemStyles,
    classes: String? = null,
    block: RDOMBuilder<LI>.() -> Unit
): ReactElement =
    li(classes = classes.appendClass(listItemStyles.className), block = block)
