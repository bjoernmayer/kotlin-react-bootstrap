package react.bootstrap.site.components

import react.RProps
import react.bootstrap.content.typography.lead
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ItemsXs
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.lib.ClassNames
import react.dom.br
import react.dom.div
import react.dom.h1
import react.functionalComponent
import react.router.dom.routeLink

val Home = functionalComponent<RProps> {
    div("bd-masthead") {
        container {
            row(all = ItemsXs.CENTER) {
                col(md = Sizes.SZ_6) {
                    h1(classes = "${ClassNames.MB_3}") { +"Kotlin React Bootstrap" }
                    lead {
                        +"The most popular front-end framework"; br { }
                        +"Rebuilt for Kotlin React"
                    }
                    row(classes = "${ClassNames.MB_N2}") {
                        col(classes = "${ClassNames.PX_2}") {
                            routeLink(PATH_DOCS, className = "btn btn-lg btn-bd-primary w-100 mb-3") {
                                +"Documentation"
                            }
                        }
                    }
                }
            }
        }
    }
}
