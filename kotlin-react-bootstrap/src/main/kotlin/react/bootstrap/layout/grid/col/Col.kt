@file:Suppress("unused", "ClassName", "DuplicatedCode")

package react.bootstrap.layout.grid.col

import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.react.rprops.WithRenderAs
import react.dom.WithClassName
import react.dom.div

class Col : CustomisableComponent<WithClassName, Col.Props, RState>() {
    override fun WithClassName.handleProps() {
        // Pairs and Triples match in multiple of those. That's why we need a Set
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

        className = props.className.appendClass(colClasses)
    }

    override fun RBuilder.getDefaultRenderer(): ReactElement = div { }

    interface Props : WithRenderAs, WithClassName {
        var all: ColAttributes?
        var sm: ColAttributes?
        var md: ColAttributes?
        var lg: ColAttributes?
        var xl: ColAttributes?
    }
}
