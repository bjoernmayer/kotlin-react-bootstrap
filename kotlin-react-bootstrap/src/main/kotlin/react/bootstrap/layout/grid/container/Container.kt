package react.bootstrap.layout.grid.container

import kotlinx.html.classes
import react.RBuilder
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.div

class Container : BootstrapComponent<Container.Props, RState>() {
    override fun buildClasses(): Set<ClassNames> = setOf(props.viscosity?.className ?: ClassNames.CONTAINER)

    override fun RBuilder.render() {
        div {
            attrs {
                loadGlobalAttributes(props)
                classes = getComponentClasses()
            }
            children()
        }
    }

    enum class Viscosities(override val className: ClassNames) : ClassNameEnum {
        FLUID(ClassNames.CONTAINER_FLUID),
        SM(ClassNames.CONTAINER_SM),
        MD(ClassNames.CONTAINER_MD),
        LG(ClassNames.CONTAINER_LG),
        XL(ClassNames.CONTAINER_XL);
    }

    interface Props : WithGlobalAttributes {
        var viscosity: Viscosities?
    }
}
