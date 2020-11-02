package react.bootstrap.components.alert

import kotlinext.js.jsObject
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.splitClassesToSet

class AlertBuilder(override val builder: RBuilder) : Builder {
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

    fun danger(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.DANGER, classes, block)

    fun dark(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.DARK, classes, block)

    fun info(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.INFO, classes, block)

    fun light(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.LIGHT, classes, block)

    fun primary(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.PRIMARY, classes, block)

    fun secondary(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.SECONDARY, classes, block)

    fun success(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.SUCCESS, classes, block)

    fun warning(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(Alert.Variants.WARNING, classes, block)

    val dismissible = DismissibleAlertBuilder(builder)
}

class DismissibleAlertBuilder(override val builder: RBuilder) : Builder {
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

    fun danger(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.DANGER, fade, classes, block)

    fun dark(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.DARK, fade, classes, block)

    fun info(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.INFO, fade, classes, block)

    fun light(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.LIGHT, fade, classes, block)

    fun primary(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.PRIMARY, fade, classes, block)

    fun secondary(
        fade: Boolean? = null,
        classes: String? = null,
        block: RHandler<Alert.DismissibleProps>
    ): ReactElement =
        builder.alert(Alert.Variants.SECONDARY, fade, classes, block)

    fun success(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.SUCCESS, fade, classes, block)

    fun warning(fade: Boolean? = null, classes: String? = null, block: RHandler<Alert.DismissibleProps>): ReactElement =
        builder.alert(Alert.Variants.WARNING, fade, classes, block)
}

val RBuilder.Alerts
    get() = AlertBuilder(this)
