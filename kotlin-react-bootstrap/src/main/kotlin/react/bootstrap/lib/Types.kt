package react.bootstrap.lib

import kotlinx.html.CommonAttributeGroupFacade
import org.w3c.dom.events.Event

public typealias DOMTag = CommonAttributeGroupFacade

public typealias NoArgEventHandler = () -> Unit
public typealias EventHandler = (Event) -> Unit
