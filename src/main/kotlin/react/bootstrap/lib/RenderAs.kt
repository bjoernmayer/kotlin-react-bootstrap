package react.bootstrap.lib

import kotlinext.js.jsObject
import react.Children
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.children
import react.cloneElement
import react.dom.WithClassName
import react.dom.fixAttributeName

interface WithRenderAs : RProps {
    var renderAs: ElementProvider?
}

abstract class RenderAsComponent<P : WithRenderAs, RP : WithClassName, S : RState> : RComponent<P, S> {
    constructor() : super() {
        state = jsObject { init() }
    }

    constructor(props: P) : super(props) {
        state = jsObject { init(props) }
    }

    protected abstract fun RP.handleProps()

    protected abstract fun RBuilder.getDefaultRenderer(): ReactElement

    protected fun RP.setProp(attribute: String, value: Any?) {
        val key = fixAttributeName(attribute)
        props.asDynamic()[key] = value
    }

    final override fun RBuilder.render() {
        val element: ReactElement = props.renderAs?.invoke(this) ?: getDefaultRenderer()

        child(cloneElement<RP>(element, *Children.toArray(props.children)) {
            handleProps()
        })
    }

    final override fun render(): dynamic {
        return RBuilder().apply {
            this.render()
        }.childList.last()
    }
}
