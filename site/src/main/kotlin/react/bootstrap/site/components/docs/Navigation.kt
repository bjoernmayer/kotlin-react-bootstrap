package react.bootstrap.site.components.docs

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.navItem
import react.bootstrap.helpers.classes
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.kotlinxhtml.addClass
import react.bootstrap.lib.kotlinxhtml.ariaLabel
import react.bootstrap.site.components.PATH_DOCS
import react.bootstrap.site.pathMatches
import react.router.dom.RouteResultProps
import react.router.dom.navLink
import react.router.dom.routeLink

// categories should come in via props
class Navigation : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        Navs.nav(classes = classes(ClassNames.FLEX_COLUMN, ClassNames.STICKY_TOP, "krbd-nav")) {
            attrs { ariaLabel = "Main navigation" }

            Docs.Pages.categories.forEach { category ->
                navItem {
                    val classes = mutableSetOf(ClassNames.NAV_LINK, ClassNames.PY_2, ClassNames.PL_4).apply {
                        if (pathMatches(props.location.pathname, category.matchProps)) {
                            add(ClassNames.ACTIVE)
                        }
                    }

                    routeLink(
                        "$PATH_DOCS${category.path}/${category.pages.first().path}",
                        className = classes(*classes.toTypedArray())
                    ) {
                        +category.name
                    }

                    Navs.nav(classes(ClassNames.FLEX_COLUMN, ClassNames.COLLAPSE, ClassNames.PB_2)) {
                        if (pathMatches(props.location.pathname, category.matchProps)) {
                            addClass("show")
                        }

                        category.pages.forEach { subCategory ->
                            navItem {

                                navLink<RProps>(
                                    subCategory.link,
                                    className = classes(ClassNames.NAV_LINK, ClassNames.PY_2, ClassNames.PL_5)
                                ) {
                                    +subCategory.name
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
