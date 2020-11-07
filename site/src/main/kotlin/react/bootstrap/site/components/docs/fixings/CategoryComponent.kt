package react.bootstrap.site.components.docs.fixings

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.site.components.docs.Category
import react.bootstrap.site.components.docs.Docs
import react.router.dom.RouteResultProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch

internal abstract class CategoryComponent :
    RComponent<RouteResultProps<CategoryComponent.Props>, RState>() {
    override fun RBuilder.render() {
        val page = props.match.params.category ?: return

        switch {
            page.pages.forEach { category ->
                route<RProps>(category.link) {
                    child(category.renderer) {
                        attrs {
                            onNewPage = props.match.params.onNewPage
                            onNewSection = props.match.params.onNewSection
                        }
                    }
                }
            }
            route(page.link) {
                redirect(props.location.pathname, page.pages.first().link)
            }
        }
    }

    interface Props : Docs.SectionNavEvents, RProps {
        var category: Category?
    }
}
