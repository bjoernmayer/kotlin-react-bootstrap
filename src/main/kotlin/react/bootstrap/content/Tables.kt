package react.bootstrap.content

import kotlinx.html.TABLE
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.Breakpoints
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.WithBlock
import react.dom.RDOMBuilder
import react.dom.WithClassName
import react.dom.div
import react.dom.table

fun RBuilder.table(
    dark: Boolean? = null,
    striped: Boolean? = null,
    borderStyle: Table.BorderStyles? = null,
    hoverable: Boolean? = null,
    small: Boolean? = null,
    responsive: Breakpoints? = null,
    classes: String? = null,
    block: RDOMBuilder<TABLE>.() -> Unit
): ReactElement = child(Table::class) {
    attrs {
        this.dark = dark
        this.striped = striped
        this.borderStyle = borderStyle
        this.hoverable = hoverable
        this.small = small
        this.responsive = responsive
        this.className = classes
        this.block = block
    }
}

@Suppress("unused")
class Table : RComponent<Table.Props, RState>() {
    enum class BorderStyles(val className: ClassNames) {
        BORDERED(ClassNames.TABLE_BORDERED),
        BORDERLESS(ClassNames.TABLE_BORDERLESS)
    }

    interface Props : WithClassName, WithBlock<TABLE> {
        var dark: Boolean?
        var striped: Boolean?
        var borderStyle: BorderStyles?
        var hoverable: Boolean?
        var small: Boolean?
        var responsive: Breakpoints?
    }

    override fun RBuilder.render() {
        val tableClasses = mutableSetOf(ClassNames.TABLE)

        if (props.dark == true) {
            tableClasses.add(ClassNames.TABLE_DARK)
        }

        if (props.striped == true) {
            tableClasses.add(ClassNames.TABLE_STRIPED)
        }

        props.borderStyle?.also {
            tableClasses.add(it.className)
        }

        if (props.hoverable == true) {
            tableClasses.add(ClassNames.TABLE_HOVER)
        }

        if (props.small == true) {
            tableClasses.add(ClassNames.TABLE_SM)
        }

        if (props.responsive !== null) {
            val divClassName = when (props.responsive!!) {
                Breakpoints.SM -> ClassNames.TABLE_RESPONSIVE_SM
                Breakpoints.MD -> ClassNames.TABLE_RESPONSIVE_MD
                Breakpoints.LG -> ClassNames.TABLE_RESPONSIVE_LG
                Breakpoints.XL -> ClassNames.TABLE_RESPONSIVE_XL
                Breakpoints.ALL -> ClassNames.TABLE_RESPONSIVE
            }

            div(classes = divClassName.className) {
                renderTable(tableClasses)
            }
        } else {
            renderTable(tableClasses)
        }
    }

    private fun RBuilder.renderTable(tableClasses: Set<ClassNames>) {
        table(classes = props.className.appendClass(tableClasses)) {
            props.block.invoke(this)
        }
    }
}
