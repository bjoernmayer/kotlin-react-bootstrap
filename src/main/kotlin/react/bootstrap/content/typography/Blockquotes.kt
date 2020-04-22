package react.bootstrap.content.typography

import kotlinx.html.BLOCKQUOTE
import kotlinx.html.DIV
import react.RBuilder
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.blockQuote
import react.dom.div

fun RBuilder.bsBlockQuote(classes: String? = null, block: RDOMBuilder<BLOCKQUOTE>.() -> Unit) =
    blockQuote(classes.appendClass("${ClassNames.BLOCKQUOTE}"), block)

fun RBuilder.blockQuoteFooter(classes: String? = null, block: RDOMBuilder<DIV>.() -> Unit) =
    div(classes.appendClass("${ClassNames.BLOCKQUOTE_FOOTER}"), block)
