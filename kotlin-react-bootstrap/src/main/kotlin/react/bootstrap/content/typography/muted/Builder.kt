package react.bootstrap.content.typography.muted

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.splitClassesToSet

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
