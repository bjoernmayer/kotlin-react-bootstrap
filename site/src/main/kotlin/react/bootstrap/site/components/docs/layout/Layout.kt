package react.bootstrap.site.components.docs.layout

import react.bootstrap.site.components.docs.Category
import react.bootstrap.site.components.docs.fixings.CategoryComponent
import react.bootstrap.site.components.docs.layout.grid.Grid
import react.bootstrap.site.components.docs.layout.overview.Overview
import react.bootstrap.site.components.docs.layout.reference.Reference

internal class Layout : CategoryComponent() {
    companion object {
        val component = Category(
            "Layout",
            "layout",
            Layout::class
        ).apply {
            addCategory("Overview", "overview", Overview::class)
            addCategory("Grid", "grid", Grid::class)
            addCategory("Reference", "reference", Reference::class)
        }
    }
}
