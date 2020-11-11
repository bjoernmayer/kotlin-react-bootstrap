package react.bootstrap.lib.component

import react.RProps
import react.RState
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import kotlin.reflect.KClass
import kotlinx.html.CommonAttributeGroupFacade as CommonAttributes

/**
 * This class bundles logic to allow components being rendered as different HTML elements.
 *
 * @param T Tag Type: The HTML tag type used to render this component
 * @param P Abstract Component Props: The [RProps] of the [AbstractComponent] implementation
 * @param S Abstract Componnt State: The [RState] of  the [AbstractComponent] implementation
 */
abstract class CustomisableComponent<T : CommonAttributes, P : CustomisableComponent.Props<out T>, S : RState> :
    AbstractComponent<T, P, S> {
    constructor() : super()
    constructor(props: P) : super(props)

    override val rendererTag: KClass<out T>
        get() = props.rendererTag ?: defaultRendererTag

    abstract val defaultRendererTag: KClass<out T>

    interface Props<T : CommonAttributes> : WithGlobalAttributes {
        var rendererTag: KClass<out T>?
    }
}
