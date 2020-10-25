package react.bootstrap.lib.component

import react.Child
import react.Children
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.children
import react.cloneElement

/**
 * @param RP Renderer Props: This [RProps] of the actual renderer element
 * @param ACP Abstract Component Props: The [RProps] of the [AbstractComponent] implementation
 * @param ACS Abstract Componnt State: The [RState] of  the [AbstractComponent] implementation
 */
abstract class AbstractComponent<RP : RProps, ACP : RProps, ACS : RState> : RComponent<ACP, ACS> {
    constructor() : super()
    constructor(props: ACP) : super(props)

    protected abstract fun RP.handleProps()

    /**
     * This is an [ElementProvider].
     *
     * This should return a [ReactElement] which is used as default renderer if no `renderAs` was set.
     */
    protected abstract fun RBuilder.getRenderer(): ReactElement

    final override fun RBuilder.render() {
        val element: ReactElement = getRenderer()

        // This clones the provided element and then pushes all children of the renderAs component into it
        child(
            element.injectChildren<RP>(Children.toArray(props.children)) {
                handleProps()
            }
        )
    }

    final override fun render(): dynamic = RBuilder().apply { render() }.childList.last()

    /**
     * @return A clone of [ReactElement] with given children
     */
    private fun <P : RProps> ReactElement.injectChildren(
        children: Array<out Child>,
        propHandler: P.() -> Unit
    ): ReactElement =
        cloneElement<P>(this, *children) {
            propHandler()
        }
}
