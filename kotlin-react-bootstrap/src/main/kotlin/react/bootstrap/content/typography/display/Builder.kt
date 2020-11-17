package react.bootstrap.content.typography.display

import kotlinx.html.HtmlInlineTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

/**
 * Creates a generic [Display].
 *
 * @param T Tag Type to be used to render this [Display].
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : HtmlInlineTag> RBuilder.display(
    variant: Display.Variants,
    classes: String? = null,
    props: PropHandler<Display.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Display::class as KClass<Display<T>>)
    .classes(classes)
    .domHandler(block)
    .propHandler {
        this.variant = variant

        with(props) {
            this@propHandler.handle()
        }
    }
    .build()

/**
 * Creates a [Display] element with variant set to [Display.Variants.DISPLAY_1].
 *
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : HtmlInlineTag> RBuilder.display1(
    classes: String? = null,
    props: PropHandler<Display.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement =
    display(variant = Display.Variants.DISPLAY_1, classes = classes, props = props, block = block)

/**
 * Creates a [Display] element with variant set to [Display.Variants.DISPLAY_2].
 *
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : HtmlInlineTag> RBuilder.display2(
    classes: String? = null,
    props: PropHandler<Display.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement =
    display(variant = Display.Variants.DISPLAY_2, classes = classes, props = props, block = block)

/**
 * Creates a [Display] element with variant set to [Display.Variants.DISPLAY_3].
 *
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : HtmlInlineTag> RBuilder.display3(
    classes: String? = null,
    props: PropHandler<Display.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement =
    display(variant = Display.Variants.DISPLAY_3, classes = classes, props = props, block = block)

/**
 * Creates a [Display] element with variant set to [Display.Variants.DISPLAY_4].
 *
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : HtmlInlineTag> RBuilder.display4(
    classes: String? = null,
    props: PropHandler<Display.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement =
    display(variant = Display.Variants.DISPLAY_4, classes = classes, props = props, block = block)
