package react.bootstrap.content.typography.heading

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

/**
 * Creates a generic [Heading].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.heading(
    size: Heading.Sizes,
    classes: String?,
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Heading.Props<T>>(Heading::class)
    .classes(classes)
    .handler {
        attrs {
            this.size = size
        }
    }
    .domHandler(block)
    .build()

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H1].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.h1(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H1, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H2].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.h2(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H2, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H3].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.h3(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H3, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H4].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.h4(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H4, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H5].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.h5(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H5, classes, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H6].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : CommonAttributeGroupFacade> RBuilder.h6(
    classes: String? = null,
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H6, classes, block)
