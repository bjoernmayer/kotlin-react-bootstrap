package react.bootstrap.site.components.docs.fixings

import kotlinx.html.P
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement
import react.bootstrap.site.components.docs.Docs
import react.bootstrap.site.components.docs.pageTitle
import react.dom.RDOMBuilder
import react.dom.h1
import react.dom.p
import kotlin.reflect.KClass

internal abstract class PageComponent : RComponent<Docs.SectionNavEvents, RState>() {
    protected fun RBuilder.pageTitle(
        title: String,
        block: RHandler<Title.Props> = {}
    ): ReactElement =
        child(Title::class) {
            attrs {
                this.title = title
                this.onNewPage = this@PageComponent.props.onNewPage
            }

            block()
        }

    protected fun RBuilder.child(clazz: KClass<out SectionComponent>) {
        child(clazz) {
            attrs {
                onNewSection = this@PageComponent.props.onNewSection
            }
        }
    }

    class Title : RComponent<Title.Props, RState>() {
        override fun componentDidMount() {
            props.onNewPage()
        }

        override fun RBuilder.render() {
            val className = "bd-title"

            pageTitle(props.title)

            h1(className) {
                +props.title
                children()
            }
        }

        interface Props : RProps {
            var title: String
            var onNewPage: () -> Unit
        }
    }

    protected fun RBuilder.pageLead(block: RDOMBuilder<P>.() -> Unit): ReactElement =
        p("bd-lead", block)
}
