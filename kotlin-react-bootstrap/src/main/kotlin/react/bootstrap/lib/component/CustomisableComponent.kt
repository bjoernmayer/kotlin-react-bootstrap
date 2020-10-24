package react.bootstrap.lib.component

import react.RBuilder
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.lib.rprops.WithRenderAs

/**
 * This class bundles logic to allow components being rendered as different HTML elements.
 *
 * @param RP Renderer Props: This [RProps] of the actual renderer element
 * @param CCP Abstract Component Props: The [RProps] of the [AbstractComponent] implementation
 * @param CCS Abstract Componnt State: The [RState] of  the [AbstractComponent] implementation
 */
abstract class CustomisableComponent<RP : RProps, CCP : WithRenderAs, CCS : RState> : AbstractComponent<RP, CCP, CCS> {
    constructor() : super()
    constructor(props: CCP) : super(props)

    protected abstract fun RBuilder.getDefaultRenderer(): ReactElement

    final override fun RBuilder.getRenderer(): ReactElement = props.renderAs?.invoke(this) ?: getDefaultRenderer()
}
