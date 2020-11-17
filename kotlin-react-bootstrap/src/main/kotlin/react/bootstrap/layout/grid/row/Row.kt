@file:Suppress("DuplicatedCode")

package react.bootstrap.layout.grid.row

import react.RState
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent

class Row<T : DOMTag>(props: Props<T>) : AbstractDOMComponent<T, Row.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> {
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

        return rowClasses
    }

    interface Props<T : DOMTag> : AbstractDOMComponent.Props<T> {
        var all: RowAttributes?
        var sm: RowAttributes?
        var md: RowAttributes?
        var lg: RowAttributes?
        var xl: RowAttributes?
        var gutters: Boolean?
    }
}
