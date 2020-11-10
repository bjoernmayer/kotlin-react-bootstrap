package react.bootstrap.content.typography.mark

import kotlinx.html.CommonAttributeGroupFacade
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.DomComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes

class Mark<TT : CommonAttributeGroupFacade>(props: Props<TT>) : DomComponent<TT, Mark.Props<TT>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.MARK)

    interface Props<TT : CommonAttributeGroupFacade> : WithGlobalAttributes, DomComponent.Props<TT>
}
