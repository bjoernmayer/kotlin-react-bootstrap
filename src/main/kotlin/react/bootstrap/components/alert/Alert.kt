package react.bootstrap.components.alert

import kotlinx.html.A
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import kotlinx.html.role
import react.RBuilder
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.ariaLabel
import react.bootstrap.data
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.WithRDOMBuilderBlock
import react.bootstrap.lib.WithRElementBuilderBlock
import react.bootstrap.lib.WithRenderAs
import react.dom.DOMProps
import react.dom.RDOMBuilder
import react.dom.WithClassName
import react.dom.a
import react.dom.button
import react.dom.div
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4
import react.dom.h5
import react.forwardRef
import react.rawForwardRef
import kotlin.text.Typography.times

enum class AlertVariants(override val className: ClassNames): ClassNameEnum {
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

val Alert = forwardRef<AlertProps> { props, ref ->
    val alertProps = props.unsafeCast<AlertProps>()
    val alertClasses = mutableSetOf(ClassNames.ALERT)

    alertProps.variant?.also { alertClasses.add(it.className) }

    div(alertProps.className.appendClass(alertClasses)) {
        attrs {
            role = "alert"
        }
        alertProps.block.invoke(this)
    }
}

fun RBuilder.alert(
    variant: AlertVariants,
    classes: String? = null,
    block: RDOMBuilder<DIV>.() -> Unit
): ReactElement = Alert {
    attrs.variant = variant
    attrs.className = classes
    attrs.block = block
}
