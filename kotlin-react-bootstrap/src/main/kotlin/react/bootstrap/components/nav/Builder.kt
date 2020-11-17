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
        props: PropHandler<NavComponent.Ul.Props> = PropHandler { },
        block: NavDOMHandler<UL>
    ): ReactElement =
        builder.domComponent(NavComponent.Ul::class)
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
        props: PropHandler<NavComponent.Ol.Props> = PropHandler { },
        block: NavDOMHandler<OL>
    ): ReactElement =
        builder.domComponent(NavComponent.Ol::class)
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
        props: PropHandler<NavComponent.Nav.Props> = PropHandler { },
        block: NavDOMHandler<NAV>
    ): ReactElement =
        builder.domComponent(NavComponent.Nav::class)
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
        props: PropHandler<NavComponent.Div.Props> = PropHandler { },
        block: NavDOMHandler<DIV>
    ): ReactElement =
        builder.domComponent(NavComponent.Div::class)
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
}

val RBuilder.Navs
    get() = NavBuilder(this)

private inline fun <reified T : HtmlBlockTag, P : NavItems.Props<T>> NavComponent.DomBuilder<*>.buildNavItem(
    klazz: KClass<out NavItems<T, P>>,
    classes: String? = null,
    props: PropHandler<P>,
    block: NavItemDOMHandler<T>
) = domComponent(klazz)
    .classes(classes)
    .propHandler(props)
    .domHandler(block)
    .build()

fun NavComponent.DomBuilder<UL>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.Li.Props> = PropHandler { },
    block: NavItemDOMHandler<LI>
): ReactElement = buildNavItem(NavItems.Li::class, classes, props, block)

fun NavComponent.DomBuilder<OL>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.Li.Props> = PropHandler { },
    block: NavItemDOMHandler<LI>
): ReactElement = buildNavItem(NavItems.Li::class, classes, props, block)

fun NavComponent.DomBuilder<NAV>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.DivItem.Props> = PropHandler { },
    block: NavItemDOMHandler<DIV>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, props, block)

fun NavComponent.DomBuilder<DIV>.navItem(
    classes: String? = null,
    props: PropHandler<NavItems.DivItem.Props> = PropHandler { },
    block: NavItemDOMHandler<DIV>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, props, block)

private fun RBuilder.buildNavLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
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
    classes: String? = null,
    target: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, classes, target, active, disabled, props, block)

fun NavComponent.DomBuilder<NAV>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, classes, target, active, disabled, props, block)

fun NavItems.DomBuilder<DIV>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, classes, target, active, disabled, props, block)

fun NavComponent.DomBuilder<DIV>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean = false,
    disabled: Boolean = false,
    props: PropHandler<NavLink.Props> = PropHandler { },
    block: RDOMHandler<A>
): ReactElement = buildNavLink(href, classes, target, active, disabled, props, block)
