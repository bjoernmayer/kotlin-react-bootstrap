@file:Suppress("DuplicatedCode")

package react.bootstrap.components.button

import kotlinx.html.A
import kotlinx.html.BUTTON
import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.INPUT
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import kotlinx.html.LABEL
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.lib.component.SimpleDOMComponent.Companion.simpleDomComponent
import kotlin.reflect.KClass

private fun RBuilder.buttonButton(
    variant: ButtonComponent.Variants,
    formEncType: ButtonFormEncType? = null,
    formMethod: ButtonFormMethod? = null,
    type: ButtonType? = null,
    classes: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    nowrap: Boolean = false,
    sizes: ButtonComponent.Sizes? = null,
    blockSized: Boolean = false,
    props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
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

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(
        RDOMHandler {
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

            with(block) {
                this@RDOMHandler.handle()
            }
        }
    )
    .build()

private fun RBuilder.buttonLabel(
    variant: ButtonComponent.Variants,
    type: ButtonComponent.Box.Type,
    formEncType: InputFormEncType? = null,
    formMethod: InputFormMethod? = null,
    blockSized: Boolean = false,
    name: String? = null,
    value: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    nowrap: Boolean = false,
    sizes: ButtonComponent.Sizes? = null,
    classes: String? = null,
    input: RDOMHandler<INPUT> = RDOMHandler { },
    props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
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
        this.inputHandler = RDOMHandler {
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
            val inputHandlerScope = this

            with(input) {
                inputHandlerScope.handle()
            }
        }

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()

private fun RBuilder.buttonInput(
    variant: ButtonComponent.Variants,
    type: ButtonComponent.Input.Type,
    formEncType: InputFormEncType? = null,
    formMethod: InputFormMethod? = null,
    name: String? = null,
    value: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    nowrap: Boolean = false,
    sizes: ButtonComponent.Sizes? = null,
    blockSized: Boolean = false,
    classes: String? = null,
    props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(
        RDOMHandler {
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

            with(block) {
                this@RDOMHandler.handle()
            }
        }
    )
    .build()

private fun RBuilder.buttonLink(
    variant: ButtonComponent.Variants,
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    nowrap: Boolean = false,
    sizes: ButtonComponent.Sizes? = null,
    blockSized: Boolean = false,
    props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
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

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(
        RDOMHandler {
            attrs {
                href?.let {
                    this.href = it
                }

                target?.let {
                    this.target = it
                }
            }

            with(block) {
                this@RDOMHandler.handle()
            }
        }
    )
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
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param type Choose between different [ButtonType]s for this button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun danger(
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            type: ButtonType = ButtonType.button,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = danger,
            formEncType = formEncType,
            formMethod = formMethod,
            type = type,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a danger button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun danger(
            href: String?,
            target: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = danger,
            href = href,
            target = target,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a danger button using an input button.
         *
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun danger(
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun danger(
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
            input: RDOMHandler<INPUT> = RDOMHandler { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = danger,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            blockSized = blockSized,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a dark button using a HTML button
         *
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param type Choose between different [ButtonType]s for this button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun dark(
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            type: ButtonType = ButtonType.button,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = dark,
            formEncType = formEncType,
            formMethod = formMethod,
            type = type,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a dark button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun dark(
            href: String?,
            target: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = dark,
            href = href,
            target = target,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a dark button using an input button.
         *
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun dark(
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun dark(
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
            input: RDOMHandler<INPUT> = RDOMHandler { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = dark,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            blockSized = blockSized,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a info button using a HTML button
         *
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param type Choose between different [ButtonType]s for this button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun info(
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            type: ButtonType = ButtonType.button,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = info,
            formEncType = formEncType,
            formMethod = formMethod,
            type = type,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a info button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun info(
            href: String?,
            target: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = info,
            href = href,
            target = target,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a info button using an input button.
         *
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun info(
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun info(
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
            input: RDOMHandler<INPUT> = RDOMHandler { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = info,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            blockSized = blockSized,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a light button using a HTML button
         *
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param type Choose between different [ButtonType]s for this button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun light(
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            type: ButtonType = ButtonType.button,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = light,
            formEncType = formEncType,
            formMethod = formMethod,
            type = type,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a light button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun light(
            href: String?,
            target: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = light,
            href = href,
            target = target,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a light button using an input button.
         *
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun light(
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun light(
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
            input: RDOMHandler<INPUT> = RDOMHandler { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = light,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            blockSized = blockSized,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a primary button using a HTML button
         *
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param type Choose between different [ButtonType]s for this button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun primary(
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            type: ButtonType = ButtonType.button,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = primary,
            formEncType = formEncType,
            formMethod = formMethod,
            type = type,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a primary button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun primary(
            href: String?,
            target: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = primary,
            href = href,
            target = target,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a primary button using an input button.
         *
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun primary(
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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
            props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
            input: RDOMHandler<INPUT> = RDOMHandler { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = primary,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            blockSized = blockSized,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a secondary button using a HTML button
         *
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param type Choose between different [ButtonType]s for this button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun secondary(
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            type: ButtonType = ButtonType.button,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = secondary,
            formEncType = formEncType,
            formMethod = formMethod,
            type = type,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a secondary button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun secondary(
            href: String?,
            target: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = secondary,
            href = href,
            target = target,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a secondary button using an input button.
         *
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun secondary(
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun secondary(
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
            input: RDOMHandler<INPUT> = RDOMHandler { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = secondary,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            blockSized = blockSized,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            classes = classes,
            input = input,
            props = props,
            block = block
        )

        /**
         * Creates a success button using a HTML button
         *
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param classes Space separated list of CSS classes for this element.
         * @param type Choose between different [ButtonType]s for this button.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun success(
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            type: ButtonType = ButtonType.button,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = success,
            formEncType = formEncType,
            formMethod = formMethod,
            type = type,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a success button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun success(
            href: String?,
            target: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = success,
            href = href,
            target = target,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a success button using an input button.
         *
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun success(
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun success(
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
            input: RDOMHandler<INPUT> = RDOMHandler { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = success,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            blockSized = blockSized,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
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
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun warning(
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            type: ButtonType = ButtonType.button,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = warning,
            formEncType = formEncType,
            formMethod = formMethod,
            type = type,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a warning button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun warning(
            href: String?,
            target: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = warning,
            href = href,
            target = target,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a warning button using an input button.
         *
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun warning(
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
            input: RDOMHandler<INPUT> = RDOMHandler { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = warning,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            blockSized = blockSized,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
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
            formEncType: ButtonFormEncType? = null,
            formMethod: ButtonFormMethod? = null,
            type: ButtonType = ButtonType.button,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Button.Props> = PropHandler { },
            block: RDOMHandler<BUTTON>
        ): ReactElement = builder.buttonButton(
            variant = ButtonComponent.Variants.Solid.LINK,
            formEncType = formEncType,
            formMethod = formMethod,
            type = type,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a link button using a link button
         *
         * @param href Href of the underlying link.
         * @param target Target-Attribute of the underlying link
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun link(
            href: String?,
            target: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Link.Props> = PropHandler { },
            block: RDOMHandler<A>
        ): ReactElement = builder.buttonLink(
            variant = ButtonComponent.Variants.Solid.LINK,
            href = href,
            target = target,
            classes = classes,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            props = props,
            block = block
        )

        /**
         * Creates a link button using a input button.
         *
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input button.
         * @param value Value-Attribute of the input button.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun link(
            type: ButtonComponent.Input.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Input.Props> = PropHandler { },
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
         * @param type Choose between different [ButtonComponent.Input.Type]s for this button.
         * @param formEncType HTML Form Enc Type.
         * @param formMethod GET/POST.
         * @param name Name-Attribute of the input.
         * @param value Value-Attribute of the input.
         * @param classes Space separated list of CSS classes for this element.
         * @param active Renders the button in a *pressed* look.
         * @param disabled Renders the button as *disabled*. Changes the cursor.
         * @param nowrap Set this to *true*, to disable text-wrapping.
         * @param sizes Choose between different [ButtonComponent.Sizes].
         * @param blockSized Renders the button as block, if set to *true*.
         */
        fun link(
            type: ButtonComponent.Box.Type,
            formEncType: InputFormEncType? = null,
            formMethod: InputFormMethod? = null,
            name: String? = null,
            value: String? = null,
            classes: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: ButtonComponent.Sizes? = null,
            blockSized: Boolean = false,
            props: PropHandler<ButtonComponent.Box.Props> = PropHandler { },
            input: RDOMHandler<INPUT> = RDOMHandler { },
            block: RDOMHandler<LABEL>
        ): ReactElement = builder.buttonLabel(
            variant = ButtonComponent.Variants.Solid.LINK,
            type = type,
            formEncType = formEncType,
            formMethod = formMethod,
            blockSized = blockSized,
            name = name,
            value = value,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
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
@Suppress("UNCHECKED_CAST")
fun RBuilder.buttonGroup(
    classes: String? = null,
    appearance: ButtonGroup.Appearance? = null,
    behaviour: ButtonGroup.Behaviours? = null,
    sizes: ButtonGroup.Sizes? = null,
    props: PropHandler<ButtonGroup.Props<DIV>> = PropHandler { },
    block: RDOMHandler<DIV>
): ReactElement = buttonGroup<DIV>(classes, appearance, behaviour, sizes, props, block)

/**
 * Creates a generic [ButtonGroup] element.
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : HtmlBlockTag> RBuilder.buttonGroup(
    classes: String? = null,
    appearance: ButtonGroup.Appearance? = null,
    behaviour: ButtonGroup.Behaviours? = null,
    sizes: ButtonGroup.Sizes? = null,
    props: PropHandler<ButtonGroup.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(ButtonGroup::class as KClass<ButtonGroup<T>>)
    .classes(classes)
    .propHandler {
        this.appearance = appearance
        this.behaviour = behaviour
        this.sizes = sizes

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()

/**
 * Creates a [ButtonToolbar] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
fun RBuilder.buttonToolbar(
    classes: String? = null,
    props: PropHandler<ButtonToolbar.Props<DIV>> = PropHandler { },
    block: RDOMHandler<DIV>
): ReactElement = buttonToolbar<DIV>(classes, props, block)

/**
 * Creates a generic [ButtonToolbar] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : HtmlBlockTag> RBuilder.buttonToolbar(
    classes: String? = null,
    props: PropHandler<ButtonToolbar.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(ButtonToolbar::class as KClass<ButtonToolbar<T>>)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()
