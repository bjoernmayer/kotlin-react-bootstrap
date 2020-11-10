package react.bootstrap.content.typography.muted

import kotlinx.html.CommonAttributeGroupFacade
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDomComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes

class Muted<TT : CommonAttributeGroupFacade>(props: Props<TT>) : AbstractDomComponent<TT, Muted.Props<TT>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.TEXT_MUTED)

    interface Props<TT : CommonAttributeGroupFacade> : WithGlobalAttributes, AbstractDomComponent.Props<TT>
}
