package react.bootstrap.content.typography.small

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.SPAN
import kotlinx.html.classes
import react.RState
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.WithRendererTag
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

class Small(props: Props) : CustomisableComponent<CommonAttributeGroupFacade, Small.Props, RState>(props) {
    override val defaultRendererTag: KClass<out CommonAttributeGroupFacade> = SPAN::class

    override fun RDOMBuilder<CommonAttributeGroupFacade>.build() {
        attrs {
            classes = props.classes.addOrInit(ClassNames.SMALL)
        }
    }

    interface Props : WithGlobalAttributes, WithRendererTag<CommonAttributeGroupFacade>
}
