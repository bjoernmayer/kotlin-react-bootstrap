package react.bootstrap.components.nav

import react.Component
import react.RBuilder
import react.RElementBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.lib.ElementProvider
import react.bootstrap.lib.NoArgEventHandler
import kotlin.reflect.KClass

class NavBuilder(override val builder: RBuilder) : Builder {
    private fun <P : Navs.Props> RBuilder.buildNav(
        klazz: KClass<out Component<P, *>>,
        classes: String? = null,
        appearance: Navs.Appearance? = null,
        widthHandling: Navs.WidthHandling? = null,
        block: RHandler<P>
    ): ReactElement = child(klazz) {
        attrs {
            this.className = classes
            this.appearance = appearance
            this.widthHandling = widthHandling
        }

        block()
    }

    fun ul(
        classes: String? = null,
        appearance: Navs.Appearance? = null,
        widthHandling: Navs.WidthHandling? = null,
        block: RHandler<Navs.Ul.Props>
    ): ReactElement =
        builder.buildNav(
            klazz = Navs.Ul::class,
            classes = classes,
            appearance = appearance,
            widthHandling = widthHandling,
            block = block
        )

    fun ol(
        classes: String? = null,
        appearance: Navs.Appearance? = null,
        widthHandling: Navs.WidthHandling? = null,
        block: RHandler<Navs.Ol.Props>
    ): ReactElement =
        builder.buildNav(
            klazz = Navs.Ol::class,
            classes = classes,
            appearance = appearance,
            widthHandling = widthHandling,
            block = block
        )

    fun nav(
        classes: String? = null,
        appearance: Navs.Appearance? = null,
        widthHandling: Navs.WidthHandling? = null,
        block: RHandler<Navs.Nav.Props>
    ): ReactElement =
        builder.buildNav(
            klazz = Navs.Nav::class,
            classes = classes,
            appearance = appearance,
            widthHandling = widthHandling,
            block = block
        )

    fun div(
        classes: String? = null,
        appearance: Navs.Appearance? = null,
        widthHandling: Navs.WidthHandling? = null,
        block: RHandler<Navs.Div.Props>
    ): ReactElement =
        builder.buildNav(
            klazz = Navs.Div::class,
            classes = classes,
            appearance = appearance,
            widthHandling = widthHandling,
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
        this.className = classes
    }

    block()
}

fun RElementBuilder<Navs.Ul.Props>.navItem(
    classes: String? = null,
    block: RHandler<NavItems.Li.Props>
): ReactElement = buildNavItem(NavItems.Li::class, classes, block)

fun RElementBuilder<Navs.Ol.Props>.navItem(
    classes: String? = null,
    block: RHandler<NavItems.Li.Props>
): ReactElement = buildNavItem(NavItems.Li::class, classes, block)

fun RElementBuilder<Navs.Nav.Props>.navItem(
    classes: String? = null,
    block: RHandler<NavItems.NavItem.Props>
): ReactElement = buildNavItem(NavItems.NavItem::class, classes, block)

fun RElementBuilder<Navs.Div.Props>.navItem(
    classes: String? = null,
    block: RHandler<NavItems.DivItem.Props>
): ReactElement = buildNavItem(NavItems.DivItem::class, classes, block)

private fun RBuilder.buildNavLink(
    href: String? = null,
    target: String? = null,
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = child(NavLink::class) {
    attrs {
        this.href = href
        this.target = target
        this.active = active
        this.onActive = onActive
        this.disabled = disabled
    }
    block()
}

private fun RBuilder.buildRenderAsNavLink(
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    renderAs: ElementProvider
): ReactElement =
    child(NavLink::class) {
        attrs {
            this.renderAs = renderAs
            this.active = active
            this.onActive = onActive
            this.disabled = disabled
        }
    }

fun RElementBuilder<NavItems.Li.Props>.navLink(
    href: String? = null,
    target: String? = null,
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, target, active, onActive, disabled, block)

fun RElementBuilder<NavItems.Li.Props>.navLink(
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    renderAs: ElementProvider
): ReactElement = buildRenderAsNavLink(active, onActive, disabled, renderAs)

fun RElementBuilder<Navs.Nav.Props>.navLink(
    href: String? = null,
    target: String? = null,
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, target, active, onActive, disabled, block)

fun RElementBuilder<Navs.Nav.Props>.navLink(
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    renderAs: ElementProvider
): ReactElement = buildRenderAsNavLink(active, onActive, disabled, renderAs)

fun RElementBuilder<NavItems.NavItem.Props>.navLink(
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    renderAs: ElementProvider
): ReactElement = buildRenderAsNavLink(active, onActive, disabled, renderAs)

fun RElementBuilder<NavItems.NavItem.Props>.navLink(
    href: String? = null,
    target: String? = null,
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, target, active, onActive, disabled, block)

fun RElementBuilder<Navs.Div.Props>.navLink(
    href: String? = null,
    target: String? = null,
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, target, active, onActive, disabled, block)

fun RElementBuilder<Navs.Div.Props>.navLink(
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    renderAs: ElementProvider
): ReactElement = buildRenderAsNavLink(active, onActive, disabled, renderAs)

fun RElementBuilder<NavItems.DivItem.Props>.navLink(
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    renderAs: ElementProvider
): ReactElement = buildRenderAsNavLink(active, onActive, disabled, renderAs)

fun RElementBuilder<NavItems.DivItem.Props>.navLink(
    href: String? = null,
    target: String? = null,
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, target, active, onActive, disabled, block)
