package react.bootstrap.helpers

import react.bootstrap.lib.bootstrap.ClassNames

fun classes(vararg classes: Any): String = classes.joinToString(" ") {
    if (it is ClassNames) {
        it.className
    } else {
        it.toString()
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

fun String?.splitClassesToSet(): Set<String> = this?.split(" ")?.toSet() ?: emptySet()

fun <T> Set<T>?.addOrInit(newEntries: Set<T>): Set<T> = run {
    this?.let {
        it.toMutableSet().apply {
            addAll(newEntries)
        }
    } ?: newEntries
}

fun Set<String>?.addOrInit(newClassNames: Set<ClassNames>): Set<String> = addOrInit(
    newClassNames.map {
        it.toString()
    }.toSet()
)

fun Set<String>?.addOrInit(newClassName: ClassNames): Set<String> = addOrInit(setOf(newClassName.className))
