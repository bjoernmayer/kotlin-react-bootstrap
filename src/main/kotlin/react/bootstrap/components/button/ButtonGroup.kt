package react.bootstrap.components.button

import kotlinx.html.role
import react.RBuilder
import react.RComponent
import react.RState
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
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

    private fun buttonClicked(index: Int) {
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
                child(Button::class.rClass, buttonProps) {
                    attrs {
                        onClick = {
                            buttonClicked(index)
                        }
                        active = state.activeButtons?.contains(index)
                    }
                }
            }
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
