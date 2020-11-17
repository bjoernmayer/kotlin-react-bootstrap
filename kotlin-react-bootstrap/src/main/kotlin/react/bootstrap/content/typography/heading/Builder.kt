package react.bootstrap.content.typography.heading

import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

/**
 * Creates a generic [Heading].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : DOMTag> RBuilder.heading(
    size: Heading.Sizes,
    classes: String?,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Heading::class as KClass<Heading<T, Heading.Props<T>>>)
    .classes(classes)
    .propHandler {
        this.size = size

        with(props) {
            this@propHandler.handle()
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
inline fun <reified T : DOMTag> RBuilder.h1(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H1, classes, props, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H2].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : DOMTag> RBuilder.h2(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H2, classes, props, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H3].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : DOMTag> RBuilder.h3(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H3, classes, props, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H4].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : DOMTag> RBuilder.h4(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H4, classes, props, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H5].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : DOMTag> RBuilder.h5(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H5, classes, props, block)

/**
 * Creates a [Heading] element with size set to [Heading.Sizes.H6].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : DOMTag> RBuilder.h6(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H6, classes, props, block)
