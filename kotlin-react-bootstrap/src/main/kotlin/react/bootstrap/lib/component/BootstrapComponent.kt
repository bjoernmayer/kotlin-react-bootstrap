package react.bootstrap.lib.component

import react.RBuilder
import react.RComponent
import react.RState
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.react.rprops.WithClasses

public abstract class BootstrapComponent<P : WithClasses, S : RState> : RComponent<P, S> {
    public constructor() : super()
    public constructor(props: P) : super(props)

    /**
     * @return A set of [ClassNames] values used to render this component
     */
    protected abstract fun buildClasses(): Set<ClassNames>

    public abstract fun RBuilder.render(rendererClasses: Set<String>)

    override fun RBuilder.render(): Unit = render(props.classes.addOrInit(buildClasses()))
}
