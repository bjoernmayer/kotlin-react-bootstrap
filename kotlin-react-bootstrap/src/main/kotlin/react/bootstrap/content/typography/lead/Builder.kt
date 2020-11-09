package react.bootstrap.content.typography.lead

import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet

/**
 * Creates a [Lead] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.lead(classes: String? = null, block: RHandler<Lead.Props>): ReactElement =
    child(Lead::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
        }

        block()
    }
