package react.bootstrap.lib.component

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RComponent
import react.RState
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.react.rprops.WithClasses
import react.bootstrap.lib.react.rprops.requireProperties

/**
 * A [DomComponent] is a react component, which passes through its [DomComponent.Props.handler] to the underlying
 * HTML element.
 *
 * @param T type of the tag which is used to render this component
 * @param P property type
 * @param S State type
 */
abstract class DomComponent<T : CommonAttributeGroupFacade, P : DomComponent.Props<T>, S : RState>(props: P) :
    RComponent<P, S>(props) {
    init {
        props.requireProperties(props::handler)
    }

    /**
     * @return A set of [ClassNames] values used to render this component
     */
    protected abstract fun buildClasses(): Set<ClassNames>

    protected abstract fun RBuilder.render(componentClasses: Set<ClassNames>, handler: RDOMHandler<T>)

    final override fun RBuilder.render() = render(buildClasses(), props.handler)

    interface Props<T : CommonAttributeGroupFacade> : WithClasses {
        var handler: RDOMHandler<T>
    }
}
