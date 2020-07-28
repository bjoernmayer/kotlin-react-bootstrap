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
import react.bootstrap.lib.ClassNameEnum
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.ElementProvider
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.NoArgEventHandler
import react.bootstrap.lib.WithDomEvents
import react.bootstrap.lib.onTransitionEndFunction
import react.bootstrap.lib.transferDomEvents
import react.bootstrap.utilities.close
import react.children
import react.cloneElement
import react.dom.WithClassName
import react.dom.div
import react.setState
import kotlin.random.Random

class Alert(props: Props) : RComponent<Alert.Props, Alert.State>(props) {
    override fun State.init(props: Props) {
        state = States.SHOWN
    }

    private fun handleDismissle(
        @Suppress("UNUSED_PARAMETER") event: Event,
        originalEventHandler: EventHandler?
    ) {
        if (originalEventHandler is EventHandler) {
            originalEventHandler.invoke(event)
        }

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

    private fun handleTransitionEnd(@Suppress("UNUSED_PARAMETER") event: Event) {
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
            children()

            val alertClasses = mutableSetOf(ClassNames.ALERT)

            props.variant?.also { alertClasses.add(it.className) }

            props.dismissible?.also { dismissibleProps ->
                alertClasses.add(ClassNames.ALERT_DISMISSIBLE)

                if (state.state == States.SHOWN) {
                    alertClasses.add(ClassNames.SHOW)
                }

                if (dismissibleProps.fade == true) {
                    alertClasses.add(ClassNames.FADE)
                    attrs.onTransitionEndFunction = this@Alert::handleTransitionEnd
                }

                val closingElement = cloneElement<WithDomEvents>(
                    dismissibleProps.closeElement ?: RBuilder().close { },
                    jsObject {
                        val origEventHandler = dismissibleProps
                            .closeElement
                            ?.run {
                                val props = this.props.asJsObject()

                                if (props.hasOwnProperty(WithDomEvents::onClick.name)) {
                                    props.unsafeCast<WithDomEvents>().onClick
                                } else {
                                    null
                                }
                            }

                        onClick = {
                            handleDismissle(it, origEventHandler)
                        }
                    }
                )

                if (dismissibleProps.closeElement != null) {
                    childList.replaceCloseElement(closingElement)
                } else {
                    childList.add(closingElement)
                }
            }

            attrs {
                transferDomEvents(props, props::onTransitionEnd)
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
                    props.unsafeCast<CloseElementMarkerProps>().random ==
                        newClosingElement.props.unsafeCast<CloseElementMarkerProps>().random
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
        DANGER(ClassNames.ALERT_DANGER),
        DARK(ClassNames.ALERT_DARK),
        INFO(ClassNames.ALERT_INFO),
        LIGHT(ClassNames.ALERT_LIGHT),
        PRIMARY(ClassNames.ALERT_PRIMARY),
        SECONDARY(ClassNames.ALERT_SECONDARY),
        SUCCESS(ClassNames.ALERT_SUCCESS),
        WARNING(ClassNames.ALERT_WARNING);
    }

    internal interface CloseElementMarkerProps : RProps {
        var random: Int?
    }

    interface Props : WithClassName, WithDomEvents {
        var dismissible: Dismissible?
        var variant: Variants?

        interface Dismissible {
            /**
             * This is the element the user can click on to dismiss the alert.
             *
             * Defaults [react.bootstrap.utilities.Close]
             */
            var closeElement: ReactElement?

            /**
             * When set to *true* the alert fades out, when dismissed.
             *
             * Defaults to *false*
             */
            var fade: Boolean?

            /**
             * This handler is called immediately when the [handleDismissle] handler was called.
             */
            var onClose: NoArgEventHandler?

            /**
             * This handler is called when the alert has been closed (will wait for CSS transitions to complete).
             */
            var onClosed: NoArgEventHandler?
        }
    }

    interface DismissibleProps : Props

    enum class States {
        SHOWN,
        DISMISSING,
        DISMISSED;
    }

    interface State : RState {
        var state: States
    }
}

/**
 * Adds an alert component.
 *
 * This extension function adds an alert component to the given RBuilder.
 * Beware: This alert is not dismissible. To create a dismissible alert, use [dismissibleAlert].
 *
 * @param variant The variant of this alert (primary, secondary, warning, etc.).
 * @param classes Additional CSS classnames for the rendered dom element.
 * @param block handler of type [RElementBuilder] with [Alert.Props] props.
 * @return ReactElement of type [Alert].
 */
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

/**
 * Adds an dismissible alert component.
 *
 * This extension function adds an dismissible alert component to the given RBuilder.
 *
 * @param variant The variant of this alert (primary, secondary, warning, etc.).
 * @param fade If set to `true` the alert will fade out. Defaults to `false`.
 * @param classes Additional CSS classnames for the rendered dom element.
 * @param block handler of type [RElementBuilder] with [Alert.Props] props.
 * @return ReactElement of type [Alert].
 */
fun RBuilder.dismissibleAlert(
    variant: Alert.Variants,
    fade: Boolean? = null,
    classes: String? = null,
    block: RHandler<Alert.DismissibleProps>
): ReactElement = child(Alert::class) {
    attrs {
        this.variant = variant
        this.className = classes

        dismissible = (dismissible ?: jsObject()).apply {
            this.fade = fade
        }
    }

    @Suppress("UNCHECKED_CAST")
    (block as RHandler<Alert.Props>).invoke(this)
}

/**
 * Wrapper for a custom alert closing element.
 *
 * Build whatever close element you like.
 *
 * @param block [RBuilder] block function
 * @return The ceated ReactElement
 */
fun RElementBuilder<Alert.DismissibleProps>.closingElement(block: ElementProvider): ReactElement {
    val element = RBuilder().block()

    // The closing element is marked, to be able to find it in the childlist
    val clone = cloneElement<Alert.CloseElementMarkerProps>(element, jsObject {
        this.random = Random.nextInt()
    })

    attrs {
        dismissible = (dismissible ?: jsObject()).apply {
            closeElement = clone
        }
    }

    return child(clone)
}
