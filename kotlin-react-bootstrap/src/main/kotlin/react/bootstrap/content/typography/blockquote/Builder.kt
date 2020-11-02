package react.bootstrap.content.typography.blockquote

import kotlinx.html.BLOCKQUOTE
import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.splitClassesToSet
import react.dom.blockQuote

fun RBuilder.blockQuote(classes: String? = null, block: RDOMHandler<BLOCKQUOTE>): ReactElement =
    blockQuote(classes = classes.appendClass(ClassNames.BLOCKQUOTE), block = block)

fun RBuilder.blockQuoteFooter(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    child(BlockQuoteFooter::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
            this.handler = block
        }
    }
