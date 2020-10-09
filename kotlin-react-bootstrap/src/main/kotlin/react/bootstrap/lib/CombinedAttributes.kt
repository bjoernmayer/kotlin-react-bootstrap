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

interface AttributePair : CombinedAttributes {
    val first: CombinedAttributes
    val second: CombinedAttributes

    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = listOf(
        first.getClassNames(breakpoints),
        second.getClassNames(breakpoints)
    ).flatten().toSet()
}

interface AttributeTriple : AttributePair {
    val third: CombinedAttributes

    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = super.getClassNames(breakpoints)
        .toMutableList().apply { addAll(third.getClassNames(breakpoints)) }
        .toSet()
}

interface AttributeQuadruple<
    T1 : CombinedAttributes,
    T2 : CombinedAttributes,
    T3 : CombinedAttributes,
    T4 : CombinedAttributes
    > : AttributeTriple {
    val fourth: CombinedAttributes

    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = super.getClassNames(breakpoints)
        .toMutableList().apply { addAll(fourth.getClassNames(breakpoints)) }
        .toSet()
}
