package react.bootstrap.components.button

import kotlinx.html.INPUT
import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RElementBuilder
import react.RState
import react.ReactElement
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.isComponent
import react.bootstrap.lib.react.mapReactElementsIndexed
import react.bootstrap.lib.react.onEachComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.childrenArray
import react.dom.div
import react.dom.input
import react.setState
import kotlinx.html.CommonAttributeGroupFacadeFlowInteractivePhrasingContent as InteractiveTag

class ButtonGroup(props: Props) : BootstrapComponent<ButtonGroup.Props, ButtonGroup.State>(props) {
    override fun State.init(props: Props) {
        buttons = mutableMapOf<Int, Pair<ReactElement, ButtonComponent.Props<*>>>().apply {
            putAll(
                props.childrenArray.mapReactElementsIndexed(ButtonComponent.Button::class) { index, pairedElement ->
                    index to pairedElement
                }.toMap()
            )
            putAll(
                props.childrenArray.mapReactElementsIndexed(ButtonComponent.Box::class) { index, pairedElement ->
                    index to pairedElement
                }.toMap()
            )
            putAll(
                props.childrenArray.mapReactElementsIndexed(ButtonComponent.Input::class) { index, pairedElement ->
                    index to pairedElement
                }.toMap()
            )
            putAll(
                props.childrenArray.mapReactElementsIndexed(ButtonComponent.Link::class) { index, pairedElement ->
                    index to pairedElement
                }.toMap()
            )
        }

        activeButtons = buttons.mapNotNull { (index, pairedElement) ->
            if (pairedElement.second.active) {
                index
            } else {
                null
            }
        }
    }

    private fun handleButtonClick(index: Int, event: Event, originalEventHandler: EventHandler?) {
        if (originalEventHandler is EventHandler) {
            originalEventHandler.invoke(event)
        }

        if (props.behaviour == Behaviours.RADIOS) {
            setState {
                activeButtons = setOf(index)
            }

            return
        }

        if (props.behaviour == Behaviours.CHECKBOXES) {
            handleCheckboxClick(index)

            return
        }

        // Behaviour was not given. Buttons might be of type Radio or Checkbox
        (state.buttons[index] ?: error("Buttongroup has no buttons.")).also { (element, props) ->
            if (element.isComponent<ButtonComponent.Box>().not()) {
                return@also
            }

            val clickedButtonProps = props.unsafeCast<ButtonComponent.Box.Props>()

            if (clickedButtonProps.type == ButtonComponent.Box.Type.CHECKBOX) {
                handleCheckboxClick(index)
                return@also
            }

            val clickedName =
                RBuilder()
                    .input { clickedButtonProps.inputHandler(this) }
                    .props
                    .unsafeCast<INPUT>()
                    .name

            setState {
                // Clicked button was a radio box.
                // Gather all currently active buttons, but filter out the clicked radio box, if it was active before
                activeButtons =
                    state.buttons
                        .filter { activeButtons.contains(it.key) }
                        .mapNotNull { (key, pairedElement) ->

                            // Only the active-flag of [ButtonComponent.Box] get changed here. Hence leave it active
                            if (!pairedElement.first.isComponent<ButtonComponent.Box>()) {
                                return@mapNotNull key
                            }

                            val buttonProps = pairedElement.second.unsafeCast<ButtonComponent.Box.Props>()

                            // Only the active-flag of Radio-Boxes get changed here. Hence leave it active
                            if (buttonProps.type != ButtonComponent.Box.Type.RADIO) {
                                return@mapNotNull key
                            }

                            // The names get set via the inputHandler. We do no apply it first, to be able to read the
                            // name
                            val buttonPropsName =
                                RBuilder()
                                    .input { buttonProps.inputHandler(this) }
                                    .props
                                    .unsafeCast<INPUT>()
                                    .name

                            // A Radio-Box of a different name group was clicked. Both can be active
                            if (clickedName != buttonPropsName) {
                                return@mapNotNull key
                            }

                            // The clicked radio box has the same as this one. So do not include it
                            null
                        }
                        .toMutableSet()
                        .apply {
                            add(index)
                        }
            }
        }
    }

    private fun handleCheckboxClick(index: Int) {
        setState {
            if (activeButtons.contains(index)) {
                // Already checked. Remove from active Buttons
                activeButtons = activeButtons.filterNot { it == index }

                return@setState
            }

            activeButtons = activeButtons.toMutableSet().apply {
                add(index)
            }
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
                props.childrenArray
                    .onEachComponent(ButtonComponent.Button::class) { index, originalProps ->
                        setProps(index, originalProps)
                    }
                    .onEachComponent(ButtonComponent.Box::class) { index, originalProps ->
                        setBoxProps(index, originalProps)
                    }
                    .onEachComponent(ButtonComponent.Input::class) { index, originalProps ->
                        setProps(index, originalProps)
                    }
                    .onEachComponent(ButtonComponent.Link::class) { index, originalProps ->
                        setProps(index, originalProps)
                    }
            )
        }
    }

    private fun <T : InteractiveTag, P : ButtonComponent.Props<T>> RElementBuilder<P>.setProps(
        index: Int,
        originalProps: P
    ) {
        attrs {
            active = state.activeButtons.contains(index)

            this.handler = {
                // First apply the handler so it applies a possible onClickFunction.
                originalProps.handler(this)

                // FIXME click is fired twice
                // Then pull out the possible onClick
                val onClick = attrs["onClick"] as EventHandler?

                attrs {
                    onClickFunction = { event ->
                        // And chain it with the new one
                        handleButtonClick(index, event, onClick)
                    }
                }
            }
        }
    }

    private fun RElementBuilder<ButtonComponent.Box.Props>.setBoxProps(
        index: Int,
        originalProps: ButtonComponent.Box.Props
    ) {
        attrs {
            active = state.activeButtons.contains(index)

            // onClick needs to be set on the input. Otherwise onClick will be fired twice!
            // See https://stackoverflow.com/questions/50819162/why-is-my-function-being-called-twice-in-react
            this.inputHandler = {
                originalProps.inputHandler(this)

                val onClick = attrs["onClick"] as EventHandler?

                attrs {
                    onClickFunction = { event ->
                        // And chain it with the new one
                        handleButtonClick(index, event, onClick)
                    }
                }
            }
        }
    }

    interface Props : WithGlobalAttributes {
        /**
         * Change the appearance of the [ButtonGroup] by setting an [Appearance].
         */
        var appearance: Appearance?

        /**
         * Set this to make [ButtonComponent]s behave like Radio- or Checkboxes.
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
        var buttons: Map<Int, Pair<ReactElement, ButtonComponent.Props<*>>>
        var activeButtons: Collection<Int>
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
