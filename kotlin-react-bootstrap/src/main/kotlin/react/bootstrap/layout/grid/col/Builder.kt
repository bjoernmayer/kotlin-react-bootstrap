package react.bootstrap.layout.grid.col

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RHandler
import react.ReactElement
import kotlin.reflect.KClass

fun RBuilder.col(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    rendererTag: KClass<out CommonAttributeGroupFacade>? = null,
    classes: String? = null,
    block: RHandler<Col.Props>
): ReactElement = child(Col::class) {
    attrs {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.rendererTag = rendererTag
        this.className = classes
    }

    block()
}
