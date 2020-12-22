@file:Suppress("DuplicatedCode")

package react.bootstrap.lib.kotlinxhtml

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.classes
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.RDOMBuilder

public var CommonAttributeGroupFacade.onAnimationEndFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onAnimationEndFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onanimationend", newValue)
    }
public var CommonAttributeGroupFacade.onAnimationIterationFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onAnimationIterationFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onanimationiteration", newValue)
    }
public var CommonAttributeGroupFacade.onAnimationStartFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onAnimationStartFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onanimationstart", newValue)
    }
public var CommonAttributeGroupFacade.onCompositionEndFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCompositionEndFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncompositionend", newValue)
    }
public var CommonAttributeGroupFacade.onCompositionStartFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCompositionStartFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncompositionstart", newValue)
    }
public var CommonAttributeGroupFacade.onCompositionUpdateFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCompositionUpdateFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncompositionupdate", newValue)
    }
public var CommonAttributeGroupFacade.onCopyFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCopyFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncopy", newValue)
    }
public var CommonAttributeGroupFacade.onCutFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCutFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncut", newValue)
    }
public var CommonAttributeGroupFacade.onDragExitFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onDragExitFunction")
    set(newValue) {
        consumer.onTagEvent(this, "ondragexit", newValue)
    }
public var CommonAttributeGroupFacade.onEncryptedFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onEncryptedFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onencrypted", newValue)
    }
public var CommonAttributeGroupFacade.onGotPointerCaptureFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onGotPointerCaptureFunction")
    set(newValue) {
        consumer.onTagEvent(this, "ongotpointercapture", newValue)
    }
public var CommonAttributeGroupFacade.onLoadedMetadataFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onLoadedMetadataFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onloadedmetadata", newValue)
    }
public var CommonAttributeGroupFacade.onLostPointerCaptureFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onLostPointerCaptureFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onlostpointercapture", newValue)
    }
public var CommonAttributeGroupFacade.onMouseEnterFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onMouseEnterFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onmouseenter", newValue)
    }
public var CommonAttributeGroupFacade.onMouseLeaveFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onMouseLeaveFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onmouseleave", newValue)
    }
public var CommonAttributeGroupFacade.onPasteFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPasteFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpaste", newValue)
    }
public var CommonAttributeGroupFacade.onPointerCancelFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerCancelFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointercancel", newValue)
    }
public var CommonAttributeGroupFacade.onPointerDownFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerDownFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerdown", newValue)
    }
public var CommonAttributeGroupFacade.onPointerEnterFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerEnterFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerenter", newValue)
    }
public var CommonAttributeGroupFacade.onPointerLeaveFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerLeaveFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerleave", newValue)
    }
public var CommonAttributeGroupFacade.onPointerMoveFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerMoveFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointermove", newValue)
    }
public var CommonAttributeGroupFacade.onPointerOutFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerOutFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerout", newValue)
    }
public var CommonAttributeGroupFacade.onPointerOverFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerOverFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerover", newValue)
    }
public var CommonAttributeGroupFacade.onPointerUpFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerUpFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerup", newValue)
    }
public var CommonAttributeGroupFacade.onResetFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onResetFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onreset", newValue)
    }
public var CommonAttributeGroupFacade.onToggleFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onToggleFunction")
    set(newValue) {
        consumer.onTagEvent(this, "ontoggle", newValue)
    }

public var CommonAttributeGroupFacade.onTransitionEndFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onTransitionEnd")
    set(newValue) {
        consumer.onTagEvent(this, "ontransitionend", newValue)
    }

public var CommonAttributeGroupFacade.ariaLabel: String
    get() = this.attributes["aria-label"].toString()
    set(newValue) {
        this.attributes["aria-label"] = newValue
    }

public var CommonAttributeGroupFacade.ariaHidden: Boolean
    get() = this.attributes["aria-hidden"]?.toBoolean() ?: false
    set(newValue) {
        this.attributes["aria-hidden"] = newValue.toString()
    }

public var CommonAttributeGroupFacade.ariaPressed: Boolean
    get() = this.attributes["aria-pressed"]?.toBoolean() ?: false
    set(newValue) {
        this.attributes["aria-pressed"] = newValue.toString()
    }

public var CommonAttributeGroupFacade.ariaDisabled: Boolean
    get() = this.attributes["aria-disabled"]?.toBoolean() ?: false
    set(newValue) {
        this.attributes["aria-disabled"] = newValue.toString()
    }

public fun RDOMBuilder<CommonAttributeGroupFacade>.addClass(vararg classNames: String) {
    attrs {
        classes = classes.toMutableSet().apply {
            addAll(classNames)
        }
    }
}

public fun RDOMBuilder<CommonAttributeGroupFacade>.addClass(vararg classNames: ClassNames) {
    attrs {
        classes = classes.toMutableSet().apply {
            addAll(classNames.map(ClassNames::className))
        }
    }
}
