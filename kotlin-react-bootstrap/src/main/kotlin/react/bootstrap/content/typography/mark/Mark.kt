package react.bootstrap.content.typography.mark

import kotlinx.html.CommonAttributeGroupFacade
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDomComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes

class Mark<T : CommonAttributeGroupFacade>(props: Props<T>) : AbstractDomComponent<T, Mark.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.MARK)

    interface Props<T : CommonAttributeGroupFacade> : WithGlobalAttributes, AbstractDomComponent.Props<T>
}
