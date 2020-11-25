package react.bootstrap.lib.component

import kotlinx.html.Tag
import react.dom.RDOMBuilder

public fun interface DOMHandler<T : Tag, B : RDOMBuilder<T>> {
    public fun B.handle()
}

public fun interface RDOMHandler<T : Tag> : DOMHandler<T, RDOMBuilder<T>>
