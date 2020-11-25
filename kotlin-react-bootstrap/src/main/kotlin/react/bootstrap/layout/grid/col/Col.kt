@file:Suppress("DuplicatedCode")

package react.bootstrap.layout.grid.col

import react.RState
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent

public class Col<T : DOMTag>(props: Props<T>) : AbstractDOMComponent<T, Col.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> {
        val colClasses = mutableSetOf<ClassNames>()

        with(props) {
            if (all?.size == null && sm?.size == null && md?.size == null && lg?.size == null && xl?.size == null) {
                EQ.getClassNames(null).let(colClasses::addAll)
            }

            all?.getClassNames(null)?.let(colClasses::addAll)
            sm?.getClassNames(Breakpoints.SM)?.let(colClasses::addAll)
            md?.getClassNames(Breakpoints.MD)?.let(colClasses::addAll)
            lg?.getClassNames(Breakpoints.LG)?.let(colClasses::addAll)
            xl?.getClassNames(Breakpoints.XL)?.let(colClasses::addAll)
        }

        return colClasses
    }

    public interface Props<T : DOMTag> : AbstractDOMComponent.Props<T> {
        public var all: ColAttributes?
        public var sm: ColAttributes?
        public var md: ColAttributes?
        public var lg: ColAttributes?
        public var xl: ColAttributes?
    }
}
