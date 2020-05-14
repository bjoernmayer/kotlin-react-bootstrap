package react.bootstrap.site.components

import react.RBuilder
import react.RProps
import react.bootstrap.content.img
import react.bootstrap.content.typography.lead
import react.bootstrap.content.typography.muted
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.ItemsXs
import react.bootstrap.layout.grid.Orderings
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.main
import react.dom.br
import react.dom.h1
import react.dom.p
import react.functionalComponent
import react.router.dom.routeLink

val Home = functionalComponent<RProps> {
    main("bd-masthead") {
        container {
            row(all = ItemsXs.CENTER) {
                col(all = Sizes.SZ_6, md = Sizes.SZ_6 ord Orderings.ORD_2, classes = "${ClassNames.MX_AUTO}") {
                    img(
                        src = logo.default as? String,
                        classes = "${ClassNames.MB_3} ${ClassNames.MB_MD_0} home-logo",
                        fluid = true
                    ) { }
                }
                col(md = Sizes.SZ_6) {
                    h1(classes = "${ClassNames.MB_3}") { +"Kotlin React Bootstrap" }
                    lead("${ClassNames.MB_4}") {
                        +"The most popular front-end framework"; br { }
                        +"Rebuilt for Kotlin React"
                    }
                    row(classes = "${ClassNames.MX_N2}") {
                        col(lg = Sizes.EQ, classes = "${ClassNames.PX_2}") {
                            routeLink(PATH_DOCS, className = "btn btn-lg btn-bd-primary rounded-pill w-100 mb-3") {
                                +"Get started"
                            }
                        }
                        col(lg = Sizes.EQ, classes = "${ClassNames.PX_2}") {
                            routeLink(
                                "${PATH_DOCS}components",
                                className = "btn btn-lg btn-outline-secondary rounded-pill w-100 mb-3"
                            ) {
                                +"Components"
                            }
                        }
                    }
                    muted(RBuilder::p, "${ClassNames.MB_0}") {
                        +"Currently WIP"
                    }
                }
            }
        }
    }
}
