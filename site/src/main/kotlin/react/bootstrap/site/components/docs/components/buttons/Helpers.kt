package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import react.RBuilder
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Button.Variants
import react.bootstrap.components.button.Button.Variants.Outline
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder
import kotlin.reflect.KClass
import kotlin.reflect.KFunction10

internal val KClass<out Button.Types.Input.Type>.nestedName
    get() = buildNestedName(this.simpleName!!, Button::class, Button.Types::class, Button.Types.Input::class)

internal val KClass<out Button.Props>.nestedName
    get() = buildNestedName(this.simpleName!!, Button::class)

internal val KClass<out Button.Sizes>.nestedName
    get() = buildNestedName(this.simpleName!!, Button::class)

internal val KClass<out Outline>.nestedName
    get() = buildNestedName(this.simpleName!!, Button::class, Variants::class)

internal val KClass<out Variants>.normalName
    get() = simpleName!!.toLowerCase().capitalize()

internal val Button.Sizes.ktN
    get() = buildNestedName(name, Button::class, this::class)

internal val Button.Types.Input.Type.ktN
    get() = buildNestedName(name, Button::class, Button.Types::class, Button.Types.Input::class)

internal val ButtonGroup.Behaviours.ktN
    get() = buildNestedName(name, ButtonGroup::class, this::class)

internal val RBuilder.solidButtonBuilderParents
    get() = listOf(RBuilder::Buttons.name, this.Buttons::solid.name)
internal val RBuilder.outlineButtonBuilderParents
    get() = listOf(RBuilder::Buttons.name, this.Buttons::outline.name)

internal typealias ButtonFun = KFunction10<ButtonType, ButtonFormEncType?, ButtonFormMethod?, Boolean?, Boolean?,
    Boolean?, Button.Sizes?, Boolean?, String?, (RElementBuilder<Button.Props>.() -> Unit), ReactElement>

internal val RBuilder.solidDangerFun: ButtonFun
    get() = Buttons.solid::danger
internal val RBuilder.outlineDangerFun: ButtonFun
    get() = Buttons.outline::danger
internal val RBuilder.solidDarkFun: ButtonFun
    get() = Buttons.solid::dark
internal val RBuilder.outlineDarkFun: ButtonFun
    get() = Buttons.outline::dark
internal val RBuilder.solidInfoFun: ButtonFun
    get() = Buttons.solid::info
internal val RBuilder.outlineInfoFun: ButtonFun
    get() = Buttons.outline::info
internal val RBuilder.solidLightFun: ButtonFun
    get() = Buttons.solid::light
internal val RBuilder.outlineLightFun: ButtonFun
    get() = Buttons.outline::light
internal val RBuilder.solidLinkFun: ButtonFun
    get() = Buttons.solid::link
internal val RBuilder.solidPrimaryFun: ButtonFun
    get() = Buttons.solid::primary
internal val RBuilder.outlinePrimaryFun: ButtonFun
    get() = Buttons.outline::primary
internal val RBuilder.solidSecondaryFun: ButtonFun
    get() = Buttons.solid::secondary
internal val RBuilder.outlineSecondaryFun: ButtonFun
    get() = Buttons.outline::secondary
internal val RBuilder.solidSuccessFun: ButtonFun
    get() = Buttons.solid::success
internal val RBuilder.outlineSuccessFun: ButtonFun
    get() = Buttons.outline::success
internal val RBuilder.solidWarningFun: ButtonFun
    get() = Buttons.solid::warning
internal val RBuilder.outlineWarningFun: ButtonFun
    get() = Buttons.outline::warning

internal fun CodeExampleBuilder.importButtonsBuilder() {
    import(buildNestedName(RBuilder::Buttons.name, "button", "components"))
}

internal fun CodeExampleBuilder.importButton() {
    import(buildNestedName(Button::class.simpleName!!, "button", "components"))
}
