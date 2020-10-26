package react.bootstrap.content.typography

import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.HtmlInlineTag
import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.WithRendererTag
import react.bootstrap.toClasses
import react.dom.WithClassName
import kotlin.reflect.KClass

class Display : CustomisableComponent<Display.Props, RState>() {
    override fun WithGlobalAttributes.handleProps() {
        classes = props.className.appendClass(props.variant.className).toClasses()!!
    }

    override fun getDefaultRendererTag(): KClass<out HtmlInlineTag> = when (props.variant) {
        Variants.DISPLAY_1 -> H1::class
        Variants.DISPLAY_2 -> H2::class
        Variants.DISPLAY_3 -> H3::class
        Variants.DISPLAY_4 -> H4::class
    }

    enum class Variants(override val className: ClassNames) : ClassNameEnum {
        DISPLAY_1(ClassNames.DISPLAY_1),
        DISPLAY_2(ClassNames.DISPLAY_2),
        DISPLAY_3(ClassNames.DISPLAY_3),
        DISPLAY_4(ClassNames.DISPLAY_4);
    }

    interface Props : WithRendererTag<HtmlInlineTag>, WithClassName {
        var variant: Variants
    }
}

@Suppress("unused")
fun RBuilder.display1(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display(variant = Display.Variants.DISPLAY_1, classes = classes, block = block)

@Suppress("unused")
fun RBuilder.display2(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display(variant = Display.Variants.DISPLAY_2, classes = classes, block = block)

@Suppress("unused")
fun RBuilder.display3(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display(variant = Display.Variants.DISPLAY_3, classes = classes, block = block)

@Suppress("unused")
fun RBuilder.display4(classes: String? = null, block: RHandler<Display.Props>): ReactElement =
    display(variant = Display.Variants.DISPLAY_4, classes = classes, block = block)

fun RBuilder.display(
    variant: Display.Variants,
    rendererTag: KClass<out HtmlInlineTag>? = null,
    classes: String? = null,
    block: RHandler<Display.Props>
): ReactElement = child(Display::class) {
    attrs {
        this.variant = variant
        this.rendererTag = rendererTag
        this.className = classes
    }

    block()
}
