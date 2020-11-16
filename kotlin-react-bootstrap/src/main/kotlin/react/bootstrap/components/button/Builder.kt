package react.bootstrap.components.button

import kotlinx.html.A
import kotlinx.html.BUTTON
import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import kotlinx.html.INPUT
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import kotlinx.html.LABEL
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.Builder
import react.bootstrap.lib.PropHandler
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.SimpleDomComponent.Companion.simpleDomComponent

private fun RBuilder.buttonButton(
    formEncType: ButtonFormEncType? = null,
    formMethod: ButtonFormMethod? = null,
    classes: String? = null,
    type: ButtonType? = null,
    variant: ButtonComponent.Variants,
    active: Boolean = false,
    disabled: Boolean = false,
    nowrap: Boolean = false,
    sizes: ButtonComponent.Sizes? = null,
    blockSized: Boolean = false,
    props: PropHandler<ButtonComponent.Button.Props> = { },
    block: RDOMHandler<BUTTON>
): ReactElement = simpleDomComponent(ButtonComponent.Button::class)
    .classes(classes)
    .propHandler {
        this.variant = variant
        this.active = active
        this.disabled = disabled
        this.nowrap = nowrap
        this.sizes = sizes
        this.blockSized = blockSized

        props()
    }
    .domHandler {
        attrs {
            formEncType?.let {
                this.formEncType = it
            }
            formMethod?.let {
                this.formMethod = it
            }
            type?.let {
                this.type = it
            }
        }

        block()
    }
    .build()

private fun RBuilder.buttonLabel(
    type: ButtonComponent.Box.Type,
    formEncType: InputFormEncType? = null,
    formMethod: InputFormMethod? = null,
    blockSized: Boolean = false,
    name: String? = null,
    value: String? = null,
    variant: ButtonComponent.Variants,
    active: Boolean = false,
    disabled: Boolean = false,
    nowrap: Boolean = false,
    sizes: ButtonComponent.Sizes? = null,
    classes: String? = null,
    input: RDOMHandler<INPUT> = { },
    props: PropHandler<ButtonComponent.Box.Props> = { },
    block: RDOMHandler<LABEL>
): ReactElement = simpleDomComponent(ButtonComponent.Box::class)
    .classes(classes)
    .propHandler {
        this.variant = variant
        this.active = active
        this.disabled = disabled
        this.nowrap = nowrap
        this.sizes = sizes
        this.blockSized = blockSized
        this.type = type
        this.inputHandler = {
            attrs {
                formEncType?.let {
                    this.formEncType = it
                }

                formMethod?.let {
                    this.formMethod = it
                }

                name?.let {
                    this.name = it
                }

                value?.let {
                    this.value = it
                }
            }
            input()
        }

        props()
    }
    .domHandler(block)
    .build()

private fun RBuilder.buttonInput(
    type: ButtonComponent.Input.Type,
    formEncType: InputFormEncType? = null,
    formMethod: InputFormMethod? = null,
    name: String? = null,
    value: String? = null,
    variant: ButtonComponent.Variants,
    active: Boolean = false,
    disabled: Boolean = false,
    nowrap: Boolean = false,
    sizes: ButtonComponent.Sizes? = null,
    blockSized: Boolean = false,
    classes: String? = null,
    props: PropHandler<ButtonComponent.Input.Props> = { },
    block: RDOMHandler<INPUT>
): ReactElement = simpleDomComponent(ButtonComponent.Input::class)
    .classes(classes)
    .propHandler {
        this.variant = variant
        this.active = active
        this.disabled = disabled
        this.nowrap = nowrap
        this.sizes = sizes
        this.blockSized = blockSized
        this.type = type

        props()
    }
    .domHandler {
        attrs {
            formEncType?.let {
                this.formEncType = it
            }

            formMethod?.let {
                this.formMethod = it
            }

            name?.let {
                this.name = it
            }

            value?.let {
                this.value = it
            }
        }

        block()
    }
    .build()

private fun RBuilder.buttonLink(
    href: String? = null,
    target: String? = null,
    variant: ButtonComponent.Variants,
    active: Boolean = false,
    disabled: Boolean = false,
    nowrap: Boolean = false,
    sizes: ButtonComponent.Sizes? = null,
    blockSized: Boolean = false,
    classes: String? = null,
    props: PropHandler<ButtonComponent.Link.Props> = { },
    block: RDOMHandler<A>
): ReactElement = simpleDomComponent(ButtonComponent.Link::class)
    .classes(classes)
    .propHandler {
        this.variant = variant
        this.active = active
        this.disabled = disabled
        this.nowrap = nowrap
        this.sizes = sizes
        this.blockSized = blockSized

        props()
    }
    .domHandler {
        attrs {
            href?.let {
                this.href = it
            }

            target?.let {
                this.target = it
            }
        }

        block()
    }
    .build()

class ButtonBuilder(override val builder: RBuilder) : Builder {
    open class OutlineButtonBuilder(override val builder: RBuilder) : Builder {
        protected open val danger: ButtonComponent.Variants = ButtonComponent.Variants.Outline.DANGER
        protected open val dark: ButtonComponent.Variants = ButtonComponent.Variants.Outline.DARK
        protected open val info: ButtonComponent.Variants = ButtonComponent.Variants.Outline.INFO
        protected open val light: ButtonComponent.Variants = ButtonComponent.Variants.Outline.LIGHT
        protected open val primary: ButtonComponent.Variants = ButtonComponent.Variants.Outline.PRIMARY
        protected open val secondary: ButtonComponent.Variants = ButtonComponent.Variants.Outline.SECONDARY
        protected open val success: ButtonComponent.Variants = ButtonComponent.Variants.Outline.SUCCESS
        protected open val warning: ButtonComponent.Variants = ButtonComponent.Variants.Outline.WARNING

        /**
         * Creates a danger button using a HTML button
         *
         * @param type Choose between different [ButtonType]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun danger(
            type: ButtonType = ButtonType.button,
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Button.Props> = { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = danger,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a danger button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun danger(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Link.Props> = { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = danger,
            href = href,
            target = target,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a danger button using an input button.
         *
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun danger(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Input.Props> = { },
            block: RDOMHandler<INPUT>
        ): ReactElement = builder.buttonInput(
            variant = danger,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a danger button using a check- or radiobox
         *
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun danger(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Box.Props> = { },
            input: RDOMHandler<INPUT> = { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = danger,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a dark button using a HTML button
         *
         * @param type Choose between different [ButtonType]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun dark(
            type: ButtonType = ButtonType.button,
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Button.Props> = { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = dark,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a dark button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun dark(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Link.Props> = { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = dark,
            href = href,
            target = target,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a dark button using an input button.
         *
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun dark(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Input.Props> = { },
            block: RDOMHandler<INPUT>
        ): ReactElement = builder.buttonInput(
            variant = dark,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a dark button using a check- or radiobox
         *
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun dark(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Box.Props> = { },
            input: RDOMHandler<INPUT> = { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = dark,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a info button using a HTML button
         *
         * @param type Choose between different [ButtonType]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun info(
            type: ButtonType = ButtonType.button,
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Button.Props> = { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = info,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a info button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun info(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Link.Props> = { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = info,
            href = href,
            target = target,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a info button using an input button.
         *
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun info(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Input.Props> = { },
            block: RDOMHandler<INPUT>
        ): ReactElement = builder.buttonInput(
            variant = info,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a info button using a check- or radiobox
         *
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun info(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Box.Props> = { },
            input: RDOMHandler<INPUT> = { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = info,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a light button using a HTML button
         *
         * @param type Choose between different [ButtonType]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun light(
            type: ButtonType = ButtonType.button,
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Button.Props> = { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = light,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a light button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun light(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Link.Props> = { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = light,
            href = href,
            target = target,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a light button using an input button.
         *
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun light(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Input.Props> = { },
            block: RDOMHandler<INPUT>
        ): ReactElement = builder.buttonInput(
            variant = light,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a light button using a check- or radiobox
         *
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun light(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Box.Props> = { },
            input: RDOMHandler<INPUT> = { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = light,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a primary button using a HTML button
         *
         * @param type Choose between different [ButtonType]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun primary(
            type: ButtonType = ButtonType.button,
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Button.Props> = { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = primary,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a primary button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun primary(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Link.Props> = { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = primary,
            href = href,
            target = target,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a primary button using an input button.
         *
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun primary(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Input.Props> = { },
            block: RDOMHandler<INPUT>
        ): ReactElement = builder.buttonInput(
            variant = primary,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a primary button using a check- or radiobox
         *
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun primary(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Box.Props> = { },
            input: RDOMHandler<INPUT> = { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = primary,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a secondary button using a HTML button
         *
         * @param type Choose between different [ButtonType]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun secondary(
            type: ButtonType = ButtonType.button,
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Button.Props> = { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = secondary,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a secondary button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun secondary(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Link.Props> = { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = secondary,
            href = href,
            target = target,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a secondary button using an input button.
         *
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun secondary(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Input.Props> = { },
            block: RDOMHandler<INPUT>
        ): ReactElement = builder.buttonInput(
            variant = secondary,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a secondary button using a check- or radiobox
         *
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun secondary(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Box.Props> = { },
            input: RDOMHandler<INPUT> = { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = secondary,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a success button using a HTML button
         *
         * @param type Choose between different [ButtonType]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun success(
            type: ButtonType = ButtonType.button,
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Button.Props> = { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = success,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a success button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun success(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Link.Props> = { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = success,
            href = href,
            target = target,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a success button using an input button.
         *
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun success(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Input.Props> = { },
            block: RDOMHandler<INPUT>
        ): ReactElement = builder.buttonInput(
            variant = success,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a success button using a check- or radiobox
         *
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun success(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Box.Props> = { },
            input: RDOMHandler<INPUT> = { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = success,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a warning button using a HTML button
         *
         * @param type Choose between different [ButtonType]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun warning(
            type: ButtonType = ButtonType.button,
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Button.Props> = { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = warning,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a warning button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun warning(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Link.Props> = { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = warning,
            href = href,
            target = target,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a warning button using an input button.
         *
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun warning(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Input.Props> = { },
            block: RDOMHandler<INPUT>
        ): ReactElement = builder.buttonInput(
            variant = warning,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a warning button using a check- or radiobox
         *
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun warning(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Box.Props> = { },
            input: RDOMHandler<INPUT> = { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = warning,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            input = input,
            props = props,
            block = block
        )
    }

    class SolidButtonBuilder(builder: RBuilder) : OutlineButtonBuilder(builder) {
        override val danger: ButtonComponent.Variants = ButtonComponent.Variants.Solid.DANGER
        override val dark: ButtonComponent.Variants = ButtonComponent.Variants.Solid.DARK
        override val info: ButtonComponent.Variants = ButtonComponent.Variants.Solid.INFO
        override val light: ButtonComponent.Variants = ButtonComponent.Variants.Solid.LIGHT
        override val primary: ButtonComponent.Variants = ButtonComponent.Variants.Solid.PRIMARY
        override val secondary: ButtonComponent.Variants = ButtonComponent.Variants.Solid.SECONDARY
        override val success: ButtonComponent.Variants = ButtonComponent.Variants.Solid.SUCCESS
        override val warning: ButtonComponent.Variants = ButtonComponent.Variants.Solid.WARNING

        /**
         * Creates a link button using a HTML button
         *
         * @param type Choose between different [ButtonType]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun link(
            type: ButtonType = ButtonType.button,
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Button.Props> = { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = ButtonComponent.Variants.Solid.LINK,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a link button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun link(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Link.Props> = { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = ButtonComponent.Variants.Solid.LINK,
            href = href,
            target = target,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a link button using a input button.
         *
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun link(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Input.Props> = { },
            block: RDOMHandler<INPUT>
        ): ReactElement = builder.buttonInput(
            variant = ButtonComponent.Variants.Solid.LINK,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            props = props,
            block = block
        )

        /**
         * Creates a link button using a check- or radiobox
         *
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         * @param classes Space separated list of CSS classes for this element.
         */
        fun link(
            name: String? = null,
            value: String? = null,
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            classes: String? = null,
            props: PropHandler<ButtonComponent.Box.Props> = { },
            input: RDOMHandler<INPUT> = { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = ButtonComponent.Variants.Solid.LINK,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            input = input,
            props = props,
            block = block
        )
    }

    val solid = SolidButtonBuilder(builder)
    val outline = OutlineButtonBuilder(builder)
}

val RBuilder.Buttons
    get() = ButtonBuilder(this)

/**
 * Creates a [ButtonGroup] element.
 */
fun RBuilder.buttonGroup(
    appearance: ButtonGroup.Appearance? = null,
    behaviour: ButtonGroup.Behaviours? = null,
    classes: String? = null,
    label: String? = null,
    sizes: ButtonGroup.Sizes? = null,
    block: RHandler<ButtonGroup.Props>
): ReactElement = child(ButtonGroup::class) {
    attrs {
        this.appearance = appearance
        this.behaviour = behaviour
        this.classes = classes.splitClassesToSet()
        this.label = label
        this.sizes = sizes
    }
    block()
}

/**
 * Creates a [ButtonToolbar] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 * @param label aria-label to describe the [ButtonToolbar]
 */
fun RBuilder.buttonToolbar(
    classes: String? = null,
    label: String? = null,
    block: RHandler<ButtonToolbar.Props>
): ReactElement =
    child(ButtonToolbar::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
            ariaLabel = label
        }

        block()
    }
