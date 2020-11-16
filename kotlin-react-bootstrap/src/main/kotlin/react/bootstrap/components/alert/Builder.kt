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
import react.bootstrap.lib.DomTag
import react.bootstrap.lib.PropHandler
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.DomComponent.Companion.domComponent
import react.bootstrap.lib.component.SimpleDomComponent.Companion.simpleDomComponent

class AlertBuilder(override val builder: RBuilder) : Builder {
    /**
     * Creates an [Alert.Static] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param classes Space separated list of CSS classes for this element.
     */
    fun RBuilder.alert(
        variant: Alert.Variants,
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
    ): ReactElement = domComponent<Alert.DomBuilder<DIV>, DIV, Alert.Props<DIV>>(Alert.Static::class)
        .classes(classes)
        .propHandler {
            this.variant = variant
            this.classes = classes.splitClassesToSet()
            this.tag = DIV::class

            props()
        }
        .domHandler(block)
        .build()

    /**
     * Creates a generic [Alert.Static] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> RBuilder.alert(
        variant: Alert.Variants,
        classes: String? = null,
        crossinline props: PropHandler<Alert.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement = domComponent<Alert.DomBuilder<T>, T, Alert.Props<T>>(Alert.Static::class)
        .classes(classes)
        .propHandler {
            this.variant = variant
            this.classes = classes.splitClassesToSet()
            this.tag = T::class

            props()
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
        props: PropHandler<Alert.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
    ): ReactElement = builder.alert(DANGER, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.DANGER].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> danger(
        classes: String? = null,
        noinline props: PropHandler<Alert.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement = builder.alert(DANGER, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun dark(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
    ): ReactElement = builder.alert(DARK, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> dark(
        classes: String? = null,
        noinline props: PropHandler<Alert.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement = builder.alert(DARK, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun info(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
    ): ReactElement = builder.alert(INFO, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> info(
        classes: String? = null,
        noinline props: PropHandler<Alert.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement = builder.alert(INFO, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun light(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
    ): ReactElement =
        builder.alert(LIGHT, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> light(
        classes: String? = null,
        noinline props: PropHandler<Alert.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement =
        builder.alert(LIGHT, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun primary(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
    ): ReactElement =
        builder.alert(PRIMARY, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> primary(
        classes: String? = null,
        noinline props: PropHandler<Alert.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement =
        builder.alert(PRIMARY, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun secondary(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
    ): ReactElement =
        builder.alert(SECONDARY, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> secondary(
        classes: String? = null,
        noinline props: PropHandler<Alert.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement =
        builder.alert(SECONDARY, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun success(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
    ): ReactElement =
        builder.alert(SUCCESS, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> success(
        classes: String? = null,
        noinline props: PropHandler<Alert.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement =
        builder.alert(SUCCESS, classes, props, block)

    /**
     * Creates an [Alert.Static] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun warning(
        classes: String? = null,
        props: PropHandler<Alert.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
    ): ReactElement =
        builder.alert(WARNING, classes, props, block)

    /**
     * Creates a generic [Alert.Static] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> warning(
        classes: String? = null,
        noinline props: PropHandler<Alert.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement =
        builder.alert(WARNING, classes, props, block)

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
    fun RBuilder.alert(
        variant: Alert.Variants,
        fade: Boolean = false,
        classes: String? = null,
        props: PropHandler<Alert.Dismissible.Props<DIV>> = { },
        block: AlertDomHandler<DIV>,
    ): ReactElement = domComponent<Alert.DomBuilder<DIV>, DIV, Alert.Dismissible.Props<DIV>>(Alert.Dismissible::class)
        .classes(classes)
        .propHandler {
            this.variant = variant
            this.classes = classes.splitClassesToSet()
            this.fade = fade
            this.tag = DIV::class

            props()
        }
        .domHandler(block)
        .build()

    /**
     * Creates a generic, dismissible [Alert.Dismissible] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     * @param T [HtmlBlockTag] that should be used to render this [Alert]
     */
    inline fun <reified T : HtmlBlockTag> RBuilder.alert(
        variant: Alert.Variants,
        fade: Boolean = false,
        classes: String? = null,
        crossinline props: PropHandler<Alert.Dismissible.Props<T>> = { },
        noinline block: AlertDomHandler<T>,
    ): ReactElement = domComponent<Alert.DomBuilder<T>, T, Alert.Dismissible.Props<T>>(Alert.Dismissible::class)
        .classes(classes)
        .propHandler {
            this.variant = variant
            this.classes = classes.splitClassesToSet()
            this.fade = fade
            this.tag = T::class

            props()
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
        props: PropHandler<Alert.Dismissible.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
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
        noinline props: PropHandler<Alert.Dismissible.Props<T>> = { },
        noinline block: AlertDomHandler<T>
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
        props: PropHandler<Alert.Dismissible.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
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
        noinline props: PropHandler<Alert.Dismissible.Props<T>> = { },
        noinline block: AlertDomHandler<T>
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
        props: PropHandler<Alert.Dismissible.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
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
        noinline props: PropHandler<Alert.Dismissible.Props<T>> = { },
        noinline block: AlertDomHandler<T>
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
        props: PropHandler<Alert.Dismissible.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
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
        noinline props: PropHandler<Alert.Dismissible.Props<T>> = { },
        noinline block: AlertDomHandler<T>
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
        props: PropHandler<Alert.Dismissible.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
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
        noinline props: PropHandler<Alert.Dismissible.Props<T>> = { },
        noinline block: AlertDomHandler<T>
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
        props: PropHandler<Alert.Dismissible.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
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
        noinline props: PropHandler<Alert.Dismissible.Props<T>> = { },
        noinline block: AlertDomHandler<T>
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
        props: PropHandler<Alert.Dismissible.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
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
        noinline props: PropHandler<Alert.Dismissible.Props<T>> = { },
        noinline block: AlertDomHandler<T>
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
        props: PropHandler<Alert.Dismissible.Props<DIV>> = { },
        block: AlertDomHandler<DIV>
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
        noinline props: PropHandler<Alert.Dismissible.Props<T>> = { },
        noinline block: AlertDomHandler<T>
    ): ReactElement = builder.alert(WARNING, fade, classes, props, block)
}

val RBuilder.Alerts
    get() = AlertBuilder(this)

// Todo: A minor optimisation: There should be another DomBuilder only for Dismissible to reduce visibility
fun Alert.DomBuilder<*>.closingElement(
    props: PropHandler<Alert.Dismissible.ClosingElement.Props<SPAN>> = { },
    block: RDOMHandler<SPAN>
): ReactElement = abstractDomComponent<SPAN, Alert.Dismissible.ClosingElement.Props<SPAN>>(
    Alert.Dismissible.ClosingElement::class
)
    .propHandler(props)
    .domHandler(block)
    .build()

// Todo: A minor optimisation: There should be another DomBuilder only for Dismissible to reduce visibility
inline fun <reified T : DomTag> Alert.DomBuilder<*>.closingElement(
    noinline props: PropHandler<Alert.Dismissible.ClosingElement.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Alert.Dismissible.ClosingElement.Props<T>>(
    Alert.Dismissible.ClosingElement::class
)
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
    props: PropHandler<Alert.Link.Props> = { },
    block: RDOMHandler<A>
): ReactElement = simpleDomComponent(Alert.Link::class)
    .classes(classes)
    .propHandler(props)
    .domHandler {
        attrs {
            href?.let {
                this.href = it
            }

            target?.let {
                this.target = it
            }
        }
        block()
    }
    .build()

/**
 * Creates a generic [Alert.Heading].
 *
 * @param T Tag Type to be used to render this [Heading].
 * @param classes Space separated list of CSS classes for this element.
 */
inline fun <reified T : DomTag> Alert.DomBuilder<*>.heading(
    size: Heading.Sizes,
    classes: String?,
    crossinline props: PropHandler<Heading.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Heading.Props<T>>(Alert.Heading::class)
    .classes(classes)
    .propHandler {
        this.size = size

        props()
    }
    .domHandler(block)
    .build()

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h1(
    classes: String? = null,
    props: PropHandler<Heading.Props<H1>> = { },
    block: RDOMHandler<H1>
): ReactElement = heading(Heading.Sizes.H1, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H1] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DomTag> Alert.DomBuilder<*>.h1(
    classes: String? = null,
    crossinline props: PropHandler<Heading.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H1, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h2(
    classes: String? = null,
    props: PropHandler<Heading.Props<H2>> = { },
    block: RDOMHandler<H2>
): ReactElement = heading(Heading.Sizes.H2, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H2] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DomTag> Alert.DomBuilder<*>.h2(
    classes: String? = null,
    crossinline props: PropHandler<Heading.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H2, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h3(
    classes: String? = null,
    props: PropHandler<Heading.Props<H3>> = { },
    block: RDOMHandler<H3>
): ReactElement = heading(Heading.Sizes.H3, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H3] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DomTag> Alert.DomBuilder<*>.h3(
    classes: String? = null,
    crossinline props: PropHandler<Heading.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H3, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h4(
    classes: String? = null,
    props: PropHandler<Heading.Props<H4>> = { },
    block: RDOMHandler<H4>
): ReactElement = heading(Heading.Sizes.H4, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H4] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DomTag> Alert.DomBuilder<*>.h4(
    classes: String? = null,
    crossinline props: PropHandler<Heading.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H4, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h5(
    classes: String? = null,
    props: PropHandler<Heading.Props<H5>> = { },
    block: RDOMHandler<H5>
): ReactElement = heading(Heading.Sizes.H5, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H5] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DomTag> Alert.DomBuilder<*>.h5(
    classes: String? = null,
    crossinline props: PropHandler<Heading.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H5, classes, props, block)

/**
 * Creates a [Alert.Heading] element.
 */
fun Alert.DomBuilder<*>.h6(
    classes: String? = null,
    props: PropHandler<Heading.Props<H6>> = { },
    block: RDOMHandler<H6>
): ReactElement = heading(Heading.Sizes.H6, classes, props, block)

/**
 * Creates a [Alert.Heading] element with [Heading.Sizes.H6] and uses T to render the element.
 *
 * @param T Tag Type that should be used to render this [Alert.Heading]
 */
inline fun <reified T : DomTag> Alert.DomBuilder<*>.h6(
    classes: String? = null,
    crossinline props: PropHandler<Heading.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = heading(Heading.Sizes.H6, classes, props, block)
