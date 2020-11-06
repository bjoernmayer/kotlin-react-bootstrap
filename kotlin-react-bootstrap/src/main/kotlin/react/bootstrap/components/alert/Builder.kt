package react.bootstrap.components.alert

import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.components.alert.Alert.Variants.DANGER
import react.bootstrap.components.alert.Alert.Variants.DARK
import react.bootstrap.components.alert.Alert.Variants.INFO
import react.bootstrap.components.alert.Alert.Variants.LIGHT
import react.bootstrap.components.alert.Alert.Variants.PRIMARY
import react.bootstrap.components.alert.Alert.Variants.SECONDARY
import react.bootstrap.components.alert.Alert.Variants.SUCCESS
import react.bootstrap.components.alert.Alert.Variants.WARNING
import react.bootstrap.lib.Builder
import react.bootstrap.splitClassesToSet

class AlertBuilder(override val builder: RBuilder) : Builder {
    fun RBuilder.alert(variant: Alert.Variants, classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        child(Alert.Static::class) {
            attrs {
                this.variant = variant
                this.classes = classes.splitClassesToSet()
            }

            block()
        }

    fun danger(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(DANGER, classes, block)

    fun dark(classes: String? = null, block: RHandler<Alert.Props>): ReactElement = builder.alert(DARK, classes, block)

    fun info(classes: String? = null, block: RHandler<Alert.Props>): ReactElement = builder.alert(INFO, classes, block)

    fun light(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(LIGHT, classes, block)

    fun primary(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(PRIMARY, classes, block)

    fun secondary(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(SECONDARY, classes, block)

    fun success(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(SUCCESS, classes, block)

    fun warning(classes: String? = null, block: RHandler<Alert.Props>): ReactElement =
        builder.alert(WARNING, classes, block)

    val dismissible = DismissibleAlertBuilder(builder)
}

class DismissibleAlertBuilder(override val builder: RBuilder) : Builder {
    fun RBuilder.alert(
        variant: Alert.Variants,
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement = child(Alert.Dismissible::class) {
        attrs {
            this.variant = variant
            this.classes = classes.splitClassesToSet()
            this.fade = fade
        }

        block()
    }

    fun danger(fade: Boolean = false, classes: String? = null, block: RHandler<Alert.Dismissible.Props>): ReactElement =
        builder.alert(DANGER, fade, classes, block)

    fun dark(fade: Boolean = false, classes: String? = null, block: RHandler<Alert.Dismissible.Props>): ReactElement =
        builder.alert(DARK, fade, classes, block)

    fun info(fade: Boolean = false, classes: String? = null, block: RHandler<Alert.Dismissible.Props>): ReactElement =
        builder.alert(INFO, fade, classes, block)

    fun light(fade: Boolean = false, classes: String? = null, block: RHandler<Alert.Dismissible.Props>): ReactElement =
        builder.alert(LIGHT, fade, classes, block)

    fun primary(
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement =
        builder.alert(PRIMARY, fade, classes, block)

    fun secondary(
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement =
        builder.alert(SECONDARY, fade, classes, block)

    fun success(
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement =
        builder.alert(SUCCESS, fade, classes, block)

    fun warning(
        fade: Boolean = false,
        classes: String? = null,
        block: RHandler<Alert.Dismissible.Props>
    ): ReactElement =
        builder.alert(WARNING, fade, classes, block)
}

val RBuilder.Alerts
    get() = AlertBuilder(this)
