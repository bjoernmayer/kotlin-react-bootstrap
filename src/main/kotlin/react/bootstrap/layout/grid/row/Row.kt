@file:Suppress("DuplicatedCode")

package react.bootstrap.layout.grid.row

import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.Breakpoints
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.RenderAsComponent
import react.bootstrap.lib.WithRenderAs
import react.dom.WithClassName
import react.dom.div

class Row : RenderAsComponent<Row.Props, WithClassName, RState>() {
    override fun WithClassName.handleProps() {
        // Pairs and Triples match in multiple of those. That's why we need a Set
        val rowClasses = mutableSetOf(ClassNames.ROW)

        with(props) {
            if (gutters == false) {
                rowClasses.add(ClassNames.NO_GUTTERS)
            }

            all?.getClassNames(null)?.let(rowClasses::addAll)
            sm?.getClassNames(Breakpoints.SM)?.let(rowClasses::addAll)
            md?.getClassNames(Breakpoints.MD)?.let(rowClasses::addAll)
            lg?.getClassNames(Breakpoints.LG)?.let(rowClasses::addAll)
            xl?.getClassNames(Breakpoints.XL)?.let(rowClasses::addAll)
        }

        className = props.className.appendClass(rowClasses)
    }

    override fun RBuilder.getDefaultRenderer(): ReactElement = div { }

    interface Props : WithRenderAs, WithClassName {
        var all: RowAttributes?
        var sm: RowAttributes?
        var md: RowAttributes?
        var lg: RowAttributes?
        var xl: RowAttributes?
        var gutters: Boolean?
    }
}
