package react.bootstrap.site.components.docs.components

import react.RBuilder
import react.bootstrap.site.components.docs.Category
import react.bootstrap.site.components.docs.DocumentationPage
import react.bootstrap.site.components.docs.components.alerts.alerts

internal val components = Category(
    "Components",
    "components",
    Components::class
).apply {
    addSubCategory("Alerts", "alerts", RBuilder::alerts)
//                addSubCategory("Badge", "badge")
//                addSubCategory("Breadcrumb", "breadcrumb")
//                addSubCategory("Buttons", "buttons")
//                addSubCategory("Button group", "button-group")
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
//                addSubCategory("Navs", "navs")
//                addSubCategory("Navbar", "navbar")
//                addSubCategory("Pagination", "pagination")
//                addSubCategory("Popovers", "popovers")
//                addSubCategory("Progress", "progress")
//                addSubCategory("Scrollspy", "scrollspy")
//                addSubCategory("Spinners", "spinners")
//                addSubCategory("Toasts", "toasts")
//                addSubCategory("Tooltips", "tooltips")
}

internal class Components : DocumentationPage(components)
