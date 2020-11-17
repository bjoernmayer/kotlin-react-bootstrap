package react.bootstrap.components.navbar

import kotlinx.html.HtmlBlockTag
import react.bootstrap.lib.component.DOMHandler

fun interface NavbarDOMHandler<T : HtmlBlockTag> : DOMHandler<T, Navbar.DomBuilder<T>>
