package react.bootstrap.lib.react

import kotlinext.js.Object
import kotlinext.js.asJsObject
import react.ReactElement

public fun Object.asReactElementOrNull(): ReactElement? {
    val element = asJsObject()

    if (!element.hasOwnProperty(ReactElement::props.name)) {
        return null
    }

    return element.unsafeCast<ReactElement>()
}
