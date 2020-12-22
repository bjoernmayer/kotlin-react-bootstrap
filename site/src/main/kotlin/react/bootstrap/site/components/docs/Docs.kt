package react.bootstrap.site.components.docs

import kotlinx.html.MAIN
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.helpers.classes
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_10
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_12
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_2
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_4
import react.bootstrap.layout.grid.col.ColAttributes.Sizes.Companion.SZ_8
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.container.Containers
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
        Containers.fluid {
            row {
                col(classes(ClassNames.P_0), all = SZ_12, md = SZ_2, lg = SZ_2) {
                    route<RProps>(props.location.pathname) {
                        child(Navigation::class) {
                            attrs {
                                from(it)
                            }
                        }
                    }
                }
                col<MAIN>(classes(ClassNames.PY_3, ClassNames.MX_LG_AUTO), all = SZ_12, md = SZ_10, lg = SZ_10) {
                    row {
                        col(all = SZ_12, lg = SZ_8) {
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
                        col(classes = classes(ClassNames.D_NONE, ClassNames.D_LG_BLOCK), lg = SZ_4) {
                            child(SectionNav::class) {
                                attrs {
                                    sections = state.sections
                                }
                            }
                        }
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
            GettingStarted.component,
            Layout.component,
            Content.component,
            Components.component
        )
    }
}
