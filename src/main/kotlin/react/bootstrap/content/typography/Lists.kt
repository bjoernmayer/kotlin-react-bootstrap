package react.bootstrap.content.typography

import kotlinx.html.LI
import kotlinx.html.UL
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.li
import react.dom.ul

enum class ListStyles(private val classNames: ClassNames) {
    UNSTYLED(ClassNames.LIST_UNSTYLED),
    INLINE(ClassNames.LIST_INLINE);

    override fun toString(): String = classNames.toString()
}

fun RBuilder.ul(
    listStyles: ListStyles? = null,
    classes: String? = null,
    block: RDOMBuilder<UL>.() -> Unit
): ReactElement = ul(
    if (listStyles !== null) {
        classes.appendClass(listStyles.toString())
    } else {
        classes
    },
    block
)

enum class ListItemStyles(private val classNames: ClassNames) {
    INLINE(ClassNames.LIST_INLINE);

    override fun toString(): String = classNames.toString()
}

fun RBuilder.li(
    listItemStyles: ListItemStyles? = null,
    classes: String? = null,
    block: RDOMBuilder<LI>.() -> Unit
): ReactElement = li(
    if (listItemStyles !== null) {
        classes.appendClass(listItemStyles.toString())
    } else {
        classes
    },
    block
)
