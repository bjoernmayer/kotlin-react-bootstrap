package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Grid : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Grid system")
        pageLead {
            +"""
Use Bootstrap's powerful mobile-first flexbox grid to build layouts of all shapes and sizes thanks to a twelve column
system, five default responsive tiers and dozens of predefined classes.
            """
        }
        child(HowItWorks::class)
        child(GridOptions::class)
        child(AutoLayoutColumns::class)
        child(ResponsiveClasses::class)
        child(Alignment::class)
        child(Reordering::class)
        child(Combining::class)
    }
}
