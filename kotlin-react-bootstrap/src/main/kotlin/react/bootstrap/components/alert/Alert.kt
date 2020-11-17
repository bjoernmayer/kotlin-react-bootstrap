package react.bootstrap.components.alert

import kotlinext.js.jsObject
import kotlinx.html.A
import kotlinx.html.HtmlBlockTag
import kotlinx.html.SPAN
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import kotlinx.html.js.onClickFunction
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RState
import react.RStatics
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.EventHandler
import react.bootstrap.lib.NoArgEventHandler
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.ClassNameEnum
import react.bootstrap.lib.component.DOMComponent
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.lib.component.SimpleDOMComponent
import react.bootstrap.lib.kotlinxhtml.onTransitionEndFunction
import react.bootstrap.lib.react.isComponent
import react.bootstrap.lib.react.onEachComponent
import react.bootstrap.lib.react.rprops.requireProperties
import react.bootstrap.utilities.close.close
import react.dom.RDOMBuilder
import react.setState
import kotlin.reflect.KClass
import react.bootstrap.content.typography.heading.Heading as BaseHeading

sealed class Alert<T : HtmlBlockTag, P : Alert.Props<T>, S : RState>(
    props: P
) : DOMComponent<T, AlertDOMHandler<T>, Alert.DomBuilder<T>, P, S>(props, props.tag) {
    init {
        props.requireProperties(props::tag)
    }

    class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): DomBuilder<T> = DomBuilder(builderFactory)

    class Static<T : HtmlBlockTag>(props: Props<T>) : Alert<T, Static.Props<T>, RState>(props) {
        override fun DomBuilder<T>.build() {
            attrs {
                role = "alert"
            }

            addChildren()
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

        override fun DomBuilder<T>.build() {
            attrs {
                role = "alert"
            }

            // Check if the lib-user added a closingElement manually
            if (childrenArray.any { it.isComponent<ClosingElement<*>>() }) {
                @Suppress("UNCHECKED_CAST")
                childList.addAll(
                    childrenArray
                        .onEachComponent(ClosingElement::class as KClass<ClosingElement<T>>) { _, originalProps ->
                            attrs {
                                this.handler = RDOMHandler {
                                    // First apply the handler so it applies a possible onClickFunction.
                                    with(originalProps.handler) {
                                        this@RDOMHandler.handle()
                                    }

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
                addChildren()
                // No [ClosingElement] in the children. So we add one and bind the eventHandler
                @Suppress("UNCHECKED_CAST")
                abstractDomComponent(ClosingElement::class as KClass<ClosingElement<SPAN>>)
                    .domHandler(
                        RDOMHandler {
                            attrs {
                                onClickFunction = { handleDismissle(it, null) }
                            }
                            close { }
                        }
                    )
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

        class ClosingElement<T : DOMTag>(
            props: Props<T>
        ) : AbstractDOMComponent<T, ClosingElement.Props<T>, RState>(props) {
            override fun buildClasses(): Set<ClassNames> = emptySet()

            interface Props<T : DOMTag> : AbstractDOMComponent.Props<T>
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

    interface Props<T : HtmlBlockTag> : DOMComponent.Props<AlertDOMHandler<T>> {
        var variant: Variants
        var tag: KClass<out T>
    }

    class Link(props: Props) : SimpleDOMComponent<A, Link.Props, RState>(props, A::class) {
        override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.ALERT_LINK)

        interface Props : SimpleDOMComponent.Props<A>
    }

    class Heading<T : DOMTag>(props: Props<T>) : BaseHeading<T, BaseHeading.Props<T>>(props) {
        override fun buildClasses(): Set<ClassNames> = super.buildClasses().run {
            toMutableSet().apply {
                add(ClassNames.ALERT_HEADING)
            }
        }
    }
}
