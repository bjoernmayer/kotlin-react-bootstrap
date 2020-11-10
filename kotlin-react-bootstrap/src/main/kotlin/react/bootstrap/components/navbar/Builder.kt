package react.bootstrap.components.navbar

import kotlinx.html.HtmlInlineTag
import kotlinx.html.classes
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.helpers.addOrInit
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.DOMWrapComponent.Companion.domWrapComponent

inline fun <reified TT : HtmlInlineTag> RElementBuilder<Navbar.Props>.brand(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = domWrapComponent<TT, Navbar.Brand.Props<TT>>(Navbar.Brand::class) {
    attrs {
        this.classes = this.classes.addOrInit(classes.splitClassesToSet())
    }

    block()
}
