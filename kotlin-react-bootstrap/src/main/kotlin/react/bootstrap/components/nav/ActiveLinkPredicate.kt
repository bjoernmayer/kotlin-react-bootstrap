package react.bootstrap.components.nav

import kotlinx.html.A

public fun interface ActiveLinkPredicate {
    public fun A.isActive(): Boolean
}
