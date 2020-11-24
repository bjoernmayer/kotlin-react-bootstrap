package react.bootstrap.components.navbar

import kotlinext.js.jsObject
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.HtmlInlineTag
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import kotlinx.html.UL
import react.RState
import react.RStatics
import react.bootstrap.components.common.navs.AbstractNavComponent
import react.bootstrap.helpers.classes
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent
import react.bootstrap.lib.component.DOMComponent
import react.bootstrap.lib.component.SimpleDOMComponent
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
import react.dom.span
import kotlin.reflect.KClass

/*
Todo: Collapse
In Navbar: Scan children for a Toggler.
Then scan for collapse.
If no collapse can be found: error

If multiple collapses can be found: collapse all of them

If multiple togglers, then require property to select the right collapse (collapseSelector?)
 */
class Navbar<T : HtmlBlockTag>(
    props: Props<T>
) : DOMComponent<T, NavbarDOMHandler<T>, Navbar.DomBuilder<T>, Navbar.Props<T>, RState>(props, props.tag) {
    init {
        props.requireProperties(props::tag)
    }

    class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): DomBuilder<T> = DomBuilder(builderFactory)

    override fun buildClasses(): Set<ClassNames> {
        val navbarClasses = mutableSetOf(ClassNames.NAVBAR)

        when (props.expand) {
            Breakpoints.ALL -> navbarClasses.add(ClassNames.NAVBAR_EXPAND)
            Breakpoints.SM -> navbarClasses.add(ClassNames.NAVBAR_EXPAND_SM)
            Breakpoints.MD -> navbarClasses.add(ClassNames.NAVBAR_EXPAND_MD)
            Breakpoints.LG -> navbarClasses.add(ClassNames.NAVBAR_EXPAND_LG)
            Breakpoints.XL -> navbarClasses.add(ClassNames.NAVBAR_EXPAND_XL)
            else -> {
                // nothing
            }
        }

        props.theme?.let {
            navbarClasses.add(it.classNames)
        }

        return navbarClasses
    }

    interface Props<T : HtmlBlockTag> : DOMComponent.Props<NavbarDOMHandler<T>> {
        var expand: Breakpoints?
        var theme: Theme?
        var tag: KClass<out T>
    }

    enum class Theme(internal val classNames: ClassNames) {
        LIGHT(ClassNames.NAVBAR_LIGHT),
        DARK(ClassNames.NAVBAR_DARK)
    }

    open class Brand<T : HtmlInlineTag>(props: Props<T>) : AbstractDOMComponent<T, Brand.Props<T>, RState>(props) {
        override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.NAVBAR_BRAND)

        interface Props<T : HtmlInlineTag> : AbstractDOMComponent.Props<T>
    }

    /**
     * @param T Tag to render
     * @param P RProps Type
     */
    sealed class Navigation<T : HtmlBlockTag, P : Navigation.Props<T>>(
        props: P,
        tag: KClass<out T>
    ) : AbstractNavComponent<T, NavbarNavigationDOMHandler<T>, Navigation.DomBuilder<T>, P>(props, tag) {
        class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

        override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): DomBuilder<T> = DomBuilder(builderFactory)

        class Ul(props: Props) : Navigation<UL, Ul.Props>(props, UL::class) {
            override fun DomBuilder<UL>.build() = buildUlOl()

            interface Props : Navigation.Props<UL>
        }

        class Ol(props: Props) : Navigation<OL, Ol.Props>(props, OL::class) {
            override fun DomBuilder<OL>.build() = buildUlOl()

            interface Props : Navigation.Props<OL>
        }

        class Nav(props: Props) : Navigation<NAV, Nav.Props>(props, NAV::class) {
            override fun DomBuilder<NAV>.build() = buildDivItem()

            interface Props : Navigation.Props<NAV>
        }

        class Div(props: Props) : Navigation<DIV, Div.Props>(props, DIV::class) {
            override fun DomBuilder<DIV>.build() = buildDivItem()

            interface Props : Navigation.Props<DIV>
        }

        override fun buildClasses(): Set<ClassNames> = super.buildClasses().toMutableSet().apply {
            add(ClassNames.NAVBAR_NAV)
        }

        interface Props<T : HtmlBlockTag> : AbstractNavComponent.Props<T, NavbarNavigationDOMHandler<T>, DomBuilder<T>>
    }

    class Toggler(props: Props) : SimpleDOMComponent<BUTTON, Toggler.Props, RState>(props, BUTTON::class) {
        override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.NAVBAR_TOGGLER)

        override fun RDOMBuilder<BUTTON>.build() {
            attrs {
                type = ButtonType.button
                ariaLabel = "Toggle navigation"
            }
            if (childrenArray.isEmpty()) {
                span(classes(ClassNames.NAVBAR_TOGGLER_ICON)) { }
            } else {
                addChildren()
            }
        }

        interface Props : SimpleDOMComponent.Props<BUTTON> {
            // todo not Navbar.Props, but collapse props
            var navbarCollapsePredicate: Navbar.Props<*>.() -> Boolean
        }
    }

    class Collapse<T : HtmlBlockTag>(props: Props<T>) : AbstractDOMComponent<T, Collapse.Props<T>, RState>(props) {
        init {
            props.requireProperties(props::id)
        }

        override fun buildClasses(): Set<ClassNames> {
            val collapseClasses = mutableSetOf(ClassNames.NAVBAR_COLLAPSE, ClassNames.COLLAPSE)

            if (props.show) {
                collapseClasses.add(ClassNames.SHOW)
            }

            return collapseClasses
        }

        interface Props<T : HtmlBlockTag> : AbstractDOMComponent.Props<T> {
            var show: Boolean
            var id: String
        }

        @Suppress("UNCHECKED_CAST")
        companion object : RStatics<Props<HtmlBlockTag>, RState, Collapse<HtmlBlockTag>, Nothing>(
            Collapse::class as KClass<Collapse<HtmlBlockTag>>
        ) {
            init {
                defaultProps = jsObject {
                    show = false
                }
            }
        }
    }
}
