package react.bootstrap.components.alert

import kotlinext.js.jsObject
import kotlinx.html.A
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.SPAN
import kotlinx.html.classes
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RState
import react.RStatics
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.NoArgEventHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.BootstrapComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.component.CustomisableComponent
import react.bootstrap.lib.component.AbstractDomComponent
import react.bootstrap.lib.kotlinxhtml.loadDomEvents
import react.bootstrap.lib.kotlinxhtml.loadGlobalAttributes
import react.bootstrap.lib.kotlinxhtml.onTransitionEndFunction
import react.bootstrap.lib.react.identifiable.IdentifiableProps
import react.bootstrap.lib.react.identifiable.isComponent
import react.bootstrap.lib.react.identifiable.mapComponents
import react.bootstrap.lib.react.rprops.WithDomEvents
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.childrenArray
import react.bootstrap.lib.react.rprops.requireProperties
import react.bootstrap.utilities.close.close
import react.dom.RDOMBuilder
import react.dom.div
import react.setState
import kotlin.reflect.KClass
import react.bootstrap.content.typography.heading.Heading as BaseHeading

sealed class Alert<PT : Alert.Props, ST : RState>(props: PT) : BootstrapComponent<PT, ST>(props) {
    class Static(props: Props) : Alert<Static.Props, RState>(props) {
        override fun RBuilder.render(rendererClasses: Set<String>) {
            div {
                children()

                attrs {
                    loadDomEvents(props)
                    loadGlobalAttributes(props)

                    role = "alert"

                    classes = rendererClasses
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

        override fun RBuilder.render(rendererClasses: Set<String>) {
            if (state.state == States.DISMISSED) {
                return
            }

            div {
                // Check if the lib-user added a closingElement manually
                if (props.childrenArray.any { it.isComponent<ClosingElement>() }) {
                    childList.addAll(
                        props.childrenArray.mapComponents<ClosingElement.Props, ClosingElement> { _, oldProps ->
                            attrs {
                                onClick = {
                                    handleDismissle(it, oldProps.onClick)
                                }
                            }
                        }
                    )
                } else {
                    children()
                    child(ClosingElement::class) {
                        attrs {
                            onClick = {
                                handleDismissle(it, null)
                            }
                        }
                        close { }
                    }
                }

                if (props.fade) {
                    attrs.onTransitionEndFunction = this@Dismissible::handleTransitionEnd
                }

                attrs {
                    loadDomEvents(props, props::onTransitionEnd)
                    loadGlobalAttributes(props)

                    role = "alert"

                    classes = rendererClasses
                }
            }
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

        class ClosingElement : CustomisableComponent<CommonAttributeGroupFacade, ClosingElement.Props, RState>() {
            override val defaultRendererTag: KClass<out CommonAttributeGroupFacade> = SPAN::class

            interface Props :
                WithGlobalAttributes,
                WithDomEvents,
                IdentifiableProps<ClosingElement>,
                CustomisableComponent.Props<CommonAttributeGroupFacade>

            override fun RDOMBuilder<CommonAttributeGroupFacade>.build() {
                attrs {
                    loadGlobalAttributes(props)
                    loadDomEvents(props)
                }
            }

            companion object : RStatics<Props, RState, ClosingElement, Nothing>(ClosingElement::class) {
                init {
                    defaultProps = jsObject {
                        componentType = ClosingElement::class
                    }
                }
            }
        }

        companion object : RStatics<Props, State, Dismissible, Nothing>(Dismissible::class) {
            init {
                defaultProps = jsObject {
                    fade = false
                }
            }
        }
    }

    init {
        props.requireProperties(props::variant)
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

    class Link(props: Props) : AbstractDomComponent<A, Link.Props, RState>(props) {
        override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.ALERT_LINK)

        interface Props : WithGlobalAttributes, AbstractDomComponent.Props<A>
    }

    class Heading<TT : CommonAttributeGroupFacade>(props: Props<TT>) : BaseHeading<TT>(props) {
        override fun buildClasses(): Set<ClassNames> = super.buildClasses().run {
            toMutableSet().apply {
                add(ClassNames.ALERT_HEADING)
            }
        }
    }
}
