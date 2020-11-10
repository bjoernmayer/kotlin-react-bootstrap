package react.bootstrap.content.typography.heading

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.domComponent

/**
 * Creates a generic [Heading].
 *
 * @param TT Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.heading(
    size: Heading.Sizes,
    classes: String?,
    noinline block: RDOMHandler<TT>
): ReactElement {
    val handler: RHandler<Heading.Props<TT>> = {
        attrs {
            this.size = size
        }
    }

    return domComponent(classes, Heading::class, handler, block)
}

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H1].
 *
 * @param TT Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h1(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = heading(Heading.Sizes.H1, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H2].
 *
 * @param TT Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h2(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = heading(Heading.Sizes.H2, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H3].
 *
 * @param TT Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h3(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = heading(Heading.Sizes.H3, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H4].
 *
 * @param TT Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h4(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = heading(Heading.Sizes.H4, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H5].
 *
 * @param TT Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h5(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = heading(Heading.Sizes.H5, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H6].
 *
 * @param TT Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified TT : CommonAttributeGroupFacade> RBuilder.h6(
    classes: String? = null,
    noinline block: RDOMHandler<TT>
): ReactElement = heading(Heading.Sizes.H6, classes, block)
