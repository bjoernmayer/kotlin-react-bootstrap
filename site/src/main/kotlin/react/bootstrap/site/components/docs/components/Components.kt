package react.bootstrap.site.components.docs.components

import react.bootstrap.site.components.docs.Category
import react.bootstrap.site.components.docs.components.alerts.Alerts
import react.bootstrap.site.components.docs.components.buttongroup.ButtonGroup
import react.bootstrap.site.components.docs.components.buttons.Buttons
import react.bootstrap.site.components.docs.components.navs.Navs
import react.bootstrap.site.components.docs.fixings.CategoryComponent

internal class Components : CategoryComponent() {
    companion object {
        val component = Category(
            "Components",
            "components",
            Components::class
        ).apply {
            addCategory("Alerts", "alerts", Alerts::class)
//                addSubCategory("Badge", "badge")
//                addSubCategory("Breadcrumb", "breadcrumb")
            addCategory("Buttons", "buttons", Buttons::class)
            addCategory("Button group", "button-group", ButtonGroup::class)
//                addSubCategory("Card", "card")
//                addSubCategory("Carousel", "carousel")
//                addSubCategory("Collapse", "collapse")
//                addSubCategory("Dropdowns", "dropdowns")
//                addSubCategory("Forms", "forms")
//                addSubCategory("Input group", "input-group")
//                addSubCategory("Jumbotron", "jumbotron")
//                addSubCategory("List group", "list-group")
//                addSubCategory("Media object", "media-object")
//                addSubCategory("Modal", "modal")
            addCategory("Navs", "navs", Navs::class)
//                addSubCategory("Navbar", "navbar")
//                addSubCategory("Pagination", "pagination")
//                addSubCategory("Popovers", "popovers")
//                addSubCategory("Progress", "progress")
//                addSubCategory("Scrollspy", "scrollspy")
//                addSubCategory("Spinners", "spinners")
//                addSubCategory("Toasts", "toasts")
//                addSubCategory("Tooltips", "tooltips")
        }
    }
}
