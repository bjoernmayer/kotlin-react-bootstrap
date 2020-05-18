package react.bootstrap.layout.grid.row

import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.row(
    all: RowAttributes? = null,
    sm: RowAttributes? = null,
    md: RowAttributes? = null,
    lg: RowAttributes? = null,
    xl: RowAttributes? = null,
    gutters: Boolean = true,
    renderAs: (RBuilder.() -> ReactElement)? = null,
    classes: String? = null,
    block: RHandler<Row.Props>
): ReactElement = child(Row::class) {
    attrs {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.gutters = gutters
        this.renderAs = renderAs
        this.className = classes
    }

    block()
}
