package react.bootstrap.content.tables

import kotlinx.html.THEAD
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.WithBlock
import react.dom.RDOMBuilder
import react.dom.WithClassName
import react.dom.thead

fun RBuilder.thead(
    style: THead.Styles? = null,
    classes: String? = null,
    block: RDOMBuilder<THEAD>.() -> Unit
): ReactElement =
    child(THead::class) {
        attrs {
            this.style = style
            this.className = classes
            this.block = block
        }
    }

class THead : RComponent<THead.Props, RState>() {
    enum class Styles(val className: ClassNames) {
        LIGHT(ClassNames.THEAD_LIGHT),
        DARK(ClassNames.THEAD_DARK);

        val kt = "${THead::class.simpleName}.${this::class.simpleName}.$name"
    }

    interface Props : WithClassName, WithBlock<THEAD> {
        var style: Styles?
    }

    override fun RBuilder.render() {
        val tHeadClasses = mutableSetOf<ClassNames>()

        props.style?.also {
            tHeadClasses.add(it.className)
        }

        thead(classes = props.className.appendClass(tHeadClasses), block = props.block)
    }
}
