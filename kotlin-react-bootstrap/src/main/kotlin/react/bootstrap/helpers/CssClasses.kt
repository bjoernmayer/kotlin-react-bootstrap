package react.bootstrap.helpers

import react.bootstrap.lib.bootstrap.ClassNames

public fun classes(vararg classes: Any): String = classes.joinToString(" ") {
    if (it is ClassNames) {
        it.className
    } else {
        it.toString()
    }
}

public fun String?.appendClass(className: ClassNames): String = appendClass(setOf(className.toString()))

public fun String?.appendClass(className: String): String = appendClass(setOf(className))

public fun String?.appendClass(vararg className: ClassNames): String = appendClass(className.toSet())

public fun String?.appendClass(classNames: Set<ClassNames>): String =
    appendClass(classNames.map(ClassNames::toString).toSet())

public fun String?.appendClass(classNames: Set<String>): String = run {
    if (this == null) {
        classNames.joinToString(" ")
    } else {
        "$this ${classNames.joinToString(" ")}"
    }
}

public fun <T> Set<T>?.addOrInit(newEntries: Set<T>): Set<T> = run {
    this?.let {
        it.toMutableSet().apply {
            addAll(newEntries)
        }
    } ?: newEntries
}

public fun Set<String>?.addOrInit(newClassNames: Set<ClassNames>): Set<String> = addOrInit(
    newClassNames.map {
        it.toString()
    }.toSet()
)

public fun Set<String>?.addOrInit(newClassName: ClassNames): Set<String> = addOrInit(setOf(newClassName.className))
