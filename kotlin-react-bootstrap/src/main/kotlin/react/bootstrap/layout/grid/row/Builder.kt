@file:Suppress("DuplicatedCode")

package react.bootstrap.layout.grid.row

import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.PropHandler
import react.bootstrap.lib.RDOMHandler
import react.bootstrap.lib.component.AbstractDomComponent.Companion.abstractDomComponent

/**
 * Creates a [Row] element.
 *
 * @param all [RowAttributes] that apply to all screen sizes.
 * @param sm [RowAttributes] that apply to small screen sizes.
 * @param md [RowAttributes] that apply to medium screen sizes.
 * @param lg [RowAttributes] that apply to large screen sizes.
 * @param xl [RowAttributes] that apply to extra-large screen sizes.
 * @param classes Space separated list of CSS classes for this element.
 */
fun RBuilder.row(
    all: RowAttributes? = null,
    sm: RowAttributes? = null,
    md: RowAttributes? = null,
    lg: RowAttributes? = null,
    xl: RowAttributes? = null,
    gutters: Boolean = true,
    classes: String? = null,
    propHandler: PropHandler<Row.Props<DIV>> = { },
    block: RDOMHandler<DIV>
): ReactElement = abstractDomComponent<DIV, Row.Props<DIV>>(Row::class)
    .classes(classes)
    .propHandler {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.gutters = gutters

        propHandler()
    }
    .domHandler(block)
    .build()

inline fun <reified T : CommonAttributeGroupFacade> RBuilder.row(
    all: RowAttributes? = null,
    sm: RowAttributes? = null,
    md: RowAttributes? = null,
    lg: RowAttributes? = null,
    xl: RowAttributes? = null,
    gutters: Boolean = true,
    classes: String? = null,
    crossinline propHandler: PropHandler<Row.Props<T>> = { },
    noinline block: RDOMHandler<T>
): ReactElement = abstractDomComponent<T, Row.Props<T>>(Row::class)
    .classes(classes)
    .propHandler {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.gutters = gutters

        propHandler()
    }
    .domHandler(block)
    .build()
