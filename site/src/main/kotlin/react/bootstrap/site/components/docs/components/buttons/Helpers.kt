package react.bootstrap.site.components.docs.components.buttons

import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Button.Variants
import react.bootstrap.components.button.Button.Variants.Outline
import react.bootstrap.components.button.Button.Variants.Solid
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.site.components.docs.buildNestedName
import kotlin.reflect.KClass

internal val Solid.DANGER.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Solid::class)

internal val Solid.DARK.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Solid::class)

internal val Solid.INFO.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Solid::class)

internal val Solid.LIGHT.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Solid::class)

internal val Solid.LINK.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Solid::class)

internal val Solid.PRIMARY.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Solid::class)

internal val Solid.SECONDARY.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Solid::class)

internal val Solid.SUCCESS.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Solid::class)

internal val Solid.WARNING.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Solid::class)

internal val Outline.Companion.all: Set<Variants>
    get() = setOf(
        DANGER,
        DARK,
        INFO,
        LIGHT,
        PRIMARY,
        SECONDARY,
        SUCCESS,
        WARNING
    )

internal val Outline.DANGER.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Outline::class)

internal val Outline.DARK.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Outline::class)

internal val Outline.INFO.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Outline::class)

internal val Outline.LIGHT.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Outline::class)

internal val Outline.PRIMARY.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Outline::class)

internal val Outline.SECONDARY.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Outline::class)

internal val Outline.SUCCESS.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Outline::class)

internal val Outline.WARNING.ktN: String
    get() = buildNestedName(this::class, Button::class, Variants::class, Outline::class)

internal val KClass<out Outline>.nestedName
    get() = buildNestedName(this.simpleName!!, Button::class, Variants::class)

internal val KClass<out Variants>.normalName
    get() = simpleName!!.toLowerCase().capitalize()

internal val Button.Sizes.ktN
    get() = buildNestedName(name, Button::class, this::class)

internal val KClass<Button.Types.Link>.nestedName
    get() = buildNestedName(this, Button::class, Button.Types::class)

internal val KClass<Button.Types.Input>.nestedName
    get() = buildNestedName(this, Button::class, Button.Types::class)

internal val KClass<Button.Types.Button>.nestedName
    get() = buildNestedName(this, Button::class, Button.Types::class)

internal val Button.Types.Input.Type.ktN
    get() = buildNestedName(name, Button::class, Button.Types::class, Button.Types.Input::class)

internal val ButtonGroup.Behaviours.ktN
    get() = buildNestedName(name, ButtonGroup::class, this::class)
