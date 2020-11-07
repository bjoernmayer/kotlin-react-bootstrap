package react.bootstrap.content

import kotlinx.html.IMG
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.img

/**
 * Creates an [IMG] element.
 *
 * @param fluid If set to *true* the image resizes fluently.
 * @param isThumbnail If set to `true`, a border is shown around the image.
 * @param alt alternative string
 * @param src Src-Attribute of the [IMG]
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.img(
    fluid: Boolean = false,
    isThumbnail: Boolean = false,
    alt: String? = null,
    src: String? = null,
    classes: String? = null,
    block: RDOMHandler<IMG>
): ReactElement {
    val imageClasses = mutableSetOf<ClassNames>()

    if (fluid) {
        imageClasses.add(ClassNames.IMG_FLUID)
    }

    if (isThumbnail) {
        imageClasses.add(ClassNames.IMG_THUMBNAIL)
    }

    return img(alt = alt, src = src, classes = classes.appendClass(imageClasses), block = block)
}
