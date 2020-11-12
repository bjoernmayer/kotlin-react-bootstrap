package react.bootstrap.lib

import kotlinx.html.CommonAttributeGroupFacade
import org.w3c.dom.events.Event
import react.dom.RDOMBuilder

typealias DomTag = CommonAttributeGroupFacade

typealias NoArgEventHandler = () -> Unit
typealias EventHandler = (Event) -> Unit
typealias RDOMHandler<T> = RDOMBuilder<T>.() -> Unit
