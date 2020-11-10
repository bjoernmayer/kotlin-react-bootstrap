package react.bootstrap.content.typography.small

import kotlinx.html.CommonAttributeGroupFacade
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDomComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes

class Small<T : CommonAttributeGroupFacade>(props: Props<T>) : AbstractDomComponent<T, Small.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.SMALL)

    interface Props<T : CommonAttributeGroupFacade> : WithGlobalAttributes, AbstractDomComponent.Props<T>
}
