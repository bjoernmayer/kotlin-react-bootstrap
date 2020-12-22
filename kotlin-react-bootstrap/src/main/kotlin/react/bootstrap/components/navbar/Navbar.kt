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
public class Navbar<T : HtmlBlockTag>(
    props: Props<T>
) : DOMComponent<T, NavbarDOMHandler<T>, Navbar.DomBuilder<T>, Navbar.Props<T>, RState>(props, props.tag) {
    init {
        props.requireProperties(props::tag)
    }

    public class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

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

    public interface Props<T : HtmlBlockTag> : DOMComponent.Props<NavbarDOMHandler<T>> {
        public var expand: Breakpoints?
        public var theme: Theme?
        public var tag: KClass<out T>
    }

    public enum class Theme(internal val classNames: ClassNames) {
        LIGHT(ClassNames.NAVBAR_LIGHT),
        DARK(ClassNames.NAVBAR_DARK)
    }

    public open class Brand<T : HtmlInlineTag>(props: Props<T>) : AbstractDOMComponent<T, Brand.Props<T>, RState>(props) {
        override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.NAVBAR_BRAND)

        public interface Props<T : HtmlInlineTag> : AbstractDOMComponent.Props<T>
    }

    /**
     * @param T Tag to render
     * @param P RProps Type
     */
    public sealed class Navigation<T : HtmlBlockTag, P : Navigation.Props<T>>(
        props: P,
        tag: KClass<out T>
    ) : AbstractNavComponent<T, NavbarNavigationDOMHandler<T>, Navigation.DomBuilder<T>, P>(props, tag) {
        public class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

        override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): DomBuilder<T> = DomBuilder(builderFactory)

        public class Ul(props: Props) : Navigation<UL, Ul.Props>(props, UL::class) {
            override fun DomBuilder<UL>.build(): Unit = buildUlOl()

            public interface Props : Navigation.Props<UL>
        }

        public class Ol(props: Props) : Navigation<OL, Ol.Props>(props, OL::class) {
            override fun DomBuilder<OL>.build(): Unit = buildUlOl()

            public interface Props : Navigation.Props<OL>
        }

        public class Nav(props: Props) : Navigation<NAV, Nav.Props>(props, NAV::class) {
            override fun DomBuilder<NAV>.build(): Unit = buildDivItem()

            public interface Props : Navigation.Props<NAV>
        }

        public class Div(props: Props) : Navigation<DIV, Div.Props>(props, DIV::class) {
            override fun DomBuilder<DIV>.build(): Unit = buildDivItem()

            public interface Props : Navigation.Props<DIV>
        }

        override fun buildClasses(): Set<ClassNames> = super.buildClasses().toMutableSet().apply {
            add(ClassNames.NAVBAR_NAV)
        }

        public interface Props<T : HtmlBlockTag> : AbstractNavComponent.Props<T, NavbarNavigationDOMHandler<T>, DomBuilder<T>>
    }

    public class Toggler(props: Props) : SimpleDOMComponent<BUTTON, Toggler.Props, RState>(props, BUTTON::class) {
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

        public interface Props : SimpleDOMComponent.Props<BUTTON> {
            // todo not Navbar.Props, but collapse props
            public var navbarCollapsePredicate: Navbar.Props<*>.() -> Boolean
        }
    }

    public class Collapse<T : HtmlBlockTag>(props: Props<T>) : AbstractDOMComponent<T, Collapse.Props<T>, RState>(props) {
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

        public interface Props<T : HtmlBlockTag> : AbstractDOMComponent.Props<T> {
            public var show: Boolean
            public var id: String
        }

        @Suppress("UNCHECKED_CAST")
        public companion object : RStatics<Props<HtmlBlockTag>, RState, Collapse<HtmlBlockTag>, Nothing>(
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
