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
import react.bootstrap.lib.ClassNameEnum
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

        if (props.behaviour == Behaviours.RADIOS) {
            setState {
                activeButtons = setOf(index)
            }
        }

        if (props.behaviour == Behaviours.CHECKBOXES) {
            handleCheckboxClick(index)
        }

        // Behaviour was not given. Buttons might be of type Radio or Checkbox
        if (props.behaviour == null) {
            (props.buttons?.get(index) ?: error("Button props not found.")).also { clickedButtonProps ->
                if (clickedButtonProps.type !is Button.Types.Input) {
                    return@also
                }

                val inputType = (clickedButtonProps.type as Button.Types.Input).type
                if (inputType != Button.Types.Input.Type.RADIO && inputType != Button.Types.Input.Type.CHECKBOX) {
                    return@also
                }

                if (inputType == Button.Types.Input.Type.CHECKBOX) {
                    handleCheckboxClick(index)
                    return@also
                }

                setState {
                    // Behaviour is not given. Gather already checked Checkboxes and Radios that do not have the same
                    // name as the clicked one. Then add the clicked one to set of active buttons
                    activeButtons = props.buttons!!.mapNotNull { (key, buttonProps) ->
                        if (activeButtons?.contains(key) != true) {
                            return@mapNotNull null
                        }

                        if (buttonProps.type !is Button.Types.Input) {
                            return@mapNotNull key
                        }

                        if ((buttonProps.type as Button.Types.Input).type != Button.Types.Input.Type.RADIO) {
                            return@mapNotNull key
                        }

                        if (
                            (clickedButtonProps.type as Button.Types.Input).name !=
                            (buttonProps.type as Button.Types.Input).name
                        ) {
                            return@mapNotNull key
                        }

                        null
                    }.toMutableSet().apply {
                        add(index)
                    }
                }
            }
        }
    }

    private fun handleCheckboxClick(index: Int) {
        setState {
            // Already checked. Remove from active Buttons
            if (activeButtons?.contains(index) == true) {
                activeButtons = activeButtons?.filterNot { it == index } ?: emptySet()

                return@setState
            }

            activeButtons = activeButtons?.toMutableSet()?.apply {
                add(index)
            } ?: setOf(index)
        }
    }

    override fun RBuilder.render() {
        val btnGroupClasses = mutableSetOf<ClassNames>()

        if (props.renderAsGroup == true) {
            btnGroupClasses.add(ClassNames.BTN_GROUP)
        }

        props.sizes?.also {
            btnGroupClasses.add(
                when (it) {
                    Sizes.SM -> ClassNames.BTN_GROUP_SM
                    Sizes.LG -> ClassNames.BTN_GROUP_LG
                }
            )
        }

        val classes = props.className.appendClass(btnGroupClasses)

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

                props.buttons?.let { buttonPropsMap ->
                    val buttonProps = buttonPropsMap[index] ?: error("Button props not found.")

                    child(Button::class.rClass, clone(buttonProps)) {
                        attrs {
                            onClick = { event ->
                                handleButtonClick(index, event, buttonProps.onClick)
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
        var renderAsGroup: Boolean? // todo add change to enum with: DEFAULT, NO_GROUP, VERTICAL
        var sizes: Sizes?
    }

    interface State : RState {
        var activeButtons: Collection<Int>?
    }

    enum class Behaviours {
        CHECKBOXES,
        RADIOS;
    }

    enum class Sizes(override val className: ClassNames) : ClassNameEnum {
        SM(ClassNames.BTN_GROUP_SM),
        LG(ClassNames.BTN_GROUP_LG);
    }
}
