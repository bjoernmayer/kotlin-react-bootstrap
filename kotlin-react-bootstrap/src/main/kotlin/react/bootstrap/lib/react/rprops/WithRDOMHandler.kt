package react.bootstrap.lib.react.rprops

import kotlinx.html.HTMLTag
import react.RProps
import react.bootstrap.lib.RDOMHandler

interface WithRDOMHandler<T : HTMLTag> : RProps {
    var handler: RDOMHandler<T>
}
