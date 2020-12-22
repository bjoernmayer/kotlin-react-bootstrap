package react.bootstrap.components.button

import kotlinx.html.HtmlBlockTag
import kotlinx.html.role
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent
import react.dom.RDOMBuilder

public class ButtonToolbar<T : HtmlBlockTag>(
    props: Props<T>
) : AbstractDOMComponent<T, ButtonToolbar.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.BTN_TOOLBAR)

    override fun RDOMBuilder<T>.build() {
        attrs {
            role = "toolbar"
        }
        addChildren()
    }

    public interface Props<T : HtmlBlockTag> : AbstractDOMComponent.Props<T>
}
