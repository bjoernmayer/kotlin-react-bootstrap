package react.bootstrap.content.typography.mark

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.classes
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.addOrInit
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.DOMWrapComponent.Companion.domWrapComponent

/**
 * Creates a generic [Mark] element.
 *
 * @param TT Tag Type to be used to render this [Mark].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.mark(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = domWrapComponent<TT, Mark.Props<TT>>(Mark::class) {
    attrs {
        this.classes = this.classes.addOrInit(classes.splitClassesToSet())
    }

    block()
}
