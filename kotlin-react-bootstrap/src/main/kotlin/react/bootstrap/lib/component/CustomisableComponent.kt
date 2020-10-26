package react.bootstrap.lib.component

import kotlinx.html.Tag
import react.RProps
import react.RState
import react.bootstrap.lib.react.rprops.WithRendererTag
import kotlin.reflect.KClass

/**
 * This class bundles logic to allow components being rendered as different HTML elements.
 *
 * @param CCP Abstract Component Props: The [RProps] of the [AbstractComponent] implementation
 * @param CCS Abstract Componnt State: The [RState] of  the [AbstractComponent] implementation
 */
abstract class CustomisableComponent<CCP : WithRendererTag<out Tag>, CCS : RState> : AbstractComponent<CCP, CCS> {
    constructor() : super()
    constructor(props: CCP) : super(props)

    protected abstract fun getDefaultRendererTag(): KClass<out Tag>
    override fun getRenderer(): KClass<out Tag> = props.rendererTag ?: getDefaultRendererTag()
}
