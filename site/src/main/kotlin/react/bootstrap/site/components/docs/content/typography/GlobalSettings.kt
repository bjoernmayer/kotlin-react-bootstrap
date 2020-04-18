package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.site.components.docs.contentTitle
import react.dom.p

fun RBuilder.globalSettings() {
    contentTitle { +"Global settings" }
    p {
        +"Bootstrap sets basic global display, typography, and link styles. When more control is needed, check out "
        +"the textual utility functions." // FIXME insert link here
    }
    // Todo rest of documentation
}
