package react.bootstrap.components.navbar

import kotlinx.html.HtmlInlineTag
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
inline fun <reified T : HtmlInlineTag> RElementBuilder<Navbar.Props>.brand(
    classes: String? = null,
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Navbar.Brand::class as KClass<Navbar.Brand<T>>)
    .classes(classes)
    .domHandler(block)
    .build()
