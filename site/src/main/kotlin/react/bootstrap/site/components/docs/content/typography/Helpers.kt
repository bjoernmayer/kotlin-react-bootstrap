package react.bootstrap.site.components.docs.content.typography

import react.bootstrap.content.typography.Display
import react.bootstrap.site.components.docs.buildNestedName

internal val Display.Variants.kt
    get() = buildNestedName(this::class, Display::class)
