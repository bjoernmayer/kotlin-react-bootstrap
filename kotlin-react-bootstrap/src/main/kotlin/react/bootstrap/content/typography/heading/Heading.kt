package react.bootstrap.content.typography.heading

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.classes
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.DOMWrapComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.RDOMBuilder

open class Heading<TT : CommonAttributeGroupFacade>(props: Props<TT>) : DOMWrapComponent<TT, Heading.Props<TT>>(props) {
    init {
        // These comparison are not senseless. The props are built using kotlin's `dynamic` keyword. Null is a possible
        // value.

        @Suppress("SENSELESS_COMPARISON")
        require(props.size != null) {
            "Missing property: size must not be null!"
        }
    }

    override fun RDOMBuilder<TT>.build() {
        attrs {
            classes = props.classes.addOrInit(props.size.className)
        }
    }

    interface Props<TT : CommonAttributeGroupFacade> : WithGlobalAttributes, DOMWrapComponent.Props<TT> {
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
