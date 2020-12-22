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
public sealed class Navigation<T : HtmlBlockTag, P : Navigation.Props<T>>(
    props: P,
    tag: KClass<out T>
) : AbstractNavComponent<T, NavDOMHandler<T>, Navigation.DomBuilder<T>, P>(props, tag) {
    public class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): DomBuilder<T> = DomBuilder(builderFactory)

    public class Ul(props: Props) : Navigation<UL, Ul.Props>(props, UL::class) {
        override fun DomBuilder<UL>.build(): Unit = buildUlOl()

        public interface Props : Navigation.Props<UL>
    }

    public class Ol(props: Props) : Navigation<OL, Ol.Props>(props, OL::class) {
        override fun DomBuilder<OL>.build(): Unit = buildUlOl()

        public interface Props : Navigation.Props<OL>
    }

    public class Nav(props: Props) : Navigation<NAV, Nav.Props>(props, NAV::class) {
        override fun DomBuilder<NAV>.build(): Unit = buildDivItem()

        public interface Props : Navigation.Props<NAV>
    }

    public class Div(props: Props) : Navigation<DIV, Div.Props>(props, DIV::class) {
        override fun DomBuilder<DIV>.build(): Unit = buildDivItem()

        public interface Props : Navigation.Props<DIV>
    }

    override fun buildClasses(): Set<ClassNames> = super.buildClasses().toMutableSet().apply {
        add(ClassNames.NAV)
    }

    public interface Props<T : HtmlBlockTag> : AbstractNavComponent.Props<T, NavDOMHandler<T>, DomBuilder<T>>

    public enum class Appearance {
        TABS, PILLS;
    }

    public enum class WidthHandling {
        FILL, JUSTIFY;
    }
}
