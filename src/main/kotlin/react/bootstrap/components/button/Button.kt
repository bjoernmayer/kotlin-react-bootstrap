@file:Suppress("unused")

package react.bootstrap.components.button

import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import kotlinx.html.InputType
import kotlinx.html.role
import kotlinx.html.tabIndex
import react.RBuilder
import react.RComponent
import react.RState
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.NoArgEventHandler
import react.bootstrap.lib.WithDomEvents
import react.bootstrap.lib.WithTypeFlag
import react.bootstrap.lib.ariaDisabled
import react.bootstrap.lib.ariaPressed
import react.bootstrap.lib.transferDomEvents
import react.dom.WithClassName
import react.dom.a
import react.dom.button
import react.dom.defaultValue
import react.dom.input
import react.setState

class Button : RComponent<Button.Props, Button.State>() {
    override fun componentDidMount() {
        setState {
            active = props.active
        }

        if (props.active == true) {
            props.onActive?.invoke()
        }
    }

    override fun componentDidUpdate(prevProps: Props, prevState: State, snapshot: Any) {
        if (prevProps.active == false && props.active == true) {
            props.onActive?.invoke()
        }
    }

    override fun RBuilder.render() {
        val btnClasses = mutableSetOf(ClassNames.BTN)

        if (props.active == true) {
            btnClasses.add(ClassNames.ACTIVE)
        }

        if (props.disabled == true && props.type is Types.Link) {
            btnClasses.add(ClassNames.DISABLED)
        }

        if (props.nowrap == true) {
            btnClasses.add(ClassNames.TEXT_NOWRAP)
        }

        if (props.blockSized == true) {
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

        props.variant?.also {
            btnClasses.add(it.className)
        }

        if (props.type !== null) {
            // todo rework this
            when (val type = props.type) {
                is Types.Button -> {
                    button(
                        formEncType = type.formEncType,
                        formMethod = type.formMethod,
                        type = type.type,
                        classes = props.className.appendClass(btnClasses)
                    ) {
                        attrs {
                            handleCommonAttrs()
                            if (props.disabled == true) {
                                attrs.disabled = true
                            }
                        }
                        children()
                    }
                }
                is Types.Input -> {
                    input(
                        type = type.type.inputType,
                        formEncType = type.formEncType,
                        formMethod = type.formMethod,
                        name = type.name,
                        classes = props.className.appendClass(btnClasses)
                    ) {
                        attrs {
                            handleCommonAttrs()
                            defaultValue = type.value

                            if (props.disabled == true) {
                                disabled = true
                                tabIndex = "-1"
                            }
                        }
                        // No children allowed
                    }
                }
                is Types.Link -> {
                    a(
                        href = type.href,
                        target = type.target,
                        classes = props.className.appendClass(btnClasses)
                    ) {
                        attrs {
                            handleCommonAttrs()
                            role = "button"
                        }
                        children()
                    }
                }
            }
        } else {
            button(
                type = ButtonType.button,
                classes = props.className.appendClass(btnClasses)
            ) {
                attrs {
                    handleCommonAttrs()
                    if (props.disabled == true) {
                        attrs.disabled = true
                    }
                }
                children()
            }
        }
    }

    private fun <T : CommonAttributeGroupFacade> T.handleCommonAttrs() {
        if (props.active == true) {
            ariaPressed = true
        }

        if (props.disabled == true) {
            ariaDisabled = true
        }

        transferDomEvents(props)
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

    sealed class Types {
        class Button(
            val formEncType: ButtonFormEncType? = null,
            val formMethod: ButtonFormMethod? = null,
            val type: ButtonType = ButtonType.button
        ) : Types()

        class Input(
            val type: Type = Type.BUTTON,
            val formEncType: InputFormEncType? = null,
            val formMethod: InputFormMethod? = null,
            val name: String? = null,
            val value: String
        ) : Types() {
            enum class Type(val inputType: InputType) {
                BUTTON(InputType.button),
                RESET(InputType.reset),
                SUBMIT(InputType.submit);
            }
        }

        class Link(
            val href: String? = null,
            val target: String? = null
        ) : Types()
    }

    interface Props : WithClassName, WithDomEvents, WithTypeFlag<Button> {
        var active: Boolean?
        var onActive: NoArgEventHandler?
        var disabled: Boolean?
        var nowrap: Boolean?
        var sizes: Sizes?
        var type: Types?
        var variant: Variants?
        var blockSized: Boolean?
    }

    interface State : RState {
        var active: Boolean?
    }
}
