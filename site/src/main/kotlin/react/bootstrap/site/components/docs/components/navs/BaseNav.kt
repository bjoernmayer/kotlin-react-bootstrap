package react.bootstrap.site.components.docs.components.navs

import react.RBuilder
import react.bootstrap.components.nav.Navs
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

            }
        }
    }
}
