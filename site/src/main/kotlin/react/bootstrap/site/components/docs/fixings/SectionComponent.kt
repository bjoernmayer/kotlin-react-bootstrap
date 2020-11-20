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
    private val section: Section
        get() = Section(title)

    protected abstract val title: String

    protected fun RBuilder.sectionTitle(block: RHandler<SectionTitle.Props> = { }): ReactElement =
        child(SectionTitle::class) {
            attrs {
                this.section = this@SectionComponent.section
                this.onNewSection = this@SectionComponent.props.onNewSection
            }
            block()
        }

    protected fun RBuilder.subSectionTitle(
        title: String,
        block: RHandler<SubSectionTitle.Props> = { }
    ): ReactElement =
        child(SubSectionTitle::class) {
            attrs {
                this.title = title
                this.onNewSection = this@SectionComponent.props.onNewSection
                this.parentSection = this@SectionComponent.section
            }
            block()
        }

    class SectionTitle : RComponent<SectionTitle.Props, RState>() {
        override fun componentDidMount() {
            props.onNewSection(props.section)
        }

        override fun RBuilder.render() {
            h2 {
                attrs {
                    set("id", props.section.id)
                }
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
        lateinit var section: Section

        override fun componentDidMount() {
            props.onNewSection(
                props.parentSection.apply {
                    subSections.add(section)
                }
            )
        }

        override fun RBuilder.render() {
            section = Section(props.title)

            h3 {
                attrs {
                    set("id", section.id)
                }
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
