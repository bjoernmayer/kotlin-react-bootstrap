package react.bootstrap.site.components.docs.layout.overview

import react.RProps
import react.bootstrap.site.components.docs.fixings.contentPageLead
import react.bootstrap.site.components.docs.fixings.contentPageTitle
import react.functionalComponent

val Overview = functionalComponent<RProps> {
    contentPageTitle("Overview") { }
    contentPageLead {
        +"Components and options for laying out your Bootstrap project, including wrapping containers, a powerful grid "
        +"system, a flexible media object, and responsive utility classes."
    }
}
