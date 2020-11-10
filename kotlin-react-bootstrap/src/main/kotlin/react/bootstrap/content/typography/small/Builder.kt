package react.bootstrap.content.typography.small

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.classes
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.content.typography.mark.Mark
import react.bootstrap.helpers.addOrInit
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.DOMWrapComponent.Companion.domWrapComponent

/**
 * Creates a generic [Small] element.
 *
 * @param TT Tag Type to be used to render this [Small].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.small(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = domWrapComponent<TT, Small.Props<TT>>(Small::class) {
    attrs {
        this.classes = this.classes.addOrInit(classes.splitClassesToSet())
    }

    block()
}

