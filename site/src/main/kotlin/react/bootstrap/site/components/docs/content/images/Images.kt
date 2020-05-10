package react.bootstrap.site.components.docs.content.images

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.PageComponent

internal class Images : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Images")
        pageLead {
            +"""
Documentation and examples for opting images into responsive behavior (so they never become larger than their parent
elements).
        """
        }
        child(ResponsiveImages::class)
        child(ImageThumbnails::class)
    }
}
