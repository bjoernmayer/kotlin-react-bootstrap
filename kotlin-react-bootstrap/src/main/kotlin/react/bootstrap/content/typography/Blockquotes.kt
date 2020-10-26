package react.bootstrap.content.typography

import kotlinx.html.BLOCKQUOTE
import kotlinx.html.DIV
import kotlinx.html.classes
import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.WithRDOMHandler
import react.bootstrap.splitClassesToSet
import react.dom.blockQuote
import react.dom.div

fun RBuilder.blockQuote(classes: String? = null, block: RDOMHandler<BLOCKQUOTE>): ReactElement =
    blockQuote(classes = classes.appendClass(ClassNames.BLOCKQUOTE), block = block)

fun RBuilder.blockQuoteFooter(classes: String? = null, block: RDOMHandler<DIV>): ReactElement =
    child(BlockQuoteFooter::class) {
        attrs {
            this.classes = classes.splitClassesToSet()
            this.handler = block
        }
    }

class BlockQuoteFooter : BootstrapComponent<BlockQuoteFooter.Props, RState>() {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.BLOCKQUOTE_FOOTER)

    override fun RBuilder.render() {
        div {
            attrs {
                loadGlobalAttributes(props)
                classes = getComponentClasses()
            }

            props.handler.invoke(this)
        }
    }

    interface Props : WithGlobalAttributes, WithRDOMHandler<DIV>
}
