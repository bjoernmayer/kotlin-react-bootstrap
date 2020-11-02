package react.bootstrap.content.typography.small

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.splitClassesToSet

inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.small(
    classes: String? = null,
    noinline block: RHandler<Small.Props>
): ReactElement = child(Small::class) {
    attrs {
        this.rendererTag = TT::class
        this.classes = classes.splitClassesToSet()
    }

    block()
}
