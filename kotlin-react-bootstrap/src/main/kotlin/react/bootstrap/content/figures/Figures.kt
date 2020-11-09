package react.bootstrap.content.figures

import kotlinx.html.FIGCAPTION
import kotlinx.html.FIGURE
import kotlinx.html.IMG
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.content.img
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.RDOMBuilder
import react.dom.figcaption
import react.dom.figure

/**
 * Creates a [FIGURE] and adds [ClassNames.FIGURE] to it.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.figure(classes: String? = null, block: RDOMHandler<FIGURE>): ReactElement =
    figure(classes.appendClass(ClassNames.FIGURE), block)

/**
 * Creates an [IMG] and adds [ClassNames.FIGURE_IMG] to it.
 *
 * @param fluid If set to *true* the image resizes fluently.
 * @param isThumbnail If set to `true`, a border is shown around the image.
 * @param alt alternative string
 * @param src Src-Attribute of the [IMG]
 * @param classes Space separated list of CSS classes for this element.
 */
fun RDOMBuilder<FIGURE>.img(
    fluid: Boolean = false,
    isThumbnail: Boolean = false,
    alt: String? = null,
    src: String? = null,
    classes: String? = null,
    block: RDOMHandler<IMG>
): ReactElement = img(fluid, isThumbnail, alt, src, classes.appendClass(ClassNames.FIGURE_IMG), block)

fun RBuilder.figcaption(classes: String? = null, block: RDOMHandler<FIGCAPTION>): ReactElement =
    figcaption(classes.appendClass(ClassNames.FIGURE_CAPTION), block)
