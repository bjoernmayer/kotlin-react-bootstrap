package react.bootstrap

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.classes
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

fun RDOMBuilder<CommonAttributeGroupFacade>.addClass(vararg className: String) {
    attrs {
        classes = classes.toMutableSet().apply {
            className.forEach {
                add(it)
            }
        }
    }
}

inline fun <reified T : Any> makeInstance(klazz: KClass<T>): T {
    val constructor = klazz.js
    return js("new constructor()") as T
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

fun String?.toClasses(): Set<String>? = this?.split(" ")?.toSet()

fun <T> Set<T>?.addOrInit(newEntries: Set<T>): Set<T> = run {
    this?.toMutableSet()?.apply {
        addAll(newEntries)
    }?.toSet() ?: newEntries
}

fun Set<String>?.addOrInit(newClassNames: Set<ClassNames>): Set<String> = addOrInit(
    newClassNames.map {
        it.toString()
    }.toSet()
)
