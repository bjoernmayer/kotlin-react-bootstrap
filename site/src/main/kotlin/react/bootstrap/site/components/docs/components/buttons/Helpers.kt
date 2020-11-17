package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.BUTTON
import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import react.RBuilder
import react.ReactElement
import react.bootstrap.components.button.ButtonComponent
import react.bootstrap.components.button.ButtonComponent.Variants
import react.bootstrap.components.button.Buttons
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass
import kotlin.reflect.KFunction11

internal val KClass<out Variants>.normalName
    get() = simpleName!!.toLowerCase().capitalize()

internal typealias ButtonFun = KFunction11<ButtonType, ButtonFormEncType?, ButtonFormMethod?, Boolean, Boolean,
    Boolean, ButtonComponent.Sizes?, Boolean, String?, PropHandler<ButtonComponent.Button.Props>,
    RDOMHandler<BUTTON>, ReactElement>

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
