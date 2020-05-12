package react.bootstrap.site.components.docs

import kotlin.browser.document
import kotlin.reflect.KClass

internal fun pageTitle(pagetitle: String) {
    document.title = "$pagetitle · Kotlin React Bootstrap"
}

internal val Enum<*>.kt: String
    get() = buildNestedName(name, this::class)

internal fun buildNestedName(target: String, vararg parents: KClass<*>): String =
    "${parents.joinToString(".") { it.simpleName!! }}.$target"

internal fun buildNestedName(target: KClass<*>, vararg parents: KClass<*>): String =
    buildNestedName(target.simpleName!!, *parents)
