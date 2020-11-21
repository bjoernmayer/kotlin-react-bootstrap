package react.bootstrap.site.components.docs

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.helpers.classes
import react.bootstrap.lib.bootstrap.ClassNames

data class Section(
    val title: String,
    val subSections: MutableSet<Section> = mutableSetOf()
) {
    // generate id here
    val id = getSanitizedId(title)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Section) return false

        if (title != other.title) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }

    companion object {
        fun getSanitizedId(toSanitize: String): String =
            toSanitize.toLowerCase().replace(", ", "-").replace(' ', '-')
    }
}

class SectionNav : RComponent<SectionNav.Props, RState>() {
    override fun RBuilder.render() {
        Navs.nav(
            classes(
                ClassNames.FLEX_COLUMN,
                ClassNames.FLEX_NOWRAP,
                ClassNames.STICKY_TOP,
                ClassNames.BORDER_LEFT,
                ClassNames.PB_3,
                "krbd-side-nav"
            )
        ) {
            props.sections?.forEach { section ->
                navItem {
                    navLink(href = "#${section.id}", classes = classes(ClassNames.PY_1)) { +section.title }
                    if (section.subSections.isNotEmpty()) {
                        Navs.nav(classes = classes(ClassNames.FLEX_COLUMN, ClassNames.ML_3, ClassNames.SMALL)) {
                            section.subSections.forEach { subsection ->
                                navItem {
                                    navLink(href = "#${subsection.id}", classes = classes(ClassNames.PY_1)) {
                                        +subsection.title
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    interface Props : RProps {
        var sections: Set<Section>?
    }
}
