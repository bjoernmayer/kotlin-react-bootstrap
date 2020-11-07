package react.bootstrap.utilities.close

import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.splitClassesToSet

/**
 * Creates a [Close] element.
 *
 * @param label aria-label
 * @param symbol Symbol/Text shown for this element
 * @param classes Space separated list of CSS classes for this element.
 */
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
