package react.bootstrap.components.navbar

import kotlinx.html.HtmlInlineTag
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.DOMWrapComponent.Companion.domWrapComponent

inline fun <reified TT : HtmlInlineTag> RElementBuilder<Navbar.Props>.brand(
    noinline block: RDOMHandler<TT>
): ReactElement = domWrapComponent(Navbar.Brand::class, block)
