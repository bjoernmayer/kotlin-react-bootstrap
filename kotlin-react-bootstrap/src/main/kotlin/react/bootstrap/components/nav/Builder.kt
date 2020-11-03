package react.bootstrap.components.nav

import react.Component
import react.RBuilder
import react.RElementBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.splitClassesToSet
import kotlin.reflect.KClass

class NavBuilder(override val builder: RBuilder) : Builder {
    private fun <P : NavComponent.Props> RBuilder.buildNav(
        klazz: KClass<out Component<P, *>>,
        classes: String? = null,
        appearance: NavComponent.Appearance? = null,
        widthHandling: NavComponent.WidthHandling? = null,
        activeLinkPredicate: ((NavLink.Props) -> Boolean)? = null,
        block: RHandler<P>
    ): ReactElement = child(klazz) {
        attrs {
            this.classes = classes.splitClassesToSet()
            this.appearance = appearance
            this.widthHandling = widthHandling
            this.activeLinkPredicate = activeLinkPredicate
        }

        block()
    }

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
        activeLinkPredicate: (NavLink.Props.() -> Boolean)? = null,
        block: RHandler<NavComponent.Ul.Props>
    ): ReactElement =
        builder.buildNav(
            klazz = NavComponent.Ul::class,
            classes = classes,
            appearance = appearance,
            widthHandling = widthHandling,
            activeLinkPredicate = activeLinkPredicate,
            block = block
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
        appearance: NavComponent.Appearance? = null,
        widthHandling: NavComponent.WidthHandling? = null,
        activeLinkPredicate: (NavLink.Props.() -> Boolean)? = null,
        block: RHandler<NavComponent.Ol.Props>
    ): ReactElement =
        builder.buildNav(
            klazz = NavComponent.Ol::class,
            classes = classes,
            appearance = appearance,
            widthHandling = widthHandling,
            activeLinkPredicate = activeLinkPredicate,
            block = block
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
        appearance: NavComponent.Appearance? = null,
        widthHandling: NavComponent.WidthHandling? = null,
        activeLinkPredicate: (NavLink.Props.() -> Boolean)? = null,
        block: RHandler<NavComponent.Nav.Props>
    ): ReactElement =
        builder.buildNav(
            klazz = NavComponent.Nav::class,
            classes = classes,
            appearance = appearance,
            widthHandling = widthHandling,
            activeLinkPredicate = activeLinkPredicate,
            block = block
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
        appearance: NavComponent.Appearance? = null,
        widthHandling: NavComponent.WidthHandling? = null,
        activeLinkPredicate: (NavLink.Props.() -> Boolean)? = null,
        block: RHandler<NavComponent.Div.Props>
    ): ReactElement =
        builder.buildNav(
            klazz = NavComponent.Div::class,
            classes = classes,
            appearance = appearance,
            widthHandling = widthHandling,
            activeLinkPredicate = activeLinkPredicate,
            block = block
        )
}

val RBuilder.Navs
    get() = NavBuilder(this)

private fun <P : NavItems.Props> RBuilder.buildNavItem(
    klazz: KClass<out Component<P, *>>,
    classes: String? = null,
    block: RHandler<P>
) = child(klazz) {
    attrs {
        this.classes = classes.splitClassesToSet()
    }

    block()
}

fun RElementBuilder<NavComponent.Ul.Props>.navItem(
    classes: String? = null,
    block: RHandler<NavItems.Li.Props>
): ReactElement = buildNavItem(NavItems.Li::class, classes, block)

fun RElementBuilder<NavComponent.Ol.Props>.navItem(
    classes: String? = null,
    block: RHandler<NavItems.Li.Props>
): ReactElement = buildNavItem(NavItems.Li::class, classes, block)

fun RElementBuilder<NavComponent.Nav.Props>.navItem(
    classes: String? = null,
    block: RHandler<NavItems.NavItem.Props>
): ReactElement = buildNavItem(NavItems.NavItem::class, classes, block)

fun RElementBuilder<NavComponent.Div.Props>.navItem(
    classes: String? = null,
    block: RHandler<NavItems.DivItem.Props>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, block)

private fun RBuilder.buildNavLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = child(NavLink::class) {
    attrs {
        this.href = href
        this.target = target
        this.active = active
        this.disabled = disabled
        this.classes = classes.splitClassesToSet()
    }
    block()
}

fun RElementBuilder<NavItems.Li.Props>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, classes, target, active, disabled, block)

fun RElementBuilder<NavComponent.Nav.Props>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, classes, target, active, disabled, block)

fun RElementBuilder<NavItems.NavItem.Props>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, classes, target, active, disabled, block)

fun RElementBuilder<NavComponent.Div.Props>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, classes, target, active, disabled, block)

fun RElementBuilder<NavItems.DivItem.Props>.navLink(
    href: String? = null,
    classes: String? = null,
    target: String? = null,
    active: Boolean? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, classes, target, active, disabled, block)
