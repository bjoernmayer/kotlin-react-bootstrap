package react.bootstrap.content

import kotlinx.html.IMG
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.appendClass
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.RDOMHandler
import react.dom.img as reactImg

/**
 * Creates an [IMG] element.
 *
 * @param alt alternative string
 * @param src Src-Attribute of the [IMG]
 * @param classes Space separated list of CSS classes for this element.
 * @param fluid If set to *true* the image resizes fluently.
 * @param isThumbnail If set to `true`, a border is shown around the image.
 */
public fun RBuilder.img(
    alt: String? = null,
    src: String? = null,
    classes: String? = null,
    fluid: Boolean = false,
    isThumbnail: Boolean = false,
    block: RDOMHandler<IMG>
): ReactElement {
    val imageClasses = mutableSetOf<ClassNames>()

    if (fluid) {
        imageClasses.add(ClassNames.IMG_FLUID)
    }

    if (isThumbnail) {
        imageClasses.add(ClassNames.IMG_THUMBNAIL)
    }

    return reactImg(alt = alt, src = src, classes = classes.appendClass(imageClasses)) {
        val builder = this
        with(block) {
            builder.handle()
        }
    }
}
