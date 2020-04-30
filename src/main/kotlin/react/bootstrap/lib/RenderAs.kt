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

interface WithRenderAs : RProps {
    var renderAs: (RBuilder.() -> ReactElement)?
}

abstract class RenderAsComponent<P : WithRenderAs, S : RState> : RComponent<P, S> {
    constructor() : super() {
        state = jsObject { init() }
    }

    constructor(props: P) : super(props) {
        state = jsObject { init(props) }
    }

    abstract fun WithClassName.setProps()

    abstract fun RBuilder.defaultElement(): ReactElement

    final override fun RBuilder.render() {
        val element: ReactElement = props.renderAs?.invoke(this) ?: defaultElement()

        child(cloneElement<WithClassName>(element, *Children.toArray(props.children)) {
            setProps()
        })
    }

    final override fun render(): dynamic {
        return RBuilder().apply {
            this.render()
        }.childList.last()
    }
}
