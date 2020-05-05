package react.bootstrap.site.components.docs.layout.overview

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Overview : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Overview")
        pageLead {
            +"""
            Components and options for laying out your Bootstrap project, including wrapping containers, a powerful grid
            system, a flexible media object, and responsive utility classes.
        """.trimIndent()
        }
        child(Containers::class)
    }
}
