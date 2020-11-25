package react.bootstrap.lib.react.rprops

import react.RProps
import react.bootstrap.lib.NoArgEventHandler

public interface WithActive : RProps {
    public var active: Boolean
    public var onActive: NoArgEventHandler?
}
