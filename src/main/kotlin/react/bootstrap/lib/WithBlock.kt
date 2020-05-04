package react.bootstrap.lib

import kotlinx.html.HTMLTag
import react.RHandler
import react.RProps
import react.dom.RDOMBuilder

interface WithRDOMBuilderBlock<T : HTMLTag> : RProps {
    var block: RDOMBuilder<T>.() -> Unit
}

interface WithRHandlerBlock<T : RProps> : RProps {
    var block: RHandler<T>
}
