package react.bootstrap.content.typography.small

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.classes
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.DOMWrapComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.RDOMBuilder

class Small<TT : CommonAttributeGroupFacade>(props: Props<TT>) : DOMWrapComponent<TT, Small.Props<TT>>(props) {
    override fun RDOMBuilder<TT>.build() {
        attrs {
            classes = props.classes.addOrInit(ClassNames.SMALL)
        }
    }

    interface Props<TT : CommonAttributeGroupFacade> : WithGlobalAttributes, DOMWrapComponent.Props<TT>
}
