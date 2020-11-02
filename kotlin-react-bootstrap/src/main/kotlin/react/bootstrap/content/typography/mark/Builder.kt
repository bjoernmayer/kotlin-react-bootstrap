package react.bootstrap.content.typography.mark

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.splitClassesToSet

inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.mark(
    classes: String? = null,
    noinline block: RHandler<Mark.Props>
): ReactElement = child(Mark::class) {
    attrs {
        this.rendererTag = TT::class
        this.classes = classes.splitClassesToSet()
    }

    block()
}
