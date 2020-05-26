package react.bootstrap.components.button

import kotlinext.js.asJsObject
import kotlinext.js.jsObject
import react.RBuilder
import react.RElementBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.lib.WithTypeFlag
import react.bootstrap.lib.toMutable

fun RBuilder.button(
    variant: Button.Variants,
    active: Boolean? = null,
    disabled: Boolean? = null,
    nowrap: Boolean? = null,
    type: Button.Types? = null,
    sizes: Button.Sizes? = null,
    blockSized: Boolean? = null,
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
            this.className = classes
            this.blockSized = blockSized
            this.krbType = Button::class
        }

        block()
    }

class ButtonBuilder(override val builder: RBuilder) : Builder {
    class SolidButtonBuilder(override val builder: RBuilder) : Builder {
        fun primary(
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            type: Button.Types? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ) = builder.button(
            variant = Button.Variants.Solid.PRIMARY,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            type = type,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )

        fun secondary(
            active: Boolean? = null,
            disabled: Boolean? = null,
            nowrap: Boolean? = null,
            type: Button.Types? = null,
            sizes: Button.Sizes? = null,
            blockSized: Boolean? = null,
            classes: String? = null,
            block: RHandler<Button.Props>
        ) = builder.button(
            variant = Button.Variants.Solid.SECONDARY,
            active = active,
            disabled = disabled,
            nowrap = nowrap,
            type = type,
            sizes = sizes,
            blockSized = blockSized,
            classes = classes,
            block = block
        )
    }

    val solid = SolidButtonBuilder(builder)
}

val RBuilder.Buttons
    get() = ButtonBuilder(this)

fun RBuilder.buttonGroup(
    behaviour: ButtonGroup.Behaviours? = null,
    label: String? = null,
    classes: String? = null,
    block: RHandler<ButtonGroup.Props>
): ReactElement {
    val builder = RElementBuilder<ButtonGroup.Props>(jsObject())

    builder.block()

    val buttons: List<Button.Props> = builder.childList.mapNotNull { child ->
        val element = child.asJsObject()

        if (!element.hasOwnProperty(ReactElement::props.name)) {
            return@mapNotNull null
        }

        val reactElement = element.unsafeCast<ReactElement>()
        val elProps = reactElement.props.asJsObject()

        if (!elProps.hasOwnProperty(WithTypeFlag<*>::krbType.name)) {
            return@mapNotNull null
        }

        if (elProps.unsafeCast<WithTypeFlag<*>>().krbType == Button::class) {
            elProps.unsafeCast<Button.Props>().toMutable()
        } else {
            null
        }
    }

    return child(ButtonGroup::class) {
        attrs {
            this.behaviour = behaviour
            this.label = label
            this.className = classes
            this.buttons = buttons
        }
    }
}
