package react.bootstrap.content.typography

import kotlinx.html.classes
import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.splitClassesToSet
import react.dom.p

class Lead : BootstrapComponent<Lead.Props, RState>() {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.LEAD)

    override fun RBuilder.render() {
        p {
            attrs {
                loadGlobalAttributes(props)
                classes = getComponentClasses()
            }

            children()
        }
    }

    interface Props : WithGlobalAttributes
}

fun RBuilder.lead(classes: String? = null, block: RHandler<Lead.Props>): ReactElement =
    child(Lead::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
        }

        block()
    }
