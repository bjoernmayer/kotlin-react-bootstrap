package react.bootstrap.lib.kotlinxhtml

import kotlinx.html.Tag

fun Tag.data(key: String, value: String) {
    attributes["data-$key"] = value
}

fun Tag.data(keyValue: Pair<String, String>) {
    attributes["data-${keyValue.first}"] = keyValue.second
}
