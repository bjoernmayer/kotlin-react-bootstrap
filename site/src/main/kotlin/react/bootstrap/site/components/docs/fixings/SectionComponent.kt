package react.bootstrap.site.components.docs.fixings

import react.RBuilder
import react.RComponent
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.site.components.docs.NewSectionHandler
import react.bootstrap.site.components.docs.Section
import react.dom.h2
import react.dom.h3

internal abstract class SectionComponent : RComponent<SectionComponent.Props, RState>() {
    protected val section: Section
        get() = Section(title)

    protected abstract val title: String

    protected fun RBuilder.sectionTitle(section: Section, block: RHandler<SectionTitle.Props> = { }): ReactElement =
        child(SectionTitle::class) {
            attrs {
                this.section = section
                this.onNewSection = this@SectionComponent.props.onNewSection
            }
            block()
        }

    protected fun RBuilder.subSectionTitle(
        title: String,
        parentSection: Section,
        block: RHandler<SubSectionTitle.Props> = { }
    ): ReactElement =
        child(SubSectionTitle::class) {
            attrs {
                this.title = title
                this.onNewSection = this@SectionComponent.props.onNewSection
                this.parentSection = parentSection
            }
            block()
        }

    class SectionTitle : RComponent<SectionTitle.Props, RState>() {
        override fun componentDidMount() {
            props.onNewSection(props.section)
        }

        override fun RBuilder.render() {
            val className = "bd-content-title"

            h2(className) {
                +props.section.title
                children()
            }
        }

        interface Props : RProps {
            var onNewSection: NewSectionHandler
            var section: Section
        }
    }

    class SubSectionTitle : RComponent<SubSectionTitle.Props, RState>() {
        override fun componentDidMount() {
            props.onNewSection(
                props.parentSection.apply {
                    subSections.add(Section(props.title))
                }
            )
        }

        override fun RBuilder.render() {
            val className = "bd-content-title"

            h3(className) {
                +props.title
                children()
            }
        }

        interface Props : RProps {
            var onNewSection: NewSectionHandler
            var parentSection: Section
            var title: String
        }
    }

    interface Props : RProps {
        var onNewSection: NewSectionHandler
    }
}
