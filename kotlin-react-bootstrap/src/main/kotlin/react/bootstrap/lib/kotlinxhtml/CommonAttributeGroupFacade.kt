@file:Suppress("DuplicatedCode")

package react.bootstrap.lib.kotlinxhtml

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.classes
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.RDOMBuilder

var CommonAttributeGroupFacade.onAnimationEndFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onAnimationEndFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onanimationend", newValue)
    }
var CommonAttributeGroupFacade.onAnimationIterationFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onAnimationIterationFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onanimationiteration", newValue)
    }
var CommonAttributeGroupFacade.onAnimationStartFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onAnimationStartFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onanimationstart", newValue)
    }
var CommonAttributeGroupFacade.onCompositionEndFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCompositionEndFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncompositionend", newValue)
    }
var CommonAttributeGroupFacade.onCompositionStartFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCompositionStartFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncompositionstart", newValue)
    }
var CommonAttributeGroupFacade.onCompositionUpdateFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCompositionUpdateFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncompositionupdate", newValue)
    }
var CommonAttributeGroupFacade.onCopyFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCopyFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncopy", newValue)
    }
var CommonAttributeGroupFacade.onCutFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onCutFunction")
    set(newValue) {
        consumer.onTagEvent(this, "oncut", newValue)
    }
var CommonAttributeGroupFacade.onDragExitFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onDragExitFunction")
    set(newValue) {
        consumer.onTagEvent(this, "ondragexit", newValue)
    }
var CommonAttributeGroupFacade.onEncryptedFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onEncryptedFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onencrypted", newValue)
    }
var CommonAttributeGroupFacade.onGotPointerCaptureFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onGotPointerCaptureFunction")
    set(newValue) {
        consumer.onTagEvent(this, "ongotpointercapture", newValue)
    }
var CommonAttributeGroupFacade.onLoadedMetadataFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onLoadedMetadataFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onloadedmetadata", newValue)
    }
var CommonAttributeGroupFacade.onLostPointerCaptureFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onLostPointerCaptureFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onlostpointercapture", newValue)
    }
var CommonAttributeGroupFacade.onMouseEnterFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onMouseEnterFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onmouseenter", newValue)
    }
var CommonAttributeGroupFacade.onMouseLeaveFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onMouseLeaveFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onmouseleave", newValue)
    }
var CommonAttributeGroupFacade.onPasteFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPasteFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpaste", newValue)
    }
var CommonAttributeGroupFacade.onPointerCancelFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerCancelFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointercancel", newValue)
    }
var CommonAttributeGroupFacade.onPointerDownFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerDownFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerdown", newValue)
    }
var CommonAttributeGroupFacade.onPointerEnterFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerEnterFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerenter", newValue)
    }
var CommonAttributeGroupFacade.onPointerLeaveFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerLeaveFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerleave", newValue)
    }
var CommonAttributeGroupFacade.onPointerMoveFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerMoveFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointermove", newValue)
    }
var CommonAttributeGroupFacade.onPointerOutFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerOutFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerout", newValue)
    }
var CommonAttributeGroupFacade.onPointerOverFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerOverFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerover", newValue)
    }
var CommonAttributeGroupFacade.onPointerUpFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onPointerUpFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onpointerup", newValue)
    }
var CommonAttributeGroupFacade.onResetFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onResetFunction")
    set(newValue) {
        consumer.onTagEvent(this, "onreset", newValue)
    }
var CommonAttributeGroupFacade.onToggleFunction: EventHandler
    get() = throw UnsupportedOperationException("You can't read variable onToggleFunction")
    set(newValue) {
        consumer.onTagEvent(this, "ontoggle", newValue)
    }

var CommonAttributeGroupFacade.onTransitionEndFunction: EventHandler
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

var CommonAttributeGroupFacade.ariaPressed: Boolean
    get() = this.attributes["aria-pressed"]?.toBoolean() ?: false
    set(newValue) {
        this.attributes["aria-pressed"] = newValue.toString()
    }

var CommonAttributeGroupFacade.ariaDisabled: Boolean
    get() = this.attributes["aria-disabled"]?.toBoolean() ?: false
    set(newValue) {
        this.attributes["aria-disabled"] = newValue.toString()
    }

fun RDOMBuilder<CommonAttributeGroupFacade>.addClass(vararg classNames: String) {
    attrs {
        classes = classes.toMutableSet().apply {
            addAll(classNames)
        }
    }
}


fun RDOMBuilder<CommonAttributeGroupFacade>.addClass(vararg classNames: ClassNames) {
    attrs {
        classes = classes.toMutableSet().apply {
            addAll(classNames.map(ClassNames::className))
        }
    }
}
