package react.bootstrap.content.typography.blockquote

import kotlinx.html.classes
import react.RBuilder
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.dom.div

class BlockQuoteFooter : BootstrapComponent<BlockQuoteFooter.Props, RState>() {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.BLOCKQUOTE_FOOTER)

    override fun RBuilder.render(rendererClasses: Set<String>) {
        div {
            attrs {
                loadGlobalAttributes(props)
                classes = rendererClasses
            }

            children()
        }
    }

    interface Props : WithGlobalAttributes
}
