package react.bootstrap.lib

import kotlinx.html.HTMLTag
import react.RHandler
import react.RProps

interface WithRDOMHandler<T : HTMLTag> : RProps {
    var handler: RDOMHandler<T>
}

interface WithRHandlerBlock<T : RProps> : RProps {
    var handler: RHandler<T>
}

interface WithOnClick : RProps {
    var onClick: EventHandler?
}
