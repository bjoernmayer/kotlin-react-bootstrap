package react.bootstrap.lib.rprops

import react.RProps
import react.bootstrap.lib.NoArgEventHandler

interface WithActive : RProps {
    var active: Boolean?
    var onActive: NoArgEventHandler?
}
