package react.bootstrap.content.typography.display

import kotlinx.html.HtmlInlineTag
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.react.rprops.requireProperties

class Display<T : HtmlInlineTag>(props: Props<T>) : AbstractDOMComponent<T, Display.Props<T>, RState>(props) {
    init {
        props.requireProperties(props::variant)
    }

    override fun buildClasses(): Set<ClassNames> = setOf(props.variant.className)

    enum class Variants(override val className: ClassNames) : ClassNameEnum {
        DISPLAY_1(ClassNames.DISPLAY_1),
        DISPLAY_2(ClassNames.DISPLAY_2),
        DISPLAY_3(ClassNames.DISPLAY_3),
        DISPLAY_4(ClassNames.DISPLAY_4);
    }

    interface Props<T : HtmlInlineTag> : AbstractDOMComponent.Props<T> {
        var variant: Variants
    }
}
