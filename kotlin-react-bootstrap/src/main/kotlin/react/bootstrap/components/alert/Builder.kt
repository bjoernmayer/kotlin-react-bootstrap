@file:Suppress("unused")

package react.bootstrap.components.alert

import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.H6
import kotlinx.html.HtmlBlockTag
import kotlinx.html.SPAN
import react.RBuilder
import react.ReactElement
import react.bootstrap.components.alert.Alert.Dismissible.ClosingElement
import react.bootstrap.components.alert.Alert.Variants.DANGER
import react.bootstrap.components.alert.Alert.Variants.DARK
import react.bootstrap.components.alert.Alert.Variants.INFO
import react.bootstrap.components.alert.Alert.Variants.LIGHT
import react.bootstrap.components.alert.Alert.Variants.PRIMARY
import react.bootstrap.components.alert.Alert.Variants.SECONDARY
import react.bootstrap.components.alert.Alert.Variants.SUCCESS
import react.bootstrap.components.alert.Alert.Variants.WARNING
import react.bootstrap.content.typography.heading.Heading
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.Builder
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.DOMComponent.Companion.domComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.lib.component.SimpleDOMComponent.Companion.simpleDomComponent
import kotlin.reflect.KClass

class AlertBuilder(override val builder: RBuilder) : Builder {
    /**
     * Creates an [Alert.Static] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param classes Space separated list of CSS classes for this element.
     */
    @Suppress("UNCHECKED_CAST")
    fun RBuilder.alert(
        variant: Alert.Variants,
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = alert<DIV>(variant, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : HtmlBlockTag> RBuilder.alert(
        variant: Alert.Variants,
        classes: String? = null,
        props: PropHandler<Alert.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = domComponent(Alert.Static::class as KClass<Alert.Static<T>>)
        .classes(classes)
        .propHandler {
            this.variant = variant
            this.classes = classes.splitClassesToSet()
            this.tag = T::class

            with(props) {
                this@propHandler.handle()
            }
        }
        .domHandler(block)
        .build()

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.DANGER].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun danger(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(DANGER, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.DANGER].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> danger(
        classes: String? = null,
        props: PropHandler<Alert.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(DANGER, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun dark(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(DARK, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> dark(
        classes: String? = null,
        props: PropHandler<Alert.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(DARK, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun info(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(INFO, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> info(
        classes: String? = null,
        props: PropHandler<Alert.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(INFO, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun light(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(LIGHT, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> light(
        classes: String? = null,
        props: PropHandler<Alert.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(LIGHT, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun primary(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(PRIMARY, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> primary(
        classes: String? = null,
        props: PropHandler<Alert.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(PRIMARY, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun secondary(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(SECONDARY, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> secondary(
        classes: String? = null,
        props: PropHandler<Alert.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(SECONDARY, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun success(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(SUCCESS, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> success(
        classes: String? = null,
        props: PropHandler<Alert.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(SUCCESS, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun warning(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(WARNING, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> warning(
        classes: String? = null,
        props: PropHandler<Alert.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(WARNING, classes, props, block)

    val dismissible = DismissibleAlertBuilder(builder)
}

class DismissibleAlertBuilder(override val builder: RBuilder) : Builder {
    /**
     * Creates a dismissible [Alert.Dismissible] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    @Suppress("UNCHECKED_CAST")
    fun RBuilder.alert(
        variant: Alert.Variants,
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>,
    ): ReactElement = alert<DIV>(variant, fade, classes, props, block)

    /**
     * Creates a generic, dismissible [Alert.Dismissible] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : HtmlBlockTag> RBuilder.alert(
        variant: Alert.Variants,
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>,
    ): ReactElement = domComponent(Alert.Dismissible::class as KClass<Alert.Dismissible<T>>)
        .classes(classes)
        .propHandler {
            this.variant = variant
            this.classes = classes.splitClassesToSet()
            this.fade = fade
            this.tag = T::class

            with(props) {
                this@propHandler.handle()
            }
        }
        .domHandler(block)
        .build()

    /**
     * Creates an [Alert.Dismissible] element with *variant* set to [Alert.Variants.DANGER].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun danger(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(DANGER, fade, classes, props, block)

    /**
     * Creates a generic [Alert.Dismissible] element with *variant* set to [Alert.Variants.DANGER].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> danger(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(DANGER, fade, classes, props, block)

    /**
     * Creates an [Alert.Dismissible] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun dark(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(DARK, fade, classes, props, block)

    /**
     * Creates a generic [Alert.Dismissible] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> dark(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(DARK, fade, classes, props, block)

    /**
     * Creates an [Alert.Dismissible] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun info(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(INFO, fade, classes, props, block)

    /**
     * Creates a generic [Alert.Dismissible] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> info(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(INFO, fade, classes, props, block)

    /**
     * Creates an [Alert.Dismissible] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun light(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(LIGHT, fade, classes, props, block)

    /**
     * Creates a generic [Alert.Dismissible] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> light(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(LIGHT, fade, classes, props, block)

    /**
     * Creates an [Alert.Dismissible] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun primary(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(PRIMARY, fade, classes, props, block)

    /**
     * Creates a generic [Alert.Dismissible] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> primary(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(PRIMARY, fade, classes, props, block)

    /**
     * Creates an [Alert.Dismissible] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun secondary(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(SECONDARY, fade, classes, props, block)

    /**
     * Creates a generic [Alert.Dismissible] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> secondary(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(SECONDARY, fade, classes, props, block)

    /**
     * Creates an [Alert.Dismissible] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun success(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(SUCCESS, fade, classes, props, block)

    /**
     * Creates a generic [Alert.Dismissible] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> success(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(SUCCESS, fade, classes, props, block)

    /**
     * Creates an [Alert.Dismissible] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun warning(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = PropHandler { },
        block: AlertDOMHandler<DIV>
    ): ReactElement = builder.alert(WARNING, fade, classes, props, block)

    /**
     * Creates a generic [Alert.Dismissible] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> warning(
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<T>> = PropHandler { },
        block: AlertDOMHandler<T>
    ): ReactElement = builder.alert(WARNING, fade, classes, props, block)
}

val RBuilder.Alerts
    get() = AlertBuilder(this)

// Todo: A minor optimisation: There should be another DomBuilder only for Dismissible to reduce visibility
@Suppress("UNCHECKED_CAST")
fun Alert.DomBuilder<*>.closingElement(
    props: PropHandler<ClosingElement.Props<SPAN>> = PropHandler { },
    block: RDOMHandler<SPAN>
): ReactElement = closingElement<SPAN>(props, block)

// Todo: A minor optimisation: There should be another DomBuilder only for Dismissible to reduce visibility
@Suppress("UNCHECKED_CAST")
inline fun <reified T : DOMTag> Alert.DomBuilder<*>.closingElement(
    props: PropHandler<ClosingElement.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(ClosingElement::class as KClass<ClosingElement<T>>)
    .propHandler(props)
    .domHandler(block)
    .build()

/**
 * Creates a [Alert.Link] element.
 */
fun Alert.DomBuilder<*>.link(
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    props: PropHandler<Alert.Link.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = simpleDomComponent(Alert.Link::class)
    .classes(classes)
    .propHandler(props)
    .domHandler(
        RDOMHandler {
            attrs {
                href?.let {
                    this.href = it
                }

                target?.let {
                    this.target = it
                }
            }

            with(block) {
                this@RDOMHandler.handle()
            }
        }
    )
    .build()

/**
 * Creates a generic [Alert.Heading].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : DOMTag> Alert.DomBuilder<*>.heading(
    size: Heading.Sizes,
    classes: String?,
    props: PropHandler<Heading.Props<T>>,
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Alert.Heading::class as KClass<Alert.Heading<T>>)
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
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h1(
    classes: String? = null,
    props: PropHandler<Heading.Props<H1>> = PropHandler { },
    block: RDOMHandler<H1>
): ReactElement = heading(Heading.Sizes.H1, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H1] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DOMTag> Alert.DomBuilder<*>.h1(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H1, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h2(
    classes: String? = null,
    props: PropHandler<Heading.Props<H2>> = PropHandler { },
    block: RDOMHandler<H2>
): ReactElement = heading(Heading.Sizes.H2, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H2] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DOMTag> Alert.DomBuilder<*>.h2(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H2, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h3(
    classes: String? = null,
    props: PropHandler<Heading.Props<H3>> = PropHandler { },
    block: RDOMHandler<H3>
): ReactElement = heading(Heading.Sizes.H3, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H3] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DOMTag> Alert.DomBuilder<*>.h3(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H3, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h4(
    classes: String? = null,
    props: PropHandler<Heading.Props<H4>> = PropHandler { },
    block: RDOMHandler<H4>
): ReactElement = heading(Heading.Sizes.H4, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H4] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DOMTag> Alert.DomBuilder<*>.h4(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H4, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h5(
    classes: String? = null,
    props: PropHandler<Heading.Props<H5>> = PropHandler { },
    block: RDOMHandler<H5>
): ReactElement = heading(Heading.Sizes.H5, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H5] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DOMTag> Alert.DomBuilder<*>.h5(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H5, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h6(
    classes: String? = null,
    props: PropHandler<Heading.Props<H6>> = PropHandler { },
    block: RDOMHandler<H6>
): ReactElement = heading(Heading.Sizes.H6, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H6] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DOMTag> Alert.DomBuilder<*>.h6(
    classes: String? = null,
    props: PropHandler<Heading.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H6, classes, props, block)
