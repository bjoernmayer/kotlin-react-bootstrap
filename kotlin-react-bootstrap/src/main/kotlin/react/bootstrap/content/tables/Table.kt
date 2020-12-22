package react.bootstrap.content.tables

import kotlinx.html.TABLE
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.component.RDOMHandler
import react.dom.div
import react.dom.table as reactTable

/**
 * Creates a [TABLE] element and adds Bootstrap classes to it.
 *
 * @param dark If set to `true`, [ClassNames.TABLE_DARK] gets added to classes.
 * @param striped If set to `true`, [ClassNames.TABLE_STRIPED] gets added to classes.
 * @param borderStyle Choose between different [BorderStyles].
 * @param hoverable If set to `true`, [ClassNames.TABLE_HOVER] gets added to classes.
 * @param small If set to `true`, [ClassNames.TABLE_SM] gets added to classes.
 * @param responsive Set [Breakpoints] to specify, when a table should start to show scrollbars.
 * @param classes Space separated list of CSS classes for this element.
 */
public fun RBuilder.table(
    classes: String? = null,
    dark: Boolean = false,
    striped: Boolean = false,
    borderStyle: BorderStyles? = null,
    hoverable: Boolean = false,
    small: Boolean = false,
    responsive: Breakpoints? = null,
    block: RDOMHandler<TABLE>
): ReactElement {
    val tableClasses = mutableSetOf(ClassNames.TABLE)

    if (dark) {
        tableClasses.add(ClassNames.TABLE_DARK)
    }

    if (striped) {
        tableClasses.add(ClassNames.TABLE_STRIPED)
    }

    borderStyle?.also {
        tableClasses.add(it.className)
    }

    if (hoverable) {
        tableClasses.add(ClassNames.TABLE_HOVER)
    }

    if (small) {
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

        div(divClassName.className) {
            reactTable(classes.appendClass(tableClasses)) {
                val builder = this
                with(block) {
                    builder.handle()
                }
            }
        }
    } else {
        reactTable(classes.appendClass(tableClasses)) {
            val builder = this
            with(block) {
                builder.handle()
            }
        }
    }
}

public enum class BorderStyles(override val className: ClassNames) : ClassNameEnum {
    BORDERED(ClassNames.TABLE_BORDERED),
    BORDERLESS(ClassNames.TABLE_BORDERLESS);
}

public enum class ContextualStyle(override val className: ClassNames) : ClassNameEnum {
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
