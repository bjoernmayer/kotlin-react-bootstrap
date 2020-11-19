package react.bootstrap.site.components.docs.components.navbar

import kotlinx.html.A
import kotlinx.html.SPAN
import react.RBuilder
import react.bootstrap.components.navbar.Navbar
import react.bootstrap.components.navbar.brand
import react.bootstrap.components.navbar.navbar
import react.bootstrap.helpers.classes
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.liveExample

internal class SupportedContent : SectionComponent() {
    override val title: String = "Supported content"

    override fun RBuilder.render() {
        sectionTitle()
        liveExample {
            navbar(classes(ClassNames.BG_LIGHT), theme = Navbar.Theme.LIGHT) {
                brand<A> {
                    attrs {
                        href = "#"
                    }
                    +"Navbar"
                }
            }
        }
        liveExample {
            navbar(classes(ClassNames.BG_LIGHT), theme = Navbar.Theme.LIGHT) {
                brand<SPAN>(classes(ClassNames.MB_0, ClassNames.H1)) {
                    +"Navbar"
                }
            }
        }
    }
}
