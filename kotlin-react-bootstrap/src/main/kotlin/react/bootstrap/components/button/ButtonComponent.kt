package react.bootstrap.components.button

import kotlinext.js.jsObject
import kotlinx.html.A
import kotlinx.html.BUTTON
import kotlinx.html.INPUT
import kotlinx.html.InputType
import kotlinx.html.LABEL
import kotlinx.html.js.onChangeFunction
import kotlinx.html.role
import kotlinx.html.style
import kotlinx.html.tabIndex
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RState
import react.RStatics
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.component.SimpleDomComponent
import react.bootstrap.lib.kotlinxhtml.ariaDisabled
import react.bootstrap.lib.kotlinxhtml.ariaPressed
import react.bootstrap.lib.react.rprops.WithActive
import react.bootstrap.lib.react.rprops.WithDisabled
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
import react.dom.input
import react.setState
import kotlin.reflect.KClass
import kotlinx.html.CommonAttributeGroupFacadeFlowInteractivePhrasingContent as InteractiveDomTag

sealed class ButtonComponent<T : InteractiveDomTag, P : ButtonComponent.Props<T>>(
    props: P,
    tag: KClass<T>
) : SimpleDomComponent<T, P, ButtonComponent.State>(props, tag) {
    init {
        props.requireProperties(props::variant)
    }

    class Button(props: Props) : ButtonComponent<BUTTON, Button.Props>(props, BUTTON::class) {
        override fun RDOMBuilder<BUTTON>.build() {
            attrs {
                ariaPressed = state.active
                ariaDisabled = props.disabled

                disabled = props.disabled
            }
            addChildren()
        }

        interface Props : ButtonComponent.Props<BUTTON>

        companion object : RStatics<Props, State, Button, Nothing>(Button::class) {
            init {
                defaultProps = getDefaultProps<Props, BUTTON>()
            }
        }
    }

    class Box(props: Props) : ButtonComponent<LABEL, Box.Props>(props, LABEL::class) {
        init {
            props.requireProperties(props::type)
        }

        override fun RDOMBuilder<LABEL>.build() {
            input {
                // This handler needs to be called first, so this component can override values
                props.inputHandler.invoke(this)

                attrs {
                    ariaPressed = state.active
                    ariaDisabled = props.disabled

                    type = props.type.inputType

                    val onChange = attrs["onChange"] as EventHandler?

                    onChangeFunction = {
                        handleChange(it, onChange)
                    }

                    // Hide the box/circle
                    @Suppress("UnsafeCastFromDynamic")
                    style = kotlinext.js.js {
                        position = "absolute"
                        clip = "rect(0,0,0,0)"
                        pointerEvents = "none"
                    }

                    if (props.disabled) {
                        disabled = true
                        tabIndex = "-1"
                    }

                    defaultChecked = state.active
                }
            }
            addChildren()
        }

        interface Props : ButtonComponent.Props<LABEL> {
            var type: Type
            var inputHandler: RDOMHandler<INPUT>
        }

        enum class Type(internal val inputType: InputType) {
            RADIO(InputType.radio),
            CHECKBOX(InputType.checkBox);
        }

        companion object : RStatics<Props, State, Box, Nothing>(Box::class) {
            init {
                defaultProps = getDefaultProps<Props, LABEL>()
            }
        }
    }

    class Input(props: Props) : ButtonComponent<INPUT, Input.Props>(props, INPUT::class) {
        init {
            props.requireProperties(props::type)
        }

        override fun RDOMBuilder<INPUT>.build() {
            attrs {
                if (props.disabled) {
                    disabled = true
                    tabIndex = "-1"
                }

                type = props.type.inputType
            }
            // No children allowed
        }

        interface Props : ButtonComponent.Props<INPUT> {
            var type: Type
        }

        enum class Type(internal val inputType: InputType) {
            BUTTON(InputType.button),
            SUBMIT(InputType.submit),
            RESET(InputType.reset)
        }

        companion object : RStatics<Props, State, Input, Nothing>(Input::class) {
            init {
                defaultProps = getDefaultProps<Props, INPUT>()
            }
        }
    }

    class Link(props: Props) : ButtonComponent<A, Link.Props>(props, A::class) {
        override fun buildClasses(): Set<ClassNames> {
            return super.buildClasses().toMutableSet().apply {
                if (props.disabled) {
                    add(ClassNames.DISABLED)
                }
            }
        }

        override fun RDOMBuilder<A>.build() {
            attrs {
                ariaPressed = state.active
                ariaDisabled = props.disabled

                role = "button"
            }
            addChildren()
        }

        interface Props : ButtonComponent.Props<A>

        companion object : RStatics<Props, State, Link, Nothing>(Link::class) {
            init {
                defaultProps = getDefaultProps<Props, A>()
            }
        }
    }

    override fun State.init(props: P) {
        active = props.active
    }

    override fun componentDidMount() {
        if (state.active) {
            props.onActive?.invoke()
        }
    }

    override fun componentDidUpdate(prevProps: P, prevState: State, snapshot: Any) {
        if (prevProps !== props) {
            setState {
                active = props.active
            }
        }
        if (!prevState.active && props.active) {
            props.onActive?.invoke()
        }
    }

    protected fun handleChange(event: Event, originalEventHandler: EventHandler?) {
        if (originalEventHandler is EventHandler) {
            originalEventHandler.invoke(event)
        }
        val target = event.target as HTMLInputElement

        setState {
            active = target.checked
        }
    }

    override fun buildClasses(): Set<ClassNames> {
        val btnClasses = mutableSetOf(ClassNames.BTN)

        if (state.active) {
            btnClasses.add(ClassNames.ACTIVE)
        }

        if (props.nowrap) {
            btnClasses.add(ClassNames.TEXT_NOWRAP)
        }

        if (props.blockSized) {
            btnClasses.add(ClassNames.BTN_BLOCK)
        }

        props.sizes?.also {
            btnClasses.add(
                when (it) {
                    Sizes.SM -> ClassNames.BTN_SM
                    Sizes.LG -> ClassNames.BTN_LG
                }
            )
        }

        btnClasses.add(props.variant.className)

        return btnClasses
    }

    sealed class Variants(val className: ClassNames) {
        class Solid {
            class DANGER internal constructor() : Variants(ClassNames.BTN_DANGER)
            class DARK internal constructor() : Variants(ClassNames.BTN_DARK)
            class INFO internal constructor() : Variants(ClassNames.BTN_INFO)
            class LIGHT internal constructor() : Variants(ClassNames.BTN_LIGHT)
            class LINK internal constructor() : Variants(ClassNames.BTN_LINK)
            class PRIMARY internal constructor() : Variants(ClassNames.BTN_PRIMARY)
            class SECONDARY internal constructor() : Variants(ClassNames.BTN_SECONDARY)
            class SUCCESS internal constructor() : Variants(ClassNames.BTN_SUCCESS)
            class WARNING internal constructor() : Variants(ClassNames.BTN_WARNING)

            companion object {
                val DANGER = DANGER()
                val DARK = DARK()
                val INFO = INFO()
                val LIGHT = LIGHT()
                val LINK = LINK()
                val PRIMARY = PRIMARY()
                val SECONDARY = SECONDARY()
                val SUCCESS = SUCCESS()
                val WARNING = WARNING()
            }
        }

        class Outline {
            class DANGER internal constructor() : Variants(ClassNames.BTN_OUTLINE_DANGER)
            class DARK internal constructor() : Variants(ClassNames.BTN_OUTLINE_DARK)
            class INFO internal constructor() : Variants(ClassNames.BTN_OUTLINE_INFO)
            class LIGHT internal constructor() : Variants(ClassNames.BTN_OUTLINE_LIGHT)
            class PRIMARY internal constructor() : Variants(ClassNames.BTN_OUTLINE_PRIMARY)
            class SECONDARY internal constructor() : Variants(ClassNames.BTN_OUTLINE_SECONDARY)
            class SUCCESS internal constructor() : Variants(ClassNames.BTN_OUTLINE_SUCCESS)
            class WARNING internal constructor() : Variants(ClassNames.BTN_OUTLINE_WARNING)

            companion object {
                val DANGER = DANGER()
                val DARK = DARK()
                val INFO = INFO()
                val LIGHT = LIGHT()
                val PRIMARY = PRIMARY()
                val SECONDARY = SECONDARY()
                val SUCCESS = SUCCESS()
                val WARNING = WARNING()
            }
        }
    }

    enum class Sizes(override val className: ClassNames) : ClassNameEnum {
        SM(ClassNames.BTN_SM),
        LG(ClassNames.BTN_LG);
    }

    interface Props<T : InteractiveDomTag> : WithActive, WithDisabled, SimpleDomComponent.Props<T> {
        /**
         * Set this to *true* to disable text-wrapping for this button.
         *
         * Defaults to *false*
         */
        var nowrap: Boolean

        /**
         * Use this to make buttons appear smaller or larger than usual.
         *
         * Defaults to *null*
         */
        var sizes: Sizes?

        /**
         * Use the [Variants] to colour-in the button.
         */
        var variant: Variants

        /**
         * Set this to *true* to render the button as block.
         *
         * Defaults to *false*
         */
        var blockSized: Boolean
    }

    interface State : RState {
        var active: Boolean
    }

    companion object {
        private fun <P : Props<T>, T : InteractiveDomTag> getDefaultProps(): P = jsObject {
            nowrap = false
            blockSized = false
            active = false
            disabled = false
        }
    }
}
