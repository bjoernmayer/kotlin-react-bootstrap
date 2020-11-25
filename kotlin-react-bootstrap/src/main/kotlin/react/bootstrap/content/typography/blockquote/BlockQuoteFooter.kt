package react.bootstrap.content.typography.blockquote

import kotlinx.html.HtmlBlockTag
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent

public class BlockQuoteFooter<T : HtmlBlockTag>(
    props: Props<T>
) : AbstractDOMComponent<T, BlockQuoteFooter.Props<T>, RState>(props) {
    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.BLOCKQUOTE_FOOTER)

    public interface Props<T : HtmlBlockTag> : AbstractDOMComponent.Props<T>
}
