package react.bootstrap.utilities.close

import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.splitClassesToSet

fun RBuilder.close(
    label: String? = null,
    symbol: String? = null,
    classes: String? = null,
    block: RHandler<Close.Props>
): ReactElement = child(Close::class) {
    attrs {
        this.label = label
        this.symbol = symbol
        this.classes = classes.splitClassesToSet()
    }

    block()
}
