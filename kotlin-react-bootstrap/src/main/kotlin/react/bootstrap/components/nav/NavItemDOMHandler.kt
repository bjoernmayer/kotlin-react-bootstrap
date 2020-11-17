package react.bootstrap.components.nav

import kotlinx.html.HtmlBlockTag
import react.bootstrap.lib.component.DOMHandler

fun interface NavItemDOMHandler<T : HtmlBlockTag> : DOMHandler<T, NavItems.DomBuilder<T>>
