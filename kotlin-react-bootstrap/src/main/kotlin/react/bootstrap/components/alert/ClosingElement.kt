package react.bootstrap.components.alert

import kotlinext.js.jsObject
import react.RBuilder
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.lib.ElementProvider
import react.cloneElement
import kotlin.random.Random

/**
 * Todo: Rebuild this as actual component and make use of Identifiable
 * Wrapper for a custom alert closing element.
 *
 * Build whatever close element you like.
 *
 * @param block [RBuilder] block function
 * @return The ceated ReactElement
 */
fun RElementBuilder<Alert.Dismissible.Props>.closingElement(block: ElementProvider): ReactElement {
    val element = RBuilder().block()

    // The closing element is marked, to be able to find it in the childlist
    val clone = cloneElement<Alert.Dismissible.CloseElementMarkerProps>(
        element,
        jsObject {
            this.random = Random.nextInt()
        }
    )

    attrs {
        closeElement = clone
    }

    return child(clone)
}
