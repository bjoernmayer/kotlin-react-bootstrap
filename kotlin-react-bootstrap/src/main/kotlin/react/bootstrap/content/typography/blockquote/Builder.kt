package react.bootstrap.content.typography.blockquote

import kotlinx.html.BLOCKQUOTE
import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.dom.RDOMBuilder
import kotlin.reflect.KClass
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
@Suppress("UNCHECKED_CAST")
fun RDOMBuilder<BLOCKQUOTE>.blockQuoteFooter(
    classes: String? = null,
    props: PropHandler<BlockQuoteFooter.Props<DIV>> = PropHandler { },
    block: RDOMHandler<DIV>
): ReactElement = blockQuoteFooter<DIV>(classes, props, block)

/**
 * Creates a generic [BlockQuoteFooter] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : HtmlBlockTag> RDOMBuilder<BLOCKQUOTE>.blockQuoteFooter(
    classes: String? = null,
    props: PropHandler<BlockQuoteFooter.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(BlockQuoteFooter::class as KClass<BlockQuoteFooter<T>>)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()
