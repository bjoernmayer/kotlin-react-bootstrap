package react.bootstrap.components.nav

import kotlinx.html.A

fun interface ActiveLinkPredicate {
    fun isActive(link: A): Boolean
}
