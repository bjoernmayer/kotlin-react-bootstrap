package react.bootstrap.components.alert

import kotlinext.js.jsObject
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.splitClassesToSet

class AlertBuilder(override val builder: RBuilder) : Builder {
    /**
     * Creates an [Alert] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param classes Space separated list of CSS classes for this element.
     */
    fun RBuilder.alert(
        variant: Alert.Variants,
        classes: String? = null,
        block: RHandler<Alert.Props>
    ): ReactElement = child(Alert::class) {
        attrs {
            this.variant = variant
            this.classes = classes.splitClassesToSet()
        }

        block()
    }

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.DANGER].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun danger(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.DANGER, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun dark(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.DARK, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun info(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.INFO, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun light(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.LIGHT, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun primary(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.PRIMARY, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun secondary(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.SECONDARY, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun success(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.SUCCESS, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param classes Space separated list of CSS classes for this element.
     */
    fun warning(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.WARNING, classes, block)

    val dismissible = DismissibleAlertBuilder(builder)
}

class DismissibleAlertBuilder(override val builder: RBuilder) : Builder {
    /**
     * Creates a dismissible [Alert] element.
     *
     * @param variant [Alert.Variants] change the styling of the [Alert].
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun RBuilder.alert(
        variant: Alert.Variants,
        fade: Boolean? = null,
        classes: String? = null,
        block: RHandler<Alert.DismissibleProps>
    ): ReactElement = child(Alert::class) {
        attrs {
            this.variant = variant
            this.classes = classes.splitClassesToSet()

            dismissible = (dismissible ?: jsObject()).apply {
                this.fade = fade
            }
        }

        @Suppress("UNCHECKED_CAST")
        (block as RHandler<Alert.Props>).invoke(this)
    }

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.DANGER].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun danger(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.DANGER, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.DARK].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun dark(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.DARK, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.INFO].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun info(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.INFO, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.LIGHT].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun light(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.LIGHT, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.PRIMARY].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun primary(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.PRIMARY, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.SECONDARY].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun secondary(
        fade: Boolean? = null,
        classes: String? = null,
        block: RHandler<Alert.DismissibleProps>
    ): ReactElement =
        builder.alert(Alert.Variants.SECONDARY, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.SUCCESS].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun success(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.SUCCESS, fade, classes, block)

    /**
     * Creates an [Alert] element with *variant* set to [Alert.Variants.WARNING].
     *
     * @param fade When set to *true*, the alert fades out, when dismissed.
     * @param classes Space separated list of CSS classes for this element.
     */
    fun warning(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.WARNING, fade, classes, block)
}

val RBuilder.Alerts
    get() = AlertBuilder(this)
