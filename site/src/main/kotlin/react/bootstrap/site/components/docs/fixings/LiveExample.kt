package react.bootstrap.site.components.docs.fixings

import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.helpers.splitClassesToSet
import react.dom.div

internal fun RBuilder.liveExample(classes: String? = null, block: RHandler<LiveExample.Props>): ReactElement =
    child(LiveExample::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
        }
        block()
    }

internal class LiveExample : RComponent<LiveExample.Props, RState>() {
    override fun RBuilder.render() {
        div {
            attrs {
                classes = props.classes.addOrInit(setOf("bd-example"))
            }
            children()
        }
    }

    interface Props : WithGlobalAttributes
}
