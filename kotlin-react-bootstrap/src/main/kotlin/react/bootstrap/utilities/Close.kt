package react.bootstrap.utilities

import kotlinx.html.ButtonType
import kotlinx.html.classes
import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.kotlinxhtml.ariaHidden
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.bootstrap.lib.kotlinxhtml.loadDomEvents
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithDomEvents
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.splitClassesToSet
import react.dom.button
import react.dom.span

class Close : BootstrapComponent<Close.Props, RState>() {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.CLOSE)

    override fun RBuilder.render() {
        button(type = ButtonType.button) {
            attrs {
                loadGlobalAttributes(props)
                loadDomEvents(props)

                classes = getComponentClasses()
                ariaLabel = props.label ?: "Close"
            }

            span {
                attrs.ariaHidden = true

                props.symbol?.let {
                    +it
                } ?: +"×"
            }
        }
    }

    interface Props : WithGlobalAttributes, WithDomEvents {
        var label: String?
        var symbol: String?
    }
}

fun RBuilder.close(
    label: String? = null,
    symbol: String? = null,
    classes: String? = null,
    block: RHandler<Close.Props>
): ReactElement = child(Close::class) {
    attrs {
        this.label = label
        this.symbol = symbol
        this.classes = classes.splitClassesToSet()
    }

    block()
}
