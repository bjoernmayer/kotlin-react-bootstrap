package react.bootstrap.lib.component

import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames

public interface CombinedAttributes {
    public val classNamePrefix: String?
    public val classNamePostfix: String?

    public fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> {
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

public interface AttributePair : CombinedAttributes {
    public val first: CombinedAttributes
    public val second: CombinedAttributes

    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = listOf(
        first.getClassNames(breakpoints),
        second.getClassNames(breakpoints)
    ).flatten().toSet()
}

public interface AttributeTriple : AttributePair {
    public val third: CombinedAttributes

    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = super.getClassNames(breakpoints)
        .toMutableList().apply { addAll(third.getClassNames(breakpoints)) }
        .toSet()
}

public interface AttributeQuadruple<
    T1 : CombinedAttributes,
    T2 : CombinedAttributes,
    T3 : CombinedAttributes,
    T4 : CombinedAttributes
    > : AttributeTriple {
    public val fourth: CombinedAttributes

    override fun getClassNames(breakpoints: Breakpoints?): Set<ClassNames> = super.getClassNames(breakpoints)
        .toMutableList().apply { addAll(fourth.getClassNames(breakpoints)) }
        .toSet()
}
