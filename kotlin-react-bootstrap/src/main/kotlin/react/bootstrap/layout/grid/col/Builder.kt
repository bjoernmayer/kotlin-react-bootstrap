package react.bootstrap.layout.grid.col

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

/**
 * Creates a [Col] element.
 *
 * @param classes Space separated list of CSS classes for this element.
 * @param all [ColAttributes] that apply to all screen sizes.
 * @param sm [ColAttributes] that apply to small screen sizes.
 * @param md [ColAttributes] that apply to medium screen sizes.
 * @param lg [ColAttributes] that apply to large screen sizes.
 * @param xl [ColAttributes] that apply to extra-large screen sizes.
 */
@Suppress("UNCHECKED_CAST")
fun RBuilder.col(
    classes: String? = null,
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    props: PropHandler<Col.Props<DIV>> = PropHandler { },
    block: RDOMHandler<DIV>
): ReactElement = col<DIV>(classes, all, sm, md, lg, xl, props, block)

@Suppress("UNCHECKED_CAST")
inline fun <reified T : DOMTag> RBuilder.col(
    classes: String? = null,
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
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

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()
