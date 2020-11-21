package react.bootstrap.components.navbar

import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.HtmlInlineTag
import kotlinx.html.LI
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.UL
import react.RBuilder
import react.ReactElement
import react.bootstrap.components.nav.ActiveLinkPredicate
import react.bootstrap.components.nav.NavItemDOMHandler
import react.bootstrap.components.nav.NavItems
import react.bootstrap.components.nav.NavLink
import react.bootstrap.components.nav.Navigation
import react.bootstrap.components.nav.buildNavItem
import react.bootstrap.components.nav.buildNavLink
import react.bootstrap.lib.Builder
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.DOMComponent.Companion.domComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun RBuilder.navbar(
    classes: String? = null,
    expand: Breakpoints? = null,
    theme: Navbar.Theme? = null,
    props: PropHandler<Navbar.Props<DIV>> = PropHandler { },
    block: NavbarDOMHandler<DIV>
): ReactElement = navbar<DIV>(classes, expand, theme, props, block)

@Suppress("UNCHECKED_CAST")
inline fun <reified T : HtmlBlockTag> RBuilder.navbar(
    classes: String? = null,
    expand: Breakpoints? = null,
    theme: Navbar.Theme? = null,
    props: PropHandler<Navbar.Props<T>> = PropHandler { },
    block: NavbarDOMHandler<T>
): ReactElement = domComponent(Navbar::class as KClass<Navbar<T>>)
    .classes(classes)
    .propHandler {
        tag = T::class

        this.expand = expand
        this.theme = theme

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()

@Suppress("UNCHECKED_CAST")
fun Navbar.DomBuilder<*>.brand(
    classes: String? = null,
    props: PropHandler<Navbar.Brand.Props<A>> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = brand<A>(classes, props, block)

@Suppress("UNCHECKED_CAST")
inline fun <reified T : HtmlInlineTag> Navbar.DomBuilder<*>.brand(
    classes: String? = null,
    props: PropHandler<Navbar.Brand.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Navbar.Brand::class as KClass<Navbar.Brand<T>>)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()

class NavbarNavigationBuilder(override val builder: Navbar.DomBuilder<*>) : Builder {
    private fun <T : HtmlBlockTag, P : Navbar.Navigation.Props<T>> buildNav(
        componentKlazz: KClass<out Navbar.Navigation<T, P>>,
        classes: String?,
        appearance: Navigation.Appearance?,
        widthHandling: Navigation.WidthHandling?,
        activeLinkPredicate: (ActiveLinkPredicate)?,
        props: PropHandler<P>,
        block: NavbarNavigationDOMHandler<T>
    ): ReactElement =
        builder.domComponent(componentKlazz)
            .classes(classes)
            .propHandler {
                this.appearance = appearance
                this.widthHandling = widthHandling
                this.activeLinkPredicate = activeLinkPredicate

                with(props) {
                    this@propHandler.handle()
                }
            }
            .domHandler(block)
            .build()

    /**
     * Creates a ul-based navigation.
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param appearance Set this value to change the appearance of the nav and make it look like Pills or Tabs.
     * @param widthHandling Set this value to change the width handling among the [NavItems] and [NavLink]s of this nav.
     * @param activeLinkPredicate Set this predicate to mark a [NavLink] active
     */
    fun ul(
        classes: String? = null,
        appearance: Navigation.Appearance? = null,
        widthHandling: Navigation.WidthHandling? = null,
        activeLinkPredicate: (ActiveLinkPredicate)? = null,
        props: PropHandler<Navbar.Navigation.Ul.Props> = PropHandler { },
        block: NavbarNavigationDOMHandler<UL>
    ): ReactElement = buildNav(
        Navbar.Navigation.Ul::class, classes, appearance, widthHandling, activeLinkPredicate, props, block
    )

    /**
     * Creates a ol-based navigation.
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param appearance Set this value to change the appearance of the nav and make it look like Pills or Tabs.
     * @param widthHandling Set this value to change the width handling among the [NavItems] and [NavLink]s of this nav.
     * @param activeLinkPredicate Set this predicate to mark a [NavLink] active
     */
    fun ol(
        classes: String? = null,
        appearance: Navigation.Appearance? = null,
        widthHandling: Navigation.WidthHandling? = null,
        activeLinkPredicate: (ActiveLinkPredicate)? = null,
        props: PropHandler<Navbar.Navigation.Ol.Props> = PropHandler { },
        block: NavbarNavigationDOMHandler<OL>
    ): ReactElement = buildNav(
        Navbar.Navigation.Ol::class, classes, appearance, widthHandling, activeLinkPredicate, props, block
    )

    /**
     * Creates a nav-based navigation.
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param appearance Set this value to change the appearance of the nav and make it look like Pills or Tabs.
     * @param widthHandling Set this value to change the width handling among the [NavItems] and [NavLink]s of this nav.
     * @param activeLinkPredicate Set this predicate to mark a [NavLink] active
     */
    fun nav(
        classes: String? = null,
        appearance: Navigation.Appearance? = null,
        widthHandling: Navigation.WidthHandling? = null,
        activeLinkPredicate: (ActiveLinkPredicate)? = null,
        props: PropHandler<Navbar.Navigation.Nav.Props> = PropHandler { },
        block: NavbarNavigationDOMHandler<NAV>
    ): ReactElement = buildNav(
        Navbar.Navigation.Nav::class, classes, appearance, widthHandling, activeLinkPredicate, props, block
    )

    /**
     * Creates a div-based navigation.
     *
     * @param classes Space separated list of CSS classes for this element.
     * @param appearance Set this value to change the appearance of the nav and make it look like Pills or Tabs.
     * @param widthHandling Set this value to change the width handling among the [NavItems] and [NavLink]s of this nav.
     * @param activeLinkPredicate Set this predicate to mark a [NavLink] active
     */
    fun div(
        classes: String? = null,
        appearance: Navigation.Appearance? = null,
        widthHandling: Navigation.WidthHandling? = null,
        activeLinkPredicate: (ActiveLinkPredicate)? = null,
        props: PropHandler<Navbar.Navigation.Div.Props> = PropHandler { },
        block: NavbarNavigationDOMHandler<DIV>
    ): ReactElement = buildNav(
        Navbar.Navigation.Div::class, classes, appearance, widthHandling, activeLinkPredicate, props, block
    )
}

val Navbar.DomBuilder<*>.NavbarNavs
    get() = NavbarNavigationBuilder(this)

fun Navbar.Navigation.DomBuilder<UL>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.Li.Props> = PropHandler { },
    block: NavItemDOMHandler<LI>
): ReactElement = buildNavItem(NavItems.Li::class, classes, props, block)

fun Navbar.Navigation.DomBuilder<OL>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.Li.Props> = PropHandler { },
    block: NavItemDOMHandler<LI>
): ReactElement = buildNavItem(NavItems.Li::class, classes, props, block)

fun Navbar.Navigation.DomBuilder<NAV>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.DivItem.Props> = PropHandler { },
    block: NavItemDOMHandler<DIV>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, props, block)

fun Navbar.Navigation.DomBuilder<DIV>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.DivItem.Props> = PropHandler { },
    block: NavItemDOMHandler<DIV>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, props, block)

fun Navbar.Navigation.DomBuilder<NAV>.navLink(
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, target, classes, active, disabled, props, block)

fun Navbar.Navigation.DomBuilder<DIV>.navLink(
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, target, classes, active, disabled, props, block)
