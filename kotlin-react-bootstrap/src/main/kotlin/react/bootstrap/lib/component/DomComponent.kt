package react.bootstrap.lib.component

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.react.rprops.WithClasses
import react.bootstrap.lib.react.rprops.requireProperties
import kotlin.reflect.KClass

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

    companion object {
        inline fun <reified T : CommonAttributeGroupFacade, reified P : Props<T>> RBuilder.domComponent(
            classes: String? = null,
            klazz: KClass<out DomComponent<*, *, *>>,
            noinline domHandler: RDOMHandler<T>,
            crossinline handler: RHandler<P> = { }
        ): ReactElement {

            @Suppress("UNCHECKED_CAST")
            val componentKlazz: KClass<out DomComponent<*, P, *>> = klazz as KClass<out DomComponent<*, P, *>>

            return child(componentKlazz) {
                attrs {
                    this.classes = classes.splitClassesToSet()
                    this.handler = domHandler
                }

                handler()
            }
        }
    }
}
