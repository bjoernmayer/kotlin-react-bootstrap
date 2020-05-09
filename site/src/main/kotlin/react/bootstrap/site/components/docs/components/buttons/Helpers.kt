package react.bootstrap.site.components.docs.components.buttons

import react.bootstrap.components.button.Button
import kotlin.reflect.KClass

internal val Button.Variants.Solid.Companion.all: Set<Button.Variants>
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

internal val Button.Variants.Solid.Companion.nestedName: String
    get() = "${Button.Variants::class.simpleName}." +
        "${Button.Variants.Solid::class.simpleName}"

internal val KClass<out Button.Variants>.normalName
    get() = simpleName!!.toLowerCase().capitalize()

internal val Button.Variants.Outline.Companion.all: Set<Button.Variants>
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

internal val Button.Variants.Outline.Companion.nestedName: String
    get() = "${Button.Variants::class.simpleName}." +
        "${Button.Variants.Outline::class.simpleName}"
