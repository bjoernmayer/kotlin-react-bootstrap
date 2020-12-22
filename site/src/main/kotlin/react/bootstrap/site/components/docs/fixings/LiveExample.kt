package react.bootstrap.site.components.docs.fixings

import kotlinx.html.DIV
import react.RBuilder
import react.RState
import react.ReactElement
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.lib.component.SimpleDOMComponent
import react.bootstrap.lib.component.SimpleDOMComponent.Companion.simpleDomComponent
import react.bootstrap.lib.kotlinxhtml.addClass
import react.dom.RDOMBuilder

internal fun RBuilder.liveExample(
    classes: String? = null,
    block: RDOMHandler<DIV>
): ReactElement = simpleDomComponent(LiveExample::class)
    .classes(classes)
    .domHandler(block)
    .build()

internal class LiveExample(
    props: Props<DIV>
) : SimpleDOMComponent<DIV, SimpleDOMComponent.Props<DIV>, RState>(props, DIV::class) {

    override fun RDOMBuilder<DIV>.build() {
        addClass("krbd-example")
        addChildren()
    }

    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.P_4, ClassNames.BORDER, ClassNames.MB_3)
}
