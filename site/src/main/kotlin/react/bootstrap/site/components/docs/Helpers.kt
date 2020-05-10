package react.bootstrap.site.components.docs

import kotlin.browser.document

internal fun pageTitle(pagetitle: String) {
    document.title = "$pagetitle · Kotlin React Bootstrap"
}

internal val Enum<*>.kt: String
    get() = "${this::class.simpleName}.$name"
