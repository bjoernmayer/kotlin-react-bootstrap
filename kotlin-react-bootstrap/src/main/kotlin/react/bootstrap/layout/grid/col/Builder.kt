package react.bootstrap.layout.grid.col

import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.lib.ElementProvider

fun RBuilder.col(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    renderAs: ElementProvider? = null,
    classes: String? = null,
    block: RHandler<Col.Props>
): ReactElement = child(Col::class) {
    attrs {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.renderAs = renderAs
        this.className = classes
    }

    block()
}
