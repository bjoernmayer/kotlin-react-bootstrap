package react.bootstrap.lib

import react.RBuilder
import react.ReactElement
import react.buildElements
import react.cloneElement

// This will contain more and more extensions to kotlin-react

@Suppress("UnsafeCastFromDynamic")
operator fun ReactElement.invoke(handler: RBuilder.() -> Unit): ReactElement =
    cloneElement(this, props, buildElements(handler))
