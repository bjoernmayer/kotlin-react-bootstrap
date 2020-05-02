package react.bootstrap.content.figures

import kotlinx.html.FIGCAPTION
import kotlinx.html.FIGURE
import kotlinx.html.IMG
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.content.img
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.figcaption
import react.dom.figure

fun RBuilder.figure(classes: String? = null, block: RDOMBuilder<FIGURE>.() -> Unit): ReactElement =
    figure(classes.appendClass(ClassNames.FIGURE), block)

fun RDOMBuilder<FIGURE>.img(
    fluid: Boolean? = true,
    isThumbnail: Boolean? = null,
    alt: String? = null,
    src: String? = null,
    classes: String? = null,
    block: RDOMBuilder<IMG>.() -> Unit
) = img(fluid, isThumbnail, alt, src, classes.appendClass(ClassNames.FIGURE_IMG), block)

fun RBuilder.figcaption(classes: String? = null, block: RDOMBuilder<FIGCAPTION>.() -> Unit): ReactElement =
    figcaption(classes.appendClass(ClassNames.FIGURE_CAPTION), block)
