package react.bootstrap.content.typography

import kotlinx.html.CommonAttributeGroupFacade
import react.bootstrap.addClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder

enum class Headings(private val classNames: ClassNames) {
    H1(ClassNames.H1),
    H2(ClassNames.H2),
    H3(ClassNames.H3),
    H4(ClassNames.H4),
    H5(ClassNames.H5),
    H6(ClassNames.H6);

    override fun toString(): String {
        return "$classNames"
    }
}

fun RDOMBuilder<CommonAttributeGroupFacade>.toH(headings: Headings) =
    addClass("$headings")

fun RDOMBuilder<CommonAttributeGroupFacade>.toH1() = toH(Headings.H1)

fun RDOMBuilder<CommonAttributeGroupFacade>.toH2() = toH(Headings.H2)

fun RDOMBuilder<CommonAttributeGroupFacade>.toH3() = toH(Headings.H3)

fun RDOMBuilder<CommonAttributeGroupFacade>.toH4() = toH(Headings.H4)

fun RDOMBuilder<CommonAttributeGroupFacade>.toH5() = toH(Headings.H5)

fun RDOMBuilder<CommonAttributeGroupFacade>.toH6() = toH(Headings.H6)

// Todo: move this to the other text stuff
fun RDOMBuilder<CommonAttributeGroupFacade>.toTextMuted() =
    addClass("${ClassNames.TEXT_MUTED}")
