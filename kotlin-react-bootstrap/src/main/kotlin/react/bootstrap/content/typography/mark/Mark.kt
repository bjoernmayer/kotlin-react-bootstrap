package react.bootstrap.content.typography.mark

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.SPAN
import kotlinx.html.classes
import react.RState
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

class Mark(props: Props) : CustomisableComponent<CommonAttributeGroupFacade, Mark.Props, RState>(props) {
    override val defaultRendererTag: KClass<out CommonAttributeGroupFacade> = SPAN::class

    override fun RDOMBuilder<CommonAttributeGroupFacade>.build() {
        attrs {
            classes = props.classes.addOrInit(ClassNames.MARK)
        }
    }

    interface Props : WithGlobalAttributes, CustomisableComponent.Props<CommonAttributeGroupFacade>
}
