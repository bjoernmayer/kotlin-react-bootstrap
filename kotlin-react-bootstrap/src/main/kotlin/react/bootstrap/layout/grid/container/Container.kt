package react.bootstrap.layout.grid.container

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.dom.div

class Container : RComponent<Container.Props, RState>() {
    override fun RBuilder.render() {
        val className: ClassNames = props.viscosity?.className ?: ClassNames.CONTAINER

        div(classes = props.classes.appendClass(className)) {
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

    interface Props : RProps {
        var viscosity: Viscosities?
        var classes: String?
    }
}
