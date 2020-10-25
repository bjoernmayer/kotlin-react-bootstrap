package react.bootstrap.lib.react.rprops

import react.RProps
import react.bootstrap.lib.ElementProvider

interface WithRenderAs : RProps {
    var renderAs: ElementProvider?
}
