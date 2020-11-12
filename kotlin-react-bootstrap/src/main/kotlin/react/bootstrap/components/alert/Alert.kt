package react.bootstrap.components.alert

import kotlinext.js.jsObject
import kotlinx.html.A
import kotlinx.html.HtmlBlockTag
import kotlinx.html.SPAN
import kotlinx.html.js.onClickFunction
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RState
import react.RStatics
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.DomTag
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.NoArgEventHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDomComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.component.DomComponent
import react.bootstrap.lib.kotlinxhtml.onTransitionEndFunction
import react.bootstrap.lib.react.isComponent
import react.bootstrap.lib.react.mapComponents
import react.bootstrap.lib.react.rprops.WithGlobalAttributes
import react.bootstrap.lib.react.rprops.childrenArray
import react.bootstrap.lib.react.rprops.requireProperties
import react.bootstrap.utilities.close.close
import react.dom.RDOMBuilder
import react.setState
import kotlin.reflect.KClass
import react.bootstrap.content.typography.heading.Heading as BaseHeading

sealed class Alert<T : HtmlBlockTag, P : Alert.Props<T>, S : RState>(props: P) : AbstractDomComponent<T, P, S>(props) {
    class Static<T : HtmlBlockTag>(props: Props<T>) : Alert<T, Static.Props<T>, RState>(props) {
        override fun RDOMBuilder<T>.build() {
            attrs {
                role = "alert"
            }

            children()
        }

        interface Props<T : HtmlBlockTag> : Alert.Props<T>
    }

    class Dismissible<T : HtmlBlockTag>(props: Props<T>) : Alert<T, Dismissible.Props<T>, Dismissible.State>(props) {
        override fun State.init(props: Props<T>) {
            state = States.SHOWN
        }

        private fun handleDismissle(event: Event, originalEventHandler: EventHandler?) {
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

            render(props.classes.addOrInit(buildClasses()))
        }

        override fun RDOMBuilder<T>.build() {
            attrs {
                role = "alert"
            }

            // Check if the lib-user added a closingElement manually
            if (props.childrenArray.any { it.isComponent<ClosingElement<*>>() }) {
                childList.addAll(
                    props.childrenArray.mapComponents<ClosingElement.Props<DomTag>, ClosingElement<DomTag>> { _, oldProps ->
                        attrs {
                            this.handler = {
                                // First apply the handler so it applies a possible onClickFunction.
                                oldProps.handler(this)

                                // Then pull out the possible onClick
                                val onClick = attrs["onClick"] as EventHandler?

                                attrs {
                                    onClickFunction = {
                                        // And chain it with the new one
                                        handleDismissle(it, onClick)
                                    }
                                }
                            }
                        }
                    }
                )
            } else {
                children()
                // No [ClosingElement] in the children. So we add one and bind the eventHandler
                abstractDomComponent<SPAN, ClosingElement.Props<SPAN>>(ClosingElement::class)
                    .domHandler {
                        attrs {
                            onClickFunction = { handleDismissle(it, null) }
                        }
                        close { }
                    }
                    .build()
            }

            if (props.fade) {
                // Todo: allow orig event here
                attrs.onTransitionEndFunction = this@Dismissible::handleTransitionEnd
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

        interface Props<T : HtmlBlockTag> : Alert.Props<T> {
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

        class ClosingElement<T : DomTag>(
            props: Props<T>
        ) : AbstractDomComponent<T, ClosingElement.Props<T>, RState>(props) {
            override fun buildClasses(): Set<ClassNames> = emptySet()

            interface Props<T : DomTag> : AbstractDomComponent.Props<T>

            override fun RDOMBuilder<T>.build() {
                children()
            }
        }

        @Suppress("UNCHECKED_CAST")
        companion object : RStatics<Props<HtmlBlockTag>, State, Dismissible<HtmlBlockTag>, Nothing>(
            Dismissible::class as KClass<Dismissible<HtmlBlockTag>>
        ) {
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

    interface Props<T : HtmlBlockTag> : AbstractDomComponent.Props<T> {
        var variant: Variants
    }

    class Link(props: Props) : DomComponent<A, Link.Props, RState>(props, A::class) {
        override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.ALERT_LINK)

        interface Props : WithGlobalAttributes, AbstractDomComponent.Props<A>
    }

    class Heading<T : DomTag>(props: Props<T>) : BaseHeading<T, BaseHeading.Props<T>>(props) {
        override fun buildClasses(): Set<ClassNames> = super.buildClasses().run {
            toMutableSet().apply {
                add(ClassNames.ALERT_HEADING)
            }
        }
    }
}
