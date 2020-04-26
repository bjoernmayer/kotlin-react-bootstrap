package react.bootstrap.content

import kotlinx.html.TABLE
import react.bootstrap.addClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder

// replace with component bstable
fun RDOMBuilder<TABLE>.toTable() =
    addClass("${ClassNames.TABLE}")
