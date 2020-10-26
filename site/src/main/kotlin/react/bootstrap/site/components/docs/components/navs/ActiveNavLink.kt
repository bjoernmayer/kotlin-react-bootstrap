package react.bootstrap.site.components.docs.components.navs

import react.RBuilder
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.liveExample

internal class ActiveNavLink : SectionComponent() {
    override val title: String = "Active Navlink"

    override fun RBuilder.render() {
        sectionTitle(section)

        liveExample {
            Navs.ul(
                appearance = react.bootstrap.components.nav.Navs.Appearance.PILLS,
                activeLinkPredicate = {
                    it.props.id == "thisOneIsActive"
                }
            ) {
                navItem {
                    navLink(href = "#", active = true) {
                        attrs {
                            id = "thisOneIsActive"
                        }
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
                        +"Disabled"
                    }
                }
            }
        }
    }
}
