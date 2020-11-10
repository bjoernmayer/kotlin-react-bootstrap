package react.bootstrap.content.typography.mark

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.classes
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.DOMWrapComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.RDOMBuilder

class Mark<TT : CommonAttributeGroupFacade>(props: Props<TT>) : DOMWrapComponent<TT, Mark.Props<TT>>(props) {
    override fun RDOMBuilder<TT>.build() {
        attrs {
            classes = props.classes.addOrInit(ClassNames.MARK)
        }
    }

    interface Props<TT : CommonAttributeGroupFacade> : WithGlobalAttributes, DOMWrapComponent.Props<TT>
}
