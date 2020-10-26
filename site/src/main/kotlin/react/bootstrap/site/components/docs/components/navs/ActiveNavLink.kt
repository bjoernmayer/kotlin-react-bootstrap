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

        /*
         This Active Predicate means:


         I need to find the navItems if there are any.
         And in there I need to find NavLinks.

         In the navLinks I have to set a new event handler on the onClick. The handler lives in the nav.
         The handler will just update the "current active" nav link and triggers a rerender.

         Problem here: I had this problem somewhere else already. I need to check if the user already  did set an
         event handler for the click. Then I need to trigger both.

         All in all it's just stuff that I have done already
         */

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
