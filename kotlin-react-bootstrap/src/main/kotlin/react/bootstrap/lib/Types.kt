package react.bootstrap.lib

import org.w3c.dom.events.Event
import react.RBuilder
import react.ReactElement
import react.dom.RDOMBuilder

typealias NoArgEventHandler = () -> Unit
typealias EventHandler = (Event) -> Unit

typealias ElementProvider = RBuilder.() -> ReactElement

typealias RDOMHandler<T> = RDOMBuilder<T>.() -> Unit
