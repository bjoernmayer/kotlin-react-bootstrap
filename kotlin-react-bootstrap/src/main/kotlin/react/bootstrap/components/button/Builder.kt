package react.bootstrap.components.button

import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.splitClassesToSet

private fun RBuilder.button(
    variant: Button.Variants,
    active: Boolean? = null,
    disabled: Boolean? = null,
    nowrap: Boolean? = null,
    sizes: Button.Sizes? = null,
    blockSized: Boolean? = null,
    type: Button.Types? = null,
    classes: String? = null,
    block: RHandler<Button.Props>
): ReactElement =
    child(Button::class) {
        attrs {
            this.variant = variant
            this.active = active
            this.disabled = disabled
            this.nowrap = nowrap
            this.type = type
            this.sizes = sizes
            this.classes = classes.splitClassesToSet()
            this.blockSized = blockSized
        }

        block()
    }

class ButtonBuilder(override val builder: RBuilder) : Builder {
    open class OutlineButtonBuilder(override val builder: RBuilder) : Builder {
        protected open val danger: Button.Variants = Button.Variants.Outline.DANGER
        protected open val dark: Button.Variants = Button.Variants.Outline.DARK
        protected open val info: Button.Variants = Button.Variants.Outline.INFO
        protected open val light: Button.Variants = Button.Variants.Outline.LIGHT
        protected open val primary: Button.Variants = Button.Variants.Outline.PRIMARY
        protected open val secondary: Button.Variants = Button.Variants.Outline.SECONDARY
        protected open val success: Button.Variants = Button.Variants.Outline.SUCCESS
        protected open val warning: Button.Variants = Button.Variants.Outline.WARNING

        /**
         * Creates a danger button using a HTML button
         */
        fun danger(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = danger,
            type = Button.Types.Button(
                buttonType = buttonType,
                buttonFormEncType = buttonFormEncType,
                buttonFormMethod = buttonFormMethod
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a danger button using a link button
         */
        fun danger(
            href: String?,
            target: String? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = danger,
            type = Button.Types.Link(
                href = href,
                target = target
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a danger button using an input button
         */
        fun danger(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = danger,
            type = Button.Types.Input(
                type = type,
                inputFormEncType = inputFormEncType,
                inputFormMethod = inputFormMethod,
                name = name,
                value = value,
                title = title
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a dark button using a HTML button
         */
        fun dark(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = dark,
            type = Button.Types.Button(
                buttonType = buttonType,
                buttonFormEncType = buttonFormEncType,
                buttonFormMethod = buttonFormMethod
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a dark button using a link button
         */
        fun dark(
            href: String?,
            target: String? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = dark,
            type = Button.Types.Link(
                href = href,
                target = target
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a dark button using an input button
         */
        fun dark(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = dark,
            type = Button.Types.Input(
                type = type,
                inputFormEncType = inputFormEncType,
                inputFormMethod = inputFormMethod,
                name = name,
                value = value,
                title = title
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a info button using a HTML button
         */
        fun info(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = info,
            type = Button.Types.Button(
                buttonType = buttonType,
                buttonFormEncType = buttonFormEncType,
                buttonFormMethod = buttonFormMethod
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a info button using a link button
         */
        fun info(
            href: String?,
            target: String? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = info,
            type = Button.Types.Link(
                href = href,
                target = target
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a info button using an input button
         */
        fun info(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = info,
            type = Button.Types.Input(
                type = type,
                inputFormEncType = inputFormEncType,
                inputFormMethod = inputFormMethod,
                name = name,
                value = value,
                title = title
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a light button using a HTML button
         */
        fun light(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = light,
            type = Button.Types.Button(
                buttonType = buttonType,
                buttonFormEncType = buttonFormEncType,
                buttonFormMethod = buttonFormMethod
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a light button using a link button
         */
        fun light(
            href: String?,
            target: String? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = light,
            type = Button.Types.Link(
                href = href,
                target = target
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a light button using an input button
         */
        fun light(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = light,
            type = Button.Types.Input(
                type = type,
                inputFormEncType = inputFormEncType,
                inputFormMethod = inputFormMethod,
                name = name,
                value = value,
                title = title
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a primary button using a HTML button
         */
        fun primary(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = primary,
            type = Button.Types.Button(
                buttonType = buttonType,
                buttonFormEncType = buttonFormEncType,
                buttonFormMethod = buttonFormMethod
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a primary button using a link button
         */
        fun primary(
            href: String?,
            target: String? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = primary,
            type = Button.Types.Link(
                href = href,
                target = target
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a primary button using an input button
         */
        fun primary(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = primary,
            type = Button.Types.Input(
                type = type,
                inputFormEncType = inputFormEncType,
                inputFormMethod = inputFormMethod,
                name = name,
                value = value,
                title = title
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a secondary button using a HTML button
         */
        fun secondary(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = secondary,
            type = Button.Types.Button(
                buttonType = buttonType,
                buttonFormEncType = buttonFormEncType,
                buttonFormMethod = buttonFormMethod
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a secondary button using a link button
         */
        fun secondary(
            href: String?,
            target: String? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = secondary,
            type = Button.Types.Link(
                href = href,
                target = target
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a secondary button using an input button
         */
        fun secondary(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = secondary,
            type = Button.Types.Input(
                type = type,
                inputFormEncType = inputFormEncType,
                inputFormMethod = inputFormMethod,
                name = name,
                value = value,
                title = title
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a success button using a HTML button
         */
        fun success(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = success,
            type = Button.Types.Button(
                buttonType = buttonType,
                buttonFormEncType = buttonFormEncType,
                buttonFormMethod = buttonFormMethod
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a success button using a link button
         */
        fun success(
            href: String?,
            target: String? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = success,
            type = Button.Types.Link(
                href = href,
                target = target
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a success button using an input button
         */
        fun success(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = success,
            type = Button.Types.Input(
                type = type,
                inputFormEncType = inputFormEncType,
                inputFormMethod = inputFormMethod,
                name = name,
                value = value,
                title = title
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a warning button using a HTML button
         */
        fun warning(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = warning,
            type = Button.Types.Button(
                buttonType = buttonType,
                buttonFormEncType = buttonFormEncType,
                buttonFormMethod = buttonFormMethod
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a warning button using a link button
         */
        fun warning(
            href: String?,
            target: String? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = warning,
            type = Button.Types.Link(
                href = href,
                target = target
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a warning button using an input button
         */
        fun warning(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = warning,
            type = Button.Types.Input(
                type = type,
                inputFormEncType = inputFormEncType,
                inputFormMethod = inputFormMethod,
                name = name,
                value = value,
                title = title
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )
    }

    class SolidButtonBuilder(builder: RBuilder) : OutlineButtonBuilder(builder) {
        override val danger: Button.Variants = Button.Variants.Solid.DANGER
        override val dark: Button.Variants = Button.Variants.Solid.DARK
        override val info: Button.Variants = Button.Variants.Solid.INFO
        override val light: Button.Variants = Button.Variants.Solid.LIGHT
        override val primary: Button.Variants = Button.Variants.Solid.PRIMARY
        override val secondary: Button.Variants = Button.Variants.Solid.SECONDARY
        override val success: Button.Variants = Button.Variants.Solid.SUCCESS
        override val warning: Button.Variants = Button.Variants.Solid.WARNING

        /**
         * Creates a link button using a HTML button
         */
        fun link(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = Button.Variants.Solid.LINK,
            type = Button.Types.Button(
                buttonType = buttonType,
                buttonFormEncType = buttonFormEncType,
                buttonFormMethod = buttonFormMethod
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a link button using a link button
         */
        fun link(
            href: String?,
            target: String? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = Button.Variants.Solid.LINK,
            type = Button.Types.Link(
                href = href,
                target = target
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        /**
         * Creates a link button using a input button
         */
        fun link(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ): ReactElement = builder.button(
            variant = Button.Variants.Solid.LINK,
            type = Button.Types.Input(
                type = type,
                inputFormEncType = inputFormEncType,
                inputFormMethod = inputFormMethod,
                name = name,
                value = value,
                title = title
            ),
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
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
    appearance: ButtonGroup.Appearance = ButtonGroup.Appearance.DEFAULT,
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
