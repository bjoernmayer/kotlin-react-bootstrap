package react.bootstrap.site.components.docs

import react.*
import react.bootstrap.layout.grid.ColVariants
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.Home
import react.bootstrap.site.components.docs.content.Content
import react.bootstrap.site.components.docs.layout.Layout
import react.router.dom.RouteResultProps
import react.router.dom.route
import react.router.dom.switch

class Docs : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        row("${ClassNames.FLEX_XL_NOWRAP}") {
            col(setOf(ColVariants.COL_MD_3, ColVariants.COL_XL_2), "bd-sidebar") {
                child(Navigation::class) {
                    attrs {
                        match = props.match
                    }
                }
            }
            col(ColVariants.COL_XL_2, "${ClassNames.D_NONE} ${ClassNames.D_XL_BLOCK} bd-toc") {
            }
            col(
                setOf(ColVariants.COL_MD_9, ColVariants.COL_XL_8),
                "${ClassNames.PY_MD_3} ${ClassNames.PL_MD_5} bd-content"
            ) {
                switch {
                    route("${props.match.path}/layout") { child(Layout) }
                    route<RProps>("${props.match.path}/content") {
                        child(Content::class) {
                            attrs {
                                match = it.match
                            }
                        }
                    }
                    route(props.match.url) { child(Home) }
                }
            }
        }
    }
}
