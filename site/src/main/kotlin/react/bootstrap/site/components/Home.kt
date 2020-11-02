package react.bootstrap.site.components

import kotlinx.html.P
import react.RProps
import react.bootstrap.content.img
import react.bootstrap.content.typography.lead.lead
import react.bootstrap.content.typography.muted.muted
import react.bootstrap.layout.grid.col.ColAttributes.Orderings.Companion.ORD_2
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.EQ
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_6
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.container
import react.bootstrap.layout.grid.row.RowAttributes.ItemsXs.Companion.CENTER
import react.bootstrap.layout.grid.row.row
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.br
import react.dom.h1
import react.dom.main
import react.functionalComponent
import react.router.dom.routeLink

val Home = functionalComponent<RProps> {
    main("bd-masthead") {
        container {
            row(all = CENTER) {
                col(all = SZ_6, md = SZ_6 ord ORD_2, classes = "${ClassNames.MX_AUTO}") {
                    img(
                        src = logo.default as? String,
                        classes = "${ClassNames.MB_3} ${ClassNames.MB_MD_0} home-logo",
                        fluid = true
                    ) { }
                }
                col(md = SZ_6) {
                    h1(classes = "${ClassNames.MB_3}") { +"Kotlin React Bootstrap" }
                    lead("${ClassNames.MB_4}") {
                        +"The most popular front-end framework"; br { }
                        +"Rebuilt for Kotlin React"
                    }
                    row(classes = "${ClassNames.MX_N2}") {
                        col(lg = EQ, classes = "${ClassNames.PX_2}") {
                            routeLink(PATH_DOCS, className = "btn btn-lg btn-bd-primary rounded-pill w-100 mb-3") {
                                +"Get started"
                            }
                        }
                        col(lg = EQ, classes = "${ClassNames.PX_2}") {
                            routeLink(
                                "${PATH_DOCS}components",
                                className = "btn btn-lg btn-outline-secondary rounded-pill w-100 mb-3"
                            ) {
                                +"Components"
                            }
                        }
                    }

                    muted<P>("${ClassNames.MB_0}") {
                        +"Currently WIP"
                    }
                }
            }
        }
    }
}
