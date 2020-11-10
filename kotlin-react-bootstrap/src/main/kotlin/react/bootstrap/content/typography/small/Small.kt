package react.bootstrap.content.typography.small

import kotlinx.html.CommonAttributeGroupFacade
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.DOMWrapComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes

class Small<TT : CommonAttributeGroupFacade>(props: Props<TT>) : DOMWrapComponent<TT, Small.Props<TT>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.SMALL)

    interface Props<TT : CommonAttributeGroupFacade> : WithGlobalAttributes, DOMWrapComponent.Props<TT>
}
