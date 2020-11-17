package react.bootstrap.components.navbar

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.HtmlInlineTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.DOMComponent.Companion.domComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun RBuilder.navbar(
    classes: String? = null,
    props: PropHandler<Navbar.Props<DIV>> = PropHandler { },
    block: NavbarDOMHandler<DIV>
): ReactElement = domComponent(Navbar::class as KClass<Navbar<DIV>>)
    .classes(classes)
    .propHandler {
        tag = DIV::class

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()

@Suppress("UNCHECKED_CAST")
inline fun <reified T : HtmlBlockTag> RBuilder.navbar(
    classes: String? = null,
    props: PropHandler<Navbar.Props<T>> = PropHandler { },
    block: NavbarDOMHandler<T>
): ReactElement = domComponent(Navbar::class as KClass<Navbar<T>>)
    .classes(classes)
    .propHandler {
        tag = T::class

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()

@Suppress("UNCHECKED_CAST")
inline fun <reified T : HtmlInlineTag> Navbar.DomBuilder<*>.brand(
    classes: String? = null,
    props: PropHandler<Navbar.Brand.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Navbar.Brand::class as KClass<Navbar.Brand<T>>)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()
