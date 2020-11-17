package react.bootstrap.components.nav

import kotlinx.html.HtmlBlockTag
import react.bootstrap.lib.component.DOMHandler

fun interface NavDOMHandler<T : HtmlBlockTag> : DOMHandler<T, NavComponent.DomBuilder<T>>
