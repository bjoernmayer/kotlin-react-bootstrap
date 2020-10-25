package react.bootstrap.lib.component

import react.RComponent
import react.RState
import react.bootstrap.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.react.rprops.WithGlobalAttributes

abstract class BootstrapComponent<RPT : WithGlobalAttributes, RST : RState> : RComponent<RPT, RST> {
    constructor() : super()
    constructor(props: RPT) : super(props)

    /**
     * @return A set of [ClassNames] values used to render this component
     */
    protected abstract fun buildClasses(): Set<ClassNames>

    protected fun getComponentClasses(): Set<String> = props.classes.addOrInit(buildClasses())
}
