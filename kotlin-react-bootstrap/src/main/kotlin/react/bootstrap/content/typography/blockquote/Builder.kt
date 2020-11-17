package react.bootstrap.content.typography.blockquote

import kotlinx.html.BLOCKQUOTE
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.RDOMHandler
import react.dom.RDOMBuilder
import react.dom.blockQuote as reactBlockQuote

/**
 * Creates a [BLOCKQUOTE] element and adds [ClassNames.BLOCKQUOTE] to it.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.blockQuote(classes: String? = null, block: RDOMHandler<BLOCKQUOTE>): ReactElement =
    reactBlockQuote(classes = classes.appendClass(ClassNames.BLOCKQUOTE)) {
        val builder = this
        with(block) {
            builder.handle()
        }
    }

/**
 * Creates a [BlockQuoteFooter] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RDOMBuilder<BLOCKQUOTE>.blockQuoteFooter(
    classes: String? = null,
    block: RHandler<BlockQuoteFooter.Props>
): ReactElement =
    child(BlockQuoteFooter::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
        }

        block()
    }
