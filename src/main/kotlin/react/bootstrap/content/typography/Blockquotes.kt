package react.bootstrap.content.typography

import kotlinx.html.BLOCKQUOTE
import kotlinx.html.DIV
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.WithBlock
import react.dom.RDOMBuilder
import react.dom.WithClassName
import react.dom.blockQuote
import react.dom.div

fun RBuilder.blockQuote(classes: String? = null, block: RDOMBuilder<BLOCKQUOTE>.() -> Unit): ReactElement =
    child(BlockQuote::class) {
        attrs {
            this.className = classes
            this.block = block
        }
    }

class BlockQuote : RComponent<BlockQuote.Props, RState>() {
    interface Props : WithClassName, WithBlock<BLOCKQUOTE>

    override fun RBuilder.render() {
        blockQuote(classes = props.className.appendClass(ClassNames.BLOCKQUOTE), block = props.block)
    }
}

fun RBuilder.blockQuoteFooter(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit): ReactElement =
    child(BlockQuoteFooter::class) {
        attrs {
            this.className = classes
            this.block = block
        }
    }

class BlockQuoteFooter : RComponent<BlockQuoteFooter.Props, RState>() {
    interface Props : WithClassName, WithBlock<DIV>

    override fun RBuilder.render() {
        div(classes = props.className.appendClass(ClassNames.BLOCKQUOTE_FOOTER), block = props.block)
    }
}
