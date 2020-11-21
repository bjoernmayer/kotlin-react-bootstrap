package react.bootstrap.components.nav

import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.LI
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.UL
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.lib.component.DOMComponent.Companion.domComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.lib.component.SimpleDOMComponent.Companion.simpleDomComponent
import kotlin.reflect.KClass

class NavigationBuilder(override val builder: RBuilder) : Builder {
    private fun <T : HtmlBlockTag, P : Navigation.Props<T>> buildNav(
        componentKlazz: KClass<out Navigation<T, P>>,
        classes: String?,
        appearance: Navigation.Appearance?,
        widthHandling: Navigation.WidthHandling?,
        activeLinkPredicate: (ActiveLinkPredicate)?,
        props: PropHandler<P>,
        block: NavDOMHandler<T>
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
        props: PropHandler<Navigation.Ul.Props> = PropHandler { },
        block: NavDOMHandler<UL>
    ): ReactElement = buildNav(
        Navigation.Ul::class, classes, appearance, widthHandling, activeLinkPredicate, props, block
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
        props: PropHandler<Navigation.Ol.Props> = PropHandler { },
        block: NavDOMHandler<OL>
    ): ReactElement = buildNav(
        Navigation.Ol::class, classes, appearance, widthHandling, activeLinkPredicate, props, block
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
        props: PropHandler<Navigation.Nav.Props> = PropHandler { },
        block: NavDOMHandler<NAV>
    ): ReactElement = buildNav(
        Navigation.Nav::class, classes, appearance, widthHandling, activeLinkPredicate, props, block
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
        props: PropHandler<Navigation.Div.Props> = PropHandler { },
        block: NavDOMHandler<DIV>
    ): ReactElement = buildNav(
        Navigation.Div::class, classes, appearance, widthHandling, activeLinkPredicate, props, block
    )
}

val RBuilder.Navs
    get() = NavigationBuilder(this)

internal inline fun <reified T : HtmlBlockTag, P : NavItems.Props<T>> RBuilder.buildNavItem(
    klazz: KClass<out NavItems<T, P>>,
    classes: String? = null,
    props: PropHandler<P>,
    block: NavItemDOMHandler<T>
) = domComponent(klazz)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()

fun Navigation.DomBuilder<UL>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.Li.Props> = PropHandler { },
    block: NavItemDOMHandler<LI>
): ReactElement = buildNavItem(NavItems.Li::class, classes, props, block)

fun Navigation.DomBuilder<OL>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.Li.Props> = PropHandler { },
    block: NavItemDOMHandler<LI>
): ReactElement = buildNavItem(NavItems.Li::class, classes, props, block)

fun Navigation.DomBuilder<NAV>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.DivItem.Props> = PropHandler { },
    block: NavItemDOMHandler<DIV>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, props, block)

fun Navigation.DomBuilder<DIV>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.DivItem.Props> = PropHandler { },
    block: NavItemDOMHandler<DIV>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, props, block)

internal fun RBuilder.buildNavLink(
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = simpleDomComponent(NavLink::class)
    .classes(classes)
    .propHandler {
        this.active = active
        this.disabled = disabled

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(
        RDOMHandler {
            attrs {
                href?.let {
                    this.href = it
                }

                target?.let {
                    this.target = it
                }
            }

            with(block) {
                this@RDOMHandler.handle()
            }
        }
    )
    .build()

fun NavItems.DomBuilder<LI>.navLink(
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, target, classes, active, disabled, props, block)

fun Navigation.DomBuilder<NAV>.navLink(
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, target, classes, active, disabled, props, block)

fun NavItems.DomBuilder<DIV>.navLink(
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, target, classes, active, disabled, props, block)

fun Navigation.DomBuilder<DIV>.navLink(
    href: String? = null,
    target: String? = null,
    classes: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, target, classes, active, disabled, props, block)
