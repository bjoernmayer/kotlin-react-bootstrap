package react.bootstrap.content.typography

import kotlinx.html.ABBR
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.RDOMHandler
import react.dom.abbr

@Suppress("unused")
fun RBuilder.abbr(
    @Suppress("UNUSED_PARAMETER") initialism: Boolean,
    classes: String? = null,
    block: RDOMHandler<ABBR>
): ReactElement = abbr(classes = classes.appendClass(ClassNames.INITIALISM), block = block)
