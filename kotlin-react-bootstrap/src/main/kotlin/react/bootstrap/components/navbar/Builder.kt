package react.bootstrap.components.navbar

import kotlinx.html.HtmlInlineTag
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

inline fun <reified T : HtmlInlineTag> RElementBuilder<Navbar.Props>.brand(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Navbar.Brand.Props<T>>(Navbar.Brand::class)
    .classes(classes)
    .domHandler(block)
    .build()
