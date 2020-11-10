package react.bootstrap.content.typography.lead

import kotlinx.html.classes
import react.RBuilder
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.p

class Lead : BootstrapComponent<Lead.Props, RState>() {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.LEAD)

    override fun RBuilder.render(rendererClasses: Set<String>) {
        p {
            attrs {
                loadGlobalAttributes(props)
                classes = rendererClasses
            }

            children()
        }
    }

    interface Props : WithGlobalAttributes
}
