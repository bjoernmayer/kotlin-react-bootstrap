package react.bootstrap.content.typography.small

import react.RState
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent

public class Small<T : DOMTag>(props: Props<T>) : AbstractDOMComponent<T, Small.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.SMALL)

    public interface Props<T : DOMTag> : AbstractDOMComponent.Props<T>
}
