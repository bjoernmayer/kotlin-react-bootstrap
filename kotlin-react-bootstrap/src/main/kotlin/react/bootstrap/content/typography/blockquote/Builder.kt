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

/**
 * Creates a [BLOCKQUOTE] element and adds [ClassNames.BLOCKQUOTE] to it.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.blockQuote(classes: String? = null, block: RDOMHandler<BLOCKQUOTE>): ReactElement =
    blockQuote(classes = classes.appendClass(ClassNames.BLOCKQUOTE), block = block)

/**
 * Creates a [BlockQuoteFooter] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.blockQuoteFooter(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    child(BlockQuoteFooter::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
            this.handler = block
        }
    }
