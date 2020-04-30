package react.bootstrap.content.typography

import kotlinx.html.ABBR
import react.RBuilder
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.abbr

@Suppress("unused")
fun RBuilder.abbr(@Suppress("UNUSED_PARAMETER") initialism: Boolean, classes: String? = null, block: RDOMBuilder<ABBR>.() -> Unit) =
    abbr(classes = classes.appendClass(ClassNames.INITIALISM), block = block)
