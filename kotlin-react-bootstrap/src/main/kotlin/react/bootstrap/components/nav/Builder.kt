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

//fun RBuilder.nav(
//    classes: String? = null,
//    appearance: Nav.Appearance? = null,
//    widthHandling: Nav.WidthHandling ? = null,
//    renderAs: ElementProvider? = null,
//    block: RHandler<Nav.Props>
//): ReactElement =
//    child(Nav::class) {
//        attrs {
//            this.className = classes
//            this.appearance = appearance
//            this.widthHandling = widthHandling
//            this.renderAs = renderAs
//        }
//
//        block()
//    }

class NavBuilder(override val builder: RBuilder) : Builder {
    fun ul(
        classes: String? = null,
        appearance: Navs.Appearance? = null,
        widthHandling: Navs.WidthHandling? = null,
        block: RHandler<Navs.Ul.Props>
    ): ReactElement =
        builder.buildNav(
            Navs.Ul::class,
            classes,
            appearance,
            widthHandling,
            block
        )

    fun ol(
        classes: String? = null,
        appearance: Navs.Appearance? = null,
        widthHandling: Navs.WidthHandling? = null,
        block: RHandler<Navs.Ol.Props>
    ): ReactElement =
        builder.buildNav(
            Navs.Ol::class,
            classes,
            appearance,
            widthHandling,
            block = block
        )

    fun nav(
        classes: String? = null,
        appearance: Navs.Appearance? = null,
        widthHandling: Navs.WidthHandling? = null,
        block: RHandler<Navs.Nav.Props>
    ): ReactElement =
        builder.buildNav(
            Navs.Nav::class,
            classes,
            appearance,
            widthHandling,
            block = block
        )

    fun div(
        classes: String? = null,
        appearance: Navs.Appearance? = null,
        widthHandling: Navs.WidthHandling? = null,
        block: RHandler<Navs.Div.Props>
    ): ReactElement =
        builder.buildNav(
            Navs.Div::class,
            classes,
            appearance,
            widthHandling,
            block = block
        )
}

val RBuilder.Navs
    get() = NavBuilder(this)

fun RElementBuilder<Navs.Ul.Props>.navItem(
    classes: String? = null,
    block: RHandler<NavItems.Li.Props>
): ReactElement = child(NavItems.Li::class) {
    attrs {
        this.className = classes
    }

    block()
}

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
): ReactElement =
    child(NavLink::class) {
        attrs {
            this.renderAs = renderAs
            this.active = active
            this.onActive = onActive
            this.disabled = disabled
        }
    }

fun RElementBuilder<Navs.Nav.Props>.navLink(
    href: String? = null,
    target: String? = null,
    active: Boolean? = null,
    onActive: NoArgEventHandler? = null,
    disabled: Boolean? = null,
    block: RHandler<NavLink.Props>
): ReactElement = buildNavLink(href, target, active, onActive, disabled, block)
