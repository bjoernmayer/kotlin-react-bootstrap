package react.bootstrap.components.button

import kotlinext.js.asJsObject
import kotlinext.js.clone
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.Child
import react.Children
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.WithTypeFlag
import react.bootstrap.lib.ariaLabel
import react.children
import react.dom.WithClassName
import react.dom.div
import react.rClass
import react.setState

class ButtonGroup(props: Props) : RComponent<ButtonGroup.Props, ButtonGroup.State>(props) {
    override fun State.init(props: Props) {
        activeButtons = props.buttons?.mapNotNull { (index, buttonProps) ->
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
            }

            if (props.behaviour == Behaviours.RADIOS) {
                activeButtons = setOf(index)
            }
        }
    }

    override fun RBuilder.render() {
        val classes = if (props.renderAsGroup == true) {
            props.className.appendClass(ClassNames.BTN_GROUP)
        } else {
            props.className
        }

        div(classes = classes) {
            attrs {
                role = "group"

                props.label?.let {
                    ariaLabel = it
                }
            }

            Children.toArray(props.children).forEachIndexed { index, child ->
                if (child.isButton().not()) {
                    childList.add(child)

                    return@forEachIndexed
                }

                props.buttons?.let {
                    val buttonProps = it[index] ?: error("Button props not found.")

                    child(Button::class.rClass, clone(buttonProps)) {
                        attrs {
                            onClick = {
                                handleButtonClick(index, it, buttonProps.onClick)
                            }
                            active = state.activeButtons?.contains(index)
                        }
                    }
                }
            }
        }
    }

    private fun Child.isButton(): Boolean {
        val element = this.asJsObject()

        if (!element.hasOwnProperty(ReactElement::props.name)) {
            return false
        }

        val reactElement = element.unsafeCast<ReactElement>()
        val elProps = reactElement.props.asJsObject()

        if (!elProps.hasOwnProperty(WithTypeFlag<*>::krbType.name)) {
            return false
        }

        return elProps.unsafeCast<WithTypeFlag<*>>().krbType == Button::class
    }

    interface Props : WithClassName {
        var label: String?
        var behaviour: Behaviours?
        var buttons: Map<Int, Button.Props>?
        var renderAsGroup: Boolean?
    }

    interface State : RState {
        var activeButtons: Collection<Int>?
    }

    enum class Behaviours {
        CHECKBOXES,
        RADIOS;
    }
}
