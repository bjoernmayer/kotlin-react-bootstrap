package react.bootstrap.components.button

import kotlinx.html.classes
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RState
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.gatherChildrenProps
import react.bootstrap.lib.react.mapComponents
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.childrenArray
import react.dom.div
import react.setState

class ButtonGroup(props: Props) : BootstrapComponent<ButtonGroup.Props, ButtonGroup.State>(props) {
    override fun State.init(props: Props) {
        buttons = props.childrenArray.gatherChildrenProps<Button.Props, Button>()

        activeButtons = buttons?.mapNotNull { (index, buttonProps) ->
            if (buttonProps.active) {
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
            (state.buttons?.get(index) ?: error("Buttongroup has no buttons.")).also { clickedButtonProps ->
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
                    activeButtons = state.buttons!!.mapNotNull { (key, buttonProps) ->
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

    override fun buildClasses(): Set<ClassNames> {
        val btnGroupClasses = mutableSetOf<ClassNames>()

        if (props.appearance == null) {
            btnGroupClasses.add(ClassNames.BTN_GROUP)
        }

        if (props.appearance == Appearance.VERTICAL) {
            btnGroupClasses.add(ClassNames.BTN_GROUP_VERTICAL)
        }

        props.sizes?.also {
            btnGroupClasses.add(
                when (it) {
                    Sizes.SM -> ClassNames.BTN_GROUP_SM
                    Sizes.LG -> ClassNames.BTN_GROUP_LG
                }
            )
        }

        return btnGroupClasses
    }

    override fun RBuilder.render(rendererClasses: Set<String>) {
        div {
            attrs {
                loadGlobalAttributes(props)
                classes = rendererClasses
                role = "group"

                props.label?.let {
                    ariaLabel = it
                }
            }

            // This basically replaces the buttons in this buttonGroup with a version, which has an onClick event
            // It does so by manually adding each child instead of using the usual children() function
            childList.addAll(
                props.childrenArray.mapComponents<Button.Props, Button> { index, oldProps ->
                    attrs {
                        onClick = { event ->
                            handleButtonClick(index, event, oldProps.onClick)
                        }
                        active = state.activeButtons?.contains(index) ?: false
                    }
                }
            )
        }
    }

    interface Props : WithGlobalAttributes {
        /**
         * Change the appearance of the [ButtonGroup] by setting an [Appearance].
         */
        var appearance: Appearance?

        /**
         * Set this to make [Button]s behave like Radio- or Checkboxes.
         *
         * Defaults to a smart [ButtonGroup] which does not change Behaviour for normal buttons, but lets Radio- &
         * Checkboxes behave like they should.
         */
        var behaviour: Behaviours?

        /**
         * aria-label
         *
         * Defaults to *null*.
         */
        var label: String?
        var sizes: Sizes?
    }

    interface State : RState {
        var buttons: Map<Int, Button.Props>?
        var activeButtons: Collection<Int>?
    }

    enum class Appearance {
        NONE,
        VERTICAL
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
