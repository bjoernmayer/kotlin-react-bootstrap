package react.bootstrap.content

import kotlinx.html.IMG
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNames
import react.dom.RDOMBuilder
import react.dom.img

@Suppress("unused")
fun RBuilder.img(
    fluid: Boolean? = true,
    isThumbnail: Boolean? = null,
    alt: String? = null,
    src: String? = null,
    classes: String? = null,
    block: RDOMBuilder<IMG>.() -> Unit
): ReactElement {
    val imageClasses = mutableSetOf<ClassNames>()

    if (fluid == true) {
        imageClasses.add(ClassNames.IMG_FLUID)
    }

    if (isThumbnail == true) {
        imageClasses.add(ClassNames.IMG_THUMBNAIL)
    }

    return img(alt = alt, src = src, classes = classes.appendClass(imageClasses), block = block)
}
