package react.bootstrap.content.typography.heading

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.H6
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDomComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.requireProperties

open class Heading<TT : CommonAttributeGroupFacade>(props: Props<TT>) :
    AbstractDomComponent<TT, Heading.Props<TT>, RState>(props) {

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

    interface Props<TT : CommonAttributeGroupFacade> : WithGlobalAttributes, AbstractDomComponent.Props<TT> {
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
