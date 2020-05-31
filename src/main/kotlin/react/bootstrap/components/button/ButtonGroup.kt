package react.bootstrap.components.button

import kotlinext.js.clone
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RState
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.ariaLabel
import react.dom.WithClassName
import react.dom.div
import react.rClass
import react.setState

class ButtonGroup(props: Props) : RComponent<ButtonGroup.Props, ButtonGroup.State>(props) {
    override fun State.init(props: Props) {
        activeButtons = props.buttons?.mapIndexedNotNull { index, buttonProps ->
            if (buttonProps.active == true) {
                index
            } else {
                null
            }
        } ?: emptySet()
    }

    private fun handleButtonClick(index: Int, event: Event, originalEventHandler: EventHandler?) {
        if (originalEventHandler is EventHandler) {
            originalEventHandler.invoke(event)
        }

        setState {
            if (props.behaviour == Behaviours.CHECKBOXES) {
                // Already checked. Remove from active Buttons
                if (activeButtons?.contains(index) == true) {
                    activeButtons = activeButtons?.filterNot { it == index } ?: emptySet()

                    return@setState
                }

                activeButtons = activeButtons?.toMutableSet()?.apply {
                    add(index)
                } ?: setOf(index)
            } else {
                activeButtons = setOf(index)
            }
        }
    }

    override fun RBuilder.render() {
        div(classes = props.className.appendClass(ClassNames.BTN_GROUP)) {
            attrs {
                role = "group"

                props.label?.let {
                    ariaLabel = it
                }
            }
            props.buttons?.forEachIndexed { index, buttonProps ->
                // The clone is important, as otherwise the buttonProps inside the props get modified
                child(Button::class.rClass, clone(buttonProps)) {
                    attrs {
                        onClick = {
                            handleButtonClick(index, it, buttonProps.onClick)
                        }
                        active = state.activeButtons?.contains(index)
                    }
                }
            }
            children()
        }
    }

    interface Props : WithClassName {
        var label: String?
        var behaviour: Behaviours?
        var buttons: List<Button.Props>?
    }

    interface State : RState {
        var activeButtons: Collection<Int>?
    }

    enum class Behaviours {
        CHECKBOXES,
        RADIOS;
    }
}
