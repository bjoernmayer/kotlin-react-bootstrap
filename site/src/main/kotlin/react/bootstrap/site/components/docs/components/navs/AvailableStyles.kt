package react.bootstrap.site.components.docs.components.navs

import react.RBuilder
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.Navs.Appearance
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.liveExample

internal class AvailableStyles : SectionComponent() {
    override val title: String = "Available styles"

    override fun RBuilder.render() {
        sectionTitle(section)

        subSectionTitle("Horizontal alignment", section)
        liveExample {
            Navs.ul(classes = "${ClassNames.JUSTIFY_CONTENT_CENTER}") {
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
            Navs.ul(classes = "${ClassNames.JUSTIFY_CONTENT_END}") {
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
        subSectionTitle("Vertical", section)
        liveExample {
            Navs.ul(classes = "${ClassNames.FLEX_COLUMN}") {
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
            Navs.nav(classes = "${ClassNames.FLEX_COLUMN}") {
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
        subSectionTitle("Tabs", section)
        liveExample {
            Navs.ul(appearance = Appearance.TABS) {
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
        subSectionTitle("Pills", section)
        liveExample {
            Navs.ul(appearance = Appearance.PILLS) {
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
    }
}
