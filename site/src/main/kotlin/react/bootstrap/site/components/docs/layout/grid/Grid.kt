package react.bootstrap.site.components.docs.layout.grid

import react.RProps
import react.bootstrap.site.components.docs.contentPageLead
import react.bootstrap.site.components.docs.contentPageTitle
import react.functionalComponent

val Grid = functionalComponent<RProps> {
    contentPageTitle { +"Grid system" }
    contentPageLead {
        +"Use our powerful mobile-first flexbox grid to build layouts of all shapes and sizes thanks to a twelve column"
        +"system, five default responsive tiers, Sass variables and mixins, and dozens of predefined classes."
    }
    howItWorks()
}
