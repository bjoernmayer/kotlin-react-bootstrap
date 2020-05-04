package react.bootstrap

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.Tag
import kotlinx.html.classes
import react.bootstrap.lib.ClassNames
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

fun RDOMBuilder<CommonAttributeGroupFacade>.addClass(vararg className: String) {
    attrs {
        classes = classes.toMutableSet().apply {
            className.forEach {
                add(it)
            }
        }
    }
}

fun String?.appendClass(className: ClassNames) = appendClass(setOf(className.toString()))

fun String?.appendClass(className: String) = appendClass(setOf(className))

fun String?.appendClass(vararg className: ClassNames) = appendClass(className.toSet())

fun String?.appendClass(classNames: Set<ClassNames>) = appendClass(classNames.map(ClassNames::toString).toSet())

fun String?.appendClass(classNames: Set<String>) = run {
    if (this == null) {
        classNames.joinToString(" ")
    } else {
        "$this ${classNames.joinToString(" ")}"
    }
}
