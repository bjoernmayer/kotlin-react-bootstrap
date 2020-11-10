package react.bootstrap.components.navbar

import kotlinx.html.HtmlInlineTag
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.domComponent

inline fun <reified TT : HtmlInlineTag> RElementBuilder<Navbar.Props>.brand(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = domComponent<TT, Navbar.Brand.Props<TT>>(classes, Navbar.Brand::class, domHandler = block)
