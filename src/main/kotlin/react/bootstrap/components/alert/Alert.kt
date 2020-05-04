package react.bootstrap.components.alert

import kotlinx.html.DIV
import kotlinx.html.role
import react.RBuilder
import react.RHandler
import react.RPureComponent
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.WithRDOMBuilderBlock
import react.bootstrap.lib.WithRenderAs
import react.dom.WithClassName
import react.dom.div

enum class AlertVariants(override val className: ClassNames) : ClassNameEnum {
    PRIMARY(ClassNames.ALERT_PRIMARY),
    SECONDARY(ClassNames.ALERT_SECONDARY),
    SUCCESS(ClassNames.ALERT_SUCCESS),
    INFO(ClassNames.ALERT_INFO),
    WARNING(ClassNames.ALERT_WARNING),
    DANGER(ClassNames.ALERT_DANGER),
    LIGHT(ClassNames.ALERT_LIGHT),
    DARK(ClassNames.ALERT_DARK);
}

interface AlertProps : WithRenderAs, WithClassName, WithRDOMBuilderBlock<DIV> {
    var variant: AlertVariants?
}

class Alert : RPureComponent<AlertProps, RState>() {

    override fun RBuilder.render() {
        val alertClasses = mutableSetOf(ClassNames.ALERT)

        props.variant?.also { alertClasses.add(it.className) }

        div(props.className.appendClass(alertClasses)) {
            attrs {
                role = "alert"
            }
            children()
        }
    }
}

fun RBuilder.alert(
    variant: AlertVariants,
    classes: String? = null,
    block: RHandler<AlertProps>
): ReactElement = child(Alert::class) {
    attrs {
        this.variant = variant
        this.className = classes
    }

    block()
}
