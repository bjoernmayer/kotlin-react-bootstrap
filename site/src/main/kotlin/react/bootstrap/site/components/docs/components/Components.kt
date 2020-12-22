package react.bootstrap.site.components.docs.components

import react.bootstrap.site.components.docs.Category
import react.bootstrap.site.components.docs.components.alerts.Alerts
import react.bootstrap.site.components.docs.components.buttongroup.ButtonGroup
import react.bootstrap.site.components.docs.components.buttons.Buttons
import react.bootstrap.site.components.docs.components.navbar.Navbar
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
            addCategory("Buttons", "buttons", Buttons::class)
            addCategory("Button group", "button-group", ButtonGroup::class)
            addCategory("Navs", "navs", Navs::class)
            addCategory("Navbar", "navbar", Navbar::class)
        }
    }
}
