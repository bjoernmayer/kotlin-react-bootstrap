@file:Suppress("unused")

package react.bootstrap.content.figures

import kotlinx.html.FIGCAPTION
import kotlinx.html.FIGURE
import kotlinx.html.IMG
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.content.img
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.RDOMHandler
import react.dom.RDOMBuilder
import react.dom.figcaption
import react.dom.figure

fun RBuilder.figure(classes: String? = null, block: RDOMHandler<FIGURE>): ReactElement =
    figure(classes.appendClass(ClassNames.FIGURE), block)

fun RDOMBuilder<FIGURE>.img(
    fluid: Boolean? = true,
    isThumbnail: Boolean? = null,
    alt: String? = null,
    src: String? = null,
    classes: String? = null,
    block: RDOMHandler<IMG>
): ReactElement = img(fluid, isThumbnail, alt, src, classes.appendClass(ClassNames.FIGURE_IMG), block)

fun RBuilder.figcaption(classes: String? = null, block: RDOMHandler<FIGCAPTION>): ReactElement =
    figcaption(classes.appendClass(ClassNames.FIGURE_CAPTION), block)
