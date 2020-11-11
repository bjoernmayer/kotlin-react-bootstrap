package react.bootstrap.content.typography.display

import kotlinx.html.HtmlInlineTag
import kotlinx.html.SPAN
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet

/**
 * Creates a generic [Display].
 *
 * @param T Tag Type to be used to render this [Display].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : HtmlInlineTag> RBuilder.display(
    variant: Display.Variants,
    classes: String? = null,
    crossinline block: RHandler<Display.Props>
): ReactElement = child(Display::class) {
    attrs {
        this.variant = variant
        this.classes = classes.splitClassesToSet()
        this.rendererTag = T::class
    }

    block()
}

/**
 * Creates a [Display] element with variant set to [Display.Variants.DISPLAY_1].
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.display1(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display<SPAN>(variant = Display.Variants.DISPLAY_1, classes = classes, block = block)

/**
 * Creates a [Display] element with variant set to [Display.Variants.DISPLAY_2].
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.display2(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display<SPAN>(variant = Display.Variants.DISPLAY_2, classes = classes, block = block)

/**
 * Creates a [Display] element with variant set to [Display.Variants.DISPLAY_3].
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.display3(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display<SPAN>(variant = Display.Variants.DISPLAY_3, classes = classes, block = block)

/**
 * Creates a [Display] element with variant set to [Display.Variants.DISPLAY_4].
 *
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.display4(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display<SPAN>(variant = Display.Variants.DISPLAY_4, classes = classes, block = block)
