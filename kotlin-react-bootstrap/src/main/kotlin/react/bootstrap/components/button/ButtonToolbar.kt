package react.bootstrap.components.button

import kotlinx.html.HtmlBlockTag
import kotlinx.html.role
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDomComponent
import react.dom.RDOMBuilder

class ButtonToolbar<T : HtmlBlockTag>(
    props: Props<T>
) : AbstractDomComponent<T, ButtonToolbar.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.BTN_TOOLBAR)

    override fun RDOMBuilder<T>.build() {
        attrs {
            role = "toolbar"
        }
        addChildren()
    }

    interface Props<T : HtmlBlockTag> : AbstractDomComponent.Props<T>
}
