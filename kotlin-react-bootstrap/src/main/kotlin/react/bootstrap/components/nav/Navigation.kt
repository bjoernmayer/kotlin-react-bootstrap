package react.bootstrap.components.nav

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.NAV
import kotlinx.html.OL
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import kotlinx.html.UL
import react.bootstrap.components.common.navs.AbstractNavComponent
import react.bootstrap.lib.bootstrap.ClassNames
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

/**
 * @param T Tag to render
 * @param P RProps Type
 */
sealed class Navigation<T : HtmlBlockTag, P : Navigation.Props<T>>(
    props: P,
    tag: KClass<out T>
) : AbstractNavComponent<T, NavDOMHandler<T>, Navigation.DomBuilder<T>, P>(props, tag) {
    class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): DomBuilder<T> = DomBuilder(builderFactory)

    class Ul(props: Props) : Navigation<UL, Ul.Props>(props, UL::class) {
        override fun DomBuilder<UL>.build() = buildUlOl()

        interface Props : Navigation.Props<UL>
    }

    class Ol(props: Props) : Navigation<OL, Ol.Props>(props, OL::class) {
        override fun DomBuilder<OL>.build() = buildUlOl()

        interface Props : Navigation.Props<OL>
    }

    class Nav(props: Props) : Navigation<NAV, Nav.Props>(props, NAV::class) {
        override fun DomBuilder<NAV>.build() = buildDivItem()

        interface Props : Navigation.Props<NAV>
    }

    class Div(props: Props) : Navigation<DIV, Div.Props>(props, DIV::class) {
        override fun DomBuilder<DIV>.build() = buildDivItem()

        interface Props : Navigation.Props<DIV>
    }

    override fun buildClasses(): Set<ClassNames> = super.buildClasses().toMutableSet().apply {
        add(ClassNames.NAV)
    }

    interface Props<T : HtmlBlockTag> : AbstractNavComponent.Props<T, NavDOMHandler<T>, DomBuilder<T>>

    enum class Appearance {
        TABS, PILLS;
    }

    enum class WidthHandling {
        FILL, JUSTIFY;
    }
}
