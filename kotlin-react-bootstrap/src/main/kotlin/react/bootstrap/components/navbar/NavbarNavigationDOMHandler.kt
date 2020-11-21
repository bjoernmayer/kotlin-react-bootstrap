package react.bootstrap.components.navbar

import kotlinx.html.HtmlBlockTag
import react.bootstrap.lib.component.DOMHandler

fun interface NavbarNavigationDOMHandler<T : HtmlBlockTag> : DOMHandler<T, Navbar.Navigation.DomBuilder<T>>
