package react.bootstrap.utilities.close

import kotlinx.html.BUTTON
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.lib.component.SimpleDOMComponent.Companion.simpleDomComponent

/**
 * Creates a [Close] element.
 *
 * @param symbol Symbol/Text shown for this element
 * @param classes Space separated list of CSS classes for this element.
 */
public fun RBuilder.close(
    symbol: String? = null,
    classes: String? = null,
    props: PropHandler<Close.Props> = PropHandler { },
    block: RDOMHandler<BUTTON>
): ReactElement = simpleDomComponent(Close::class)
    .classes(classes)
    .propHandler {
        symbol?.let {
            this.symbol = it
        }

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()
