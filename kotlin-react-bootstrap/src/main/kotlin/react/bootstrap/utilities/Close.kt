package react.bootstrap.utilities

import kotlinx.html.ButtonType
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.react.rprops.WithDomEvents
import react.bootstrap.lib.kotlinxhtml.ariaHidden
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.bootstrap.lib.kotlinxhtml.loadDomEvents
import react.dom.WithClassName
import react.dom.button
import react.dom.span

class Close : RComponent<Close.Props, RState>() {
    override fun RBuilder.render() {
        button(type = ButtonType.button, classes = props.className.appendClass(ClassNames.CLOSE)) {
            attrs {
                ariaLabel = props.label ?: "Close"

                loadDomEvents(props)
            }

            span {
                attrs.ariaHidden = true

                props.symbol?.let {
                    +it
                } ?: +"×"
            }
        }
    }

    interface Props : WithClassName, WithDomEvents {
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
        this.className = classes
    }

    block()
}
