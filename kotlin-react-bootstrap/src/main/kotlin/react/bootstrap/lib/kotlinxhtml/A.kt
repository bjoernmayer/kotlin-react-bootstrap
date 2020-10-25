@file:Suppress("DuplicatedCode")

package react.bootstrap.lib.kotlinxhtml

import kotlinx.html.A
import react.bootstrap.lib.react.rprops.tags.WithAttributesA
import kotlin.reflect.KProperty

fun A.loadAttributes(props: WithAttributesA, vararg excludes: KProperty<*>) {
    if (props::href !in excludes) {
        props.href?.let { href = it }
    }

    if (props::target !in excludes) {
        props.target?.let { target = it }
    }
    if (props::ping !in excludes) {
        props.ping?.let { ping = it }
    }
    if (props::rel !in excludes) {
        props.rel?.let { rel = it }
    }
    if (props::hrefLang !in excludes) {
        props.hrefLang?.let { hrefLang = it }
    }
    if (props::type !in excludes) {
        props.type?.let { type = it }
    }
}
