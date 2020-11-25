package react.bootstrap.components.nav

import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.LI
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import react.RState
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.component.DOMComponent
import react.bootstrap.lib.react.onEachComponent
import react.dom.RDOMBuilder
import kotlin.reflect.KClass

public sealed class NavItems<T : HtmlBlockTag, P : NavItems.Props<T>>(
    props: P,
    tag: KClass<out T>
) : DOMComponent<T, NavItemDOMHandler<T>, NavItems.DomBuilder<T>, P, RState>(props, tag) {
    public class DomBuilder<out T : Tag>(factory: (TagConsumer<Unit>) -> T) : RDOMBuilder<T>(factory)

    override fun buildBuilder(builderFactory: (TagConsumer<Unit>) -> T): DomBuilder<T> = DomBuilder(builderFactory)

    public class Li(props: Props) : NavItems<LI, Li.Props>(props, LI::class) {
        public interface Props : NavItems.Props<LI>
    }

    public class DivItem(props: Props) : NavItems<DIV, DivItem.Props>(props, DIV::class) {
        public interface Props : NavItems.Props<DIV>
    }

    override fun buildClasses(): Set<ClassNames> = setOf(ClassNames.NAV_ITEM)

    override fun DomBuilder<T>.build() {
        if (props.activeLinkPredicate == null) {
            addChildren()
        } else {
            childList.addAll(
                childrenArray.onEachComponent(NavLink::class) { _, _ ->
                    attrs {
                        activeLinkPredicate = this@NavItems.props.activeLinkPredicate
                    }
                }
            )
        }
    }

    public interface Props<T : HtmlBlockTag> : DOMComponent.Props<NavItemDOMHandler<T>> {
        public var activeLinkPredicate: ActiveLinkPredicate?
    }
}
