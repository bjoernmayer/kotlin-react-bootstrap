package react.bootstrap.site.components.docs.components.navs

import react.RBuilder
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.liveExample

internal class BaseNav : SectionComponent() {
    override val title: String = "Base nav"

    override fun RBuilder.render() {
        sectionTitle(section)
        // bla
        // bla
        liveExample {
            Navs.ul {
                navItem {
                    navLink(href = "#", active = true) {
                        +"Active"
                    }
                }
                navItem {
                    navLink(href = "#") {
                        +"Link"
                    }
                }
                navItem {
                    navLink(href = "#") {
                        +"Link"
                    }
                }
                navItem {
                    navLink(href = "#", disabled = true) {
                        +"Link"
                    }
                }
            }
        }

        liveExample {
            Navs.nav {
                navLink(href = "#", active = true) {
                    +"Active"
                }
                navLink(href = "#") {
                    +"Link"
                }
                navLink(href = "#") {
                    +"Link"
                }
                navLink(href = "#", disabled = true) {
                    +"Link"
                }
            }
        }

    }
}
