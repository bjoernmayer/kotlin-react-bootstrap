package react.bootstrap.site.components.docs

import kotlinx.browser.document
import kotlin.reflect.KClass

internal val KClass<*>.nestedName: String
    get() = this.js.name.replace("$", ".")

internal val Enum<*>.nestedName: String
    get() = this::class.nestedName + ".$name"

internal fun pageTitle(pagetitle: String) {
    document.title = "$pagetitle · Kotlin React Bootstrap"
}

internal val Enum<*>.kt: String
    get() = buildNestedName(name, this::class)

internal fun buildNestedName(target: String, vararg parents: String): String =
    "${parents.joinToString(".")}.$target"

internal fun buildNestedName(target: String, vararg parents: KClass<*>): String =
    "${parents.joinToString(".") { it.simpleName!! }}.$target"

internal fun buildNestedName(target: KClass<*>, vararg parents: KClass<*>): String =
    buildNestedName(target.simpleName!!, *parents)
