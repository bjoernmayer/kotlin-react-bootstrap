package react.bootstrap.lib

import kotlinx.html.CommonAttributeGroupFacade
import org.w3c.dom.events.Event

var CommonAttributeGroupFacade.onTransitionEnd: (Event) -> Unit
    get() = throw UnsupportedOperationException("You can't read variable onTransitionEnd")
    set(newValue) {
        consumer.onTagEvent(this, "ontransitionend", newValue)
    }

var CommonAttributeGroupFacade.ariaLabel: String
    get() = this.attributes["aria-label"].toString()
    set(newValue) {
        this.attributes["aria-label"] = newValue
    }

var CommonAttributeGroupFacade.ariaHidden: Boolean
    get() = this.attributes["aria-hidden"]?.toBoolean() ?: false
    set(newValue) {
        this.attributes["aria-hidden"] = newValue.toString()
    }
