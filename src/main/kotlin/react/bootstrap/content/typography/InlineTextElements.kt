package react.bootstrap.content.typography

import kotlinx.html.CommonAttributeGroupFacade
import react.bootstrap.addClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder

fun RDOMBuilder<CommonAttributeGroupFacade>.toSmall() =
    addClass("${ClassNames.SMALL}")

fun RDOMBuilder<CommonAttributeGroupFacade>.toMark() =
    addClass("${ClassNames.MARK}")
