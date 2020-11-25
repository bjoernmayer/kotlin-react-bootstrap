package react.bootstrap.content.typography.mark

import react.RState
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent

public class Mark<T : DOMTag>(props: Props<T>) : AbstractDOMComponent<T, Mark.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.MARK)

    public interface Props<T : DOMTag> : AbstractDOMComponent.Props<T>
}
