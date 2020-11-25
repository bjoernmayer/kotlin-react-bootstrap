package react.bootstrap.components.nav

import kotlinx.html.HtmlBlockTag
import react.bootstrap.lib.component.DOMHandler

public fun interface NavDOMHandler<T : HtmlBlockTag> : DOMHandler<T, Navigation.DomBuilder<T>>
