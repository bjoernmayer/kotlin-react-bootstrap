package react.bootstrap.site.components.docs.layout

import react.RBuilder
import react.bootstrap.site.components.docs.Category
import react.bootstrap.site.components.docs.DocumentationPage
import react.bootstrap.site.components.docs.layout.grid.grid
import react.bootstrap.site.components.docs.layout.overview.overview

internal val layout = Category(
    "Layout",
    "layout",
    Layout::class
).apply {
    addSubCategory("Overview", "overview", RBuilder::overview)
    addSubCategory("Grid", "grid", RBuilder::grid)
//                addSubCategory("Utilities for layout", "utilities-for-layout")
}

internal class Layout : DocumentationPage(layout)
