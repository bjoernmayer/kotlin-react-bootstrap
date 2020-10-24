package react.bootstrap.lib.rprops

import react.RProps

interface WithAriaLabel : RProps {
    var ariaLabel: String?
}

interface WithAriaDisabled : RProps {
    var ariaDisabled: Boolean?
}
