package react.bootstrap.components.alert

import kotlinext.js.asJsObject
import kotlinext.js.jsObject
import kotlinx.html.classes
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RProps
import react.RState
import react.RStatics
import react.ReactElement
import react.asElementOrNull
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.NoArgEventHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.kotlinxhtml.loadDomEvents
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.kotlinxhtml.onTransitionEndFunction
import react.bootstrap.lib.react.rprops.WithDomEvents
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.childrenArray
import react.bootstrap.utilities.close.close
import react.cloneElement
import react.dom.div
import react.setState

sealed class Alert<PT : Alert.Props, ST : RState>(props: PT) : BootstrapComponent<PT, ST>(props) {
    class Static(props: Props) : Alert<Static.Props, RState>(props) {
        override fun RBuilder.render() {
            div {
                children()

                attrs {
                    loadDomEvents(props)
                    loadGlobalAttributes(props)

                    role = "alert"

                    classes = getComponentClasses()
                }
            }
        }

        interface Props : Alert.Props
    }

    class Dismissible(props: Props) : Alert<Dismissible.Props, Dismissible.State>(props) {
        override fun State.init(props: Props) {
            state = States.SHOWN
        }

        private fun handleDismissle(
            event: Event,
            originalEventHandler: EventHandler?
        ) {
            if (originalEventHandler is EventHandler) {
                originalEventHandler.invoke(event)
            }

            props.onClose?.apply {
                invoke()
            }

            if (props.fade) {
                setState {
                    state = States.DISMISSING
                }

                return
            }

            setState {
                state = States.DISMISSED
            }

            props.onClosed?.apply {
                invoke()
            }
        }

        private fun handleTransitionEnd(@Suppress("UNUSED_PARAMETER") event: Event) {
            // Only react, under the right circumstances
            if (props.fade && state.state == States.DISMISSING) {
                props.onClosed?.apply {
                    invoke()
                }

                setState {
                    state = States.DISMISSED
                }
            }
        }

        override fun buildClasses(): Set<ClassNames> {
            val superClasses = super.buildClasses()

            return superClasses.toMutableSet().apply {
                add(ClassNames.ALERT_DISMISSIBLE)

                if (state.state == States.SHOWN) {
                    add(ClassNames.SHOW)
                }

                if (props.fade) {
                    add(ClassNames.FADE)
                }
            }
        }

        override fun RBuilder.render() {
            if (state.state == States.DISMISSED) {
                return
            }

            div {
                children()

                if (props.fade) {
                    attrs.onTransitionEndFunction = this@Dismissible::handleTransitionEnd
                }

                val closingElement = cloneElement<WithDomEvents>(
                    props.closeElement,
                    jsObject {
                        val origEventHandler = props
                            .closeElement
                            .run {
                                val props = this@Dismissible.props.asJsObject()

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

                if (props.closeElement != defaultCloseElement) {
                    childList.replaceCloseElement(closingElement)
                } else {
                    childList.add(closingElement)
                }

                attrs {
                    loadDomEvents(props, props::onTransitionEnd)
                    loadGlobalAttributes(props)

                    role = "alert"

                    classes = getComponentClasses()
                }
            }
        }

        /**
         * We marked the close element before. Now we find it in the children and replace it
         */
        private fun MutableList<Any>.replaceCloseElement(newClosingElement: ReactElement) {
            val closeElementInChildren = props.childrenArray.indexOfFirst {
                it.asElementOrNull()?.let { el ->
                    val props = el.props.asJsObject()

                    if (props.hasOwnProperty(CloseElementMarkerProps::random.name)) {
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

        internal interface CloseElementMarkerProps : RProps {
            var random: Int?
        }

        enum class States {
            SHOWN,
            DISMISSING,
            DISMISSED;
        }

        interface State : RState {
            var state: States
        }

        interface Props : Alert.Props {
            /**
             * This is the element the user can click on to dismiss the alert.
             *
             * Defaults [react.bootstrap.utilities.close.Close]
             */
            var closeElement: ReactElement

            /**
             * When set to *true* the alert fades out, when dismissed.
             *
             * Defaults to *false*
             */
            var fade: Boolean

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

    init {
        // These comparison are not senseless. The props are built using kotlin's `dynamic` keyword. Null is a possible
        // value.

        @Suppress("SENSELESS_COMPARISON")
        require(props.variant != null) {
            "Missing property: variant must not be null!"
        }
    }

    override fun buildClasses(): Set<ClassNames> = mutableSetOf(ClassNames.ALERT, props.variant.className)

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

    interface Props : WithGlobalAttributes, WithDomEvents {
        var variant: Variants
    }

    /**
     * This special companion must be part of the sealed class. Putting it into [Dismissible] would break things.
     */
    companion object : RStatics<Dismissible.Props, Dismissible.State, Dismissible, Nothing>(Dismissible::class) {
        private val defaultCloseElement = RBuilder().close { }

        init {
            defaultProps = jsObject {
                closeElement = defaultCloseElement
                fade = false
            }
        }
    }
}
