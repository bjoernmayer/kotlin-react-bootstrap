package react.bootstrap.layout.grid.col

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

/**
 * Creates a [Col] element.
 *
 * @param all [ColAttributes] that apply to all screen sizes.
 * @param sm [ColAttributes] that apply to small screen sizes.
 * @param md [ColAttributes] that apply to medium screen sizes.
 * @param lg [ColAttributes] that apply to large screen sizes.
 * @param xl [ColAttributes] that apply to extra-large screen sizes.
 * @param classes Space separated list of CSS classes for this element.
 */
@Suppress("UNCHECKED_CAST")
fun RBuilder.col(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    classes: String? = null,
    props: PropHandler<Col.Props<DIV>> = PropHandler { },
    block: RDOMHandler<DIV>
): ReactElement = col<DIV>(all, sm, md, lg, xl, classes, props, block)

@Suppress("UNCHECKED_CAST")
inline fun <reified T : DOMTag> RBuilder.col(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    classes: String? = null,
    props: PropHandler<Col.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Col::class as KClass<Col<T>>)
    .classes(classes)
    .propHandler {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.classes = classes.splitClassesToSet()

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()
