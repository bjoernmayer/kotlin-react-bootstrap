@file:Suppress("DuplicatedCode")

package react.bootstrap.layout.grid.row

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import kotlinx.html.classes
import react.RState
import react.bootstrap.appendClass
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.react.rprops.WithRendererTag
import react.bootstrap.toClasses
import react.dom.RDOMBuilder
import react.dom.WithClassName
import kotlin.reflect.KClass

class Row : CustomisableComponent<CommonAttributeGroupFacade, Row.Props, RState>() {
    override val defaultRendererTag: KClass<out CommonAttributeGroupFacade> = DIV::class

    override fun RDOMBuilder<CommonAttributeGroupFacade>.build() {
        attrs {
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

            classes = props.className.appendClass(rowClasses).toClasses()!!
        }
    }

    interface Props : WithRendererTag<CommonAttributeGroupFacade>, WithClassName {
        var all: RowAttributes?
        var sm: RowAttributes?
        var md: RowAttributes?
        var lg: RowAttributes?
        var xl: RowAttributes?
        var gutters: Boolean?
    }
}
