package react.bootstrap.content.typography

import kotlinx.html.ABBR
import react.bootstrap.addClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder

fun RDOMBuilder<ABBR>.toInitialism() =
    addClass("${ClassNames.INITIALISM}")
