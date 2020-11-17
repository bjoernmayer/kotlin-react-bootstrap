@file:Suppress("DuplicatedCode")

package react.bootstrap.layout.grid.row

import kotlinx.html.DIV
import react.RBuilder
import react.ReactElement
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.AbstractDOMComponent.Companion.abstractDomComponent
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import kotlin.reflect.KClass

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
@Suppress("UNCHECKED_CAST")
fun RBuilder.row(
    all: RowAttributes? = null,
    sm: RowAttributes? = null,
    md: RowAttributes? = null,
    lg: RowAttributes? = null,
    xl: RowAttributes? = null,
    gutters: Boolean = true,
    classes: String? = null,
    props: PropHandler<Row.Props<DIV>> = PropHandler { },
    block: RDOMHandler<DIV>
): ReactElement = abstractDomComponent(Row::class as KClass<Row<DIV>>)
    .classes(classes)
    .propHandler {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.gutters = gutters

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()

@Suppress("UNCHECKED_CAST")
inline fun <reified T : DOMTag> RBuilder.row(
    all: RowAttributes? = null,
    sm: RowAttributes? = null,
    md: RowAttributes? = null,
    lg: RowAttributes? = null,
    xl: RowAttributes? = null,
    gutters: Boolean = true,
    classes: String? = null,
    props: PropHandler<Row.Props<T>> = PropHandler { },
    block: RDOMHandler<T>
): ReactElement = abstractDomComponent(Row::class as KClass<Row<T>>)
    .classes(classes)
    .propHandler {
        this.all = all
        this.sm = sm
        this.md = md
        this.lg = lg
        this.xl = xl
        this.gutters = gutters

        with(props) {
            this@propHandler.handle()
        }
    }
    .domHandler(block)
    .build()
