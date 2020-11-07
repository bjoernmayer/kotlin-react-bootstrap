package react.bootstrap.layout.grid.col

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.RHandler
import react.ReactElement
import react.bootstrap.splitClassesToSet
import kotlin.reflect.KClass

/**
 * Notes:
 * As soon as Kotlin supports default type values, those methods can be made generic.
 */

/**
 * Creates a [Col] element.
 *
 * @param all [ColAttributes] that apply to all screen sizes.
 * @param sm [ColAttributes] that apply to small screen sizes.
 * @param md [ColAttributes] that apply to medium screen sizes.
 * @param lg [ColAttributes] that apply to large screen sizes.
 * @param xl [ColAttributes] that apply to extra-large screen sizes.
 * @param rendererTag [KClass] of a tag that should be used to render this [Col].
 * @param classes Space separated list of CSS classes for this element.
 */
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
        this.classes = classes.splitClassesToSet()
    }

    block()
}
