package react.bootstrap.lib

import kotlinx.html.HTMLTag
import react.RElementBuilder
import react.RProps
import react.ReactElement
import react.dom.RDOMBuilder

interface WithRDOMBuilderBlock<T : HTMLTag> : RProps {
    var block: RDOMBuilder<T>.() -> Unit
}

interface WithRElementBuilderBlock<T : RProps> : RProps {
    var block: RElementBuilder<T>.() -> Unit
}
