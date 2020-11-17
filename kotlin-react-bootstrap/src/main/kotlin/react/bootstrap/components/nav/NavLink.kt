package react.bootstrap.components.nav

import kotlinext.js.jsObject
import kotlinx.html.A
import kotlinx.html.tabIndex
import react.RBuilder
import react.RState
import react.RStatics
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.lib.component.SimpleDOMComponent
import react.bootstrap.lib.kotlinxhtml.ariaDisabled
import react.bootstrap.lib.react.rprops.WithActive
import react.bootstrap.lib.react.rprops.WithDisabled
import react.dom.RDOMBuilder
import react.dom.a
import react.setState

class NavLink(props: Props) : SimpleDOMComponent<A, NavLink.Props, NavLink.State>(props, A::class) {
    override fun State.init(props: Props) {
        linkProps = buildLinkProps(props.handler)

        active = props.active

        props.activeLinkPredicate?.apply {
            active = linkProps.isActive()
        }
    }

    private fun buildLinkProps(domHandler: RDOMHandler<A>): A = RBuilder().a {
        with(domHandler) { this@a.handle() }
    }.props.unsafeCast<A>()

    override fun componentDidMount() {
        if (state.active) {
            props.onActive?.invoke()
        }
    }

    override fun componentDidUpdate(prevProps: Props, prevState: State, snapshot: Any) {
        if (prevProps !== props) {
            setState {
                linkProps = buildLinkProps(props.handler)

                active = props.activeLinkPredicate?.run {
                    linkProps.isActive()
                } ?: props.active
            }
        }
        if (!prevState.active && props.active) {
            props.onActive?.invoke()
        }
    }

    override fun buildClasses(): Set<ClassNames> {
        val navLinkClasses = mutableSetOf(
            ClassNames.NAV_LINK
        )

        if (state.active) {
            navLinkClasses.add(ClassNames.ACTIVE)
        }

        if (props.disabled) {
            navLinkClasses.add(ClassNames.DISABLED)
        }

        return navLinkClasses
    }

    override fun RDOMBuilder<A>.build() {
        attrs {
            if (props.disabled) {
                tabIndex = "-1"
                ariaDisabled = true
            }
        }
        addChildren()
    }

    interface Props : WithActive, WithDisabled, SimpleDOMComponent.Props<A> {
        var activeLinkPredicate: ActiveLinkPredicate?
    }

    interface State : RState {
        var active: Boolean
        var linkProps: A
    }

    companion object : RStatics<Props, State, NavLink, Nothing>(NavLink::class) {
        init {
            defaultProps = jsObject {
                active = false
                disabled = false
            }
        }
    }
}
