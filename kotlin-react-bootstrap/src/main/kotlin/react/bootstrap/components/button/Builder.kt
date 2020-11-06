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
    active: Boolean = false,
    disabled: Boolean = false,
    nowrap: Boolean = false,
    sizes: Button.Sizes? = null,
    blockSized: Boolean = false,
    type: Button.Types = Button.Types.Button(),
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

        fun danger(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun danger(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun danger(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun dark(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun dark(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun dark(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun info(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun info(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun info(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun light(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun light(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun light(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun primary(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun primary(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun primary(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun secondary(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun secondary(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun secondary(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun success(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun success(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun success(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun warning(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun warning(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun warning(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun link(
            buttonType: ButtonType = ButtonType.button,
            buttonFormEncType: ButtonFormEncType? = null,
            buttonFormMethod: ButtonFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun link(
            href: String?,
            target: String? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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

        fun link(
            value: String,
            name: String? = null,
            title: String? = null,
            type: Button.Types.Input.Type = Button.Types.Input.Type.BUTTON,
            inputFormEncType: InputFormEncType? = null,
            inputFormMethod: InputFormMethod? = null,
            active: Boolean = false,
            disabled: Boolean = false,
            nowrap: Boolean = false,
            sizes: Button.Sizes? = null,
            blockSized: Boolean = false,
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
