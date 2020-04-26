package react.bootstrap.lib

interface CombinedAttributes {
    val classNamePrefix: String?
    val classNamePostfix: String?

    fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> {
        if (classNamePrefix == null && classNamePostfix == null) {
            return emptySet()
        }

        val breakpoint: String? = if (breakpoints !== null) {
            breakpoints.name.toUpperCase()
        } else null

        val className = listOfNotNull(classNamePrefix, breakpoint, classNamePostfix).joinToString("_")

        return setOf(ClassNames.valueOf(className))
    }
}

interface AttributePair<T1 : CombinedAttributes, T2 : CombinedAttributes> : CombinedAttributes {
    val first: T1
    val second: T2

    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = listOf(
        first.getClassNames(breakpoints),
        second.getClassNames(breakpoints)
    ).flatten().toSet()
}

interface AttributeTriple<T1 : CombinedAttributes, T2 : CombinedAttributes, T3 : CombinedAttributes> :
    AttributePair<T1, T2> {
    val third: T3

    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = super.getClassNames(breakpoints)
        .toMutableList().apply { addAll(third.getClassNames(breakpoints)) }
        .toSet()
}

interface AttributeQuadruple<
    T1 : CombinedAttributes,
    T2 : CombinedAttributes,
    T3 : CombinedAttributes,
    T4 : CombinedAttributes
    > : AttributeTriple<T1, T2, T3> {
    val fourth: T4

    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = super.getClassNames(breakpoints)
        .toMutableList().apply { addAll(fourth.getClassNames(breakpoints)) }
        .toSet()
}

inline fun <reified T : CombinedAttributes> resolveAttributeClassNames(
    all: CombinedAttributes? = null,
    sm: CombinedAttributes? = null,
    md: CombinedAttributes? = null,
    lg: CombinedAttributes? = null,
    xl: CombinedAttributes? = null
): Set<ClassNames> {
    val classes = mutableSetOf<ClassNames>()

    if (all is T) {
        all.getClassNames(null).let(classes::addAll)
    }

    if (sm is T) {
        sm.getClassNames(Breakpoints.SM).let(classes::addAll)
    }

    if (md is T) {
        md.getClassNames(Breakpoints.MD).let(classes::addAll)
    }

    if (lg is T) {
        lg.getClassNames(Breakpoints.LG).let(classes::addAll)
    }

    if (xl is T) {
        xl.getClassNames(Breakpoints.XL).let(classes::addAll)
    }

    return classes
}
