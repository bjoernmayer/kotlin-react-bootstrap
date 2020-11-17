package react.bootstrap.utilities.close

import kotlinx.html.BUTTON
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.SimpleDOMComponent
import react.bootstrap.lib.kotlinxhtml.ariaHidden
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.dom.RDOMBuilder
import react.dom.span

class Close(props: Props) : SimpleDOMComponent<BUTTON, Close.Props, RState>(props, BUTTON::class) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.CLOSE)

    override fun RDOMBuilder<BUTTON>.build() {
        attrs {
            ariaLabel = "Close"
        }

        span {
            attrs.ariaHidden = true

            props.symbol?.let {
                +it
            } ?: +"×"
        }

        addChildren()
    }

    interface Props : SimpleDOMComponent.Props<BUTTON> {
        var symbol: String?
    }
}
