@file:Suppress("unused")

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
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.lib.component.SimpleDOMComponent
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

public sealed class ButtonComponent<T : InteractiveDomTag, P : ButtonComponent.Props<T>>(
    props: P,
    tag: KClass<T>
) : SimpleDOMComponent<T, P, ButtonComponent.State>(props, tag) {
    init {
        props.requireProperties(props::variant)
    }

    public class Button(props: Props) : ButtonComponent<BUTTON, Button.Props>(props, BUTTON::class) {
        override fun RDOMBuilder<BUTTON>.build() {
            attrs {
                ariaPressed = state.active
                ariaDisabled = props.disabled

                disabled = props.disabled
            }
            addChildren()
        }

        public interface Props : ButtonComponent.Props<BUTTON>

        public companion object : RStatics<Props, State, Button, Nothing>(Button::class) {
            init {
                defaultProps = getDefaultProps<Props, BUTTON>()
            }
        }
    }

    public class Box(props: Props) : ButtonComponent<LABEL, Box.Props>(props, LABEL::class) {
        init {
            props.requireProperties(props::type)
        }

        override fun buildClasses(): Set<ClassNames> {
            return super.buildClasses().toMutableSet().apply {
                add(ClassNames.MB_0)
            }
        }

        override fun RDOMBuilder<LABEL>.build() {
            input {
                // This handler needs to be called first, so this component can override values
                with(props.inputHandler) {
                    this@input.handle()
                }

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

        public interface Props : ButtonComponent.Props<LABEL> {
            public var type: Type
            public var inputHandler: RDOMHandler<INPUT>
        }

        public enum class Type(internal val inputType: InputType) {
            RADIO(InputType.radio),
            CHECKBOX(InputType.checkBox);
        }

        public companion object : RStatics<Props, State, Box, Nothing>(Box::class) {
            init {
                defaultProps = getDefaultProps<Props, LABEL>()
            }
        }
    }

    public class Input(props: Props) : ButtonComponent<INPUT, Input.Props>(props, INPUT::class) {
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

        public interface Props : ButtonComponent.Props<INPUT> {
            public var type: Type
        }

        public enum class Type(internal val inputType: InputType) {
            BUTTON(InputType.button),
            SUBMIT(InputType.submit),
            RESET(InputType.reset)
        }

        public companion object : RStatics<Props, State, Input, Nothing>(Input::class) {
            init {
                defaultProps = getDefaultProps<Props, INPUT>()
            }
        }
    }

    public class Link(props: Props) : ButtonComponent<A, Link.Props>(props, A::class) {
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

        public interface Props : ButtonComponent.Props<A>

        public companion object : RStatics<Props, State, Link, Nothing>(Link::class) {
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

    public sealed class Variants(public val className: ClassNames) {
        public class Solid {
            public class DANGER internal constructor() : Variants(ClassNames.BTN_DANGER)
            public class DARK internal constructor() : Variants(ClassNames.BTN_DARK)
            public class INFO internal constructor() : Variants(ClassNames.BTN_INFO)
            public class LIGHT internal constructor() : Variants(ClassNames.BTN_LIGHT)
            public class LINK internal constructor() : Variants(ClassNames.BTN_LINK)
            public class PRIMARY internal constructor() : Variants(ClassNames.BTN_PRIMARY)
            public class SECONDARY internal constructor() : Variants(ClassNames.BTN_SECONDARY)
            public class SUCCESS internal constructor() : Variants(ClassNames.BTN_SUCCESS)
            public class WARNING internal constructor() : Variants(ClassNames.BTN_WARNING)

            public companion object {
                public val DANGER: DANGER = DANGER()
                public val DARK: DARK = DARK()
                public val INFO: INFO = INFO()
                public val LIGHT: LIGHT = LIGHT()
                public val LINK: LINK = LINK()
                public val PRIMARY: PRIMARY = PRIMARY()
                public val SECONDARY: SECONDARY = SECONDARY()
                public val SUCCESS: SUCCESS = SUCCESS()
                public val WARNING: WARNING = WARNING()
            }
        }

        public class Outline {
            public class DANGER internal constructor() : Variants(ClassNames.BTN_OUTLINE_DANGER)
            public class DARK internal constructor() : Variants(ClassNames.BTN_OUTLINE_DARK)
            public class INFO internal constructor() : Variants(ClassNames.BTN_OUTLINE_INFO)
            public class LIGHT internal constructor() : Variants(ClassNames.BTN_OUTLINE_LIGHT)
            public class PRIMARY internal constructor() : Variants(ClassNames.BTN_OUTLINE_PRIMARY)
            public class SECONDARY internal constructor() : Variants(ClassNames.BTN_OUTLINE_SECONDARY)
            public class SUCCESS internal constructor() : Variants(ClassNames.BTN_OUTLINE_SUCCESS)
            public class WARNING internal constructor() : Variants(ClassNames.BTN_OUTLINE_WARNING)

            public companion object {
                public val DANGER: DANGER = DANGER()
                public val DARK: DARK = DARK()
                public val INFO: INFO = INFO()
                public val LIGHT: LIGHT = LIGHT()
                public val PRIMARY: PRIMARY = PRIMARY()
                public val SECONDARY: SECONDARY = SECONDARY()
                public val SUCCESS: SUCCESS = SUCCESS()
                public val WARNING: WARNING = WARNING()
            }
        }
    }

    public enum class Sizes(override val className: ClassNames) : ClassNameEnum {
        SM(ClassNames.BTN_SM),
        LG(ClassNames.BTN_LG);
    }

    public interface Props<T : InteractiveDomTag> : WithActive, WithDisabled, SimpleDOMComponent.Props<T> {
        /**
         * Set this to *true* to disable text-wrapping for this button.
         *
         * Defaults to *false*
         */
        public var nowrap: Boolean

        /**
         * Use this to make buttons appear smaller or larger than usual.
         *
         * Defaults to *null*
         */
        public var sizes: Sizes?

        /**
         * Use the [Variants] to colour-in the button.
         */
        public var variant: Variants

        /**
         * Set this to *true* to render the button as block.
         *
         * Defaults to *false*
         */
        public var blockSized: Boolean
    }

    public interface State : RState {
        public var active: Boolean
    }

    public companion object {
        private fun <P : Props<T>, T : InteractiveDomTag> getDefaultProps(): P = jsObject {
            nowrap = false
            blockSized = false
            active = false
            disabled = false
        }
    }
}
