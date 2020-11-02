package react.bootstrap.content.typography.lead

import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.splitClassesToSet

fun RBuilder.lead(classes: String? = null, block: RHandler<Lead.Props>): ReactElement =
    child(Lead::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
        }

        block()
    }
