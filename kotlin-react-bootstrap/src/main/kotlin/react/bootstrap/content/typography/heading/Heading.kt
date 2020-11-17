package react.bootstrap.content.typography.heading

import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.H6
import react.RState
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent
import react.bootstrap.lib.react.rprops.requireProperties

open class Heading<T : DOMTag, P : Heading.Props<T>>(props: P) : AbstractDOMComponent<T, P, RState>(props) {
    init {
        props.requireProperties(props::size)
    }

    override fun buildClasses(): Set<ClassNames> = when (props.tag) {
        H1::class -> emptySet()
        H2::class -> emptySet()
        H3::class -> emptySet()
        H4::class -> emptySet()
        H5::class -> emptySet()
        H6::class -> emptySet()
        else -> setOf(props.size.className)
    }

    interface Props<T : DOMTag> : AbstractDOMComponent.Props<T> {
        var size: Sizes
    }

    enum class Sizes(internal val className: ClassNames) {
        H1(ClassNames.H1),
        H2(ClassNames.H2),
        H3(ClassNames.H3),
        H4(ClassNames.H4),
        H5(ClassNames.H5),
        H6(ClassNames.H6);
    }
}
