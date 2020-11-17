package react.bootstrap.content.typography.muted

import react.RState
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent

class Muted<T : DOMTag>(props: Props<T>) : AbstractDOMComponent<T, Muted.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.TEXT_MUTED)

    interface Props<T : DOMTag> : AbstractDOMComponent.Props<T>
}
