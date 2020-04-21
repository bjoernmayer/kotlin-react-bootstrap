package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.site.components.docs.contentTitle
import react.dom.p

fun RBuilder.textUtilities() {
    contentTitle { +"Text utilities" }
    p {
        // FIXME links
        +"Change text alignment, transform, style, weight, and color with our text utilities and color utilities."
    }
}
