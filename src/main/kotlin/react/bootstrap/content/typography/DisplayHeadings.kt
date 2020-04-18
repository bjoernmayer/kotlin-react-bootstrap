package react.bootstrap.content.typography

import kotlinx.html.CommonAttributeGroupFacade
import react.bootstrap.addClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder

enum class DisplayHeadings(private val classNames: ClassNames) {
    DISPLAY_1(ClassNames.DISPLAY_1),
    DISPLAY_2(ClassNames.DISPLAY_2),
    DISPLAY_3(ClassNames.DISPLAY_3),
    DISPLAY_4(ClassNames.DISPLAY_4);

    override fun toString(): String {
        return "$classNames"
    }
}

fun RDOMBuilder<CommonAttributeGroupFacade>.toDisplay(displayHeadings: DisplayHeadings) =
    addClass("$displayHeadings")

fun RDOMBuilder<CommonAttributeGroupFacade>.toDisplay1() = toDisplay(DisplayHeadings.DISPLAY_1)

fun RDOMBuilder<CommonAttributeGroupFacade>.toDisplay2() = toDisplay(DisplayHeadings.DISPLAY_2)

fun RDOMBuilder<CommonAttributeGroupFacade>.toDisplay3() = toDisplay(DisplayHeadings.DISPLAY_3)

fun RDOMBuilder<CommonAttributeGroupFacade>.toDisplay4() = toDisplay(DisplayHeadings.DISPLAY_4)
