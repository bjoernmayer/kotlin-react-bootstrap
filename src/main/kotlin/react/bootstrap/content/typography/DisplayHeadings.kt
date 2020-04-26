package react.bootstrap.content.typography

import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4

enum class DisplayHeadings(private val classNames: ClassNames) {
    DISPLAY_1(ClassNames.DISPLAY_1),
    DISPLAY_2(ClassNames.DISPLAY_2),
    DISPLAY_3(ClassNames.DISPLAY_3),
    DISPLAY_4(ClassNames.DISPLAY_4);

    override fun toString(): String = classNames.toString()
}

@Suppress("unused")
fun RBuilder.display1(classes: String? = null, block: RDOMBuilder<H1>.() -> Unit): ReactElement =
    h1(classes.appendClass("${ClassNames.DISPLAY_1}"), block)

@Suppress("unused")
fun RBuilder.display2(classes: String? = null, block: RDOMBuilder<H2>.() -> Unit): ReactElement =
    h2(classes.appendClass("${ClassNames.DISPLAY_2}"), block)

@Suppress("unused")
fun RBuilder.display3(classes: String? = null, block: RDOMBuilder<H3>.() -> Unit): ReactElement =
    h3(classes.appendClass("${ClassNames.DISPLAY_3}"), block)

@Suppress("unused")
fun RBuilder.display4(classes: String? = null, block: RDOMBuilder<H4>.() -> Unit): ReactElement =
    h4(classes.appendClass("${ClassNames.DISPLAY_4}"), block)

fun <T : HTMLTag> RBuilder.display(
    variant: DisplayHeadings,
    tagFun: RBuilder.(String?, RDOMBuilder<T>.() -> Unit) -> ReactElement,
    classes: String? = null,
    block: RDOMBuilder<T>.() -> Unit
): ReactElement = tagFun(classes.appendClass(variant.toString()), block)
