package react.bootstrap.lib.react.rprops

import react.Child
import react.Children
import react.RProps
import react.children

val RProps.childrenArray: Array<out Child>
    get() = Children.toArray(children)
