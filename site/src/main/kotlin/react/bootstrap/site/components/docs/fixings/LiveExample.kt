package react.bootstrap.site.components.docs.fixings

import kotlinx.html.DIV
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.react.rprops.WithRDOMHandler
import react.dom.WithClassName
import react.dom.div

internal fun RBuilder.liveExample(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    child(LiveExample::class) {
        attrs {
            this.className = classes
            this.handler = block
        }
    }

internal class LiveExample : RComponent<LiveExample.Props, RState>() {
    override fun RBuilder.render() {
        div(props.className.appendClass("bd-example")) {
            props.handler.invoke(this)
        }
    }

    interface Props : WithClassName, WithRDOMHandler<DIV>
}
