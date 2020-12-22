package react.bootstrap.layout.grid.container

import kotlinx.html.HtmlBlockTag
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent
import react.bootstrap.lib.component.ClassNameEnum

public class Container<T : HtmlBlockTag>(props: Props<T>) : AbstractDOMComponent<T, Container.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(props.viscosity?.className ?: ClassNames.CONTAINER)

    public enum class Viscosities(override val className: ClassNames) : ClassNameEnum {
        FLUID(ClassNames.CONTAINER_FLUID),
        SM(ClassNames.CONTAINER_SM),
        MD(ClassNames.CONTAINER_MD),
        LG(ClassNames.CONTAINER_LG),
        XL(ClassNames.CONTAINER_XL);
    }

    public interface Props<T : HtmlBlockTag> : AbstractDOMComponent.Props<T> {
        public var viscosity: Viscosities?
    }
}
