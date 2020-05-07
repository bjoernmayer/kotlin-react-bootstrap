package react.bootstrap.components.alert

import kotlinext.js.asJsObject
import kotlinext.js.jsObject
import kotlinx.html.classes
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.Children
import react.RBuilder
import react.RComponent
import react.RElementBuilder
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement
import react.asElementOrNull
import react.bootstrap.lib.ArglessEventHandler
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.WithOnClick
import react.bootstrap.lib.onTransitionEnd
import react.bootstrap.utilities.close
import react.children
import react.cloneElement
import react.dom.WithClassName
import react.dom.div
import react.setState
import kotlin.random.Random

class Alert : RComponent<Alert.Props, Alert.State>() {
    override fun componentDidMount() {
        setState {
            state = States.SHOWN
        }
    }

    private fun onDismiss(@Suppress("UNUSED_PARAMETER") event: Event) {
        props.dismissible?.onClose?.apply {
            invoke()
        }

        if (props.dismissible?.fade == true) {
            setState {
                state = States.DISMISSING
            }

            return
        }

        setState {
            state = States.DISMISSED
        }

        props.dismissible?.onClosed?.apply {
            invoke()
        }
    }

    private fun onTransitionEnd(@Suppress("UNUSED_PARAMETER") event: Event) {
        // Only react, under the right circumstances
        if (props.dismissible?.fade == true && state.state == States.DISMISSING) {
            props.dismissible?.onClosed?.apply {
                invoke()
            }

            setState {
                state = States.DISMISSED
            }
        }
    }

    override fun RBuilder.render() {
        if (state.state == States.DISMISSED) {
            return
        }

        div {
            props.children()

            val alertClasses = mutableSetOf(ClassNames.ALERT)

            props.variant?.also { alertClasses.add(it.className) }

            props.dismissible?.also { dismissibleProps ->
                alertClasses.add(ClassNames.ALERT_DISMISSIBLE)

                if (state.state == States.SHOWN) {
                    alertClasses.add(ClassNames.SHOW)
                }

                if (dismissibleProps.fade == true) {
                    alertClasses.add(ClassNames.FADE)
                    attrs.onTransitionEnd = this@Alert::onTransitionEnd
                }

                val closingElement = cloneElement<WithOnClick>(
                    dismissibleProps.closeElement ?: RBuilder().close { },
                    jsObject {
                        onClick = this@Alert::onDismiss
                    }
                )

                if (dismissibleProps.closeElement != null) {
                    childList.replaceCloseElement(closingElement)
                } else {
                    childList.add(closingElement)
                }
            }

            attrs {
                role = "alert"
                classes = alertClasses.map { it.className }.toSet()
            }
        }
    }

    /**
     * We marked the close element before. Now we find it in the children and replace it
     */
    private fun MutableList<Any>.replaceCloseElement(newClosingElement: ReactElement) {
        val closeElementInChildren = Children.toArray(props.children).indexOfFirst {
            it.asElementOrNull()?.let { el ->
                val props = el.props.asJsObject()

                if (props.hasOwnProperty(CloseElementMarkerProps::random.name)) {
                    @Suppress("UnsafeCastFromDynamic")
                    props.asDynamic().random == newClosingElement.props.asDynamic().random
                } else {
                    false
                }
            } ?: false
        }

        if (closeElementInChildren == -1) {
            error("Given close element could not be found in children.")
        }

        this[closeElementInChildren] = newClosingElement
    }

    @Suppress("unused")
    enum class Variants(override val className: ClassNames) : ClassNameEnum {
        PRIMARY(ClassNames.ALERT_PRIMARY),
        SECONDARY(ClassNames.ALERT_SECONDARY),
        SUCCESS(ClassNames.ALERT_SUCCESS),
        INFO(ClassNames.ALERT_INFO),
        WARNING(ClassNames.ALERT_WARNING),
        DANGER(ClassNames.ALERT_DANGER),
        LIGHT(ClassNames.ALERT_LIGHT),
        DARK(ClassNames.ALERT_DARK);

        val kt = "${Alert::class.simpleName}.${Variants::class.simpleName}.$name"
    }

    interface DismissibleProps : RProps {
        /**
         * When set to *true* the alert fades out, when dismissed.
         *
         * Defaults to *false*
         */
        var fade: Boolean?

        /**
         * This is the element the user can click on to dismiss the alert.
         *
         * Be aware that [WithOnClick.onClick] gets overriden.
         *
         * Defaults [react.bootstrap.utilities.Close]
         */
        var closeElement: ReactElement?

        /**
         * This handler is called immediately when the [onDismiss] handler was called.
         */
        var onClose: ArglessEventHandler?

        /**
         * This handler is called when the alert has been closed (will wait for CSS transitions to complete).
         */
        var onClosed: ArglessEventHandler?
    }

    internal interface CloseElementMarkerProps : RProps {
        var random: Int?
    }

    interface Props : WithClassName {
        var variant: Variants?
        var dismissible: DismissibleProps?
    }

    enum class States {
        SHOWN,
        DISMISSING,
        DISMISSED;
    }

    interface State : RState {
        var state: States
    }
}

fun RBuilder.alert(
    variant: Alert.Variants,
    classes: String? = null,
    block: RHandler<Alert.Props>
): ReactElement = child(Alert::class) {
    attrs {
        this.variant = variant
        this.className = classes
    }

    block()
}

fun RBuilder.dismissibleAlert(
    variant: Alert.Variants,
    fade: Boolean? = null,
    classes: String? = null,
    block: RHandler<Alert.Props>
): ReactElement = child(Alert::class) {
    attrs {
        this.variant = variant
        this.className = classes

        dismissible = (dismissible ?: jsObject()).apply {
            this.fade = fade
        }
    }

    block()
}

fun RElementBuilder<Alert.Props>.closingElement(block: RBuilder.() -> ReactElement) {
    val element = RBuilder().block()

    // The closing element is marked, to be able to find it in the childlist
    val clone = cloneElement<Alert.CloseElementMarkerProps>(element, jsObject {
        this.random = Random.nextInt()
    })

    child(clone)

    attrs {
        dismissible = (dismissible ?: jsObject()).apply {
            closeElement = clone
        }
    }
}
