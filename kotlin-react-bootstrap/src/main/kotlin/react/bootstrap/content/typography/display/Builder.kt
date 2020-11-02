package react.bootstrap.content.typography.display

import kotlinx.html.HtmlInlineTag
import kotlinx.html.SPAN
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.splitClassesToSet

@Suppress("unused")
fun RBuilder.display1(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display<SPAN>(variant = Display.Variants.DISPLAY_1, classes = classes, block = block)

@Suppress("unused")
fun RBuilder.display2(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display<SPAN>(variant = Display.Variants.DISPLAY_2, classes = classes, block = block)

@Suppress("unused")
fun RBuilder.display3(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display<SPAN>(variant = Display.Variants.DISPLAY_3, classes = classes, block = block)

@Suppress("unused")
fun RBuilder.display4(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display<SPAN>(variant = Display.Variants.DISPLAY_4, classes = classes, block = block)

inline fun <reified TT : HtmlInlineTag> RBuilder.display(
    variant: Display.Variants,
    classes: String? = null,
    crossinline block: RHandler<Display.Props>
): ReactElement = child(Display::class) {
    attrs {
        this.variant = variant
        this.classes = classes.splitClassesToSet()
        this.rendererTag = TT::class
    }

    block()
}
