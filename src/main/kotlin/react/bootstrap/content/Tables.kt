package react.bootstrap.content

import kotlinx.html.TABLE
import react.bootstrap.addClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder

fun RDOMBuilder<TABLE>.toTable() =
    addClass("${ClassNames.TABLE}")
