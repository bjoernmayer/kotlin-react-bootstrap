package react.bootstrap.lib.component

import kotlinx.html.Tag
import react.dom.RDOMBuilder

fun interface DOMHandler<T : Tag, B : RDOMBuilder<T>> {
    fun B.handle()
}

fun interface RDOMHandler<T : Tag> : DOMHandler<T, RDOMBuilder<T>>
