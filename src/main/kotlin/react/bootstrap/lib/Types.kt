package react.bootstrap.lib

import org.w3c.dom.events.Event
import react.RBuilder
import react.ReactElement

typealias ArglessEventHandler = () -> Unit
typealias EventHandler = (Event) -> Unit

typealias ElementProvider = (RBuilder.() -> ReactElement)
