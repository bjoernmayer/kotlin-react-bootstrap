package react.bootstrap.content.figures

import kotlinx.html.FIGCAPTION
import kotlinx.html.FIGURE
import kotlinx.html.IMG
import react.RBuilder
import react.ReactElement
import react.bootstrap.content.img
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.RDOMHandler
import react.dom.RDOMBuilder
import react.dom.figcaption as reactFigcaption
import react.dom.figure as reactFigure

/**
 * Creates a [FIGURE] and adds [ClassNames.FIGURE] to it.
 *
 * @param classes Space separated list of CSS classes for this element.
 */
public fun RBuilder.figure(classes: String? = null, block: RDOMHandler<FIGURE>): ReactElement =
    reactFigure(classes.appendClass(ClassNames.FIGURE)) {
        val builder = this
        with(block) {
            builder.handle()
        }
    }

/**
 * Creates an [IMG] and adds [ClassNames.FIGURE_IMG] to it.
 *
 * @param alt alternative string
 * @param src Src-Attribute of the [IMG]
 * @param classes Space separated list of CSS classes for this element.
 * @param fluid If set to *true* the image resizes fluently.
 * @param isThumbnail If set to `true`, a border is shown around the image.
 */
public fun RDOMBuilder<FIGURE>.img(
    alt: String? = null,
    src: String? = null,
    classes: String? = null,
    fluid: Boolean = false,
    isThumbnail: Boolean = false,
    block: RDOMHandler<IMG>
): ReactElement = img(alt, src, classes.appendClass(ClassNames.FIGURE_IMG), fluid, isThumbnail, block)

public fun RBuilder.figcaption(classes: String? = null, block: RDOMHandler<FIGCAPTION>): ReactElement =
    reactFigcaption(classes.appendClass(ClassNames.FIGURE_CAPTION)) {
        val builder = this
        with(block) {
            builder.handle()
        }
    }
