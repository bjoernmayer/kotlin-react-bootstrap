package react.bootstrap.site.components.docs

import react.RProps
import react.bootstrap.layout.grid.ColVariants
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.Home
import react.bootstrap.site.components.docs.content.Content
import react.bootstrap.site.components.docs.layout.Layout
import react.child
import react.dom.h1
import react.functionalComponent
import react.router.dom.route
import react.router.dom.switch
import react.router.dom.useRouteMatch

val Docs = functionalComponent<RProps> {
    h1 { +"docs und so" }
    console.log(useRouteMatch<RProps>())
    val match = useRouteMatch<RProps>() ?: return@functionalComponent

    row("${ClassNames.FLEX_XL_NOWRAP}") {
        col(setOf(ColVariants.COL_MD_3, ColVariants.COL_XL_2), "bd-sidebar") {
            child(Navigation)
        }
        col(ColVariants.COL_XL_2, "${ClassNames.D_NONE} ${ClassNames.D_XL_BLOCK} bd-toc") {
        }
        col(
            setOf(ColVariants.COL_MD_9, ColVariants.COL_XL_8),
            "${ClassNames.PY_MD_3} ${ClassNames.PL_MD_5} bd-content"
        ) {
            switch {
                route("${match.path}/layout") { child(Layout) }
                route("${match.path}/content") { child(Content) }
                route(match.url) { child(Home) }
            }
        }
    }
}
