package react.bootstrap.site.components.docs.components.buttons

import react.bootstrap.components.button.Button
import react.bootstrap.components.button.Button.Variants
import react.bootstrap.components.button.Button.Variants.Solid
import react.bootstrap.site.components.docs.buildNestedName
import kotlin.reflect.KClass

internal val Solid.Companion.all: Set<Variants>
    get() = setOf(
        DANGER,
        DARK,
        INFO,
        LIGHT,
        LINK,
        PRIMARY,
        SECONDARY,
        SUCCESS,
        WARNING
    )

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

internal val KClass<out Variants>.normalName
    get() = simpleName!!.toLowerCase().capitalize()

internal val Variants.Outline.Companion.all: Set<Variants>
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
