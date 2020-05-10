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

internal val Solid.DANGER.kt: String
    get() = buildNestedName(Solid.DANGER::class, Button::class, Variants::class, Solid::class)

internal val Solid.DARK.kt: String
    get() = buildNestedName(Solid.DARK::class, Button::class, Variants::class, Solid::class)

internal val Solid.INFO.kt: String
    get() = buildNestedName(Solid.INFO::class, Button::class, Variants::class, Solid::class)

internal val Solid.LIGHT.kt: String
    get() = buildNestedName(Solid.LIGHT::class, Button::class, Variants::class, Solid::class)

internal val Solid.LINK.kt: String
    get() = buildNestedName(Solid.LINK::class, Button::class, Variants::class, Solid::class)

internal val Solid.PRIMARY.kt: String
    get() = buildNestedName(Solid.PRIMARY::class, Button::class, Variants::class, Solid::class)

internal val Solid.SECONDARY.kt: String
    get() = buildNestedName(Solid.SECONDARY::class, Button::class, Variants::class, Solid::class)

internal val Solid.SUCCESS.kt: String
    get() = buildNestedName(Solid.SUCCESS::class, Button::class, Variants::class, Solid::class)

internal val Solid.WARNING.kt: String
    get() = buildNestedName(Solid.WARNING::class, Button::class, Variants::class, Solid::class)

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

internal val Button.Sizes.kt
    get() = buildNestedName(name, Button::class, Button.Sizes::class)
