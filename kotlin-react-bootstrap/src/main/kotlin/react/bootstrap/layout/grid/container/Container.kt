package react.bootstrap.layout.grid.container

import kotlinx.html.HtmlBlockTag
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDomComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.dom.RDOMBuilder

class Container<T : HtmlBlockTag>(props: Props<T>) : AbstractDomComponent<T, Container.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(props.viscosity?.className ?: ClassNames.CONTAINER)

    override fun RDOMBuilder<T>.build() {
        children()
    }

    enum class Viscosities(override val className: ClassNames) : ClassNameEnum {
        FLUID(ClassNames.CONTAINER_FLUID),
        SM(ClassNames.CONTAINER_SM),
        MD(ClassNames.CONTAINER_MD),
        LG(ClassNames.CONTAINER_LG),
        XL(ClassNames.CONTAINER_XL);
    }

    interface Props<T : HtmlBlockTag> : AbstractDomComponent.Props<T> {
        var viscosity: Viscosities?
    }
}
