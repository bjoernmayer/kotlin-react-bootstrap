package react.bootstrap.components.button

import kotlinx.html.role
import react.RBuilder
import react.RComponent
import react.RState
import react.bootstrap.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.rprops.WithAriaLabel
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.dom.WithClassName
import react.dom.div

class ButtonToolbar : RComponent<ButtonToolbar.Props, RState>() {
    override fun RBuilder.render() {
        div(classes = props.className.appendClass(ClassNames.BTN_TOOLBAR)) {
            attrs {
                role = "toolbar"

                props.ariaLabel?.let {
                    ariaLabel = it
                }
            }
            children()
        }
    }

    interface Props : WithClassName, WithAriaLabel
}
