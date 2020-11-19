package react.bootstrap.site.components.docs

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.li
import react.dom.ul

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
        ul("section-nav") {
            props.sections?.forEach { section ->
                li("toc-entry toc-h2") {
                    a(href = "#${section.id}") { +section.title }
                    if (section.subSections.isNotEmpty()) {
                        ul {
                            section.subSections.forEach { subsection ->
                                li("toc-entry toc-h3") {
                                    a(href = "#${subsection.id}") { +subsection.title }
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
