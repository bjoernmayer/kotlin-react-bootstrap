package react.bootstrap.content.typography.heading

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.H6
import kotlinx.html.SPAN
import kotlinx.html.classes
import react.RState
import react.bootstrap.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.WithRendererTag
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

class Heading(props: Props) : CustomisableComponent<CommonAttributeGroupFacade, Heading.Props, RState>(props) {
    override val defaultRendererTag: KClass<out CommonAttributeGroupFacade> =
        when (props.size) {
            Sizes.H1 -> H1::class
            Sizes.H2 -> H2::class
            Sizes.H3 -> H3::class
            Sizes.H4 -> H4::class
            Sizes.H5 -> H5::class
            Sizes.H6 -> H6::class
            else -> SPAN::class
        }

    override fun RDOMBuilder<CommonAttributeGroupFacade>.build() {
        attrs {
            props.size?.let {
                classes = props.classes.addOrInit(it.className)
            }
        }
    }

    interface Props : WithGlobalAttributes, WithRendererTag<CommonAttributeGroupFacade> {
        var size: Sizes?
    }

    enum class Sizes(val className: ClassNames) {
        H1(ClassNames.H1),
        H2(ClassNames.H2),
        H3(ClassNames.H3),
        H4(ClassNames.H4),
        H5(ClassNames.H5),
        H6(ClassNames.H6);
    }
}
