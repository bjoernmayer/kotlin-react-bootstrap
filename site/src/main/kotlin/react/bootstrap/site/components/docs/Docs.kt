package react.bootstrap.site.components.docs

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.lib.ClassNames
// import react.bootstrap.site.components.docs.about.About
// import react.bootstrap.site.components.docs.components.Components
import react.bootstrap.site.components.docs.content.Content
// import react.bootstrap.site.components.docs.extend.Extend
// import react.bootstrap.site.components.docs.gettingstarted.GettingStarted
import react.bootstrap.site.components.docs.layout.Layout
// import react.bootstrap.site.components.docs.utilities.Utilities
import react.router.dom.RouteResultProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch

class Docs : RComponent<RouteResultProps<RProps>, RState>() {
    override fun RBuilder.render() {
        row(classes = "${ClassNames.FLEX_XL_NOWRAP}") {
            col(md = Sizes.SZ_3, xl = Sizes.SZ_2, classes = "bd-sidebar") {
                route<RProps>(props.location.pathname) {
                    child(Navigation::class) {
                        attrs {
                            from(it)
                        }
                    }
                }
            }
            col(xl = Sizes.SZ_2, classes = "${ClassNames.D_NONE} ${ClassNames.D_XL_BLOCK} bd-toc") {
            }
            col(
                md = Sizes.SZ_9, xl = Sizes.SZ_8, classes = "${ClassNames.PY_MD_3} ${ClassNames.PL_MD_5} bd-content"
            ) {
                switch {
                    Categories.categories.forEach { category ->
                        route<RProps>(category.link) {
                            child(category.component) {
                                attrs {
                                    from(it)
                                }
                            }
                        }
                    }
                    route<RProps>(props.match.path) {
                        redirect(from = props.match.path, to = Categories.categories.first().link)
                    }
                }
            }
        }
    }

    object Categories {
        var categories: List<Category<*>> = listOf(
//            Category(
//                "Getting started",
//                "getting-started",
//                GettingStarted::class
//            ).apply {
//                addSubCategory("Introduction", "introduction")
//                addSubCategory("Download", "download")
//                addSubCategory("Contents", "contents")
//                addSubCategory("Browsers & devices", "browsers-devices")
//                addSubCategory("JavaScript", "javascript")
//                addSubCategory("Theming", "theming")
//                addSubCategory("Build,ols", "build-tools")
//                addSubCategory("Webpack", "webpack")
//                addSubCategory("Accessibility", "accessibility")
//            },
            Category(
                "Layout",
                "layout",
                Layout::class
            ).apply {
//                addSubCategory("Overview", "overview")
                addSubCategory("Grid", "grid")
//                addSubCategory("Utilities for layout", "utilities-for-layout")
            },
            Category(
                "Content",
                "content",
                Content::class
            ).apply {
                // "Reboot", "reboot",
                addSubCategory("Typography", "typography")
//                addSubCategory("Code", "code")
//                addSubCategory("Images", "images")
//                addSubCategory("Tables", "tables")
//                addSubCategory("Figures", "figures")
            } // ,
//            Category(
//                "Components",
//                "components",
//                Components::class
//            ).apply {
//                addSubCategory("Alerts", "alerts")
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
//            },
//            Category(
//                "Utilities",
//                "utilities",
//                Utilities::class
//            ).apply {
//                addSubCategory("Borders", "borders")
//                addSubCategory("Clearfix", "clearfix")
//                addSubCategory("Close icon", "close-icon")
//                addSubCategory("Colors", "colors")
//                addSubCategory("Display", "display")
//                addSubCategory("Embed", "embed")
//                addSubCategory("Flex", "flex")
//                addSubCategory("Float", "float")
//                addSubCategory("Image replacement", "image-replacement")
//                addSubCategory("Overflow", "overflow")
//                addSubCategory("Position", "position")
//                addSubCategory("Screen readers", "screen readers")
//                addSubCategory("Shadows", "shadows")
//                addSubCategory("Sizing", "sizing")
//                addSubCategory("Spacing", "spacing")
//                addSubCategory("Stretched link", "stretched link")
//                addSubCategory("Text", "text")
//                addSubCategory("Vertical align", "vertical align")
//                addSubCategory("Visibility", "visibility")
//                addSubCategory("Extend", "extend")
//            },
//            Category(
//                "Extend",
//                "extend",
//                Extend::class
//            ).apply {
//                addSubCategory("Approach", "approach")
//                addSubCategory("Icons", "icons")
//            },
//            Category(
//                "About",
//                "about",
//                About::class
//            ).apply {
//                addSubCategory("Overview", "overview")
//            }
        )
    }
}
