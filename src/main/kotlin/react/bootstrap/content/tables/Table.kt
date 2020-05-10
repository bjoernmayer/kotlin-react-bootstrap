package react.bootstrap.content.tables

import kotlinx.html.TABLE
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.Breakpoints
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.RDOMHandler
import react.dom.div
import react.dom.table

fun RBuilder.table(
    dark: Boolean? = null,
    striped: Boolean? = null,
    borderStyle: BorderStyles? = null,
    hoverable: Boolean? = null,
    small: Boolean? = null,
    responsive: Breakpoints? = null,
    classes: String? = null,
    block: RDOMHandler<TABLE>
): ReactElement {
    val tableClasses = mutableSetOf(ClassNames.TABLE)

    if (dark == true) {
        tableClasses.add(ClassNames.TABLE_DARK)
    }

    if (striped == true) {
        tableClasses.add(ClassNames.TABLE_STRIPED)
    }

    borderStyle?.also {
        tableClasses.add(it.className)
    }

    if (hoverable == true) {
        tableClasses.add(ClassNames.TABLE_HOVER)
    }

    if (small == true) {
        tableClasses.add(ClassNames.TABLE_SM)
    }

    return if (responsive !== null) {
        val divClassName = when (responsive) {
            Breakpoints.SM -> ClassNames.TABLE_RESPONSIVE_SM
            Breakpoints.MD -> ClassNames.TABLE_RESPONSIVE_MD
            Breakpoints.LG -> ClassNames.TABLE_RESPONSIVE_LG
            Breakpoints.XL -> ClassNames.TABLE_RESPONSIVE_XL
            Breakpoints.ALL -> ClassNames.TABLE_RESPONSIVE
        }

        div(classes = divClassName.className) {
            table(classes = classes.appendClass(tableClasses), block = block)
        }
    } else {
        table(classes = classes.appendClass(tableClasses), block = block)
    }
}

enum class BorderStyles(override val className: ClassNames) : ClassNameEnum {
    BORDERED(ClassNames.TABLE_BORDERED),
    BORDERLESS(ClassNames.TABLE_BORDERLESS);
}

enum class ContextualStyle(override val className: ClassNames) : ClassNameEnum {
    ACTIVE(ClassNames.TABLE_ACTIVE),
    DANGER(ClassNames.TABLE_DANGER),
    DARK(ClassNames.TABLE_DARK),
    INFO(ClassNames.TABLE_INFO),
    LIGHT(ClassNames.TABLE_LIGHT),
    PRIMARY(ClassNames.TABLE_PRIMARY),
    SECONDARY(ClassNames.TABLE_SECONDARY),
    SUCCESS(ClassNames.TABLE_SUCCESS),
    WARNING(ClassNames.TABLE_WARNING);
}
