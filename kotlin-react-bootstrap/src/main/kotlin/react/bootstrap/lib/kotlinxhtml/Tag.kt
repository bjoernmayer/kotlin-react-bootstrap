package react.bootstrap.lib.kotlinxhtml

import kotlinx.html.Tag

public fun Tag.data(key: String, value: String) {
    attributes["data-$key"] = value
}

public fun Tag.data(keyValue: Pair<String, String>) {
    attributes["data-${keyValue.first}"] = keyValue.second
}
