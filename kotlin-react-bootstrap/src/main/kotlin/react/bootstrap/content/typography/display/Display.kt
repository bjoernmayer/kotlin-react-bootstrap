package react.bootstrap.content.typography.display

import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.HtmlInlineTag
import kotlinx.html.classes
import react.RState
import react.bootstrap.addOrInit
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.WithRendererTag
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

class Display(props: Props) : CustomisableComponent<HtmlInlineTag, Display.Props, RState>(props) {
    init {
        // These comparison are not senseless. The props are built using kotlin's `dynamic` keyword. Null is a possible
        // value.

        @Suppress("SENSELESS_COMPARISON")
        require(props.variant != null) {
            "Missing property: variant must not be null!"
        }
    }

    override val defaultRendererTag: KClass<out HtmlInlineTag>
        get() = when (props.variant) {
            Variants.DISPLAY_1 -> H1::class
            Variants.DISPLAY_2 -> H2::class
            Variants.DISPLAY_3 -> H3::class
            Variants.DISPLAY_4 -> H4::class
        }

    override fun RDOMBuilder<HtmlInlineTag>.build() {
        attrs {
            loadGlobalAttributes(props)
            classes = props.classes.addOrInit(props.variant.className)
        }
    }

    enum class Variants(override val className: ClassNames) : ClassNameEnum {
        DISPLAY_1(ClassNames.DISPLAY_1),
        DISPLAY_2(ClassNames.DISPLAY_2),
        DISPLAY_3(ClassNames.DISPLAY_3),
        DISPLAY_4(ClassNames.DISPLAY_4);
    }

    interface Props : WithRendererTag<HtmlInlineTag>, WithGlobalAttributes {
        var variant: Variants
    }
}
