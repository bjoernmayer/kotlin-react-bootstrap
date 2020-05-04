package react.bootstrap.components.alert

import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RState
import react.ReactElement
import react.bootstrap.appendClass
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.dom.WithClassName
import react.dom.button
import react.dom.div
import react.dom.span
import react.setState

class Alert : RComponent<Alert.Props, Alert.State>() {
    private fun onDismiss(event: Event) {
        setState {
            hide = true
        }
    }

    override fun RBuilder.render() {
        val alertClasses = mutableSetOf(ClassNames.ALERT)

        props.variant?.also { alertClasses.add(it.className) }

        if (props.dismissible !== null) {
            alertClasses.add(ClassNames.ALERT_DISMISSIBLE)

            when (props.dismissible) {
                Transition.POP_OUT -> alertClasses.add(ClassNames.SHOW)
                Transition.FADE_OUT -> alertClasses.addAll(listOf(ClassNames.SHOW, ClassNames.FADE))
                Transition.FADE_IN -> alertClasses.add(ClassNames.FADE)
                else -> Unit
            }
        }

        if (state.hide == true) {
            return
        }

        div(props.className.appendClass(alertClasses)) {
            attrs {
                role = "alert"
            }
            children()
            if (props.dismissible !== null) {
                button(type = ButtonType.button, classes = "${ClassNames.CLOSE}") {
                    attrs {
                        onClickFunction = this@Alert::onDismiss
                    }
                    span {
                        attrs {
                            set("aria-hidden", true)
                        }
                        +"×"
                    }
                }
            }
        }
    }

    enum class Variants(override val className: ClassNames) : ClassNameEnum {
        PRIMARY(ClassNames.ALERT_PRIMARY),
        SECONDARY(ClassNames.ALERT_SECONDARY),
        SUCCESS(ClassNames.ALERT_SUCCESS),
        INFO(ClassNames.ALERT_INFO),
        WARNING(ClassNames.ALERT_WARNING),
        DANGER(ClassNames.ALERT_DANGER),
        LIGHT(ClassNames.ALERT_LIGHT),
        DARK(ClassNames.ALERT_DARK);

        val kt = "${Alert::class.simpleName}.${Alert.Variants::class.simpleName}.$name"
    }

    enum class Transition {
        POP_OUT,
        FADE_OUT,
        POP_IN,
        FADE_IN;
    }

    interface Props : WithClassName {
        var variant: Variants?
        var dismissible: Transition?
    }

    interface State : RState {
        var hide: Boolean?
    }
}

fun RBuilder.alert(
    variant: Alert.Variants,
    dismissible: Alert.Transition? = null,
    classes: String? = null,
    block: RHandler<Alert.Props>
): ReactElement = child(Alert::class) {
    attrs {

        this.variant = variant
        this.className = classes
        this.dismissible = dismissible
    }

    block()
}
