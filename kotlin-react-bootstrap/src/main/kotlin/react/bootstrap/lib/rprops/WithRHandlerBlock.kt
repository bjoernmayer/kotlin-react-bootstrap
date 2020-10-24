package react.bootstrap.lib.rprops

import react.RHandler
import react.RProps

interface WithRHandlerBlock<T : RProps> : RProps {
    var handler: RHandler<T>
}
