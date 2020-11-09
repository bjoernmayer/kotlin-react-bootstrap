package react.bootstrap.site.components.docs

// import react.bootstrap.site.components.docs.about.About
// import react.bootstrap.site.components.docs.components.Components
// import react.bootstrap.site.components.docs.extend.Extend
// import react.bootstrap.site.components.docs.gettingstarted.GettingStarted
// import react.bootstrap.site.components.docs.utilities.Utilities
import kotlinx.html.MAIN
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_2
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_3
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_8
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_9
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.row.row
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.components.Components
import react.bootstrap.site.components.docs.content.Content
import react.bootstrap.site.components.docs.fixings.CategoryComponent
import react.bootstrap.site.components.docs.gettingstarted.GettingStarted
import react.bootstrap.site.components.docs.layout.Layout
import react.bootstrap.site.from
import react.router.dom.RouteResultProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch
import react.setState

typealias NewSectionHandler = (Section) -> Unit

class Docs : RComponent<RouteResultProps<RProps>, Docs.State>() {
    init {
        state.sections = mutableSetOf()
    }

    private fun handleClearSections() {
        setState {
            sections.clear()
        }
    }

    private fun handleAddSection(section: Section) {
        setState {
            if (section in sections) {
                // Todo: Use a Map or something
                sections.find { it.title == section.title }!!.subSections.add(section.subSections.last())
            } else {
                sections.add(section)
            }
        }
    }

    override fun RBuilder.render() {
        row(classes = "${ClassNames.FLEX_XL_NOWRAP}") {
            col(md = SZ_3, xl = SZ_2, classes = "bd-sidebar") {
                route<RProps>(props.location.pathname) {
                    child(Navigation::class) {
                        attrs {
                            from(it)
                        }
                    }
                }
            }
            col(xl = SZ_2, classes = "${ClassNames.D_NONE} ${ClassNames.D_XL_BLOCK} bd-toc") {
                child(SectionNav::class) {
                    attrs {
                        sections = state.sections
                    }
                }
            }
            col(
                md = SZ_9,
                xl = SZ_8,
                classes = "${ClassNames.PY_MD_3} ${ClassNames.PL_MD_5} bd-content",
                rendererTag = MAIN::class
            ) {
                switch {
                    Pages.categories.forEach { category ->
                        route<CategoryComponent.Props>(category.link) {
                            child(category.component) {
                                attrs {
                                    from(it)
                                    match.params.category = category
                                    match.params.onNewPage = this@Docs::handleClearSections
                                    match.params.onNewSection = this@Docs::handleAddSection
                                }
                            }
                        }
                    }
                    route<RProps>(props.match.path) {
                        redirect(from = props.location.pathname, to = Pages.categories.first().link)
                    }
                }
            }
        }
    }

    interface SectionNavEvents : RProps {
        var onNewPage: () -> Unit
        var onNewSection: NewSectionHandler
    }

    interface State : RState {
        var sections: MutableSet<Section>
    }

    internal object Pages {
        var categories: List<Category> = listOf(
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
            GettingStarted.component,
            Layout.component,
            Content.component,
            Components.component // ,
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
