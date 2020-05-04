package react.bootstrap.content.typography

import react.RBuilder
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.RenderAsComponent
import react.bootstrap.lib.WithRenderAs
import react.dom.WithClassName
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4

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
    renderAs: (RBuilder.() -> ReactElement)? = null,
    classes: String? = null,
    block: RHandler<Display.Props>
): ReactElement = child(Display::class) {
    attrs {
        this.variant = variant
        this.renderAs = renderAs
        this.className = classes
    }

    block()
}

class Display : RenderAsComponent<Display.Props, WithClassName, RState>() {
    override fun WithClassName.handleProps() {
        className = props.className.appendClass(props.variant.className)
    }

    override fun RBuilder.getDefaultRenderer(): ReactElement = when (props.variant) {
        Variants.DISPLAY_1 -> h1 { }
        Variants.DISPLAY_2 -> h2 { }
        Variants.DISPLAY_3 -> h3 { }
        Variants.DISPLAY_4 -> h4 { }
    }

    enum class Variants(override val className: ClassNames) : ClassNameEnum {
        DISPLAY_1(ClassNames.DISPLAY_1),
        DISPLAY_2(ClassNames.DISPLAY_2),
        DISPLAY_3(ClassNames.DISPLAY_3),
        DISPLAY_4(ClassNames.DISPLAY_4);

        val kt = "${Display::class.simpleName}.${this::class.simpleName}.$name"
    }

    interface Props : WithRenderAs, WithClassName {
        var variant: Variants
    }
}
