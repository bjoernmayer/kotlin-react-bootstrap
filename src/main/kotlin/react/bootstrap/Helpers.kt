package react.bootstrap

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.Tag
import kotlinx.html.classes
import react.dom.RDOMBuilder

fun Tag.data(key: String, value: String) {
    attributes["data-$key"] = value
}

fun Tag.data(keyValue: Pair<String, String>) {
    attributes["data-${keyValue.first}"] = keyValue.second
}

var CommonAttributeGroupFacade.ariaLabel: String
    get() = this.attributes["aria-label"].toString()
    set(newValue) {
        this.attributes["aria-label"] = newValue
    }

fun RDOMBuilder<CommonAttributeGroupFacade>.addClass(className: String) {
    attrs {
        classes = classes.toMutableSet().apply {
            add(className)
        }
    }
}

fun String?.appendClass(className: String) = run {
    if (this == null) {
        className
    } else {
        "$this $className"
    }
}
