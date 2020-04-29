package react.bootstrap.site.components.docs

import kotlinx.html.LI
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.addClass
import react.bootstrap.ariaLabel
import react.bootstrap.site.components.PATH_DOCS
import react.bootstrap.site.pathMatches
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.li
import react.dom.nav
import react.dom.ul
import react.router.dom.RouteResultProps
import react.router.dom.navLink
import react.router.dom.routeLink

class Navigation : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        nav("collapse bd-links") {
            attrs { ariaLabel = "Main navigation" }

            Docs.Categories.categories.forEach { category ->
                div("bd-toc-item") {
                    if (pathMatches(
                            props.location.pathname,
                            category.matchProps
                        )
                    ) {
                        addClass("active")
                    }

                    routeLink(
                        "$PATH_DOCS${category.path}/${category.subCategories.first().path}",
                        className = "bd-toc-link"
                    ) {
                        +category.name
                    }

                    ul("nav bd-sidenav") {
                        category.subCategories.forEach { subCategory ->
                            li {
                                if (pathMatches(
                                        props.location.pathname,
                                        subCategory.matchProps
                                    )
                                ) {
                                    markActive()
                                }
                                navLink<RProps>(subCategory.link) {
                                    +subCategory.name
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    companion object {
        fun RDOMBuilder<LI>.markActive() {
            addClass("active", "bd-sidenav-active")
        }
    }
}
