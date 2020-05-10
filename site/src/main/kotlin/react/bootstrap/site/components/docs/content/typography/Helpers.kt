package react.bootstrap.site.components.docs.content.typography

import react.bootstrap.content.typography.Display

internal val Display.Variants.kt
    get() = "${Display::class.simpleName}.${this::class.simpleName}.$name"
