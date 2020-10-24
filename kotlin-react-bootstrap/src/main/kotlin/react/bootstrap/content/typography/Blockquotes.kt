package react.bootstrap.content.typography

import kotlinx.html.BLOCKQUOTE
import kotlinx.html.DIV
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.rprops.WithRDOMHandler
import react.dom.WithClassName
import react.dom.blockQuote
import react.dom.div

fun RBuilder.blockQuote(classes: String? = null, block: RDOMHandler<BLOCKQUOTE>): ReactElement =
    blockQuote(classes = classes.appendClass(ClassNames.BLOCKQUOTE), block = block)

fun RBuilder.blockQuoteFooter(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    child(BlockQuoteFooter::class) {
        attrs {
            this.className = classes
            this.handler = block
        }
    }

class BlockQuoteFooter : RComponent<BlockQuoteFooter.Props, RState>() {
    override fun RBuilder.render() {
        div(classes = props.className.appendClass(ClassNames.BLOCKQUOTE_FOOTER), block = props.handler)
    }

    interface Props : WithClassName, WithRDOMHandler<DIV>
}
