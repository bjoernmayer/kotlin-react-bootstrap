package react.bootstrap.content.typography.muted

import kotlinx.html.CommonAttributeGroupFacade
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDomComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes

class Muted<T : CommonAttributeGroupFacade>(props: Props<T>) : AbstractDomComponent<T, Muted.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.TEXT_MUTED)

    interface Props<T : CommonAttributeGroupFacade> : WithGlobalAttributes, AbstractDomComponent.Props<T>
}
