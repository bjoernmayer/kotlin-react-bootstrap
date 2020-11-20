package react.bootstrap.site.components.docs.components.navbar

import react.RBuilder
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.external.Markdown

internal class HowItWorks : SectionComponent() {
    override val title: String = "How it works"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Here's what you need to know before getting started with the navbar:

- Navbars require a wrapping `navbar { }` with `expand = <<${Breakpoints::class.simpleName}>>` for responsive collapsing
and color scheme classes.
- Navbars and their contents are fluid by default. Use optional containers to limit their horizontal width.
- Use Bootstrap's [spacing](https://getbootstrap.com/docs/4.5/utilities/spacing/) and
[flex](https://getbootstrap.com/docs/4.5/utilities/flex/) utility classes for controlling spacing and alignment within
navbars.

Read on for an example and list of supported sub-components.
            """
        }
    }
}
