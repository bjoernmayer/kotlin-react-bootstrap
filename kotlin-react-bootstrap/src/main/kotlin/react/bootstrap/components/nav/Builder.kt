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
import react.bootstrap.lib.PropHandler
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.DomComponent
import react.bootstrap.lib.component.DomComponent.Companion.domComponent
import react.bootstrap.lib.component.SimpleDomComponent.Companion.simpleDomComponent
import kotlin.reflect.KClass

class NavBuilder(override val builder: RBuilder) : Builder {
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
        appearance: NavComponent.Appearance? = null,
        widthHandling: NavComponent.WidthHandling? = null,
        activeLinkPredicate: (ActiveLinkPredicate)? = null,
        props: PropHandler<NavComponent.Ul.Props> = { },
        block: NavDomHandler<UL>
    ): ReactElement =
        builder.domComponent<NavComponent.DomBuilder<UL>, UL, NavComponent.Ul.Props>(NavComponent.Ul::class)
            .classes(classes)
            .propHandler {
                this.appearance = appearance
                this.widthHandling = widthHandling
                this.activeLinkPredicate = activeLinkPredicate
                props()
            }
            .domHandler(block)
            .build()

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
        appearance: NavComponent.Appearance? = null,
        widthHandling: NavComponent.WidthHandling? = null,
        activeLinkPredicate: (ActiveLinkPredicate)? = null,
        props: PropHandler<NavComponent.Ol.Props> = { },
        block: NavDomHandler<OL>
    ): ReactElement =
        builder.domComponent<NavComponent.DomBuilder<OL>, OL, NavComponent.Ol.Props>(NavComponent.Ol::class)
            .classes(classes)
            .propHandler {
                this.appearance = appearance
                this.widthHandling = widthHandling
                this.activeLinkPredicate = activeLinkPredicate
                props()
            }
            .domHandler(block)
            .build()

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
        appearance: NavComponent.Appearance? = null,
        widthHandling: NavComponent.WidthHandling? = null,
        activeLinkPredicate: (ActiveLinkPredicate)? = null,
        props: PropHandler<NavComponent.Nav.Props> = { },
        block: NavDomHandler<NAV>
    ): ReactElement =
        builder.domComponent<NavComponent.DomBuilder<NAV>, NAV, NavComponent.Nav.Props>(NavComponent.Nav::class)
            .classes(classes)
            .propHandler {
                this.appearance = appearance
                this.widthHandling = widthHandling
                this.activeLinkPredicate = activeLinkPredicate
                props()
            }
            .domHandler(block)
            .build()

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
        appearance: NavComponent.Appearance? = null,
        widthHandling: NavComponent.WidthHandling? = null,
        activeLinkPredicate: (ActiveLinkPredicate)? = null,
        props: PropHandler<NavComponent.Div.Props> = { },
        block: NavDomHandler<DIV>
    ): ReactElement =
        builder.domComponent<NavComponent.DomBuilder<DIV>, DIV, NavComponent.Div.Props>(NavComponent.Div::class)
            .classes(classes)
            .propHandler {
                this.appearance = appearance
                this.widthHandling = widthHandling
                this.activeLinkPredicate = activeLinkPredicate
                props()
            }
            .domHandler(block)
            .build()
}

val RBuilder.Navs
    get() = NavBuilder(this)

private inline fun <reified T : HtmlBlockTag, P : NavItems.Props<T>> NavComponent.DomBuilder<*>.buildNavItem(
    klazz: KClass<out DomComponent<NavItems.DomBuilder<T>, T, P, *>>,
    classes: String? = null,
    noinline props: PropHandler<P>,
    noinline block: NavItemDomHandler<T>
) = domComponent<NavItems.DomBuilder<T>, T, P>(klazz)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()

fun NavComponent.DomBuilder<UL>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.Li.Props> = { },
    block: NavItemDomHandler<LI>
): ReactElement = buildNavItem(NavItems.Li::class, classes, props, block)

fun NavComponent.DomBuilder<OL>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.Li.Props> = { },
    block: NavItemDomHandler<LI>
): ReactElement = buildNavItem(NavItems.Li::class, classes, props, block)

fun NavComponent.DomBuilder<NAV>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.DivItem.Props> = { },
    block: NavItemDomHandler<DIV>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, props, block)

fun NavComponent.DomBuilder<DIV>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.DivItem.Props> = { },
    block: NavItemDomHandler<DIV>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, props, block)

private fun RBuilder.buildNavLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = { },
    block: RDOMHandler<A>
): ReactElement = simpleDomComponent(NavLink::class)
    .classes(classes)
    .domHandler {
        attrs {
            href?.let {
                this.href = it
            }

            target?.let {
                this.target = it
            }
        }
        block()
    }
    .propHandler {
        this.active = active
        this.disabled = disabled

        props()
    }
    .build()

fun NavItems.DomBuilder<LI>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, classes, target, active, disabled, props, block)

fun NavComponent.DomBuilder<NAV>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, classes, target, active, disabled, props, block)

fun NavItems.DomBuilder<DIV>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, classes, target, active, disabled, props, block)

fun NavComponent.DomBuilder<DIV>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, classes, target, active, disabled, props, block)
