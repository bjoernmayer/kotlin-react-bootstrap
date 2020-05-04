package react.bootstrap.components.alert

import kotlinx.html.A
import react.RElementBuilder
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.a

fun RElementBuilder<Alert.Props>.link(
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    block: RDOMBuilder<A>.() -> Unit
) =
    a(href, target, classes.appendClass(ClassNames.ALERT_LINK), block)
