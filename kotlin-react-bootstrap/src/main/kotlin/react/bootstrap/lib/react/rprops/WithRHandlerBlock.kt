package react.bootstrap.lib.react.rprops

import react.RHandler
import react.RProps

interface WithRHandlerBlock<T : RProps> : RProps {
    var handler: RHandler<T>
}
