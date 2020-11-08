package react.bootstrap.lib.component

import kotlinx.html.CommonAttributeGroupFacade
import react.RProps
import react.RState
import react.bootstrap.lib.react.rprops.WithRendererTag
import kotlin.reflect.KClass

/**
 * This class bundles logic to allow components being rendered as different HTML elements.
 *
 * @param TT Tag Type: The HTML tag type used to render this component
 * @param CCP Abstract Component Props: The [RProps] of the [AbstractComponent] implementation
 * @param CCS Abstract Componnt State: The [RState] of  the [AbstractComponent] implementation
 */
abstract class CustomisableComponent<TT : CommonAttributeGroupFacade, CCP : WithRendererTag<out TT>, CCS : RState> :
    AbstractComponent<TT, CCP, CCS> {
    constructor() : super()
    constructor(props: CCP) : super(props)

    override val rendererTag: KClass<out TT>
        get() = props.rendererTag ?: defaultRendererTag

    abstract val defaultRendererTag: KClass<out TT>
}
