@file:Suppress("unused", "ClassName", "DuplicatedCode")

package react.bootstrap.layout.grid.col

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import kotlinx.html.classes
import react.RState
import react.bootstrap.appendClass
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.react.rprops.WithRendererTag
import react.bootstrap.toClasses
import react.dom.RDOMBuilder
import react.dom.WithClassName
import kotlin.reflect.KClass

class Col : CustomisableComponent<CommonAttributeGroupFacade, Col.Props, RState>() {
    override val defaultRendererTag: KClass<out CommonAttributeGroupFacade> = DIV::class

    override fun RDOMBuilder<CommonAttributeGroupFacade>.build() {
        attrs {
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

            classes = props.className.appendClass(colClasses).toClasses()!!
        }
    }

    interface Props : WithRendererTag<CommonAttributeGroupFacade>, WithClassName {
        var all: ColAttributes?
        var sm: ColAttributes?
        var md: ColAttributes?
        var lg: ColAttributes?
        var xl: ColAttributes?
    }
}
