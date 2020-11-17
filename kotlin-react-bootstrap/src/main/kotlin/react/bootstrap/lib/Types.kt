package react.bootstrap.lib

import kotlinx.html.CommonAttributeGroupFacade
import org.w3c.dom.events.Event

typealias DOMTag = CommonAttributeGroupFacade

typealias NoArgEventHandler = () -> Unit
typealias EventHandler = (Event) -> Unit
