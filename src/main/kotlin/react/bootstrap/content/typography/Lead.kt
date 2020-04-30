package react.bootstrap.content.typography

import react.RBuilder
import react.RComponent
import react.RElementBuilder
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.WithClassName
import react.dom.p

fun RBuilder.lead(classes: String? = null, block: RElementBuilder<Lead.Props>.() -> Unit): ReactElement =
    child(Lead::class) {
        attrs {
            className = classes
        }

        block()
    }

class Lead : RComponent<Lead.Props, RState>() {
    interface Props : WithClassName

    override fun RBuilder.render() {
        p(classes = props.className.appendClass(ClassNames.LEAD)) {
            children()
        }
    }
}
