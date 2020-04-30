package react.bootstrap.lib

import kotlinx.html.HTMLTag
import react.RProps
import react.dom.RDOMBuilder

interface WithBlock<T : HTMLTag> : RProps {
    var block: RDOMBuilder<T>.() -> Unit
}
