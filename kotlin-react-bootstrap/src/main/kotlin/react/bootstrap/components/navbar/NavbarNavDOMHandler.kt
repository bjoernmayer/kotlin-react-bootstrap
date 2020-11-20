package react.bootstrap.components.navbar

import kotlinx.html.HtmlBlockTag
import react.bootstrap.lib.component.DOMHandler

fun interface NavbarNavDOMHandler<T : HtmlBlockTag> : DOMHandler<T, NavbarNavComponent.DomBuilder<T>>
