package react.bootstrap.content.typography.muted

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet

/**
 * Creates a generic [Muted] element.
 *
 * @param TT Tag Type to be used to render this [Muted].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.muted(
    classes: String? = null,
    noinline block: RHandler<Muted.Props>
): ReactElement = child(Muted::class) {
    attrs {
        this.rendererTag = TT::class
        this.classes = classes.splitClassesToSet()
    }

    block()
}
