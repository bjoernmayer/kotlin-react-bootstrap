package react.bootstrap.layout.grid

import kotlinx.html.DIV
import react.RBuilder
import react.RProps
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.div

enum class ColumnCount(internal val value: Int) {
    CNT_1(1),
    CNT_2(2),
    CNT_3(3),
    CNT_4(4),
    CNT_5(5),
    CNT_6(6)
}

internal interface RowProps : RProps {
    var all: ColumnCount?
    var sm: ColumnCount?
    var md: ColumnCount?
    var lg: ColumnCount?
    var xl: ColumnCount?
    var classes: String?
    var block: RDOMBuilder<DIV>.() -> Unit
}

fun RBuilder.row(
    all: ColumnCount? = null,
    sm: ColumnCount? = null,
    md: ColumnCount? = null,
    lg: ColumnCount? = null,
    xl: ColumnCount? = null,
    classes: String? = null,
    block: RDOMBuilder<DIV>.() -> Unit
): ReactElement {
    val rowClasses = listOfNotNull(
        "${ClassNames.ROW}",
        all?.let { ClassNames.valueOf("ROW_COLS_${it.value}") },
        sm?.let { ClassNames.valueOf("ROW_COLS_SM_${it.value}") },
        md?.let { ClassNames.valueOf("ROW_COLS_MD_${it.value}") },
        lg?.let { ClassNames.valueOf("ROW_COLS_LG_${it.value}") },
        xl?.let { ClassNames.valueOf("ROW_COLS_XL_${it.value}") }
    )

    return div(
        classes.appendClass(rowClasses.joinToString(" "))
    ) {
        block()
    }
}
