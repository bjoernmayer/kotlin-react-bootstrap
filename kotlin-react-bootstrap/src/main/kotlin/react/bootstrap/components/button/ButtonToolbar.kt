package react.bootstrap.components.button

import kotlinx.html.classes
import kotlinx.html.role
import react.RBuilder
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithAriaLabel
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.div

class ButtonToolbar : BootstrapComponent<ButtonToolbar.Props, RState>() {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.BTN_TOOLBAR)

    override fun RBuilder.render() {
        div {
            attrs {
                loadGlobalAttributes(props)

                role = "toolbar"
                classes = getComponentClasses()

                props.ariaLabel?.let {
                    ariaLabel = it
                }
            }
            children()
        }
    }

    interface Props : WithGlobalAttributes, WithAriaLabel
}
