package react.bootstrap.components.nav

import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.Builder
import react.bootstrap.lib.ElementProvider
import react.dom.div
import react.dom.nav
import react.dom.ol
import react.dom.ul

fun RBuilder.nav(
    classes: String? = null,
    appearance: Nav.Appearance? = null,
    widthHandling: Nav.WidthHandling ? = null,
    renderAs: ElementProvider? = null,
    block: RHandler<Nav.Props>
): ReactElement =
    child(Nav::class) {
        attrs {
            this.className = classes
            this.appearance = appearance
            this.widthHandling = widthHandling
            this.renderAs = renderAs
        }

        block()
    }

class NavBuilder(override val builder: RBuilder) : Builder {
    fun ul(
        classes: String? = null,
        appearance: Nav.Appearance? = null,
        widthHandling: Nav.WidthHandling ? = null,
        block: RHandler<Nav.Props>
    ): ReactElement =
        builder.nav(
            classes,
            appearance,
            widthHandling,
            renderAs = { ul { } },
            block = block
        )

    fun ol(
        classes: String? = null,
        appearance: Nav.Appearance? = null,
        widthHandling: Nav.WidthHandling ? = null,
        block: RHandler<Nav.Props>
    ): ReactElement =
        builder.nav(
            classes,
            appearance,
            widthHandling,
            renderAs = { ol { } },
            block = block
        )

    fun nav(
        classes: String? = null,
        appearance: Nav.Appearance? = null,
        widthHandling: Nav.WidthHandling ? = null,
        block: RHandler<Nav.Props>
    ): ReactElement =
        builder.nav(
            classes,
            appearance,
            widthHandling,
            renderAs = { nav { } },
            block = block
        )

    fun div(
        classes: String? = null,
        appearance: Nav.Appearance? = null,
        widthHandling: Nav.WidthHandling ? = null,
        block: RHandler<Nav.Props>
    ): ReactElement =
        builder.nav(
            classes,
            appearance,
            widthHandling,
            renderAs = { div { } },
            block = block
        )
}

val RBuilder.Navs
    get() = NavBuilder(this)
