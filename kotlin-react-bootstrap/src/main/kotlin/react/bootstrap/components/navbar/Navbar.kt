package react.bootstrap.components.navbar

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.HtmlInlineTag
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import kotlinx.html.UL
import react.RState
import react.bootstrap.components.common.navs.AbstractNavComponent
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.AbstractDOMComponent
import react.bootstrap.lib.component.DOMComponent
import react.bootstrap.lib.react.rprops.requireProperties
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

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
}
