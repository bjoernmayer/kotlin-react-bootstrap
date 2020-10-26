package react.bootstrap.site.components.docs.fixings

import kotlinx.html.DIV
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import react.bootstrap.addOrInit
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.WithRDOMHandler
import react.bootstrap.splitClassesToSet
import react.dom.div

internal fun RBuilder.liveExample(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    child(LiveExample::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
            this.handler = block
        }
    }

internal class LiveExample : RComponent<LiveExample.Props, RState>() {
    override fun RBuilder.render() {
        div {
            attrs {
                classes = props.classes.addOrInit(setOf("bd-example"))
            }
            props.handler.invoke(this)
        }
    }

    interface Props : WithGlobalAttributes, WithRDOMHandler<DIV>
}
