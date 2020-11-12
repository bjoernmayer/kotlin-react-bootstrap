package react.bootstrap.layout.grid.col

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.helpers.splitClassesToSet
import react.bootstrap.lib.PropHandler
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

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
fun RBuilder.col(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    classes: String? = null,
    propHandler: PropHandler<Col.Props<DIV>> = { },
    block: RDOMHandler<DIV>
): ReactElement = abstractDomComponent<DIV, Col.Props<DIV>>(Col::class)
    .classes(classes)
    .propHandler {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.classes = classes.splitClassesToSet()

        propHandler()
    }
    .domHandler(block)
    .build()

inline fun <reified T : CommonAttributeGroupFacade> RBuilder.col(
    all: ColAttributes? = null,
    sm: ColAttributes? = null,
    md: ColAttributes? = null,
    lg: ColAttributes? = null,
    xl: ColAttributes? = null,
    classes: String? = null,
    crossinline propHandler: PropHandler<Col.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Col.Props<T>>(Col::class)
    .classes(classes)
    .propHandler {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.classes = classes.splitClassesToSet()

        propHandler()
    }
    .domHandler(block)
    .build()
